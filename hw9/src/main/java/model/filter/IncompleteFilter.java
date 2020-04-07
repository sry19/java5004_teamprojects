package model.filter;

import java.util.ArrayList;
import model.Todo;

public class IncompleteFilter extends Filter {

  /**
   * filters the ArrayList
   *
   * @param itemList an ArrayList of todos
   * @return a filtered ArrayList of todos
   */
  @Override
  public ArrayList<Todo> filter(ArrayList<Todo> itemList) {
    itemList.removeIf(Todo::isCompleted);
    return itemList;
  }

  /**
   * equals method
   *
   * @param o object
   * @return if they are equal, return true. Otherwise, return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    return true;
  }

  /**
   * computes hashcode
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return 31;
  }

  /**
   * displays
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "IncompleteFilter";
  }

}
