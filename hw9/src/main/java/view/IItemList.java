package view;
import controller.commandlineparser.ICommandLine;
import java.util.HashMap;
import model.IItem;

public interface IItemList<T> {

  void appendItem(T item);

  void filter(HashMap<String,String[]> values);

  void sort(String name);

  void display();


}
