package model.comparators;

import java.util.Comparator;
import model.Todo;

public class DateComparator extends AbstractComparator {

  //HOW TO RESOLVE DATE
  @Override
  public int compare(Todo o1, Todo o2) {
    return o1.getDue().compareTo(o2.getDue());
//    if ((dateParser(o2.getDate())[2]).equals((dateParser(o2.getDate())[2]))) {
//      if ((dateParser(o1.getDate())[1]).equals((dateParser(o2.getDate())[1]))) {
//        return ((dateParser(o1.getDate())[0]).compareTo((dateParser(o2.getDate())[0])));
//      } else {
//        return ((dateParser(o1.getDate())[1]).compareTo((dateParser(o2.getDate())[1])));
//      }
//      } else {
//      return ((dateParser(o1.getDate())[2]).compareTo((dateParser(o2.getDate())[2])));
//    }
  }

//  private String[] dateParser(String date) {
//    String[] parsedDate = date.split("////");
//    return parsedDate;
//  }
}