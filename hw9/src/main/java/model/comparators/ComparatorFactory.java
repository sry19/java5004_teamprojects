package model.comparators;

import controller.OptionConstants;

public class ComparatorFactory {

  private ComparatorFactory() {
  }

  /**
   * Returns a specific comparator based on the name passed in
   *
   * @param name the element to compare for
   * @return a specific comparator based on the name passed in
   */
  public static AbstractComparator makeComparator(String name) {
    switch (name) {
      case OptionConstants.SORT_BY_DATE:
        return new DateComparator();
      case OptionConstants.SORT_BY_PRIORITY:
      default:
        return new PriorityComparator();
    }
  }
}