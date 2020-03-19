package nonprofit_communication_automation;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  Entry point of the program.
 */

public class Main {
  public static void main(String[] args) {
    try {
      ArgumentHandler argumentHandler = new ArgumentHandler();
      argumentHandler.commandLineParser(args);
      Generator generator = new Generator(
          argumentHandler.getInputFilePath(),
          argumentHandler.getOutputDir());
      generator.iterator(argumentHandler.getInputFile());
    } catch (IllegalArgumentException e) {
      System.out.println("Error:" + e.getMessage());
      System.out.println("Usage:\n"
          + " * --email Generate email messages. If this option is provided, then\n"
          + " * --email-template must also be provided.\n"
          + " * --email-template <path/to/file> A filename for the email template.\n"
          + " * --letter Generate letters. If this option is provided, then\n"
          + " * --letter-template must also be provided.\n"
          + " * --letter-template <path/to/file> A filename for the letter\n"
          + " * template.\n"
          + " * --output-dir <path/to/folder> The folder to store all generated\n"
          + " * files. This option is required.\n"
          + " * --csv-file <path/to/folder> The CSV file to process. This option is\n"
          + " * required.\n"
          + " *\n"
          + " * Examples:\n"
          + " * --email --email-template email-template.txt --output-dir emails\n"
          + " * --csv-file customer.csv\n"
          + " * --letter --letter-template letter-template.txt --output-dir letters\n"
          + " * --csv-file customer.csv");
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }
}
