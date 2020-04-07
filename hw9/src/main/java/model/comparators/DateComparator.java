package model.comparators;

import java.util.Comparator;
import model.Todo;

public class DateComparator extends AbstractComparator {

  /**
   * Compare two items by date
   * @param o1 the first object
   * @param o2 the second object
   * @return positive if o1 is after o2, negative is o1 is before o2
   */
  @Override
  public int compare(Todo o1, Todo o2) {
    if (o1.getDue().equals(o2.getDue())) {
      return Integer.compare(o1.getId(), o2.getId());
    } else {
      return o1.getDue().compareTo(o2.getDue());
    }
  }
}