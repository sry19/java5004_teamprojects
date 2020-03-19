package nonprofit_communication_automation;

public class illegalDataException extends RuntimeException{

  public illegalDataException() {
    super("Data is invalid.");
  }
}
