package controller.commandlineparser;


import controller.commandlineparser.exceptions.InvalidSplitterException;
import java.util.Arrays;
import java.util.Objects;
import tools.ArrayHelper;

/**
 * A single option class that contains all information related to one option.
 */

public class Option {

  private String name;
  private String description;
  private boolean required;
  private boolean hasSubArg;
  private boolean hasSubArgs;
  private String argSplitter;
  private String argName;
  private String value;
  private String[] values;
  private String[] dependencies;

  /**
   * Use builder to build an Option.
   *
   * @param builder the builder to build the option.
   */
  private Option(Builder builder) {
    this.name = builder.name;
    this.description = builder.description;
    this.required = builder.required;
    this.hasSubArg = builder.hasSubArg;
    this.hasSubArgs = builder.hasSubArgs;
    this.argSplitter = builder.argSplitter;
    this.argName = builder.argName;
    this.dependencies = builder.dependencies;
  }

  /**
   * Use anther option to build the current Option. Mainly for update values.
   *
   * @param option the option to build on.
   */
  private Option(Option option, String value) {
    this.name = option.name;
    this.description = option.description;
    this.required = option.required;
    this.hasSubArg = option.hasSubArg;
    this.hasSubArgs = option.hasSubArgs;
    this.argSplitter = option.argSplitter;
    this.argName = option.argName;
    this.dependencies = option.dependencies;
    this.value = value;
    this.values = new String[1];
    this.values[0] = value;
  }

  /**
   * Use anther option to build the current Option. Mainly for update values.
   *
   * @param option the option to build on.
   */
  private Option(Option option, String[] values) {
    this.name = option.name;
    this.description = option.description;
    this.required = option.required;
    this.hasSubArg = option.hasSubArg;
    this.hasSubArgs = option.hasSubArgs;
    this.argSplitter = option.argSplitter;
    this.argName = option.argName;
    this.dependencies = option.dependencies;
    this.value = values[0];
    this.values = values;
  }

  /**
   * Given a row argument of an option. Update its value and return a new option object.
   *
   * @param arg the raw argument input.
   * @return a new option with updated value.
   */
  public Option updateValue(String arg) {
    if (this.hasSubArgs) {
      return this.addValues(arg.split(this.getArgSplitter()));
    } else {
      return this.addValue(arg);
    }
  }

  public void printUsage() {
    String arg = this.hasSubArg ? this.getArgName() : "";
    System.out.println(this.getName() + " " + arg);
    System.out.println(this.getDescription() + "\n");
  }

  /**
   * Add a value to an Option in a immutable way.
   *
   * @param value the value to add.
   * @return a new Option with updated value.
   */
  private Option addValue(String value) {
    return new Option(this, value);
  }

  /**
   * Add a value to an Option in a immutable way.
   *
   * @param values the values to add.
   * @return a new Option with updated value.
   */
  private Option addValues(String[] values) {
    return new Option(this, ArrayHelper.combineAll(this.getValues(), values));
  }

  /**
   * @return name.
   */
  public String getName() {
    return name;
  }

  /**
   * @return description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return required.
   */
  public boolean isRequired() {
    return required;
  }

  /**
   * @return hasSubArg.
   */
  public boolean hasSubArg() {
    return hasSubArg;
  }

  /**
   * @return hasSubArgs.
   */
  public boolean hasSubArgs() {
    return hasSubArgs;
  }

  /**
   * @return argSplitter.
   */
  public String getArgSplitter() {
    return argSplitter;
  }

  /**
   * @return argName
   */
  public String getArgName() {
    return argName;
  }

  /**
   * @return value
   */
  public String getValue() {
    return value;
  }

  /**
   * @return values
   */
  public String[] getValues() {
    return values;
  }

  /**
   * @return dependencies.
   */
  public String[] getDependencies() {
    return dependencies;
  }

  /**
   * Nested Builder class.
   */
  public static class Builder {

    private String name;
    private String description;
    private boolean required;
    private boolean hasSubArg;
    private boolean hasSubArgs;
    private String argSplitter;
    private String argName;
    private String[] dependencies;

    /**
     * Use constructor to initialize the name of the option.
     *
     * @param name the name is the identifier of an option. Like "--csv-file".
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * @param description a short description of the option.
     * @return the builder.
     */
    public Builder addDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * @param required if the option is required.
     * @return the builder.
     */
    public Builder addRequired(boolean required) {
      this.required = required;
      return this;
    }

    /**
     * @param hasSubArg does the option has a sub argument.
     * @return the builder.
     */
    public Builder addHasSubArg(boolean hasSubArg) {
      this.hasSubArg = hasSubArg;
      return this;
    }

    /**
     * @param hasSubArgs does the option has multiple sub arguments.
     * @return the builder.
     */
    public Builder addHasSubArgs(boolean hasSubArgs) {
      this.hasSubArgs = hasSubArgs;
      return this;
    }

    /**
     * @param argSplitter the splitter for multiple arguments.
     * @return the builder.
     * @throws InvalidSplitterException if the argSplitter is invalid.
     */
    public Builder addArgSplitter(String argSplitter) throws InvalidSplitterException {
      this.checkArgSplitter(argSplitter);
      this.argSplitter = argSplitter;
      return this;
    }

    /**
     * @param argName a name or description for the options's argument.
     * @return the builder.
     */
    public Builder addArgName(String argName) {
      this.argName = argName;
      return this;
    }

    /**
     * @param dependencies which options the current option depends on.
     * @return the builder.
     */
    public Builder addDependencies(String[] dependencies) {
      this.dependencies = dependencies;
      return this;
    }

    /**
     * Build the Option.
     *
     * @return a new Option.
     */
    public Option build() {
      return new Option(this);
    }

    /**
     * Check if the argSplitter is valid.
     *
     * @param argSplitter the provided argSplitter.
     * @throws InvalidSplitterException if the argSplitter is invalid.
     */
    private void checkArgSplitter(String argSplitter) throws InvalidSplitterException {
      if (argSplitter.trim().length() == 0) {
        throw new InvalidSplitterException();
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Option option = (Option) o;
    return isRequired() == option.isRequired() &&
        hasSubArg == option.hasSubArg &&
        hasSubArgs == option.hasSubArgs &&
        getName().equals(option.getName()) &&
        Objects.equals(getDescription(), option.getDescription()) &&
        Objects.equals(getArgSplitter(), option.getArgSplitter()) &&
        Objects.equals(getArgName(), option.getArgName()) &&
        Objects.equals(getValue(), option.getValue()) &&
        Arrays.equals(getValues(), option.getValues()) &&
        Arrays.equals(getDependencies(), option.getDependencies());
  }

  @Override
  public int hashCode() {
    int result = Objects
        .hash(getName(), getDescription(), isRequired(), hasSubArg, hasSubArgs, getArgSplitter(),
            getArgName(), getValue());
    result = 31 * result + Arrays.hashCode(getValues());
    result = 31 * result + Arrays.hashCode(getDependencies());
    return result;
  }

  @Override
  public String toString() {
    return "Option{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", required=" + required +
        ", hasSubArg=" + hasSubArg +
        ", hasSubArgs=" + hasSubArgs +
        ", argSplitter='" + argSplitter + '\'' +
        ", argName='" + argName + '\'' +
        ", value='" + value + '\'' +
        ", values=" + Arrays.toString(values) +
        ", dependencies=" + Arrays.toString(dependencies) +
        '}';
  }
}