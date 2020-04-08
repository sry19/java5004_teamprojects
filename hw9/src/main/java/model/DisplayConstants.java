package model;

public class DisplayConstants {

  public static final int ID_WIDTH = 5;
  public static final int TEXT_WIDTH = 30;
  public static final int COMPLETED_WIDTH = 15;
  public static final int DUE_WIDTH = 15;
  public static final int PRIORITY_WIDTH = 10;
  public static final int CATEGORY_WIDTH = 15;
  public static final String SPLITTER = "-";
  public static final String HEADER_ID = "ID";
  public static final String HEADER_TEXT = "TEXT";
  public static final String HEADER_COMPLETED = "COMPLETED";
  public static final String HEADER_DUE = "DUE";
  public static final String HEADER_PRIORITY = "PRIORITY";
  public static final String HEADER_CATEGORY = "CATEGORY";

  public static final String fmt = "| %-" + ID_WIDTH + "s" +
      "| %-" + TEXT_WIDTH + "s" +
      "| %-" + COMPLETED_WIDTH + "s" +
      "| %-" + DUE_WIDTH + "s" +
      "| %-" + PRIORITY_WIDTH + "s" +
      "| %-" + CATEGORY_WIDTH + "s";
}
