package controller.commandlineparser;

import controller.commandlineparser.exceptions.OptionExistedException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * A container for a collection of options.
 */
public class Options implements ICommandLine, Iterable<Option> {

  private Map<String, Option> optionMap;

  /**
   * Initialize the map to store all the Options.
   */
  public Options() {
    this.optionMap = new HashMap<>();
  }

  /**
   * Add an Option to the container.
   *
   * @param option the Option to add.
   * @throws OptionExistedException if the Options already existed in the container.
   */
  public void addOption(Option option) throws OptionExistedException {
    if (this.optionMap.containsKey(option.getName())) {
      throw new OptionExistedException();
    }
    this.optionMap.put(option.getName(), option);
  }

  /**
   * Update an existing option.
   *
   * @param option the new option to update.
   */
  public void updateOption(Option option) {
    this.optionMap.put(option.getName(), option);
  }

  /**
   * Check if the command line contains a certain option.
   *
   * @param optionName the option name to check.
   * @return true or false.
   */
  @Override
  public boolean hasOption(String optionName) {
    return this.optionMap.containsKey(optionName);
  }

  /**
   * Get the option value.
   *
   * @param optionName provide the option name.
   * @return the option value.
   */
  @Override
  public String getOptionValue(String optionName) {
    return this.optionMap.get(optionName).getValue();
  }

  /**
   * Get all the values of the option.
   *
   * @param optionName provide the option name.
   * @return the option values.
   */
  @Override
  public String[] getOptionValues(String optionName) {
    return this.optionMap.get(optionName).getValues();
  }


  /**
   * Get an option from the container via its name.
   *
   * @param optionName the option name to check.
   * @return the option.
   */
  public Option getOption(String optionName) {
    return this.optionMap.get(optionName);
  }

  /**
   * Print the usage of the current options.
   */
  public void printUsage() {
    System.out.println("Option usage:\n");
    for (Option option : this.optionMap.values()) {
      option.printUsage();
    }
  }


  /**
   * Returns an iterator for the options container.
   *
   * @return an Iterator.
   */
  @Override
  public Iterator<Option> iterator() {
    return this.optionMap.values().iterator();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Options options = (Options) o;
    return optionMap.equals(options.optionMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(optionMap);
  }

  @Override
  public String toString() {
    return "Options{" +
        "optionMap=" + optionMap +
        '}';
  }
}