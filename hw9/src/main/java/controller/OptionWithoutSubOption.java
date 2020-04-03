package controller;

import controller.commandlineparser.Option;
import java.util.List;

public class OptionWithoutSubOption extends Option {

  public OptionWithoutSubOption(String name, String description, boolean required,
      boolean hasSubArg,
      boolean hasSubArgs, boolean subArgRequired, boolean argName, String value,
      List<String> values) {
    super(name, description, required, hasSubArg, hasSubArgs, subArgRequired, argName, value,
        values);
  }

  @Override
    public void takeActions() {
    }
  }