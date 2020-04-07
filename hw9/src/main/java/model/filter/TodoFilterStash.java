package model.filter;

import java.util.ArrayList;
import java.util.HashMap;
import model.Todo;

/**
 * The type todos' filter stash.
 */
public class TodoFilterStash extends FilterStash<Todo> {

  /**
   * Instantiates a new todos' filter stash.
   *
   * @param values the option's values
   */
  public TodoFilterStash(HashMap<String,String[]> values) {
    super(values);
  }

  /**
   * Filter array list.
   *
   * @param todoArrayList an arrayList of todos
   * @return the array list of todos
   */
  @Override
  public ArrayList<Todo> filter(ArrayList<Todo> todoArrayList) {
    for (Filter filter : this.filters) {
      todoArrayList = filter.filter(todoArrayList);
    }
    return todoArrayList;
  }

  /**
   * displays
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "TodoFilterStash{" + super.toString() +
        '}';
  }
}
