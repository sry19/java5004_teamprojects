package model.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Todo;

public class CategoryFilterDecorator extends FilterDecorator{

  private String[] categories;

  public CategoryFilterDecorator(Filter filter, String[] categories) {
    super(filter);
    this.categories = categories;
  }

  public ArrayList<Todo> filter() {
    Set<String> categorySet = new HashSet<>();
    for (String category: this.categories) {
      categorySet.add(category);
    }

    this.todoList.removeIf(todo -> !categorySet.contains(todo.getCategory()));
    return this.todoList;
  }

}
