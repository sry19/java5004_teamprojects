package controller.commandlineparser;

import java.util.List;

/**
 * Command line data structure. Used to define an command line object. and tell use what they can do
 * with it.
 */
public interface ICommandLine {

  /**
   * Check if the command line contains a certain option.
   *
   * @param optionName the option name to check.
   * @return true or false.
   */
  boolean hasOption(String optionName);

  /**
   * Get the option value.
   *
   * @param optionName provide the option name.
   * @return the option value.
   */
  String getOptionValue(String optionName);

  /**
   * Get all the values of the option.
   *
   * @param optionName provide the option name.
   * @return the option values.
   */
  List<String> getOptionValues(String optionName);
}