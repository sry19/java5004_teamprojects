package model.filter;

import controller.OptionConstants;
import java.util.HashMap;

/**
 * The type Filter settings.
 */
public class FilterSettings {

  /**
   * The Container.
   */
  HashMap<String, String> container;

  /**
   * Instantiates a new Filter settings.
   */
  public FilterSettings() {
    this.container = new HashMap<>();
    this.container.put(OptionConstants.SHOW_CATEGORY, OptionConstants.SHOW_CATEGORY);
    this.container.put(OptionConstants.SHOW_INCOMPLETE, OptionConstants.SHOW_INCOMPLETE);
  }

  /**
   * equals method
   *
   * @param o object
   * @return if they are equal, return true. Otherwise, return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FilterSettings that = (FilterSettings) o;

    return container.equals(that.container);
  }

  /**
   * computes hashcode
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return container.hashCode();
  }

  /**
   * displays
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "FilterSettings{" +
        "container=" + container +
        '}';
  }
}
