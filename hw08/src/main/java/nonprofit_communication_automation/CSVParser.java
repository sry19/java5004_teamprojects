package nonprofit_communication_automation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Csv parser.
 */
public class CSVParser {
  private ArrayList<String> titles;
  private int category;

  /**
   * Instantiates a new Csv parser.
   *
   * @param header the header
   */
  public CSVParser(String header) {
    this.titles = new ArrayList<>();
    this.category = 0;
    headerParser(header);
  }

  /**
   * initializes all fields in a CSVParser object
   *
   * @param header the header
   */
  public void headerParser(String header) {
    String[] titles = lineSplitter(header);
    checkTitles(titles);
  }

  /**
   * calculates the number of keys in user data and assigns to fields
   *
   * @param titles the titles
   */
  public void checkTitles(String[] titles) {
    ArrayList<String> newTitles = new ArrayList<>();
    for (String title: titles) {
      if (title != "" && this.isValidTitle(title)) {
        newTitles.add(title);
        this.category++;
      }
    }
    this.titles = newTitles;
  }

  /**
   * checks if it is a valid keyword
   *
   * @param title the title
   * @return the boolean
   */
  public boolean isValidTitle(String title) {
    return title.matches("[_\\w]+");
  }

  /**
   * builds a map to correspond keys with values
   *
   * @param line the line
   * @return the map
   */
  public Map<String, String> dataMatcher(String line) {
    String[] data = lineSplitter(line);
    ArrayList<String> newData = this.checkData(data);
    Map<String, String> matcher = new HashMap<>();
    for (int i = 0; i < this.category; i++) {
      matcher.put(this.titles.get(i), newData.get(i));
    }
    return matcher;
  }

  /**
   * Check data array list.
   *
   * @param data the data
   * @return the array list
   */
  public ArrayList<String> checkData(String[] data) {
    ArrayList<String> newData = new ArrayList<>();
    int size = 0;
    for (String title: titles) {
      if (title != "") {
        newData.add(title);
        size++;
      }
    }
    if (size != this.category) {
      throw new illegalDataException();
    }
    return newData;
  }

  /**
   * splits a line.
   *
   * @param line the line
   * @return the string [ ]
   */
  public String[] lineSplitter(String line) {
    String[] titles = line.split("\\\"\\,\\\"|\\\"");
    return titles;
  }

  /**
   * Gets titles.
   *
   * @return the titles
   */
  public ArrayList<String> getTitles() {
    return titles;
  }

  /**
   * Gets category.
   *
   * @return the category
   */
  public int getCategory() {
    return category;
  }
}
