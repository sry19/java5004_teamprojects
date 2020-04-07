package model.comparators;

import static org.junit.Assert.*;

import model.Todo;
import org.junit.Before;
import org.junit.Test;

public class DateComparatorTest {
  DateComparator comparator2;
  Todo todo1, todo2, todo3;

  @Before
  public void setUp() throws Exception {
    comparator2 = new DateComparator();
    todo1 = new Todo(1, "Finish hw9", "false", "3/21/2020", "1", "school");
    todo2 = new Todo(2, "Finish hw8", "false", "3/22/2020", "2", "?");
    todo3 = new Todo(3, "Finish hw9", "false", "3/22/2020", "1", "school");
  }

  @Test
  public void compare() {
    assertTrue(comparator2.compare(todo2, todo1) > 0);
    assertTrue(comparator2.compare(todo3, todo2) > 0);
  }
}