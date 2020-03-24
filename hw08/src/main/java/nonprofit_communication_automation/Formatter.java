package nonprofit_communication_automation;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nonprofit_communication_automation.exceptions.InvalidTemplateException;

/**
 * Formatter is in charge of formatting a template line with provided HashMap.
 */
public class Formatter implements IFormatter {

  /**
   * format a single string with placeholder values.
   *
   * @param s       the input string.
   * @param hashMap the lookup table to replace the placeholder.
   * @return formatted string.
   * @throws InvalidTemplateException if the variable in template is not in provided table.
   */
  @Override
  public String format(String s, HashMap<String, String> hashMap)
      throws InvalidTemplateException {
    Pattern p = Pattern.compile("\\[\\[([^\\]]+)\\]\\]");
    Matcher m = p.matcher(s);
    while (m.find()) {
      String field = m.group(1);
      if (!hashMap.containsKey(field)) {
        throw new InvalidTemplateException();
      }
      s = s.replaceAll("\\[\\[" + field + "\\]\\]", hashMap.get(field));
    }
    return s;
  }
}
