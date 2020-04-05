package model.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Todo;

public class CategoryFilterDecorator extends FilterDecorator{

  private List<String> categories;

  public CategoryFilterDecorator(Filter filter, List<String> categories) {
    super(filter);
    this.categories = categories;
  }

  public ArrayList<Todo> filter() {
    Set<String> categorySet = new HashSet<>(this.categories);

    this.todoList.removeIf(todo -> !categorySet.contains(todo.getCategory()));
    return this.todoList;
  }

}
