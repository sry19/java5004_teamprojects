package view;

import exceptions.InvalidCSVFileException;
import java.text.ParseException;
import java.util.HashMap;
import model.comparators.ComparatorFactory;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import model.Todo;
import model.filter.TodoFilterStash;
import model.reader.CSVReader;
import model.reader.IReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import model.comparators.AbstractComparator;

public class TodoList extends ItemList<Todo> {
  String filepath;
  int numOftodo;
  static final int COLUMN = 6;
  static final String TRIM_REGEX = "^\"|\"$";
  static final String SPLIT_REGEX = "\",";
  static final String EMPTY = "";
  static final String HEADER = "“id”,”text”,”completed”,”due”,”priority”,”category”";

  public TodoList(String filepath) throws IOException {
    super();
    this.filepath = filepath;
    this.numOftodo = this.initialize();
  }

  public int initialize() throws IOException {
    int count = 0;
    try {
      IReader reader = new CSVReader(this.filepath);
      HashMap<String, String> keyValuePair = reader.readNextRow();
      while (keyValuePair != null) {
        this.add(keyValuePair.get("id"), keyValuePair.get("text"), keyValuePair.get("completed"),
            keyValuePair.get("due"), keyValuePair.get("priority"), keyValuePair.get("category"));
        count += 1;
        keyValuePair = reader.readNextRow();
      }
      reader.close();
      return count;
    } catch (Exception e) {
      return 0;
    }
  }
  

  private void add(String id, String text, String completed, String due, String priority, String category)
      throws ParseException {
    Todo newItem = new Todo(Integer.parseInt(id),text,completed,due,priority,category);
    super.appendItem(newItem);
  }

  public void addTodo(String text, String completed, String due, String priority, String category)
      throws IOException, ParseException {
    int newId = this.numOftodo + 1;
    Todo newItem = new Todo(newId,text,completed,due,
        priority,trimQuotes(category));
    this.appendItem(newItem);
  }

  /**
   * Trim the starting and ending quote of a String.
   *
   * @param s the provided string.
   * @return the trimmed string.
   */
  private static String trimQuotes(String s) {
    return s.replaceAll(TRIM_REGEX, EMPTY);
  }


  //how to change a specific line??
  public void completed(int id) throws FileNotFoundException {
    for (Todo todo : this.itemArrayList) {
      if (todo.getId() == id) {
        todo.setCompleted(true);
        return;
      }
    }
  }

  public void updateCSV() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filepath))) {
      writer.write(HEADER);
      for (Todo todo : super.itemArrayList) {
        writer.write(todo.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void sort(String type) {
    AbstractComparator todoComparator = ComparatorFactory.makeComparator(type);
    Collections.sort(this.itemArrayList, todoComparator);
  }

  @Override
  public void display() {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(this.filepath))) {
      String line;
      inputFile.readLine();  //read the first line and not use it
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
  public void filter(HashMap<String,String[]> values) {
    TodoFilterStash filterStash = new TodoFilterStash(values);
    filterStash.produceFilters();
    this.itemArrayList = filterStash.filter(this.itemArrayList);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TodoList todoList = (TodoList) o;

    if (numOftodo != todoList.numOftodo) {
      return false;
    }
    return filepath.equals(todoList.filepath);
  }

  @Override
  public int hashCode() {
    int result = filepath.hashCode();
    result = 31 * result + numOftodo;
    return result;
  }

  @Override
  public String toString() {
    return "TodoList{" +
        "filepath='" + filepath + '\'' +
        ", numOftodo=" + numOftodo +
        ", itemArrayList=" + itemArrayList +
        '}';
  }
}
