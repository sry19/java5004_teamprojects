package nonprofit_communication_automation;

import java.io.FileNotFoundException;
import java.io.IOException;
import nonprofit_communication_automation.exceptions.InvalidCSVFileException;
import nonprofit_communication_automation.exceptions.InvalidTemplateException;

/**
 *  Entry point of the program.
 */

public class Main {
  public static void main(String[] args) {
    ArgumentHandler argumentHandler = new ArgumentHandler();
    try {
      argumentHandler.commandLineParser(args);
      IFormatter formatter = new Formatter();
      Generator generator = new Generator(argumentHandler.getCsvFile(), argumentHandler.getTemplateList(), argumentHandler.getOutputDir(), formatter);
      generator.generate();
    } catch (IllegalArgumentException e) {
      System.out.println("Error:");
      System.out.println(argumentHandler.getLog().toString());
      Usage.printUsage();
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } catch (InvalidTemplateException | InvalidCSVFileException e) {
      e.printStackTrace();
    }
  }
}