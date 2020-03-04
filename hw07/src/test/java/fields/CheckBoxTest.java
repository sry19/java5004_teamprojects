package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckBoxTest {

  CheckBox checkBox;

  @Before
  public void setUp() throws Exception {
    this.checkBox = new CheckBox();
  }

  @Test
  public void isValid() {
    assertTrue(this.checkBox.isValid(true));
    assertTrue(this.checkBox.isValid(false));
    assertTrue(this.checkBox.isValid(null));
  }
}