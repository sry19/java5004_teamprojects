package model.filter1;

import controller.commandlineparser.ICommandLine;
import java.util.ArrayList;
import java.util.HashMap;
import model.Todo;

/**
 * The type Filter stash.
 *
 * @param <T> the type parameter
 */
public abstract class FilterStash<T> {

  /**
   * The Command line.
   */
  ICommandLine commandLine;
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
   * @param commandLine the command line
   */
  public FilterStash(ICommandLine commandLine) {
    this.commandLine = commandLine;
    FilterSettings filterSettings = new FilterSettings();
    this.container = filterSettings.container;
    this.filters = new ArrayList<>();
  }

  /**
   * Produce filters.
   */
  public void produceFilters() {
    for (String optionName : this.container.keySet()) {
      if (this.commandLine.hasOption(optionName)) {
        Filter filter = FilterFactory
            .makeFilter(optionName, this.commandLine.getOptionValue(optionName),
                this.commandLine.getOptionValues(optionName));
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
