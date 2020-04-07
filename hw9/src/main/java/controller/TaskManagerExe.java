package controller;

import controller.commandlineparser.Executable;
import controller.commandlineparser.ICommandLine;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import view.TodoList;

/**
 * This class is to execute all actions according to provided ICommandLine ADT.
 */
public class TaskManagerExe implements Executable {

  /**
   * Execute according to ICommandLine.
   *
   * @param iCommandLine the provided ICommandLine.
   * @throws Exception if anything goes wrong.
   */
  @Override
  public void execute(ICommandLine iCommandLine) throws Exception {
    addTodo(iCommandLine);
    completeTodo(iCommandLine);
    display(iCommandLine);
  }

  /**
   * Execute add to do.
   *
   * @param iCommandLine the provided ICommandLine.
   */
  private void addTodo(ICommandLine iCommandLine) throws IOException, ParseException {
    if (iCommandLine.hasOption(OptionConstants.ADD_TODO)) {
      String csv_file = iCommandLine.getOptionValue(OptionConstants.CSV_FILE);
      String todoText = iCommandLine.getOptionValue(OptionConstants.TODO_TEXT);
      String completed = iCommandLine.hasOption(OptionConstants.COMPLETED) ? "true" : "false";
      String dueDate = iCommandLine.hasOption(OptionConstants.DUE) ? iCommandLine
          .getOptionValue(OptionConstants.DUE) : OptionConstants.DEFAULT_VAL;
      String priority = iCommandLine.hasOption(OptionConstants.PRIORITY) ? iCommandLine
          .getOptionValue(OptionConstants.PRIORITY) : OptionConstants.DEFAULT_VAL;
      String category = iCommandLine.hasOption(OptionConstants.CATEGORY) ? iCommandLine
          .getOptionValue(OptionConstants.CATEGORY) : OptionConstants.DEFAULT_VAL;

      TodoList todoList = new TodoList(csv_file);
      todoList.addTodo(todoText, completed, dueDate, priority, category);
      todoList.updateCSV();
    }
  }

  /**
   * Complete a list of To-dos.
   *
   * @param iCommandLine the provided ICommandLine.
   * @throws IOException if IO operation goes wrong.
   */
  private void completeTodo(ICommandLine iCommandLine) throws IOException {
    if (iCommandLine.hasOption(OptionConstants.COMPLETE_TODO)) {
      String csv_file = iCommandLine.getOptionValue(OptionConstants.CSV_FILE);
      TodoList todoList = new TodoList(csv_file);
      for (String id : iCommandLine.getOptionValues(OptionConstants.COMPLETE_TODO)) {
        todoList.completed(Integer.parseInt(id));
      }
      todoList.updateCSV();
    }
  }

  /**
   * Display a list of To-dos.
   *
   * @param iCommandLine the provided ICommandLine.
   * @throws IOException if IO operation goes wrong.
   */
  private void display(ICommandLine iCommandLine) throws IOException {
    if (iCommandLine.hasOption(OptionConstants.DISPLAY)) {
      String csv_file = iCommandLine.getOptionValue(OptionConstants.CSV_FILE);
      TodoList todoList = new TodoList(csv_file);
      filterToDoList(todoList, iCommandLine);
      sortToDoList(todoList, iCommandLine);
      todoList.display();
    }
  }

  /**
   * filter the current To-do List.
   *
   * @param todoList     the To-do List to filter.
   * @param iCommandLine the provided ICommandLine.
   */
  private void filterToDoList(TodoList todoList, ICommandLine iCommandLine) {
    HashMap<String, String[]> filters = new HashMap<>();
    if (iCommandLine.hasOption(OptionConstants.SHOW_INCOMPLETE)) {
      filters.put(OptionConstants.SHOW_INCOMPLETE, null);
    }
    if (iCommandLine.hasOption(OptionConstants.SHOW_CATEGORY)) {
      filters.put(OptionConstants.SHOW_CATEGORY,
          iCommandLine.getOptionValues(OptionConstants.SHOW_CATEGORY));
    }
    todoList.filter(filters);
  }

  /**
   * sort the current To-do List.
   *
   * @param todoList     the To-do List to sort.
   * @param iCommandLine the provided ICommandLine.
   */
  private void sortToDoList(TodoList todoList, ICommandLine iCommandLine) {
    if (iCommandLine.hasOption(OptionConstants.SORT_BY_DATE)) {
      todoList.sort(OptionConstants.SORT_BY_DATE);
    }

    if (iCommandLine.hasOption(OptionConstants.SORT_BY_PRIORITY)) {
      todoList.sort(OptionConstants.SORT_BY_PRIORITY);
    }
  }

}
