package view;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

public class TodoListTest {
  Todo todo1, todo2, todo3, todo4, todo5, todo6, todo7, todo8, todo9;
  TodoList list1, list2, list3;

  @Before
  public void setUp() throws Exception {
    todo1 = new Todo(1, "Finish hw9", "false", "3/22/2020", "1", "school");
    todo3 = new Todo(2, "Finish hw8", "false", "03/22/2019", "1", "?");
    todo4 = new Todo(3, "Finish hw9", "false", "03/22/2020", "1", "school");
    todo5 = new Todo(4, "Finish hw9", "true", "4/22/2020", "1", "school");
    todo6 = new Todo(5, "Finish hw9", "false", "03/21/2020", "1", "school");
    todo8 = new Todo(6, "Finish hw9", "false", "03/22/2020", "3", "school");
    todo9 = new Todo(7, "Finish hw9", "false", "03/22/2020", "1", "health");
    todo7 = new Todo(8, "eating salmon", "false", "?", "1", "school");
    list1 = new TodoList("src/main/resources/todolist2.csv");
  }

  @Test
  public void initialize() {
    assertTrue(list1.numOftodo == 2);
  }

  @Test
  public void addTodo() throws IOException, ParseException {
    String description = "\"Finish hw9\",\"false\",\"03/22/2020\",\"1\",\"school\"";
    //int num = list1.numOftodo;
    list1.addTodo(description);
    assertTrue(list1.numOftodo == 3);
  }

  @Test
  public void completed() throws FileNotFoundException {
    list1.completed(1);
    System.out.println(list1.itemArrayList.get(0).toString());
    assertTrue(list1.itemArrayList.get(0).isCompleted());
  }

  @Test
  public void updateCSV() throws IOException, ParseException {
    String description = "\"Finish hw10\",\"false\",\"03/21/2020\",\"1\",\"school\"";
    //list1 = new TodoList("src/main/resources/todolist1.csv");
    list1.addTodo(description);
    list1.updateCSV();
  }

  @Test
  public void sort() {
//    list1.sort("date");
//    list1.updateCSV();
//    list1.display();
  }

  @Test
  public void display() {
    list1.display();
  }

  @Test
  public void filter() {
  }
}