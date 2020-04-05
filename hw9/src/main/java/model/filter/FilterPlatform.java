package model.filter;

import java.util.ArrayList;
import model.Todo;

public class FilterPlatform {
  private FilterSettings settings;

  public FilterPlatform(FilterSettings settings) {
    this.settings = settings;
  }

  public IFilter filter(ArrayList<Todo> todos) {
    return this.settings.buildAdvancedFilter(todos);
  }
}
