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
    if (input == null) {
      return false;
    }
    if (input.length() != this.len) {
      return false;
    }
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
