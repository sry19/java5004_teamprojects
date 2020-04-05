package model.filter;

import java.util.ArrayList;
import java.util.List;
import model.Todo;

public class FilterSettings {
  private boolean incomplete;
  private List<String> category;

  private FilterSettings(Builder builder) {
    this.incomplete = builder.incompleteEnabled;
    this.category = builder.categorySelected;
  }

  public IFilter buildAdvancedFilter(ArrayList<Todo> todos) {
    Filter filter = new Filter();
    filter.setTodoList(todos);
    if (this.incomplete) {
      filter = new IncompleteFilterDecorator(filter);
    }
    if (this.category != null) {
      filter = new CategoryFilterDecorator(filter, this.category);
    }
    return filter;
  }

  public static class Builder {
    private boolean incompleteEnabled;
    private List<String> categorySelected;

    public Builder() {
      this.incompleteEnabled = false;
      this.categorySelected = null;
    }

    public Builder incompleteTodo() {
      this.incompleteEnabled = true;
      return this;
    }

    public Builder selectCategory(List<String> categorySelected) {
      this.categorySelected = categorySelected;
      return this;
    }

    public FilterSettings build() {
      return new FilterSettings(this);
    }
  }

}
