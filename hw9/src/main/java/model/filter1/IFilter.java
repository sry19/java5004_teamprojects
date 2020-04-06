package model.filter1;

import java.util.ArrayList;
import model.Todo;

public interface IFilter {

  /**
   * filters the ArrayList
   *
   * @param itemList an ArrayList of todos
   * @return a filtered ArrayList of todos
   */
  ArrayList<Todo> filter(ArrayList<Todo> itemList);

}
