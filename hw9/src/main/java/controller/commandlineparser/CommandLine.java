package controller.commandlineparser;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The default implementation of ICommandLine ADT.
 */
public class CommandLine implements ICommandLine {

  private final Options options;

  /**
   * Constructor for the CommandLine ADT.
   *
   * @param options store options as a map.
   */
  public CommandLine(Options options) {
    this.options = options;
  }

  /**
   * Check if the command line contains a certain option.
   *
   * @param optionName the option name to check.
   * @return true or false.
   */
  @Override
  public boolean hasOption(String optionName) {
    return this.options.hasOption(optionName);
  }

  /**
   * Get the option value.
   *
   * @param optionName provide the option name.
   * @return the option value.
   */
  @Override
  public String getOptionValue(String optionName) {
    return this.options.getOptionValue(optionName);
  }

  /**
   * Get all the values of the option.
   *
   * @param optionName provide the option name.
   * @return the option values.
   */
  @Override
  public String[] getOptionValues(String optionName) {
    return this.options.getOptionValues(optionName);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLine that = (CommandLine) o;
    return options.equals(that.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options);
  }

  @Override
  public String toString() {
    return "CommandLine{" +
        "options=" + options +
        '}';
  }
}