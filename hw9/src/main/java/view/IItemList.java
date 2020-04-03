package view;
import model.IItem;

public interface IItemList<T> {

  void appendItem(T item);

  void filter(int status);

  void sort(String name);

  void display();


}
