package controller;

public class OptionWithoutSubOption extends Option  {

  public OptionWithoutSubOption(String name, boolean required, boolean hasSubArgument,
      String description) {
    super(name, required, hasSubArgument, description);
  }

  @Override
  public void takeActions() {
  }
}