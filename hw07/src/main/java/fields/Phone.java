package fields;


/**
 * The phone validator class.
 */
public class Phone implements Validator<String> {

  private Integer len;

  /**
   * Instantiates a new Phone validator.
   *
   * @param len the len
   */
  public Phone(Integer len) {
    this.len = len;
  }

  /**
   * Check if a input is valid.
   *
   * @param input the input to check.
   * @return true or false.
   */
  @Override
  public boolean isValid(String input) {
    return input != null && input.length() == this.len && this.allDigits(input);
  }

  /**
   * check if all chars are digits
   *
   * @param input a string
   * @return true or false
   */
  private boolean allDigits(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (!Character.isDigit(input.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Phone phone = (Phone) o;

    return len.equals(phone.len);
  }

  @Override
  public int hashCode() {
    return len.hashCode();
  }

  @Override
  public String toString() {
    return "Phone{" +
        "len=" + len +
        '}';
  }
}
