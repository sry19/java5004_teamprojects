package view;

import java.time.LocalDate;
import java.util.Date;

public class Main {

  //options, required, some of them are combined
  public static void main(String[] args) {
    Integer priority1, priority2;
    priority1 = 1;
    priority2 = 2;
    System.out.println(priority1.compareTo(priority2));

    LocalDate date1, date2;
    date1 = LocalDate.of(2020, 1, 1);
    date2 = LocalDate.of(2020, 2, 2);
    System.out.println(date1.compareTo(date2));
  }
}