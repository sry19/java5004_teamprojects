package controller.commandlineparser;

import static org.junit.Assert.*;

import com.sun.org.apache.xpath.internal.operations.String;
import controller.TaskManagerOptionsBuilder;
import org.junit.Before;
import org.junit.Test;

public class CommandLineTest {

  CommandLine commandLine1, commandLine2;

  @Before
  public void setUp() throws Exception {
    this.commandLine1 = new CommandLine(TaskManagerOptionsBuilder.build());
    Option option = new Option.Builder("test").addDescription("testOption").build();
    Options options = TaskManagerOptionsBuilder.build();
    options.addOption(option);
    this.commandLine2 = new CommandLine(options);
  }

  @Test
  public void testEquals() {
    assertEquals(this.commandLine1, this.commandLine1);
    assertNotEquals(this.commandLine1, null);
    assertNotEquals(this.commandLine1, new String[]{});
    assertNotEquals(this.commandLine1, this.commandLine2);
  }

  @Test
  public void testHashCode() {
    assertNotEquals(this.commandLine1.hashCode(), this.commandLine2.hashCode());
    assertEquals(this.commandLine1.hashCode(), this.commandLine1.hashCode());
  }

  @Test
  public void testToString() {
    System.out.println(this.commandLine1);
  }
}