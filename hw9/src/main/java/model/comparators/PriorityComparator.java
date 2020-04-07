package model.comparators;

import java.util.Comparator;
import model.Todo;

public class PriorityComparator extends AbstractComparator {

  /**
   * Compare two to-do by their priority
   * @param o1 the first object
   * @param o2 the second object
   * @return return 1 if o1 is larger than o2, return -1 if otherwise
   */
  @Override
  public int compare(Todo o1, Todo o2) {
    if (o1.getPriority() == o2.getPriority()) {
      return Integer.compare(o1.getId(), o2.getId());  //ID should be unique
    } else {
      return -Integer.compare(o1.getPriority(), o2.getPriority());
    }
  }
}