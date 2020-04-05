package view;
import model.IItem;

public interface IItemList<T> {

  void appendItem(T item);

  void filter();

  void sort(String name);

  void display();


}
