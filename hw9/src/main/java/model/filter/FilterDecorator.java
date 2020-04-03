package model.filter;

import java.util.ArrayList;
import model.Todo;

public class FilterDecorator extends Filter{
  protected IFilter filter;

  public FilterDecorator(Filter filter) {
    this.filter = filter;
  }

  @Override
  public ArrayList<Todo> filter() {
    return this.filter.filter();
  }
}
