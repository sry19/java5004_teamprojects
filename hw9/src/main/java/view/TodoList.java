package view;

// Yiyu and Ruoyun are modifying the same file

import exceptions.IllegalTodoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import model.comparators.AbstractComparator;
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
      throws IOException, ParseException {
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
    AbstractComparator todoComparator = ComparatorFactory.makeComparator(type);
    Collections.sort(this.itemArrayList, todoComparator);
  }

  //@Override   /////
  public void display(String filepath) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filepath))) {
          String line;
          String temp = inputFile.readLine();  //read the first line and not use it
          while ((line = inputFile.readLine()) != null) {
            System.out.println(line);  //starting printing from line 2
          }
        } catch (FileNotFoundException fnfe) {
          System.out.println("File not found!" + fnfe.getMessage());
          fnfe.printStackTrace();
        } catch (IOException ioe) {
          System.out.println("Something went wrong!" + ioe.getMessage());
        }
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