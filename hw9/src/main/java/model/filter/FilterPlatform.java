package model.filter;

import java.util.ArrayList;
import model.Todo;

public class FilterPlatform {
  private FilterSettings settings;

  public FilterPlatform(FilterSettings settings) {
    this.settings = settings;
  }

  public IFilter filter(ArrayList<Todo> todos) {
    IFilter advancedFilter = this.settings.buildAdvancedFilter(todos);
    return advancedFilter;
  }
}
