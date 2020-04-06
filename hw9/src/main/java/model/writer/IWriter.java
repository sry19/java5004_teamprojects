package model.writer;

import java.io.IOException;

public interface IWriter {

  /**
   * closes the file
   *
   * @throws IOException io exception
   */
  void closeFile() throws IOException;

  /**
   * writes the contents to the file
   *
   * @param content a string
   * @throws IOException io exception
   */
  void write(String content) throws IOException;
}
