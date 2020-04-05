package controller.commandlineparser.exceptions;

/**
 * Invalid option exception. Throw out some useful information for the user
 */
public class InvalidOptionException extends Exception {

  public InvalidOptionException() {
    super("Invalid Options.");
  }
}
