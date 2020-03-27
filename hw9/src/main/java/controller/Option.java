package controller;

public abstract class Option implements IOption {
  private String name;
  private boolean required;
  private boolean hasSubArgument;
  private String subArgument;
  private String description;

  public Option(String name, boolean required, boolean hasSubArgument, String subArgument,
      String description) {
    this.name = name;
    this.required = required;
    this.hasSubArgument = hasSubArgument;
    this.subArgument = subArgument;
    this.description = description;
  }
}