package model.Comparators;

import java.util.Comparator;
import model.Todo;

//Yiyu
public class DateComparator extends AbstractComparator implements Comparator<Todo> {

  @Override
  public int compare(Todo o1, Todo o2) {
    if ((dateParser(o1.getDate())[2]).equals((dateParser(o2.getDate())[2]))) {
      if ((dateParser(o1.getDate())[1]).equals((dateParser(o2.getDate())[1]))) {
        return ((dateParser(o1.getDate())[0]).equals((dateParser(o2.getDate())[0])));
      } else {
        return ((dateParser(o1.getDate())[1]).equals((dateParser(o2.getDate())[1])));
      }
      } else {
      return ((dateParser(o1.getDate())[2]).equals((dateParser(o2.getDate())[2])));
    }
  }

  private String[] dateParser(String date) {
    String[] parsedDate = date.split("////");
    return parsedDate;
  }
}