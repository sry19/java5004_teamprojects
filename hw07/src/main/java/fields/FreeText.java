package fields;


/**
 * The free text validator.
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
    if (input == null) {
      return false;
    }
    if (input.length() <= this.numOfCharsPerLine * this.numOfLines) {
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FreeText freeText = (FreeText) o;

    if (!numOfLines.equals(freeText.numOfLines)) {
      return false;
    }
    return numOfCharsPerLine.equals(freeText.numOfCharsPerLine);
  }

  @Override
  public int hashCode() {
    int result = numOfLines.hashCode();
    result = 31 * result + numOfCharsPerLine.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "FreeText{" +
        "numOfLines=" + numOfLines +
        ", numOfCharsPerLine=" + numOfCharsPerLine +
        '}';
  }
}
