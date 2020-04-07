package model;

import static org.junit.Assert.*;

import exceptions.InvalidItemException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class TodoTest {
  Todo todo1, todo2, todo3, todo4, todo5, todo6, todo7, todo8, todo9;

  @Before
  public void setUp() throws Exception {
    todo1 = new Todo(1, "Finish hw9", "false", "3/22/2020", "1", "school");
    todo3 = new Todo(1, "Finish hw8", "false", "03/22/2020", "1", "?");
    todo4 = new Todo(1, "Finish hw9", "false", "03/22/2020", "1", "school");
    todo5 = new Todo(1, "Finish hw9", "true", "03/22/2020", "1", "school");
    todo6 = new Todo(1, "Finish hw9", "false", "03/21/2020", "1", "school");
    todo8 = new Todo(1, "Finish hw9", "false", "03/22/2020", "3", "school");
    todo9 = new Todo(1, "Finish hw9", "false", "03/22/2020", "1", "health");
    todo7 = new Todo(2, "eating salmon", "false", "?", "1", "school");
    HashMap<String, String> todoMap2 = new HashMap<>();
    todoMap2.put("id", "2");
    todoMap2.put("text", "jogging");
    todoMap2.put("completed", "false");
    todoMap2.put("due", "11/30/2019");
    todoMap2.put("priority", "?");
    todoMap2.put("category", "health");
    todo2 = new Todo(todoMap2);
  }

  @Test
  public void setCompleted() {
    todo1.setCompleted(true);
    assertTrue(todo1.isCompleted());
  }

  @Test (expected = InvalidItemException.class)
  public void checkEmptyText() throws ParseException {
    todo3 = new Todo(2, "?", "false", "03/22/2020", "1", "school");
  }

  @Test
  public void checkPriority() throws ParseException {
    todo1.checkPriority("2");
  }
  @Test (expected = InvalidItemException.class)
  public void checkLowPriority() throws ParseException {
    todo1.checkPriority("0");
  }

  @Test (expected = InvalidItemException.class)
  public void checkHighPriority() throws ParseException {
    todo1.checkPriority("10");
  }

  @Test (expected = ParseException.class)
  public void checkInvalidDue() throws ParseException {
    Todo todo = new Todo(2, "eating salmon", "false", "abc", "1", "school");
  }

  @Test
  public void getId() {
    assertTrue(todo1.getId() == 1);
  }

  @Test
  public void getText() {
    assertEquals("Finish hw9", todo1.getText());
  }

  @Test
  public void isCompleted() {
    assertFalse(todo1.isCompleted());
  }

  @Test
  public void getDue() {
    assertEquals(null, todo7.getDue());
  }

  @Test
  public void getPriority() {
    assertTrue(todo1.getPriority() == 1);
  }

  @Test
  public void getCategory() {
    assertEquals("school", todo1.getCategory());
  }

  @Test
  public void testToString() {
    String expected = "\"1\",\"Finish hw9\",\"false\",\"2020-03-22\",\"1\",\"school\"";
    assertEquals(expected, todo1.toString());
  }

  @Test
  public void testEqual() {
    ArrayList a = new ArrayList();
    assertTrue(todo1.equals(todo1));
    System.out.println(todo1);
    System.out.println(todo4);
    assertTrue(todo1.equals(todo4));
    assertFalse(todo1.equals(null));
    assertFalse(todo1.equals(todo2));
    assertFalse(todo1.equals(todo3));
    assertFalse(todo1.equals(todo5));
    assertFalse(todo1.equals(todo6));
    assertFalse(todo1.equals(todo8));
    assertFalse(todo1.equals(todo9));
    assertNotEquals(todo1, a);
  }

  @Test
  public void testHashCode() {
    assertTrue(todo1.hashCode() == todo4.hashCode());
  }
}