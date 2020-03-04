package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FreeTextTest {

  Validator<String> validator1;
  @Before
  public void setUp() throws Exception {
    validator1 = new FreeText(4,2);
  }

  @Test
  public void isValid() {
    assertFalse(validator1.isValid("free text"));
    assertTrue(validator1.isValid("freetxt"));
    assertTrue(validator1.isValid("freetext"));
  }
}