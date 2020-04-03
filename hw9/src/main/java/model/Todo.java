package model;


import java.util.Date;
import java.util.HashMap;

public class Todo extends Item implements IItem {
  private String text;
  private boolean completed;
  private Date due;
  private int priority;
  private String category;
  private int id;
  private static final String NOT_FILLED = "?";

  public Todo(int id, String text, String completed, String due, String priority, String category) throws InvalidItemException{
    this.id = id;
    this.text = this.checkText(text);
    this.completed = this.checkCompleted(completed);
    this.due = this.checkDue(due);
    this.priority = this.checkPriority(priority);
    this.category = this.checkCategory(category);
  }

  public Todo(HashMap<String,String> todo) throws InvalidItemException{
    for (String field: todo.keySet()) {
      if (field.equals("id")) {
        this.id = this.checkID(todo.get(field));
      } else if (field.equals("text")) {
        this.text = this.checkText(todo.get(field));
      } else if (field.equals("completed")) {
        this.completed = this.checkCompleted(todo.get(field));
      } else if (field.equals("due")) {
        this.due = this.checkDue(todo.get(field));
      } else if (field.equals("priority")) {
        this.priority = this.checkPriority(todo.get(field));
      } else {
        this.category = this.checkCategory(todo.get(field));
      }
    }
  }

  private static Date generateDue(String due) {
    //check date. If not valid, throw exception
    String[] time = due.split("/");
    int year = Integer.parseInt(time[2]);
    int month = Integer.parseInt(time[0]);
    int date = Integer.parseInt(time[1]);
    Date newDate = new Date(year,month,date);
    return newDate;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public String checkText(String text) {
    if (text.equals(NOT_FILLED)) {
      throw new InvalidItemException("text field is required");  // if there is an invalid to-do, ignore that line and continue to create others
    } else {
      return text;
    }
  }

  public int checkPriority(String priority) {
    if (priority.equals(NOT_FILLED)) {
      return 3;
    }
    int p = Integer.parseInt(priority);
    if (p > 3 || p < 1) {
      throw new InvalidItemException();
    }
    return p;
  }

  public Date checkDue(String due) {
    if (due.equals(NOT_FILLED)) {
      return null;
    } else {
      return generateDue(due);
    }
  }

  public int checkID(String id) {
    return Integer.parseInt(id);
  }

  public boolean checkCompleted(String completed) {
    return Boolean.parseBoolean(completed);
  }

  public String checkCategory(String category) {
    if (category.equals(NOT_FILLED)) {
      return null;
    } else {
      return category;
    }
  }

  public int getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public boolean isCompleted() {
    return completed;
  }

  public Date getDue() {
    return due;
  }

  public int getPriority() {
    return priority;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "\"" + id + "\",\"" +
        text + "\",\"" +
        completed + "\",\"" +
        due + "\",\"" +
        priority + "\",\"" +
        category + "\"";
  }
}