package model.comparators;

import static org.junit.Assert.*;

import model.Todo;
import org.junit.Before;
import org.junit.Test;

public class PriorityComparatorTest {
  Todo todo1, todo2, todo3;
  PriorityComparator comparator1;

  @Before
  public void setUp() throws Exception {
    comparator1 = new PriorityComparator();
    todo1 = new Todo(1, "Finish hw9", "false", "3/22/2020", "1", "school");
    todo2 = new Todo(2, "Finish hw8", "false", "3/22/2020", "2", "?");
    todo3 = new Todo(3, "Finish hw9", "false", "3/22/2020", "1", "school");
  }

  @Test
  public void compare() {
    assertTrue(comparator1.compare(todo1, todo2) == 1);
    assertTrue(comparator1.compare(todo3, todo1) == 1);
  }

}