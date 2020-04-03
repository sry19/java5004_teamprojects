package controller.commandlineparser;

import java.util.List;

public class Option {

  private String name;
  private String description;
  private boolean required;
  private boolean hasSubArg;
  private boolean hasSubArgs;
  private boolean subArgRequired;
  private boolean argName;
  private String value;
  private List<String> values;

  public Option(String name, String description, boolean required, boolean hasSubArg,
      boolean hasSubArgs, boolean subArgRequired, boolean argName, String value,
      List<String> values) {
    this.name = name;
    this.description = description;
    this.required = required;
    this.hasSubArg = hasSubArg;
    this.hasSubArgs = hasSubArgs;
    this.subArgRequired = subArgRequired;
    this.argName = argName;
    this.value = value;
    this.values = values;
  }


}