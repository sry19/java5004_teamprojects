package nonprofit_communication_automation;

/**
 * Usage class to print out the usage.
 */
public class Usage {

  /**
   * Print the usage of the command line.
   */
  public static void printUsage() {
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
  }
}
