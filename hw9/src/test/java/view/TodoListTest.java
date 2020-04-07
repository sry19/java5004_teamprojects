package view;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
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
    list2 = new TodoList("src/main/resources/sortfile2.csv");
    list2.sort("--sort-by-date");
    list2.updateCSV();
    list2.display();
  }

  @Test
  public void display() throws IOException {
    list1 = new TodoList("src/main/resources/todolist.csv");
    list1.display();
  }

  @Test
  public void filter() throws IOException {
    list1 = new TodoList("src/main/resources/sortfile.csv");
    HashMap<String, String[]> hashMap = new HashMap<>();
    hashMap.put("--show-category", new String[]{"work"});
    hashMap.put("--show-incomplete", null);
    list1.filter(hashMap);
  }

}