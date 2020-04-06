package model.reader;

import exceptions.InvalidCSVFileException;
import java.io.IOException;
import java.util.HashMap;

public interface IReader {

  /**
   * Cleanup the BufferReader.
   *
   * @throws IOException if IO error happens.
   */
  void close() throws IOException;

  /**
   * Read the next row of the CSV file and return a HashMap.
   *
   * @return the result as a HashMap.
   * @throws IOException             if IO error happens.
   * @throws InvalidCSVFileException if the CSVFile is invalid.
   */
  HashMap<String, String> readNextRow() throws IOException;
}