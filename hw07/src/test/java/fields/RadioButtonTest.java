package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RadioButtonTest {
  RadioButton button;

  @Before
  public void setUp() throws Exception {
    button = new RadioButton();
  }

  @Test
  public void isValid() {
    assertFalse(button.isValid(null));
    assertTrue(button.isValid(true));
    assertTrue(button.isValid(false));
  }
}