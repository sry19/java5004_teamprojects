package controller;

public abstract class Option implements IOption {
  private String name;
  private boolean required;
  private boolean hasSubArgument;
  private String description;

  public Option(String name, boolean required, boolean hasSubArgument,
      String description) {
    this.name = name;
    this.required = required;
    this.hasSubArgument = hasSubArgument;
    this.description = description;
  }
}