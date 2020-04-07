package view;

import static org.junit.Assert.*;

import exceptions.InvalidIdException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

public class TodoListTest {

  TodoList list1, list2;



  @Test
  public void addTodo() throws IOException, ParseException {
    list1 = new TodoList("src/main/resources/todolist2.csv");
    int old = list1.numOftodo;
    list1.addTodo("Finish hw9", "false", "03/22/2020", "1", "school");
    assertTrue(list1.numOftodo == old + 1);
  }

  @Test
  public void completed() throws IOException {
    list1 = new TodoList("src/main/resources/todolist.csv");
    list1.completed(1);
    assertTrue(list1.itemArrayList.get(0).isCompleted());
  }

  @Test (expected = InvalidIdException.class)
  public void invalidCompleted() throws IOException {
    list1 = new TodoList("src/main/resources/todolist.csv");
    list1.completed(1000);
  }

  @Test
  public void updateCSV() throws IOException, ParseException {
    list1 = new TodoList("src/main/resources/todolist2.csv");
    list1.addTodo("Finish hw9", "false", "03/22/2020", "1", "school");
    list1.updateCSV();
  }

  @Test
  public void sortByPriority() throws IOException {
    list1 = new TodoList("src/main/resources/sortfile.csv");
    list1.sort("--sort-by-priority");
    list1.updateCSV();
    list1.display();
  }

  @Test
  public void sortByDate() throws IOException {
    list1 = new TodoList("src/main/resources/sortfile2.csv");
    list1.sort("--sort-by-date");
    list1.updateCSV();
    list1.display();
  }

  @Test
  public void display() throws IOException {
    list1 = new TodoList("src/main/resources/todolist.csv");
    list1.display();
    list2 = new TodoList("src/main/resources/invalid.csv");
    list2.display();
  }

  @Test
  public void filter() throws IOException {
    list1 = new TodoList("src/main/resources/sortfile.csv");
    HashMap<String, String[]> hashMap = new HashMap<>();
    hashMap.put("--show-category", new String[]{"work"});
    hashMap.put("--show-incomplete", null);
    list1.filter(hashMap);
  }


  @Test
  public void testEquals() throws IOException {
    ArrayList a = new ArrayList();
    list1 = new TodoList("src/main/resources/todolist2.csv");
    list2 = new TodoList("src/main/resources/todolist1.csv");
    TodoList list3 = new TodoList("src/main/resources/todolist2.csv");
    assertTrue(list1.equals(list1));
    assertFalse(list1.equals(null));
    assertFalse(list1.equals(a));
    assertTrue(list1.equals(list3));
    assertFalse(list1.equals(list2));
  }

  @Test
  public void testHashCode() throws IOException {
    list1 = new TodoList("src/main/resources/todolist2.csv");
    assertTrue(list1.hashCode() == list1.hashCode());
  }

  @Test
  public void testToString() throws IOException {
    list1 = new TodoList("src/main/resources/todolist1.csv");
    for (Todo item: list1.itemArrayList) {
      System.out.println(item.toString());
    }
    String expected = "TodoList{filepath='src/main/resources/todolist1.csv', numOftodo=1, "
        + "itemArrayList=[\"1\",\"Finish hw10\",\"false\",\"03/21/2020\",\"1\",\"school\"]}";
    assertEquals(expected, list1.toString());
  }
}