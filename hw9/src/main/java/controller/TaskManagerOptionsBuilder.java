package controller;

import controller.commandlineparser.Option;
import controller.commandlineparser.Options;
import controller.commandlineparser.exceptions.InvalidSplitterException;
import controller.commandlineparser.exceptions.OptionExistedException;

/**
 * An Options Builder for our application, which uses the general commandlineparser package we
 * wrote. This defines all the options we use in this particular application. We can modify it any
 * time in this class.
 */
public class TaskManagerOptionsBuilder extends Options {

  /**
   * Build the options we need for task manager.
   *
   * @return the Options object.
   * @throws InvalidSplitterException if the argSplitter is invalid.
   * @throws OptionExistedException   if the Options already existed in the container.
   */
  public static Options build() throws InvalidSplitterException, OptionExistedException {
    Option option1 = new Option.Builder("--csv-file")
        .addDescription("The CSV file containing the todos. This option is required.")
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false).addArgName("<path/to/file>")
        .build();

    Option option2 = new Option.Builder("--add-todo").addDescription(
        "Add a new todo. If this option is provided, then --todo-text must also be provided.")
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{"--todo-text"})
        .build();

    Option option3 = new Option.Builder("--todo-text").addDescription("A description of the todo.")
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false)
        .addArgName("<description of todo>").addDependencies(new String[]{"--add-todo"}).build();

    Option option4 = new Option.Builder("--completed")
        .addDescription("(Optional) Sets the completed status of a new todo to true.")
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{"--add-todo"}).build();

    Option option5 = new Option.Builder("--due").addDescription(
        "(Optional) Sets the due date of a new todo. You may choose how the date should be formatted.")
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false).addArgName("<due date>")
        .addDependencies(new String[]{"--add-todo"}).build();

    Option option6 = new Option.Builder("--priority")
        .addDescription("(Optional) Sets the priority of a new todo. The value can be 1, 2, or 3.")
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false).addArgName("<1, 2, or 3>")
        .addDependencies(new String[]{"--add-todo"}).build();

    Option option7 = new Option.Builder("--category").addDescription(
        "(Optional) Sets the category of a new todo. The value can be any String. Categories do not need to be pre-defined.")
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false).addArgName("<a category name>")
        .addDependencies(new String[]{"--add-todo"}).build();

    Option option8 = new Option.Builder("--complete-todo")
        .addDescription("Mark the Todo with the provided ID as complete.").addRequired(false)
        .addHasSubArg(true).addHasSubArgs(true).addArgSplitter(",").addArgName("<id1,id2>").build();

    Option option9 = new Option.Builder("--display").addDescription(
        "Display todos. If none of the following optional arguments are provided, displays all todos.")
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false).build();

    Option option10 = new Option.Builder("--show-incomplete").addDescription(
        "(Optional) If --display is provided, only incomplete todos should be displayed.")
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{"--display"}).build();

    Option option11 = new Option.Builder("--show-category").addDescription(
        "(Optional) If --display is provided, only todos with the given category should be displayed.")
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false).addArgName("<category>")
        .addDependencies(new String[]{"--display"}).build();

    Option option12 = new Option.Builder("--sort-by-date").addDescription(
        "(Optional) If --display is provided, sort the list of todos by date order (ascending). Cannot be combined with --sort-by-priority.")
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{"--display"}).build();

    Option option13 = new Option.Builder("--sort-by-priority").addDescription(
        "(Optional) If --display is provided, sort the list of todos by priority (ascending). Cannot be combined with --sort-by-date.")
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{"--display"}).build();

    Options options = new Options();
    options.addOption(option1);
    options.addOption(option2);
    options.addOption(option3);
    options.addOption(option4);
    options.addOption(option5);
    options.addOption(option6);
    options.addOption(option7);
    options.addOption(option8);
    options.addOption(option9);
    options.addOption(option10);
    options.addOption(option11);
    options.addOption(option12);
    options.addOption(option13);
    return options;
  }
}
