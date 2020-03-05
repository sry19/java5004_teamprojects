package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneTest {

  Validator<String> validator1;
  Validator<String> validator2;
  Validator<String> validator3;

  @Before
  public void setUp() throws Exception {
    validator1 = new Phone(6);
    validator2 = new Phone(5);
    validator3 = new Phone(6);
  }

  @Test
  public void isValid() {
    assertTrue(validator1.isValid("123456"));
    assertFalse(validator1.isValid("123a45"));
    assertFalse(validator1.isValid("123"));
    assertFalse(validator1.isValid("1234567"));
  }

  @Test
  public void testEquals() {
    assertEquals(validator1, validator1);
    assertEquals(validator1, validator3);
    assertNotEquals(validator1, validator2);
    assertFalse(validator1.equals(null));
    assertFalse(validator1.equals("ss"));
  }

  @Test
  public void testHashCode() {
    assertEquals(validator1.hashCode(), validator3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Phone{len=6}", validator1.toString());
  }
}