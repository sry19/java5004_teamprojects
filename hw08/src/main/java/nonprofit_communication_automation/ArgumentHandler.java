package nonprofit_communication_automation;

/**
 * Handle arguments passed in to the program.
 * Give feedback to the user.
 */

/**
 * Error: --email provided but no --email-template was given.
 *
 * Usage:
 * --email Generate email messages. If this option is provided, then
 * --email-template must also be provided.
 * --email-template <path/to/file> A filename for the email template.
 * --letter Generate letters. If this option is provided, then
 * --letter-template must also be provided.
 * --letter-template <path/to/file> A filename for the letter
 * template.
 * --output-dir <path/to/folder> The folder to store all generated
 * files. This option is required.
 * --csv-file <path/to/folder> The CSV file to process. This option is
 * required.
 *
 * Examples:
 * --email --email-template email-template.txt --output-dir emails
 * --csv-file customer.csv
 * --letter --letter-template letter-template.txt --output-dir letters
 * --csv-file customer.csv
 */

/**
 * Wrong argument
 * 1. no "--email" and no "--letter". These two are required(at least one of them).
 * 2. no "--csv-file".
 * 3. no "--output-dir".
 * 4. "--email" but no "--email-template"
 * 5. "--letter" but no "--letter-template"
 * 6. option that doesn't exit like "--dog".
 * 7. wrong file type. For example ".jpg".
 * 8. argument is valid.
 */

public class ArgumentHandler {
  private final String[] args;
  private String[] inputFilePath;
  private String outputDir;

  public ArgumentHandler(String[] args) {
    this.args = args;
  }

  public boolean isValid() {
    throw new IllegalArgumentException("error messege");
  }

  public void switchCase() {

  }
}
