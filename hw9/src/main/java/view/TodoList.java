package view;

import controller.commandlineparser.ICommandLine;
import exceptions.InvalidCSVFileException;
import java.text.ParseException;
import java.util.HashMap;
import model.comparators.ComparatorFactory;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import model.Todo;
import model.filter.FilterPlatform;
import model.filter.FilterSettings;
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
  
  //TODO:.
  //can i use builder pattern?
  public void addTodo(String description)
      throws IOException, ParseException {
    int newId = this.numOftodo + 1;
    String[] columns = description.split(SPLIT_REGEX);
    if (columns.length != TodoList.COLUMN - 1) {
      throw new InvalidCSVFileException();
    }
    Todo newItem = new Todo(newId,trimQuotes(columns[0]),trimQuotes(columns[1]),trimQuotes(columns[2]),
        trimQuotes(columns[3]),trimQuotes(columns[4]));
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

  public void updateCSV(String filepath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
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
  public void filter(ICommandLine commandLine) {
    if (commandLine.hasOption("--show-incomplete") && commandLine.hasOption("--show-category")) {
      FilterSettings both = new FilterSettings.Builder().incompleteTodo().selectCategory(commandLine.getOptionValues("--show-category")).build();
      FilterPlatform platform1 = new FilterPlatform(both);
      platform1.filter(this.itemArrayList);
    } else if (commandLine.hasOption("--show-incomplete")) {
      FilterSettings onlyOne = new FilterSettings.Builder().incompleteTodo().build();
      FilterPlatform platform1 = new FilterPlatform(onlyOne);
      platform1.filter(this.itemArrayList);
    } else {
      FilterSettings only12 = new FilterSettings.Builder().selectCategory(commandLine.getOptionValues("--show-category")).build();
      FilterPlatform platform3 = new FilterPlatform(only12);
      platform3.filter(this.itemArrayList);
    }
  }

}
