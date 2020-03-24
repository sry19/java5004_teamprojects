package nonprofit_communication_automation;

import java.util.HashMap;
import nonprofit_communication_automation.exceptions.InvalidTemplateException;

public interface IFormatter {

  /**
   * format a single string with placeholder values.
   *
   * @param s       the input string.
   * @param hashMap the lookup table to replace the placeholder.
   * @return formatted string.
   * @throws InvalidTemplateException if the variable in template is not in provided table.
   */
  String format(String s, HashMap<String, String> hashMap) throws InvalidTemplateException;
}
