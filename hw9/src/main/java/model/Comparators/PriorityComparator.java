package model.Comparators;

import java.util.Comparator;
import model.Todo;

public class PriorityComparator extends AbstractComparator implements Comparator<Todo> {

  @Override
  public int compare(Todo o1, Todo o2) {
    return o1.getPriority().compareTo(o2.getPriority());
  }
}