package model.writer;

import java.io.IOException;

public interface IWriter {

  void addLine(String newLine) throws IOException;

  void closeFile() throws IOException;

  void write(String content) throws IOException;
}
