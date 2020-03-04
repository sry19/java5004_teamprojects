package fields;

/**
 * Checkbox validator.
 */

public class CheckBox implements Validator<Boolean> {

  /**
   * Check if a input is valid.
   *
   * @param input the input to check.
   * @return true or false.
   */
  @Override
  public boolean isValid(Boolean input) {
    return true;
  }
}
