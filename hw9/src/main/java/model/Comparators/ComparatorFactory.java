package model.Comparators;

import java.util.Comparator;

public class ComparatorFactory extends AbstractComparator {

  public static AbstractComparator makeComparator(String name) {
    switch (name) {
      case Constants.DATE:
        return new DateComparator();
      case Constants.PRIORITY:
        return new PriorityComparator();
      default:
        return new PriorityComparator();
    }
  }
}