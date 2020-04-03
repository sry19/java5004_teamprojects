package model.filter;

import java.util.ArrayList;
import model.Todo;

public class CategoryFilterDecorator extends FilterDecorator{

  private String category;

  public CategoryFilterDecorator(Filter filter,String category) {
    super(filter);
    this.category = category;
  }

  public ArrayList<Todo> filter() {
    this.todoList.removeIf(todo -> !todo.getCategory().equals(this.category));
    return this.todoList;
  }

}
