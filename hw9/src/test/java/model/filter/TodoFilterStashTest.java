package model.filter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import model.Todo;
import org.junit.Before;
import org.junit.Test;

public class TodoFilterStashTest {

  Todo todo1;
  Todo todo2;
  Todo todo3;
  Todo todo4;
  ArrayList<Todo> todoArrayList;
  TodoFilterStash filterStash;
  TodoFilterStash filterStash1;

  @Before
  public void setUp() throws Exception {
    todo1 = new Todo(1, "text","false", "3/22/2020","3","work");
    todo2 = new Todo(2, "text","true", "3/22/2020","3","business");
    todo3 = new Todo(3, "text","true", "3/22/2020","3","work");
    todo4 = new Todo(4, "text","false", "3/22/2020","3","school");
    todoArrayList = new ArrayList<>();
    todoArrayList.add(todo1);
    todoArrayList.add(todo2);
    todoArrayList.add(todo3);
    todoArrayList.add(todo4);
    HashMap<String,String[]> values = new HashMap<>();
    values.put("--show-incomplete",new String[]{});
    values.put("--show-category",new String[]{"work"});
    filterStash = new TodoFilterStash(values);
    filterStash1 = new TodoFilterStash(values);
  }

  @Test
  public void produceFilters() {
    Filter filter = new CategoryFilter(new String[]{"work"});
    Filter filter1 = new IncompleteFilter();
    filterStash.produceFilters();
    ArrayList<Filter> filterArrayList = new ArrayList<>();
    filterArrayList.add(filter1);
    filterArrayList.add(filter);
    assertEquals(filterArrayList, filterStash.filters);
  }

  @Test
  public void filter() {
    filterStash.produceFilters();
    ArrayList<Todo> todoList = new ArrayList<>();
    todoList.add(todo1);
    assertEquals(todoList, filterStash.filter(todoArrayList));
  }

  @Test
  public void testEquals() {
    assertEquals(filterStash, filterStash1);
    assertEquals(filterStash, filterStash);
    assertFalse(filterStash.equals(null));
    assertFalse(filterStash.equals(new String[]{}));
  }

  @Test
  public void testHashCode() {
    assertEquals(filterStash.hashCode(),filterStash1.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("TodoFilterStash{FilterStash{container={--show-incomplete=--show-incomplete, --show-category=--show-category}, filters=[]}}", filterStash.toString());
  }

}