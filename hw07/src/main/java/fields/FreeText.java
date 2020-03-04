package fields;

/**
 * Ruoyun
 */
public class FreeText implements Validator<String> {

  private Integer numOfLines;
  private Integer numOfCharsPerLine;

  /**
   * Instantiates a new Free text validator.
   *
   * @param numOfLines        the num of lines
   * @param numOfCharsPerLine the num of chars per line
   */
  public FreeText(Integer numOfLines, Integer numOfCharsPerLine) {
    this.numOfLines = numOfLines;
    this.numOfCharsPerLine = numOfCharsPerLine;
  }

  /**
   * Check if an input is valid.
   *
   * @param input the input to check.
   * @return true or false.
   */
  @Override
  public boolean isValid(String input) {
    if (input.length() <= this.numOfCharsPerLine * this.numOfLines) {
      return true;
    }
    return false;
  }
}
