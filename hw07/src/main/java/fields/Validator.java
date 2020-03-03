package fields;

public interface Validator<T> {

  /**
   * Check if a input is valid.
   *
   * @param input the input to check.
   * @return true or false.
   */
  boolean isValid(T input);
}
