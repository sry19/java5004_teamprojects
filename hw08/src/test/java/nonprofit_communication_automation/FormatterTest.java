package nonprofit_communication_automation;

import static org.junit.Assert.*;

import java.util.HashMap;
import nonprofit_communication_automation.exceptions.InvalidTemplateException;
import org.junit.Before;
import org.junit.Test;

public class FormatterTest {

  Formatter formatter;

  @Before
  public void setUp() throws Exception {
    this.formatter = new Formatter();
  }

  @Test(expected = InvalidTemplateException.class)
  public void formatInvalidTemplate() throws Exception {
    String s = "Dear [[first_name]] [[last_name]],";
    HashMap<String, String> hashMap = new HashMap<>();
    assertEquals("Dear Bryan Pei,", this.formatter.format(s, hashMap));
  }

  @Test
  public void format() throws Exception {
    String s = "Dear [[first_name]] [[last_name]],";
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("first_name", "Bryan");
    hashMap.put("last_name", "Pei");
    assertEquals("Dear Bryan Pei,", this.formatter.format(s, hashMap));
  }
}