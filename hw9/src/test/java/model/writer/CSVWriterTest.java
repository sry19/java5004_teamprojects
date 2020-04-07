package model.writer;

import static org.junit.Assert.*;

import java.io.IOException;
import model.reader.CSVReader;
import org.junit.Before;
import org.junit.Test;

public class CSVWriterTest {
  CSVWriter csvWriter3;

  @Before
  public void setUp() throws Exception {
    this.csvWriter3 = new CSVWriter("src/main/resources/writer.csv");
  }

  @Test
  public void write() throws IOException {
    this.csvWriter3.write("\"2\",\"Mail passport application, photo\",\"true\",\"2/28/2020\",\"?\",\"?\"");
    this.csvWriter3.closeFile();
  }

}