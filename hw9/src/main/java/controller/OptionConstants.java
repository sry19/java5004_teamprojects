package controller;

import javax.swing.Spring;

/**
 * Option name arg name and other related constants for our task manager.
 */
public class OptionConstants {

  public static final String CSV_FILE = "--csv-file";
  public static final String ADD_TODO = "--add-todo";
  public static final String TODO_TEXT = "--todo-text";
  public static final String COMPLETED = "--completed";
  public static final String DUE = "--due";
  public static final String PRIORITY = "--priority";
  public static final String CATEGORY = "--category";
  public static final String COMPLETE_TODO = "--complete-todo";
  public static final String DISPLAY = "--display";
  public static final String SHOW_INCOMPLETE = "--show-incomplete";
  public static final String SHOW_CATEGORY = "--show-category";
  public static final String SORT_BY_DATE = "--sort-by-date";
  public static final String SORT_BY_PRIORITY = "--sort-by-priority";

  public static final String CSV_FILE_DES = "The CSV file containing the todos. This option is required.";
  public static final String ADD_TODO_DES = "Add a new todo. If this option is provided, then --todo-text must also be provided.";
  public static final String TODO_TEXT_DES = "A description of the todo.";
  public static final String COMPLETED_DES = "(Optional) Sets the completed status of a new todo to true.";
  public static final String DUE_DES = "(Optional) Sets the due date of a new todo. You may choose how the date should be formatted.";
  public static final String PRIORITY_DES = "(Optional) Sets the priority of a new todo. The value can be 1, 2, or 3.";
  public static final String CATEGORY_DES = "(Optional) Sets the category of a new todo. The value can be any String. Categories do not need to be pre-defined.";
  public static final String COMPLETE_TODO_DES = "Mark the Todo with the provided ID as complete.";
  public static final String DISPLAY_DES = "Display todos. If none of the following optional arguments are provided, displays all todos.";
  public static final String SHOW_INCOMPLETE_DES = "(Optional) If --display is provided, only incomplete todos should be displayed.";
  public static final String SHOW_CATEGORY_DES = "(Optional) If --display is provided, only todos with the given category should be displayed.";
  public static final String SORT_BY_DATE_DES = "(Optional) If --display is provided, sort the list of todos by date order (ascending). Cannot be combined with --sort-by-priority.";
  public static final String SORT_BY_PRIORITY_DES = "(Optional) If --display is provided, sort the list of todos by priority (ascending). Cannot be combined with --sort-by-date.";

  public static final String CSV_FILE_ARG_NAME = "<path/to/file>";
  public static final String TODO_TEXT_ARG_NAME = "<description of todo>";
  public static final String DUE_ARG_NAME = "<due date>";
  public static final String PRIORITY_ARG_NAME = "<1, 2, or 3>";
  public static final String CATEGORY_ARG_NAME = "<a category name>";
  public static final String COMPLETE_TODO_ARG_NAME = "<id>";
  public static final String SHOW_CATEGORY_ARG_NAME = "<category>";

  public static final String ARG_SPLITTER = ",";
  public static final String DEFAULT_VAL = "?";
}
