package exceptions;

public class InvalidCSVFileException extends RuntimeException {

  /**
   * Constructor for InvalidCSVFileException.
   */
  public InvalidCSVFileException() {
    super("Invalid CSV File.");
  }
}