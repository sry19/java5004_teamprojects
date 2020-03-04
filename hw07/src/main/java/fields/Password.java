package fields;

import java.util.Objects;

/**
 * Password validator.
 */
public class Password implements Validator<String> {

  private final int minLen, maxLen;
  private final int minNumLowerCase, minNumUpperCase;
  private final int minNumDigit;

  /**
   * Create Password Validator.
   *
   * @param minLen the minimum length of the password.
   * @param maxLen the maximum length of the password.
   */
  public Password(int minLen, int maxLen) {
    this.minLen = minLen;
    this.maxLen = maxLen;
    this.minNumLowerCase = 0;
    this.minNumUpperCase = 0;
    this.minNumDigit = 0;
  }

  /**
   * Create Password Validator.
   *
   * @param minLen          the minimum length of the password.
   * @param maxLen          the maximum length of the password.
   * @param minNumLowerCase the minimum number of lowercase characters.
   */
  public Password(int minLen, int maxLen, int minNumLowerCase) {
    this.minLen = minLen;
    this.maxLen = maxLen;
    this.minNumLowerCase = minNumLowerCase;
    this.minNumUpperCase = 0;
    this.minNumDigit = 0;
  }

  /**
   * Create Password Validator.
   *
   * @param minLen          the minimum length of the password.
   * @param maxLen          the maximum length of the password.
   * @param minNumLowerCase the minimum number of lowercase characters.
   * @param minNumUpperCase the minimum number of uppercase characters.
   */
  public Password(int minLen, int maxLen, int minNumLowerCase, int minNumUpperCase) {
    this.minLen = minLen;
    this.maxLen = maxLen;
    this.minNumLowerCase = minNumLowerCase;
    this.minNumUpperCase = minNumUpperCase;
    this.minNumDigit = 0;
  }

  /**
   * Create Password Validator.
   *
   * @param minLen          the minimum length of the password.
   * @param maxLen          the maximum length of the password.
   * @param minNumLowerCase the minimum number of lowercase characters.
   * @param minNumUpperCase the minimum number of uppercase characters.
   * @param minNumDigit     the minimum number of digits.
   */
  public Password(int minLen, int maxLen, int minNumLowerCase, int minNumUpperCase,
      int minNumDigit) {
    this.minLen = minLen;
    this.maxLen = maxLen;
    this.minNumLowerCase = minNumLowerCase;
    this.minNumUpperCase = minNumUpperCase;
    this.minNumDigit = minNumDigit;
  }

  /**
   * Check if a input is valid.
   *
   * @param input the input to check.
   * @return true or false.
   */
  @Override
  public boolean isValid(String input) {
    return this.withLength(input) && this.noSpace(input) && this.meetNumberRequirements(input);
  }

  /**
   * Helper method to check if the input is within required length range.
   *
   * @param input the input to check.
   * @return true or false.
   */
  private boolean withLength(String input) {
    return input.length() >= this.minLen && input.length() <= this.maxLen;
  }

  /**
   * Helper method to check if the input contains any space character.
   *
   * @param input the input to check.
   * @return true or false.
   */
  private boolean noSpace(String input) {
    return !input.contains(" ");
  }

  /**
   * Helper method to check if the input meets all character number requirements.
   *
   * @param input the input to check.
   * @return true or false.
   */
  private boolean meetNumberRequirements(String input) {
    int lowerCaseCount = 0;
    int upperCaseCount = 0;
    int digitCount = 0;

    for (char c : input.toCharArray()) {
      if (Character.isLowerCase(c)) {
        lowerCaseCount++;
      } else if (Character.isUpperCase(c)) {
        upperCaseCount++;
      } else if (Character.isDigit(c)) {
        digitCount++;
      }
    }

    return lowerCaseCount >= this.minNumLowerCase && upperCaseCount >= this.minNumUpperCase
        && digitCount >= this.minNumDigit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Password password = (Password) o;
    return minLen == password.minLen &&
        maxLen == password.maxLen &&
        minNumLowerCase == password.minNumLowerCase &&
        minNumUpperCase == password.minNumUpperCase &&
        minNumDigit == password.minNumDigit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minLen, maxLen, minNumLowerCase, minNumUpperCase, minNumDigit);
  }

  @Override
  public String toString() {
    return "Password{" +
        "minLen=" + minLen +
        ", maxLen=" + maxLen +
        ", minNumLowerCase=" + minNumLowerCase +
        ", minNumUpperCase=" + minNumUpperCase +
        ", minNumDigit=" + minNumDigit +
        '}';
  }
}
