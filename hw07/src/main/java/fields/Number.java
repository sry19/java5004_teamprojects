package fields;


import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Validator for numbers.
 */
public class Number implements Validator<String> {

  private Integer minValue;
  private Integer maxValue;
  private Integer decimalPlaces;

  /**
   * Constructor for number validator
   *
   * @param minValue      the minimum value for the number
   * @param maxValue      the maximum value for the number
   * @param decimalPlaces maximum decimal places allowed
   */
  public Number(Integer minValue, Integer maxValue, Integer decimalPlaces) {
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.decimalPlaces = decimalPlaces;
  }

  /**
   * Check if a input is valid.
   *
   * @param input the input to check.
   * @return true or false.
   */
  @Override
  public boolean isValid(String input) {
    return (this.validNumeric(input) &&
        this.validDecimal(input) <= Math.max(0, this.decimalPlaces) &&
        this.validValue(input));
  }

  /**
   * Returns if the string is a valid positive numeric number
   *
   * @param input the input string
   * @return if the string is a valid positive numeric number
   */
  private boolean validNumeric(String input) {
    Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");

    if (input == null) {
      return false;
    } else {
      return p.matcher(input).matches();
    }
  }

  /**
   * Returns the decimal places of the number
   *
   * @param input the input string
   * @return the decimal places of the number
   */
  private Integer validDecimal(String input) {
    if (!input.contains(".")) {
      return 0;
    } else {
      return (input.length() - input.indexOf('.') - 1);
    }
  }

  /**
   * Returns if the number is a valid value
   *
   * @param input the input string
   * @return if the number is a valid value
   */
  private boolean validValue(String input) {
    float f = Float.parseFloat(input);

    return (f >= minValue && f <= maxValue);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Number number = (Number) o;
    return Objects.equals(minValue, number.minValue) &&
        Objects.equals(maxValue, number.maxValue) &&
        Objects.equals(decimalPlaces, number.decimalPlaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minValue, maxValue, decimalPlaces);
  }

  @Override
  public String toString() {
    return "Number{" +
        "minValue=" + minValue +
        ", maxValue=" + maxValue +
        ", decimalPlaces=" + decimalPlaces +
        '}';
  }
}
