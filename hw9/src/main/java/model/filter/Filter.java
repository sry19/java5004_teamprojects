package model.filter;

import java.util.ArrayList;
import model.Todo;

public class Filter implements IFilter{
  protected ArrayList<Todo> todoList;

  public Filter() {
    this.todoList = null;
  }

  public void setTodoList(ArrayList<Todo> todoList) {
    this.todoList = todoList;
  }

  @Override
  public ArrayList<Todo> filter() {
    return null;
  }
}
