package model.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import exceptions.InvalidCSVFileException;

/**
 * The type Csv reader.
 */
public class CSVReader implements IReader {

  private BufferedReader data;
  private String inputDataPath;
  private String[] fields;
  private int fieldNum;

  /**
   * Initialize a CSV Reader.
   *
   * @param inputDataPath the input csv file path.
   * @throws IOException             if IO error happens.
   * @throws InvalidCSVFileException if the CSVFile is invalid.
   */
  public CSVReader(String inputDataPath) throws IOException, InvalidCSVFileException {
    this.inputDataPath = inputDataPath;
    this.data = new BufferedReader(new FileReader(inputDataPath));
    this.setFields();
  }

  /**
   * Read the next row of the CSV file and return a HashMap.
   *
   * @return the result as a HashMap.
   * @throws IOException             if IO error happens.
   * @throws InvalidCSVFileException if the CSVFile is invalid.
   */
  public HashMap<String, String> readNextRow() throws IOException, InvalidCSVFileException {
    String row = this.data.readLine();
    if (row == null) {
      return null;
    }
    return this.parseRow(row);
  }

  /**
   * Cleanup the BufferReader.
   *
   * @throws IOException if IO error happens.
   */
  public void close() throws IOException {
    this.data.close();
  }

  /**
   * Parse a single row of the csv file and return a HashMap.
   *
   * @param row the input row
   * @return the HashMap with key value pair.
   * @throws InvalidCSVFileException if the CSV File is invalid.
   */
  private HashMap<String, String> parseRow(String row) throws InvalidCSVFileException {
    HashMap<String, String> res = new HashMap<>();
    String[] columns = row.split("\",\"");  // TODO might need to be improved
    if (columns.length != this.fieldNum) {
      throw new InvalidCSVFileException();
    }
    for (int i = 0; i < columns.length; i++) {
      res.put(this.fields[i], trimQuotes(columns[i]));
    }
    return res;
  }

  /**
   * Set the head of the csv file.
   *
   * @throws IOException             if IO error happens.
   * @throws InvalidCSVFileException if the CSVFile is invalid.
   */
  private void setFields() throws IOException, InvalidCSVFileException {
    String headRow = this.data.readLine();
    if (headRow == null) {
      throw new InvalidCSVFileException();
    }

    this.fields = headRow.split("\",\"");
    this.fieldNum = this.fields.length;

    for (int i = 0; i < this.fieldNum; i++) {
      this.fields[i] = trimQuotes(this.fields[i]);
    }
  }

  /**
   * Trim the starting and ending quote of a String.
   *
   * @param s the provided string.
   * @return the trimmed string.
   */
  private static String trimQuotes(String s) {
    return s.replaceAll("^\"|\"$", "");
  }

  /**
   * Get fields string [ ].
   *
   * @return fields. string [ ]
   */
  public String[] getFields() {
    return fields;
  }

  /**
   * Gets field num.
   *
   * @return number of fields.
   */
  public int getFieldNum() {
    return fieldNum;
  }

  /**
   * equals
   *
   * @param o object
   * @return if they are equal, return true. Otherwise, return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CSVReader csvReader = (CSVReader) o;
    return inputDataPath.equals(csvReader.inputDataPath);
  }

  /**
   * computes hashcode
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(data, getFieldNum());
    result = 31 * result + Arrays.hashCode(getFields());
    return result;
  }

  /**
   * return to string
   *
   * @return string
   */
  @Override
  public String toString() {
    return "CSVReader{" +
        "inputDataPath='" + inputDataPath + '\'' +
        ", fields=" + Arrays.toString(fields) +
        ", fieldNum=" + fieldNum +
        '}';
  }
}

