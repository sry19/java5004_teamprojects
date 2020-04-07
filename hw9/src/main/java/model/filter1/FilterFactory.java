package model.filter1;

/**
 * The type Filter factory.
 */
public class FilterFactory {

  /**
   * Make filter according to option fields.
   *
   * @param name   the name
   * @param value  the value
   * @param values the values
   * @return the filter
   */
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
