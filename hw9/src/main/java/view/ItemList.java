package view;

import java.util.ArrayList;
import model.IItem;
import model.Item;

public class ItemList<T> implements IItemList<T> {
  ArrayList<T> itemArrayList;

  public ItemList() {
    this.itemArrayList = new ArrayList<>();
  }

  @Override
  public void appendItem(T item) {
    itemArrayList.add(item);
  }

  @Override
  public void filter() {

  }

  @Override
  public void sort(String item) {

  }

  @Override
  public void display() {
    if (this.itemArrayList.isEmpty()) {
      System.out.println("There is no matched result.");
    }
    this.itemArrayList.toString();
  }

}