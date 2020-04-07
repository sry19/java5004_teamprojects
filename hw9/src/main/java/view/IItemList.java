package view;
import controller.commandlineparser.ICommandLine;
import java.util.HashMap;
import model.IItem;

/**
 * IItem interface
 *
 * @param <T> the element type in the item list
 */
public interface IItemList<T> {

  /**
   * To append an item
   *
   * @param item the item to append
   */
  void appendItem(T item);


  /**
   * Filter.
   *
   * @param values the values
   */
  void filter(HashMap<String,String[]> values);

  /**
   * Sort the items by type
   *
   * @param name the type to sort with
   */
  void sort(String name);

  /**
   * Display all the items
   */
  void display();


}
