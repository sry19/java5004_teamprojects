package model.filter1;


import java.util.ArrayList;
import model.Todo;

/**
 * The abstract class Filter.
 */
public abstract class Filter implements IFilter {

  /**
   * filters the ArrayList
   *
   * @param itemList an ArrayList of todos
   * @return a filtered ArrayList of todos
   */
  public ArrayList<Todo> filter(ArrayList<Todo> itemList) {
    return itemList;
  }

}
