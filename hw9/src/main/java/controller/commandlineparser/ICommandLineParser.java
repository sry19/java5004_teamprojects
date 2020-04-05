package controller.commandlineparser;

import controller.commandlineparser.exceptions.InvalidOptionException;

/**
 * The interface to define the behavior of a command line parser. It's responsible for validating
 * the command line input and turns the raw input to a ICommandLine ADT.
 */
public interface ICommandLineParser {

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
  ICommandLine parse(Options options, String[] args) throws InvalidOptionException;
}