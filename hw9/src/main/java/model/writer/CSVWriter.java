package model.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Csv writer.
 */
public class CSVWriter implements IWriter {

  private BufferedWriter writer;

  /**
   * Instantiates a new Csv writer.
   *
   * @param filepath the filepath
   * @throws IOException the io exception
   */
  public CSVWriter(String filepath) throws IOException {
    this.writer = new BufferedWriter(new FileWriter(filepath));
  }

  /**
   * writes the contents to the file
   *
   * @param content a string
   * @throws IOException io exception
   */
  public void write(String content) throws IOException {
    this.writer.write(content);
  }

  /**
   * closes the file
   *
   * @throws IOException io exception
   */
  public void closeFile() throws IOException {
    writer.close();
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

    CSVWriter csvWriter = (CSVWriter) o;

    return writer.equals(csvWriter.writer);
  }

  /**
   * computes hashcode
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return writer.hashCode();
  }

  /**
   * return to string
   *
   * @return string
   */
  @Override
  public String toString() {
    return "CSVWriter{" +
        "writer=" + writer +
        '}';
  }
}
