package controller;

public class OptionWithSubOption extends Option {
  private String subArgument;

  public OptionWithSubOption(String name, boolean required, boolean hasSubArgument,
      String subArgument, String description) {
    super(name, required, hasSubArgument, description);
    this.subArgument = subArgument;
  }

  @Override
  public void takeActions() {

  }
}