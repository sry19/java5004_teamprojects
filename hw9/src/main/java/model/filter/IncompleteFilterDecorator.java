package model.filter;

import java.util.ArrayList;
import model.Todo;

public class IncompleteFilterDecorator extends FilterDecorator {
  public IncompleteFilterDecorator(Filter filter) {
    super(filter);
  }

  @Override
  public ArrayList<Todo> filter() {
    this.todoList.removeIf(Todo::isCompleted);
    return this.todoList;
  }
}
