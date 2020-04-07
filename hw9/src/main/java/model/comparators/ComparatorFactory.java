package model.comparators;

public class ComparatorFactory {

  /**
   * Returns a specific comparator based on the name passed in
   * @param name the element to compare for
   * @return a specific comparator based on the name passed in
   */
  public static AbstractComparator makeComparator(String name) {
    switch (name) {
      case Constants.DATE:
        return new DateComparator();
      case Constants.PRIORITY:
      default:
        return new PriorityComparator();
    }
  }
}