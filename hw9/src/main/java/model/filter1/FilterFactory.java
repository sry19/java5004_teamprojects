package model.filter1;

public class FilterFactory {
  public static Filter makeFilter(String name, String value, String[] values) {
    switch (name) {
      case Constants.CATEGORY_FILTER:
        return new CategoryFilter(values);
      case Constants.INCOMPLETE_FILTER:
        return new IncompleteFilter();
      default:
        return null;
    }
  }


}
