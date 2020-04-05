package model.reader;

import java.io.IOException;
import java.util.HashMap;

public interface IReader {

  void close() throws IOException;

  HashMap<String, String> readNextRow() throws IOException;
}