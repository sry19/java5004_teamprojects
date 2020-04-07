package controller.commandlineparser;

import static org.junit.Assert.*;

import controller.TaskManagerOptionsBuilder;
import org.junit.Before;
import org.junit.Test;

public class CommandLineParserTest {

  CommandLineParser commandLineParser, commandLineParser2;

  @Before

  public void setUp() throws Exception {
    commandLineParser = new CommandLineParser();
    commandLineParser2 = new CommandLineParser();
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--display"};
    commandLineParser2.parse(TaskManagerOptionsBuilder.build(), args);
  }

  @Test
  public void testEquals() {
    assertEquals(this.commandLineParser, this.commandLineParser);
    assertNotEquals(this.commandLineParser, null);
    assertNotEquals(this.commandLineParser, new String[]{});
    assertNotEquals(this.commandLineParser, this.commandLineParser2);

  }

  @Test
  public void testHashCode() {
    assertEquals(this.commandLineParser.hashCode(), this.commandLineParser.hashCode());
  }

  @Test
  public void testToString() {
    TaskManagerOptionsBuilder taskManagerOptionsBuilder = new TaskManagerOptionsBuilder();
    System.out.println(this.commandLineParser);
  }
}