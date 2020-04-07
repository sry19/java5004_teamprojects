package model;

import exceptions.InvalidItemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * The concrete to-do class
 */
public class Todo extends Item implements IItem {
  private String text;
  private boolean completed;
  private Date due;
  private int priority;
  private String category;
  private int id;
  private static final String NOT_FILLED = "?";

  /**
   * To-do constructor
   * @param id to-do id
   * @param text to-do text
   * @param completed if to-do is completed
   * @param due due date
   * @param priority priority of to-do
   * @param category category of to-do
   * @throws InvalidItemException if item is not valid
   * @throws ParseException if cannot parse
   */
  public Todo(int id, String text, String completed, String due, String priority, String category)
      throws InvalidItemException, ParseException {
    this.id = id;
    this.text = this.checkText(text);
    this.completed = this.checkCompleted(completed);
    this.due = this.checkDue(due);
    this.priority = this.checkPriority(priority);
    this.category = this.checkCategory(category);
  }

  /**
   * to-do constructor
   * @param todo a to-do hash map
   * @throws InvalidItemException when item is not valid
   * @throws ParseException if file cannot parse
   */
  public Todo(HashMap<String,String> todo) throws InvalidItemException, ParseException {
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

  /**
   * Generate a due date
   * @param due due date passed in from the command line
   * @return a Date object
   * @throws ParseException if cannot parse
   */
  private static Date generateDue(String due) throws ParseException {
    if (due == null) {
      return null;
    } else {
      try {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.parse(due);
        String[] time = due.split("/");
        int year = Integer.parseInt(time[2]);
        int month = Integer.parseInt(time[0]);
        int date = Integer.parseInt(time[1]);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, date, 12, 30, 30);
        Date newDate = cal.getTime();
        return newDate;
      } catch (ParseException e) {
        throw new ParseException("Date must be in format of MM/dd/yyyy", 1);  //TODO: can we extend parse exception?
      }
    }
  }

  /**
   * Set to-do as complete
   * @param completed if to-do is completed
   */
  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  /**
   * Check if to-do text is valid
   * @param text to-do text
   * @return the text
   */
  public String checkText(String text) {
    if (text.equals(NOT_FILLED)) {
      throw new InvalidItemException("text field is required");  // if there is an invalid to-do, ignore that line and continue to create others
    } else {
      return text;
    }
  }

  /**
   * Check and return the priority
   * @param priority the priority of to-do
   * @return an int of priority
   */
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

  /**
   * Check if due date is valid
   * @param due the due date
   * @return a Date object
   * @throws ParseException if due cannot parse
   */
  public Date checkDue(String due) throws ParseException {
    if (due.equals(NOT_FILLED)) {
      return null;
    } else {
      return generateDue(due);
    }
  }

  /**
   * Check if the id is valid
   * @param id the string passed in
   * @return an int
   */
  public int checkID(String id) {
    return Integer.parseInt(id);
  }

  /**
   * Check if completion is valid
   * @param completed the completion status
   * @return a boolean on the completion status
   */
  public boolean checkCompleted(String completed) {
    return Boolean.parseBoolean(completed);
  }

  /**
   * Check and return the category
   * @param category the to-do category
   * @return the category
   */
  public String checkCategory(String category) {
    if (category.equals(NOT_FILLED)) {
      return null;
    } else {
      return category;
    }
  }

  /**
   * Get the ID
   * @return the ID
   */
  public int getId() {
    return id;
  }

  /**
   * Get the text
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Get completion status
   * @return the completion status
   */
  public boolean isCompleted() {
    return completed;
  }

  /**
   * Get the due date
   * @return the due date
   */
  public Date getDue() {
    return due;
  }

  /**
   * Get the priority
   * @return the priority
   */
  public int getPriority() {
    return priority;
  }

  /**
   * Get the category
   * @return the category
   */
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Todo todo = (Todo) o;
    return completed == todo.completed &&
        priority == todo.priority &&
        id == todo.id &&
        Objects.equals(text, todo.text) &&
        Objects.equals(due, todo.due) &&
        Objects.equals(category, todo.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, completed, due, priority, category, id);
  }
}