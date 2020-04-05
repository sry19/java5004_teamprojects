package view;

import controller.commandlineparser.CommandLine;
import controller.commandlineparser.ICommandLine;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import model.reader.IReader;

public class Main {

  //options, required, some of them are combined
  public static void main(String[] args) throws IOException {
//    Integer priority1, priority2;
//    priority1 = 1;
//    priority2 = 2;
//    System.out.println(priority1.compareTo(priority2));
//
//    LocalDate date1, date2;
//    date1 = LocalDate.of(2020, 1, 1);
//    date2 = LocalDate.of(2020, 2, 2);
//    System.out.println(date1.compareTo(date2));

    ICommandLine commandLine = new CommandLine();
    IItemList iItemList = new TodoList(commandLine);
    iItemList.add(String filename);

    iItemList.appendItem();
    iItemList.completed();

    iItemList.write();
    //iItemList.filter();
    //iItemList.sort();
    iItemList.display();


  }
}