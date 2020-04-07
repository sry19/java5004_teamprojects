package model.filter;

import controller.OptionConstants;

/**
 * The type Filter factory.
 */
public class FilterFactory {

  /**
   * Make filter according to commandline arguments.
   *
   * @param name   the name
   * @param values the values
   * @return the filter
   */
  public static Filter makeFilter(String name, String[] values) {
    switch (name) {
      case OptionConstants.SHOW_CATEGORY:
        return new CategoryFilter(values);
      case OptionConstants.SHOW_INCOMPLETE:
        return new IncompleteFilter();
      default:
        return null;
    }
  }


}
