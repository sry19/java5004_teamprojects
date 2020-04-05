package view;

import java.util.ArrayList;

public abstract class ItemList<T> implements IItemList<T> {
  ArrayList<T> itemArrayList;

  public ItemList() {
    this.itemArrayList = new ArrayList<>();
  }

  @Override
  public void appendItem(T item) {
    itemArrayList.add(item);
  }

  @Override
  public void display() {
    if (this.itemArrayList.isEmpty()) {
      System.out.println("There is no matched result.");
    }
    this.itemArrayList.toString();
  }

}