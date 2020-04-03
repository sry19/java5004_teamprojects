package view;

import java.util.ArrayList;
import model.IItem;
import model.Item;

public class ItemList implements IItemList<Item> {
  ArrayList<Item> itemArrayList;

  public ItemList() {
    this.itemArrayList = null;
  }

  @Override
  public void appendItem(Item item) {
    itemArrayList.add(item);
  }

  @Override
  public void sort(String item) {

  }

}