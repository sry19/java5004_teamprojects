package model.filter1;

import java.util.ArrayList;
import model.Todo;

public class IncompleteFilter extends Filter {

  @Override
  public ArrayList<Todo> filter(ArrayList<Todo> itemList) {
    itemList.removeIf(Todo::isCompleted);
    return itemList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "IncompleteFilter";
  }

}
