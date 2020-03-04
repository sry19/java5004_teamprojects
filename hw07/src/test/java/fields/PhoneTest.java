package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneTest {
  Validator<String> validator1;

  @Before
  public void setUp() throws Exception {
    validator1 = new Phone(6);
  }

  @Test
  public void isValid() {
    assertTrue(validator1.isValid("123456"));
    assertFalse(validator1.isValid("123a45"));
    assertFalse(validator1.isValid("123"));
    assertFalse(validator1.isValid("1234567"));
  }
}