package model.filter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Filter stash.
 *
 * @param <T> the type parameter
 */
public abstract class FilterStash<T> {

  HashMap<String,String[]> values;
  /**
   * The Container: a HashMap.
   */
  HashMap<String, String> container;
  /**
   * The Filters.
   */
  ArrayList<Filter> filters;

  /**
   * Instantiates a new Filter stash.
   *
   * @param values a HashMap whose key is the option name and value is the option values
   */
  public FilterStash(HashMap<String,String[]> values) {
    this.values = values;
    FilterSettings filterSettings = new FilterSettings();
    this.container = filterSettings.container;
    this.filters = new ArrayList<>();
  }

  /**
   * Produce filters.
   */
  public void produceFilters() {
    for (String optionName : this.container.keySet()) {
      if (this.values.containsKey(optionName)) {
        Filter filter = FilterFactory
            .makeFilter(optionName, this.values.get(optionName));
        this.filters.add(filter);
      }
    }
  }

  /**
   * Filter array list.
   *
   * @param todoArrayList an arrayList of todos
   * @return the array list of todos
   */
  public ArrayList<T> filter(ArrayList<T> todoArrayList) {
    return todoArrayList;
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

    FilterStash that = (FilterStash) o;

    if (!container.equals(that.container)) {
      return false;
    }
    return filters.equals(that.filters);
  }

  /**
   * computes hashcode
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    int result = container.hashCode();
    result = 31 * result + filters.hashCode();
    return result;
  }

  /**
   * displays
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "FilterStash{" +
        "container=" + container +
        ", filters=" + filters +
        '}';
  }
}
