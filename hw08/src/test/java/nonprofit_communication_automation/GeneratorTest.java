package nonprofit_communication_automation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GeneratorTest {

  Generator generator1, generator2, generator3, generator4, generator5, generator6;
  IFormatter formatter1;

  @Before
  public void setUp() throws Exception {
    this.formatter1 = new Formatter();
    this.generator1 = new Generator("src/main/resources/nonprofit-supporters.csv",
        "src/main/resources/email-template.txt", "src/resources/output", this.formatter1);
    this.generator2 = new Generator("src/main/resources/nonprofit-supporters.csv",
        "src/main/resources/email-template.txt", "src/resources/output", this.formatter1);

    this.generator3 = new Generator("src/main/resources/t.csv",
        "src/main/resources/email-template.txt", "src/resources/output", this.formatter1);
    this.generator4 = new Generator("src/main/resources/nonprofit-supporters.csv",
        "src/main/resources/t.txt", "src/resources/output", this.formatter1);
    this.generator5 = new Generator("src/main/resources/nonprofit-supporters.csv",
        "src/main/resources/email-template.txt", "src/resources/t", this.formatter1);
    this.generator6 = new Generator("src/main/resources/nonprofit-supporters.csv",
        "src/main/resources/email-template.txt", "src/resources/output", null);
  }

  @Test
  public void testEquals() {
    assertEquals(this.generator1, this.generator1);
    assertNotEquals(this.generator1, null);
    assertNotEquals(this.generator1, "");
    assertEquals(this.generator1, this.generator2);
    assertNotEquals(this.generator1, this.generator3);
    assertNotEquals(this.generator1, this.generator4);
    assertNotEquals(this.generator1, this.generator5);
    assertNotEquals(this.generator1, this.generator6);
  }

  @Test
  public void testHashCode() {
    assertEquals(this.generator1.hashCode(), this.generator2.hashCode());
  }

  @Test
  public void testToString() {
    String s = this.generator1.toString();
    assertEquals(s, this.generator1.toString());
  }
}