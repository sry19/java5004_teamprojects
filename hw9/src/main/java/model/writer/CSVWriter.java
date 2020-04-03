package model.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter implements IWriter {
  private String filepath;
  private BufferedWriter writer;


  // write only once

  // what if the user forgets to close
  public CSVWriter(String filepath) throws IOException {
    this.filepath = filepath;
    this.writer = new BufferedWriter(new FileWriter(filepath,true));
  }
  // how to close the file if there is an exception
  public void addLine(String newLine) throws IOException {
    try {
      this.writer.write(newLine);
    } catch (IOException ioe) {
      this.closeFile();
    }
  }

  public void closeFile() throws IOException {
    writer.close();
  }
}
