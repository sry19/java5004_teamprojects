package view;
import model.IItem;

public interface IItemList<T> {

  void appendItem(T item);

  void sort(String name);

}
