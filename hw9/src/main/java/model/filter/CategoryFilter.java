package model.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import model.Todo;

/**
 * The type Category filter.
 */
public class CategoryFilter extends Filter {

  /**
   * The Categories used to filter.
   */
  String[] categories;

  /**
   * Instantiates a new Category filter.
   *
   * @param categories the categories used to filter
   */
  public CategoryFilter(String[] categories) {
    this.categories = categories;
  }

  /**
   * filters the ArrayList
   *
   * @param itemList an ArrayList of todos
   * @return a filtered ArrayList of todos
   */
  @Override
  public ArrayList<Todo> filter(ArrayList<Todo> itemList) {
    Set<String> categorySet = new HashSet<>();
    for (String category : this.categories) {
      categorySet.add(category);
    }
    ArrayList<Todo> todoArrayList = new ArrayList<>();
    for (Todo todo : itemList) {
      if (categorySet.contains(todo.getCategory())) {
        todoArrayList.add(todo);
      }
    }
    return todoArrayList;
  }

  /**
   * equals method
   *
   * @param o object
   * @return if they are equal, return true. Otherwise, return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CategoryFilter that = (CategoryFilter) o;
    return Arrays.equals(categories, that.categories);
  }

  /**
   * computes hashcode
   *
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Arrays.hashCode(categories);
  }

  /**
   * displays
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "CategoryFilter{" +
        "categories=" + Arrays.toString(categories) +
        '}';
  }
}
