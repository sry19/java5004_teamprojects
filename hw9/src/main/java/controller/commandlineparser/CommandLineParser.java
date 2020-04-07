package controller.commandlineparser;

import controller.commandlineparser.exceptions.InvalidOptionException;
import java.util.Arrays;

public class CommandLineParser implements ICommandLineParser {

  private Options options;

  public CommandLineParser() {
    this.options = new Options();
  }

  /**
   * The main method needed by a command line parser is parse. This method validate the raw command
   * line input, if the input is valid, return a ICommandLine ADT, otherwise print out the error and
   * usage
   *
   * @param options The options for the command line to validate.
   * @param args    the raw command line input.
   * @return a ICommandLine ADT.
   * @throws InvalidOptionException if the current option is not valid.
   */
  @Override
  public ICommandLine parse(Options options, String[] args) throws InvalidOptionException {
    this.options = createFromArgs(options, args);
    this.validateOptions(options);
    return new CommandLine(this.options);
  }

  /**
   * Create the options from raw arguments and preset options.
   *
   * @param options the preset options.
   * @param args    the input argument.
   * @return a built options.
   * @throws InvalidOptionException if the current option is not valid.
   */
  private Options createFromArgs(Options options, String[] args) throws InvalidOptionException {
    Options newOptions = new Options();
    for (int i = 0; i < args.length; i++) {
      // i start from 1 because the first argument is the program's name.
      if (!newOptions.hasOption(args[i])) {
        if (!options.hasOption(args[i])) {
          System.out.println(args[i] + " is an invalid option.");
          throw new InvalidOptionException();
        }
        newOptions.updateOption(options.getOption(args[i]));
      }
      Option curOption = newOptions.getOption(args[i]);
      if (curOption.hasSubArg() || curOption.hasSubArgs()) {
        i += 1;
        newOptions.updateOption(curOption.updateValue(curOption, args[i]));
      }
    }
    return newOptions;
  }

  /**
   * Check if the current options is valid.
   *
   * @param options the original option collection to check with.
   * @throws InvalidOptionException if the current option is not valid.
   */
  private void validateOptions(Options options) throws InvalidOptionException {
    if (!checkRequired(options) || !checkOptionArgs() || !checkDependencies()) {
      throw new InvalidOptionException();
    }
  }

  /**
   * Check if all required options is provided.
   *
   * @param options the original option collection to check with.
   * @return true or false.
   */
  private boolean checkRequired(Options options) {
    for (Option option : options) {
      if (option.isRequired() && !this.options.hasOption(option.getName())) {
        System.out.println(option.getName() + " is required!");
        return false;
      }
    }
    return true;
  }

  /**
   * Check if the option is provided with an argument if it needs one.
   *
   * @return true or false.
   */
  private boolean checkOptionArgs() {
    for (Option option : this.options) {
      if ((option.hasSubArgs() && option.getValues() == null) || (option.hasSubArg()
          && option.getValue() == null)) {
        System.out.println(option.getName() + " needs sub argument(s)");
        return false;
      }
    }
    return true;
  }

  /**
   * Check the case when an option depends on other option and the other option is not provided.
   *
   * @return true or false.
   */
  private boolean checkDependencies() {
    for (Option option : this.options) {
      if (option.getDependencies() != null) {
        for (String dependency : option.getDependencies()) {
          if (!this.options.hasOption(dependency)) {
            System.out.println(option.getName() + " requires " + Arrays
                .toString(option.getDependencies()));
            return false;
          }
        }
      }
    }
    return true;
  }

  //TODO check conflicts
}