package exceptions;

public class InvalidItemException extends IllegalArgumentException{

  public InvalidItemException() {
    super();
  }

  public InvalidItemException(String s) {
    super(s);
  }
}