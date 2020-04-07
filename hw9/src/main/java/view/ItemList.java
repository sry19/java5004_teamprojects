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

  /**
   * equals
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

    ItemList<?> itemList = (ItemList<?>) o;

    return itemArrayList.equals(itemList.itemArrayList);
  }

  /**
   * computes hashcode
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return itemArrayList.hashCode();
  }

  /**
   * return to string
   *
   * @return string
   */
  @Override
  public String toString() {
    return "ItemList{" +
        "itemArrayList=" + itemArrayList +
        '}';
  }
}