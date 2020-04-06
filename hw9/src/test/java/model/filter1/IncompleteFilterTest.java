package model.filter1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

public class IncompleteFilterTest {
  String[] categories;
  Todo todo1;
  Todo todo2;
  Todo todo3;
  Todo todo4;
  ArrayList<Todo> todoArrayList;
  IncompleteFilter incompleteFilter1;
  IncompleteFilter incompleteFilter2;

  @Before
  public void setUp() throws Exception {
    categories = new String[]{"work","business"};
    todo1 = new Todo(1, "text","false", "3/22/2020","3","work");
    todo2 = new Todo(2, "text","false", "3/22/2020","3","business");
    todo3 = new Todo(3, "text","true", "3/22/2020","3","work");
    todo4 = new Todo(4, "text","false", "3/22/2020","3","school");
    todoArrayList = new ArrayList<>();
    todoArrayList.add(todo1);
    todoArrayList.add(todo2);
    todoArrayList.add(todo3);
    todoArrayList.add(todo4);
    incompleteFilter1 = new IncompleteFilter();
    incompleteFilter2 = new IncompleteFilter();
  }

  @Test
  public void filter() {
    ArrayList<Todo> todoArrayList1 = new ArrayList<>();
    todoArrayList1.add(todo1);
    todoArrayList1.add(todo2);
    todoArrayList1.add(todo4);
    assertEquals(todoArrayList1, incompleteFilter1.filter(todoArrayList));
  }

  @Test
  public void testEquals() {
    assertEquals(incompleteFilter1,incompleteFilter1);
    assertEquals(incompleteFilter1,incompleteFilter2);
    assertFalse(incompleteFilter1.equals(null));
    assertFalse(incompleteFilter1.equals(new ArrayList<String>()));
  }

  @Test
  public void testHashCode() {
    assertEquals(incompleteFilter1.hashCode(),incompleteFilter2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("IncompleteFilter",incompleteFilter1.toString());
  }
}