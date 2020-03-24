package nonprofit_communication_automation;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class ArgumentHandlerTest {

  ArgumentHandler argumentHandler;
  ArgumentHandler argumentHandler1;

  @Before
  public void setUp() throws Exception {
    argumentHandler = new ArgumentHandler();
    argumentHandler1 = new ArgumentHandler();
  }

  @Test
  public void commandLineParser() {
    String[] args = new String[]{"--csv-file", "abc.csv", "--output-dir", "dir", "--email-template",
        "abs.txt", "--email"};
    assertTrue(argumentHandler.commandLineParser(args));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCommandLineParser() {
    String[] args = new String[]{"--csv-file", "--output-dir", "dir", "--email-template", "abs.txt",
        "--email"};
    argumentHandler.commandLineParser(args);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCommandLineParser2() {
    String[] args = new String[]{"--csv-file", "abc.csv", "--output-dir", "--email-template",
        "abs.txt", "--email"};
    argumentHandler.commandLineParser(args);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCommandLineParser3() {
    String[] args = new String[]{"--csv-file", "xx.csv", "--output-dir", "dir", "--email-template",
        "--email"};
    argumentHandler.commandLineParser(args);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCommandLineParser4() {
    String[] args = new String[]{"--csv-file", "xx.csv", "--output-dir", "dir", "--email-template",
        "abs.txt", "--email", "--output-dir", "dir"};
    argumentHandler.commandLineParser(args);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCommandLineParser5() {
    String[] args = new String[]{"--csv-file", "xx.csv", "--csv-file", "xx.csv", "--output-dir",
        "dir", "--email-template", "abs.txt", "--email"};
    argumentHandler.commandLineParser(args);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCommandLineParser6() {
    String[] args = new String[]{"--csv-file", "xx.csv", "--output-dir", "dir", "--email-template",
        "abs.txt"};
    argumentHandler.commandLineParser(args);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCommandLineParser7() {
    String[] args = new String[]{"--csv-file", "xx.cs", "--output-dir", "dir", "--email-template",
        "abs.txt"};
    argumentHandler.commandLineParser(args);
  }

  @Test
  public void labelParser() {
    argumentHandler.getVisitedTemplate().put("--email", "abs.txt");
    assertFalse(argumentHandler.getVisitedTemplate().isEmpty());
    assertTrue(argumentHandler.labelParser("--email"));
    assertTrue(argumentHandler.getVisitedTemplate().isEmpty());

    assertTrue(argumentHandler.getVisitedLabel().isEmpty());
    assertTrue(argumentHandler.labelParser("--email"));
    assertFalse(argumentHandler.getVisitedLabel().isEmpty());
  }

  @Test
  public void templateParser() {
    String[] args = new String[]{"--csv-file", "abc.csv", "--output-dir", "dir", "--email-template",
        "abs.txt", "--email"};
    assertTrue(argumentHandler.templateParser(args, 4, "--email"));
    assertEquals("{--email=abs.txt}", argumentHandler.getVisitedTemplate().toString());

    String[] args1 = new String[]{"--csv-file", "abc.csv", "--email", "--output-dir", "dir",
        "--email-template", "abs.txt"};
    Set<String> set = new HashSet<>();
    set.add("--email");
    argumentHandler1.setVisitedLabel(set);
    argumentHandler1.templateParser(args1, 5, "--email");
    assertTrue(argumentHandler1.getVisitedLabel().isEmpty());
    assertEquals("[abs.txt]", argumentHandler1.getTemplateList().toString());
  }

  @Test
  public void invalidTemplateParser1() {
    String[] args = new String[]{"--csv-file", "abc.csv", "--email-template"};
    assertFalse(argumentHandler.templateParser(args, 2, "--email"));
  }

  @Test
  public void invalidTemplateParser2() {
    String[] args = new String[]{"--output-dir", "dir", "--email-template", "abs.jpg", "--email"};
    assertFalse(argumentHandler.templateParser(args, 2, "--email"));
  }

  @Test
  public void invalidTemplateParser3() {
    String[] args = new String[]{"--csv-file", "abc.csv", "--email", "--output-dir", "dir",
        "--email-template"};
    Set<String> set = new HashSet<>();
    set.add("--email");
    argumentHandler.setVisitedLabel(set);
    assertFalse(argumentHandler.templateParser(args, 5, "--email"));
  }

  @Test
  public void invalidTemplateParser4() {
    String[] args = new String[]{"--csv-file", "abc.csv", "--email", "--output-dir", "dir",
        "--email-template", "avs"};
    Set<String> set = new HashSet<>();
    set.add("--email");
    argumentHandler.setVisitedLabel(set);
    assertFalse(argumentHandler.templateParser(args, 5, "--email"));
  }

  @Test
  public void checkRequiredArguments() {
    argumentHandler.setCsvFile("xxx");
    argumentHandler.setOutputDir("yyy");
    ArrayList<String> array = new ArrayList<String>();
    array.add("zzz");
    argumentHandler.setTemplateList(array);
    assertTrue(argumentHandler.checkRequiredArguments());
  }

  @Test
  public void invalidCheckRequiredArguments1() {
    argumentHandler.setOutputDir("yyy");
    ArrayList<String> array = new ArrayList<String>();
    array.add("zzz");
    argumentHandler.setTemplateList(array);
    assertFalse(argumentHandler.checkRequiredArguments());
  }

  @Test
  public void invalidCheckRequiredArguments2() {
    argumentHandler.setCsvFile("xxx");
    ArrayList<String> array = new ArrayList<String>();
    array.add("zzz");
    argumentHandler.setTemplateList(array);
    assertFalse(argumentHandler.checkRequiredArguments());
  }

  @Test
  public void invalidCheckRequiredArguments3() {
    argumentHandler.setCsvFile("xxx");
    argumentHandler.setOutputDir("yyy");
    assertFalse(argumentHandler.checkRequiredArguments());
  }

  @Test
  public void isValidPath() {
    assertTrue(argumentHandler.isValidPath("aaa"));
    assertTrue(argumentHandler.isValidPath("a_b" + File.separator + "513b"));
    assertFalse(argumentHandler.isValidPath("bs.c"));
  }

  @Test
  public void getInputFile() {
    argumentHandler.setCsvFile("zxc");
    assertEquals("zxc", argumentHandler.getCsvFile());
  }

  @Test
  public void getInputFilePath() {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("xxx");
    argumentHandler.setTemplateList(arrayList);
    assertEquals("[xxx]", argumentHandler.getTemplateList().toString());
  }

  @Test
  public void getOutputDir() {
    argumentHandler.setOutputDir("asd");
    assertEquals("asd", argumentHandler.getOutputDir());
  }

  @Test
  public void getVisitedLabel() {
    HashSet<String> set = new HashSet<>();
    set.add("zzz");
    argumentHandler.setVisitedLabel(set);
    assertEquals("[zzz]", argumentHandler.getVisitedLabel().toString());
  }

  @Test
  public void getVisitedTemplate() {
    HashMap<String, String> map = new HashMap<>();
    map.put("a", "b");
    argumentHandler.setVisitedTemplate(map);
    assertEquals("{a=b}", argumentHandler.getVisitedTemplate().toString());
  }

  @Test
  public void isValidCSVFile() {
    assertTrue(argumentHandler.isValidCSVFile("xxx.csv"));
    assertTrue(argumentHandler.isValidCSVFile("asd.sd.csv"));
  }

  @Test
  public void getLog() {
    assertEquals(new ErrorLogger(), argumentHandler.getLog());
  }

  @Test
  public void testEqual() {
  }

  @Test
  public void testHashcode() {
  }

  @Test
  public void testToString() {
    assertEquals("ArgumentHandler{csvFile='null', templateList=[], outputDir='null', visitedLabel=[], visitedTemplate={}, log=Empty log}", argumentHandler.toString());
  }
}
