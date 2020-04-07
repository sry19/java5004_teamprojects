package view;

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
import java.util.Collections;
import model.comparators.AbstractComparator;

public class TodoList extends ItemList<Todo> {

  String filepath;
  int numOftodo;
  static final int COLUMN = 6;
  static final String TRIM_REGEX = "^\"|\"$";
  static final String SPLIT_REGEX = "\",\"";
  static final String EMPTY = "";
  static final String HEADER = "\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"";

  /**
   * To-do list constructor
   *
   * @param filepath the file path
   * @throws IOException when file cannot be opened
   */
  public TodoList(String filepath) throws IOException {
    super();
    this.filepath = filepath;
    this.numOftodo = this.initialize();
  }

  /**
   * Initialize the to-do array list
   *
   * @return count of items
   * @throws IOException when file cannot open
   */
  private int initialize() throws IOException {
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
      System.out.println(e);
      return 0;
    }
  }

  /**
   * Add a to-do
   *
   * @param id        to-do id
   * @param text      to-do text
   * @param completed if completed
   * @param due       due time
   * @param priority  priority of to-do
   * @param category  category of to-do
   * @throws ParseException when cannot parse
   */
  private void add(String id, String text, String completed, String due, String priority,
      String category)
      throws ParseException {
    Todo newItem = new Todo(Integer.parseInt(id), text, completed, due, priority, category);
    super.appendItem(newItem);
  }

  /**
   * constructs a new to-do
   *
   * @param text      a string
   * @param completed a string
   * @param due       a string
   * @param priority  a string
   * @param category  a string
   * @throws ParseException
   */
  public void addTodo(String text, String completed, String due, String priority, String category)
      throws ParseException {
    int newId = this.numOftodo + 1;
    Todo newItem = new Todo(newId, text, completed, due, priority, category);
    this.appendItem(newItem);
    this.numOftodo++;
  }

  /**
   * set the completion status of a to-do
   *
   * @param id the to-do id
   * @throws FileNotFoundException if id not found
   */
  //how to change a specific line??
  public void completed(int id) throws FileNotFoundException {
    for (Todo todo : this.itemArrayList) {  //why this, and super in line 138?
      if (todo.getId() == id) {
        todo.setCompleted(true);
        return;
      }
    }
  }

  /**
   * Update the CSV
   */
  public void updateCSV() {
    System.out.println(super.itemArrayList);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filepath))) {
      writer.write(HEADER);
      writer.write("\n");
      for (Todo todo : super.itemArrayList) {
        writer.write(todo.toString());
        writer.write("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Sort the to-dos
   *
   * @param type the type to sort with
   */
  @Override
  public void sort(String type) {
    AbstractComparator todoComparator = ComparatorFactory.makeComparator(type);
    Collections.sort(this.itemArrayList, todoComparator);
  }

  /**
   * Display the to-dos
   */
  @Override
  public void display() {
    for (Todo todo : this.itemArrayList) {
      System.out.println(todo.displayTodo());
    }
  }

  /**
   * filter for the sort type
   *
   * @param values a HashMap whose key is the option name and whose values are string array
   */
  @Override
  public void filter(HashMap<String, String[]> values) {
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
