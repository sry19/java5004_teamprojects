package controller.commandlineparser;

import static org.junit.Assert.*;

import controller.OptionConstants;
import controller.commandlineparser.exceptions.InvalidSplitterException;
import org.junit.Before;
import org.junit.Test;

public class OptionTest {

  Option option1, option2, option3;
  Option option4, option5, option6;
  Option option7, option8, option9;
  Option option10, option11, option12;
  Option option13;

  @Before
  public void setUp() throws Exception {
    this.option1 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option2 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option3 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option4 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(false).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option5 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(true)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option6 = new Option.Builder(OptionConstants.TODO_TEXT)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option7 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.SHOW_CATEGORY_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option8 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .addArgSplitter(",")
        .build();

    this.option9 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.TODO_TEXT_ARG_NAME)
        .build();

    this.option10 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .addDependencies(new String[]{OptionConstants.DISPLAY})
        .build();

    this.option11 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    this.option12 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(true)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .addArgSplitter(",")
        .build();

    this.option13 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(true)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .addArgSplitter(",")
        .build();

    this.option11 = this.option11.updateValue("123");
    this.option13 = this.option13.updateValue("1,2,3,4");
    this.option12 = this.option12.updateValue("1,2,3");
  }

  @Test(expected = InvalidSplitterException.class)
  public void invalidSplitter() throws InvalidSplitterException {
    Option option = new Option.Builder(OptionConstants.TODO_TEXT)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .addArgSplitter(" ")
        .build();
  }

  @Test
  public void testEquals() {
    assertEquals(this.option1, this.option1);
    assertNotEquals(this.option1, null);
    assertNotEquals(this.option1, new String[]{});
    assertEquals(this.option1, this.option2);
    assertNotEquals(this.option1, this.option3);
    assertNotEquals(this.option1, this.option4);
    assertNotEquals(this.option1, this.option5);
    assertNotEquals(this.option1, this.option6);
    assertNotEquals(this.option1, this.option7);
    assertNotEquals(this.option1, this.option8);
    assertNotEquals(this.option1, this.option9);
    assertNotEquals(this.option1, this.option10);
    assertNotEquals(this.option1, this.option11);
    assertNotEquals(this.option12, this.option13);
  }

  @Test
  public void testHashCode() {
    assertEquals(this.option1.hashCode(), this.option2.hashCode());
  }

  @Test
  public void testToString() {
    System.out.println(this.option1);
  }
}