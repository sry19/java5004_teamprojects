package view;

import static org.junit.Assert.*;

import controller.TaskManagerOptionsBuilder;
import controller.commandlineparser.exceptions.InvalidOptionException;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

  @Test
  public void displayAll() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--display"};
    Main.main(args);
  }

  @Test
  public void showIncomplete() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--display",
        "--show-incomplete"};
    Main.main(args);
  }

  @Test
  public void showIncompleteCategory() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--display",
        "--show-incomplete", "--show-category", "hw"};
    Main.main(args);
  }

  @Test
  public void sortByPriority() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--display",
        "--sort-by-priority"};
    Main.main(args);
  }

  @Test
  public void sortByDate() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--display",
        "--sort-by-date"};
    Main.main(args);
  }

  @Test
  public void addTodoWithOptional() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--add-todo", "--todo-text",
        "random_event1", "--completed", "--due", "04/06/2020", "--category", "some_category",
        "--priority", "1"};
    Main.main(args);
  }

  @Test
  public void addTodoWithoutOptional() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--add-todo", "--todo-text",
        "random_event2"};
    Main.main(args);
  }

  @Test
  public void completeTodo() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--complete-todo", "1,2,3"};
    Main.main(args);
  }

  @Test
  public void completeTodo2() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--complete-todo", "1",
        "--complete-todo", "2"};
    Main.main(args);
  }

  @Test(expected = InvalidOptionException.class)
  public void addNoTodoText() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--add-todo"};
    Main.main(args);
  }

  @Test(expected = InvalidOptionException.class)
  public void addNoTodo() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--todo-text",
        "Finish laundry"};
    Main.main(args);
  }

  @Test(expected = InvalidOptionException.class)
  public void addTodoNoDueDate() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--add-todo", "--todo-text",
        "random_event", "--completed", "--due"};
    Main.main(args);
  }

  @Test(expected = InvalidOptionException.class)
  public void noDisplay() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--sort-by-date"};
    Main.main(args);
  }

  @Test(expected = InvalidOptionException.class)
  public void invalidOption() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--delete-todo"};
    Main.main(args);
  }


  @Test(expected = InvalidOptionException.class)
  public void requiredNotProvided() throws Exception {
    String[] args = {"--add-todo", "--todo-text", "random_event",};
    Main.main(args);
  }

  @Test(expected = InvalidOptionException.class)
  public void addTodoNoCSVFile() throws Exception {
    String[] args = {"--csv-file", "--add-todo", "--todo-text", "random_event"};
    Main.main(args);
  }

  @Test(expected = InvalidOptionException.class)
  public void addTodoNoCompleteId() throws Exception {
    String[] args = {"--csv-file", "src/main/resources/maintest.csv", "--complete-todo"};
    Main.main(args);
  }
}