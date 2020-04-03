package view;

// Mainly deal with sorting and display.

import exceptions.IllegalTodoException;
import java.util.HashSet;
import java.util.Set;
import model.comparators.ComparatorFactory;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Todo;
import model.filter.FilterPlatform;
import model.filter.FilterSettings;
import model.writer.CSVWriter;
import model.writer.IWriter;

public class TodoList extends ItemList<Todo> {
      Set<Integer> usedId;
      String filepath;

      public TodoList(String filepath) {
        super();
        this.filepath = filepath;
        this.usedId = new HashSet<>();
      }

  //can i use builder pattern?
  public void add(String text, String completed, String due, String priority, String category)
      throws IOException {
    int newId = this.itemArrayList.get(-1).getId() + 1;
    while (this.usedId.contains(newId)) {
      newId += 1;
    }
    Todo newItem = new Todo(newId,text,completed,due,priority,category);
    this.appendItem(newItem);
    IWriter writer = new CSVWriter(this.filepath);
    writer.addLine(newItem.toString());
    writer.closeFile();
  }
  @Override
  public void appendItem(Todo todo) {
    if (!this.usedId.contains(todo.getId())) {
      super.appendItem(todo);
      this.usedId.add(todo.getId());
    } else {
      throw new IllegalTodoException("duplicate identification number found");
    }
  }

  //how to change a specific line??
  public void completed(int id) throws FileNotFoundException {
    for (Todo todo : this.itemArrayList) {
      if (todo.getId() == id) {
        todo.setCompleted(true);
        this.updateCSV(this.filepath) ;
        return;
      }
    }
  }

  public void updateCSV(String filepath) throws FileNotFoundException {
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
      for (Todo todo: this.itemArrayList) {
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

  @Override
  public void display() {  //having it here, so that we can format options the way we want
  }

  @Override
  public void filter(int status) {
    if (status == 1) {
      FilterSettings both = new FilterSettings.Builder().incompleteTodo().selectCategory("Work")
          .build();
      FilterPlatform platform = new FilterPlatform(both);
      platform.filter(this.itemArrayList);
    } else if (status == 2) {
      FilterSettings onlyOne = new FilterSettings.Builder().incompleteTodo().build();
      FilterPlatform platform1 = new FilterPlatform(onlyOne);
      platform1.filter(this.itemArrayList);
    } else {
      FilterSettings only12 = new FilterSettings.Builder().selectCategory("Work").build();
      FilterPlatform platform3 = new FilterPlatform(only12);
      platform3.filter(this.itemArrayList);
    }
  }

}