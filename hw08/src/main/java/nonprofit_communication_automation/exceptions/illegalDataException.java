package nonprofit_communication_automation.exceptions;

public class illegalDataException extends RuntimeException{

  public illegalDataException() {
    super("Data is invalid.");
  }
}
