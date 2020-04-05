package view;
import controller.commandlineparser.ICommandLine;
import model.IItem;

public interface IItemList<T> {

  void appendItem(T item);

  void filter(ICommandLine commandLine);

  void sort(String name);

  void display();


}
