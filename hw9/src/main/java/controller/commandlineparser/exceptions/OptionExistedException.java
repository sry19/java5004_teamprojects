package controller.commandlineparser.exceptions;

/**
 * Exception for when an option is already existed in the Options container.
 */
public class OptionExistedException extends Exception {

  /**
   * Constructs a new  ExistedException with.
   */
  public OptionExistedException() {
    super("Option already existed.");
  }
}
