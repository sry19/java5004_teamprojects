package view;

import controller.TaskManagerExe;
import controller.TaskManagerOptionsBuilder;
import controller.commandlineparser.CommandLineParser;
import controller.commandlineparser.ICommandLine;

/**
 * Entry point of the program.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    CommandLineParser commandLineParser = new CommandLineParser();
    ICommandLine iCommandLine = commandLineParser.parse(TaskManagerOptionsBuilder.build(), args);
    TaskManagerExe taskManagerExe = new TaskManagerExe();
    taskManagerExe.execute(iCommandLine);
  }
}