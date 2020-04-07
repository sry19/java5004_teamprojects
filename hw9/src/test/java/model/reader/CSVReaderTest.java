package model.reader;

import static org.junit.Assert.*;

import exceptions.InvalidCSVFileException;
import java.io.IOException;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {

  CSVReader csvReader, csvReader2, csvReader3, csvReader4;

  @Before
  public void setUp() throws Exception {
    this.csvReader = new CSVReader("src/main/resources/todolist.csv");
    this.csvReader2 = new CSVReader("src/main/resources/invalid.csv");
    this.csvReader4 = new CSVReader("src/main/resources/todolist.csv");
  }

  @Test
  public void readEmptyCSVFile() throws Exception {
    assertNull(this.csvReader2.readNextRow());
  }

  @Test(expected = InvalidCSVFileException.class)
  public void readInvalidCSVFile() throws Exception {
    this.csvReader3 = new CSVReader("src/main/resources/emptytodolist.csv");
  }

  @Test
  public void checkInitialization() throws IOException, InvalidCSVFileException {
    // 12 fields of the example csv file.
    assertEquals(6, this.csvReader.getFieldNum());

    String[] fields = this.csvReader.getFields();
    assertEquals("id", fields[0]);
    assertEquals("text", fields[1]);
    assertEquals("completed", fields[2]);
    assertEquals("due", fields[3]);
    assertEquals("priority", fields[4]);
    assertEquals("category", fields[5]);
    this.csvReader.close();
  }

  @Test
  public void readNextRow() throws IOException, InvalidCSVFileException {
    HashMap<String, String> hashMap = this.csvReader.readNextRow();
    assertEquals("1", hashMap.get("id"));
    assertEquals("Finish HW9", hashMap.get("text"));
    assertEquals("false", hashMap.get("completed"));
    assertEquals("3/22/2020", hashMap.get("due"));
    assertEquals("1", hashMap.get("priority"));
    assertEquals("school", hashMap.get("category"));
    this.csvReader.readNextRow();
    assertNull(this.csvReader.readNextRow());
    this.csvReader.close();
  }

  @Test
  public void testEquals() {
    assertEquals(this.csvReader, this.csvReader);
    assertNotEquals(this.csvReader, null);
    assertNotEquals(this.csvReader, "");
    assertEquals(this.csvReader, this.csvReader4);
  }

  @Test
  public void testHashCode() {
    assertEquals(this.csvReader.hashCode(), this.csvReader.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("CSVReader{inputDataPath='src/main/resources/todolist.csv', fields=[id, text, completed, due, priority, category], fieldNum=6}", this.csvReader.toString());
  }
}
