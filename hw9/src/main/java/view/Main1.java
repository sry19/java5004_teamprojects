package view;

import controller.TaskManagerExe;
import controller.TaskManagerOptionsBuilder;
import controller.commandlineparser.CommandLineParser;
import controller.commandlineparser.ICommandLine;

/**
 * Entry point of the program.
 */
public class Main1 {

<<<<<<<HEAD

  public static void main(String[] args) throws Exception {
    CommandLineParser commandLineParser = new CommandLineParser();
    ICommandLine iCommandLine = commandLineParser.parse(TaskManagerOptionsBuilder.build(), args);
    TaskManagerExe taskManagerExe = new TaskManagerExe();
    taskManagerExe.execute(iCommandLine);
=======
    //options, required, some of them are combined
    public static void main (String[]args) throws IOException {
//    ICommandLine commandLine = new CommandLine();
//    IItemList iItemList = new TodoList(commandLine);
//    iItemList.add(String filename);
//
//    iItemList.appendItem();
//    iItemList.completed();
//
//    iItemList.write();
//    //iItemList.filter();
//    //iItemList.sort();
//    iItemList.display();
>>>>>>>master
    }
  }

