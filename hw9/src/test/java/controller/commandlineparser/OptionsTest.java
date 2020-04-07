package controller.commandlineparser;

import static org.junit.Assert.*;

import controller.OptionConstants;
import controller.TaskManagerOptionsBuilder;
import controller.commandlineparser.exceptions.OptionExistedException;
import org.junit.Before;
import org.junit.Test;

public class OptionsTest {

  Options options1, options2;

  @Before
  public void setUp() throws Exception {
    this.options1 = TaskManagerOptionsBuilder.build();
    this.options2 = TaskManagerOptionsBuilder.build();
  }

  @Test(expected = OptionExistedException.class)
  public void addExistedOption() throws OptionExistedException {
    Option option = new Option.Builder(OptionConstants.ADD_TODO).build();
    this.options1.addOption(option);
  }

  @Test
  public void testEquals() {
    assertEquals(this.options1, this.options1);
    assertNotEquals(this.options1, null);
    assertNotEquals(this.options1, new String[]{});
  }
}