package model.filter1;

import controller.commandlineparser.ICommandLine;
import java.util.ArrayList;
import java.util.HashMap;
import model.Todo;

public abstract class FilterStash<T> {

  ICommandLine commandLine;
  HashMap<String,String> container;
  ArrayList<Filter> filters;

  public FilterStash(ICommandLine commandLine) {
    this.commandLine = commandLine;
    FilterSettings filterSettings = new FilterSettings();
    this.container = filterSettings.container;
    this.filters = new ArrayList<>();
  }

  public void produceFilters() {
    for (String optionName : this.container.keySet()) {
      if (this.commandLine.hasOption(optionName)) {
        Filter filter = FilterFactory.makeFilter(optionName, this.commandLine.getOptionValue(optionName),this.commandLine.getOptionValues(optionName));
        this.filters.add(filter);
      }
    }
  }

  public ArrayList<T> filter(ArrayList<T> todoArrayList) {
    return todoArrayList;
  }

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

  @Override
  public int hashCode() {
    int result = container.hashCode();
    result = 31 * result + filters.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "FilterStash{" +
        "container=" + container +
        ", filters=" + filters +
        '}';
  }
}
