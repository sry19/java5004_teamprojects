package view;

import java.util.ArrayList;

/**
 * An abstract item list class
 * @param <T> the element type in item list
 */
public abstract class ItemList<T> implements IItemList<T> {
  ArrayList<T> itemArrayList;

  /**
   * Constructor of item list
   */
  public ItemList() {
    this.itemArrayList = new ArrayList<>();
  }

  /**
   * Append an item
   * @param item the item to append
   */
  @Override
  public void appendItem(T item) {
    itemArrayList.add(item);
  }

}