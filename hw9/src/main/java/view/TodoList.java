package view;

// Mainly deal with sorting and display.

import model.comparators.ComparatorFactory;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.CSVWriter;
import model.Todo;

    public class TodoList extends ItemList {
      ArrayList<Todo> todoArrayList;
      String filepath;

      public TodoList(String filepath) {
        this.todoArrayList = new ArrayList<>();
        this.filepath = filepath;
      }

      public void createItem(String text, String completed, String due, String priority, String category)
          throws IOException {
        Todo newItem = new Todo(this.todoArrayList.size()+1,text,completed,due,priority,category);
        this.appendItem(newItem);
        IWriter writer = new CSVWriter(this.filepath);
        writer.addLine(newItem.toString());
        writer.closeFile();
      }

      public void completeTodo(int id) throws FileNotFoundException {
        for (Todo todo : this.todoArrayList) {
          if (todo.getId() == id) {
            todo.setCompleted(true);
            this.updateCSV(this.filepath) ;
            return;
          }
        }
      }

      public void updateCSV(String filepath) throws FileNotFoundException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
          for (Todo todo: this.todoArrayList) {
            writer.write(todo.toString());
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

  //pass in option.getName()
  @Override
  public void sort(String type) {
    ComparatorFactory.makeComparator(type);

    //
    // might need to pass field to comparator??
    // use a factory to create comparator, then pass to sort
  }

  //override
  public void display() {  //having it here, so that we can format options the way we want
  }

}