package nonprofit_communication_automation;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import nonprofit_communication_automation.exceptions.InvalidCSVFileException;
import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {

  CSVReader csvReader, csvReader2, csvReader3, csvReader4;

  @Before
  public void setUp() throws Exception {
    this.csvReader = new CSVReader("src/main/resources/nonprofit-supporters.csv");
    this.csvReader2 = new CSVReader("src/main/resources/invalid.csv");
    this.csvReader4 = new CSVReader("src/main/resources/nonprofit-supporters.csv");
  }

  @Test(expected = InvalidCSVFileException.class)
  public void readEmptyCSVFile() throws Exception {
    this.csvReader2.readNextRow();
  }

  @Test(expected = InvalidCSVFileException.class)
  public void readInvalidCSVFile() throws Exception {
    this.csvReader3 = new CSVReader("src/main/resources/empty.csv");
  }

  @Test
  public void checkInitialization() throws IOException, InvalidCSVFileException {
    // 12 fields of the example csv file.
    assertEquals(12, this.csvReader.getFieldNum());

    String[] fields = this.csvReader.getFields();
    assertEquals("first_name", fields[0]);
    assertEquals("last_name", fields[1]);
    assertEquals("company_name", fields[2]);
    assertEquals("address", fields[3]);
    assertEquals("city", fields[4]);
    assertEquals("county", fields[5]);
    this.csvReader.close();
  }

  @Test
  public void readNextRow() throws IOException, InvalidCSVFileException {
    // First row is
    // "James","Butt","Benton, John B Jr","6649 N Blue Gum St","New Orleans",...
    HashMap<String, String> hashMap = this.csvReader.readNextRow();
    assertEquals("James", hashMap.get("first_name"));
    assertEquals("Butt", hashMap.get("last_name"));
    assertEquals("Benton, John B Jr", hashMap.get("company_name"));
    assertEquals("6649 N Blue Gum St", hashMap.get("address"));
    assertEquals("New Orleans", hashMap.get("city"));
    assertNull(this.csvReader.readNextRow());
    this.csvReader.close();
  }

  @Test
  public void testEquals() {
    assertEquals(this.csvReader, this.csvReader);
    assertNotEquals(this.csvReader, null);
    assertNotEquals(this.csvReader, "");
    assertEquals(this.csvReader, this.csvReader4);
    assertNotEquals(this.csvReader, this.csvReader2);
  }

  @Test
  public void testHashCode() {
    assertEquals(this.csvReader.hashCode(), this.csvReader.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("CSVReader{inputDataPath='src/main/resources/nonprofit-supporters.csv', fields=[first_name, last_name, company_name, address, city, county, state, zip, phone1, phone2, email, web], fieldNum=12}", this.csvReader.toString());
  }
}