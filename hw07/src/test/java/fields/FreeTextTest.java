package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FreeTextTest {

  Validator<String> validator1;
  Validator<String> validator2;
  Validator<String> validator3;
  Validator<String> validator4;

  @Before
  public void setUp() throws Exception {
    validator1 = new FreeText(4, 2);
    validator2 = new FreeText(3, 2);
    validator3 = new FreeText(4, 1);
    validator4 = new FreeText(4, 2);
  }

  @Test
  public void isValid() {
    assertFalse(validator1.isValid(null));
    assertFalse(validator1.isValid("free text"));
    assertTrue(validator1.isValid("freetxt"));
    assertTrue(validator1.isValid("freetext"));
  }

  @Test
  public void testEquals() {
    assertEquals(validator1, validator1);
    assertEquals(validator1, validator4);
    assertNotEquals(validator1, validator2);
    assertNotEquals(validator1, validator3);
    assertFalse(validator1.equals(null));
    assertFalse(validator1.equals("ss"));
  }

  @Test
  public void testHashCode() {
    assertEquals(validator1.hashCode(), validator4.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("FreeText{numOfLines=4, numOfCharsPerLine=2}", validator1.toString());
  }
}