package model.comparators;

public class ComparatorFactory {

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