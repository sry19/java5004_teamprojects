package fields;

/**
 * ruoyun
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
}
