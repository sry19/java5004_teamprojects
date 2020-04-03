package controller;

import controller.commandlineparser.Option;
import java.util.List;

public class OptionWithSubOption extends Option {
  private String subArgument;

  public OptionWithSubOption(String name, String description, boolean required, boolean hasSubArg,
      boolean hasSubArgs, boolean subArgRequired, boolean argName, String value,
      List<String> values, String subArgument) {
    super(name, description, required, hasSubArg, hasSubArgs, subArgRequired, argName, value,
        values);
    this.subArgument = subArgument;
  }

  @Override
  public void takeActions() {
  }
}