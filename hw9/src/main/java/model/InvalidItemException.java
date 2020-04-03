package model;

public class InvalidItemException extends IllegalArgumentException{
  //Yiyu asks: why two kinds?
  public InvalidItemException() {
    super();
  }

  public InvalidItemException(String s) {
    super(s);
  }
}