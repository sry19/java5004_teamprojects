package controller.commandlineparser;

/**
 * The interface to define the behavior of a command line parser.
 */
public interface ICommandLineParser {

  ICommandLine parse(Options options, String args);
}