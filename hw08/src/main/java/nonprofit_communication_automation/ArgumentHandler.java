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

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wrong argument 1. no "--email" and no "--letter". These two are required(at least one of them).
 * 2. no "--csv-file". 3. no "--output-dir". 4. "--email" but no "--email-template" 5. "--letter"
 * but no "--letter-template" 6. option that doesn't exit like "--dog". 7. wrong file type. For
 * example ".jpg". 8. argument is valid.
 */
public class ArgumentHandler {
  private String inputFile;
  private ArrayList<String> inputFilePath;
  private String outputDir;

  /**
   * Instantiates a new Argument handler.
   */
  public ArgumentHandler() {
    this.inputFilePath = new ArrayList<>();
    this.inputFile = null;
    this.outputDir = null;
  }

  /**
   * Command line parser.
   *
   * @param args the args
   * @return the boolean
   */
  public boolean commandLineParser(String[] args) {
    int length = args.length;
    int i = 0;
    while (i < length) {
      if (args[i] == "--csv-file") {
        if (i+1 < length && isValidCSVFile(args[i+1])) {
          if (inputFile == null) {
            inputFile = args[i + 1];
            i += 1;
          } else {
            throw new IllegalArgumentException("CSV file has already provided");
          }
        }else {
            throw new IllegalArgumentException("CSV file was not provided");
          }
      }
      else if (args[i] == "--output-dir") {
        if (i+1 < length && isValidPath(args[i+1])) {
          if (outputDir == null) {
            outputDir = args[i + 1];
            i += 1;
          } else {
            throw new IllegalArgumentException("output directory has already provided");
          }
        } else {
          throw new IllegalArgumentException("output directory was not provided");
        }
      }
      else if (args[i].matches(".*-template")) {
        throw new IllegalArgumentException("template was given without a label");
      }
      else if (i+2 < length && args[i+1] == args[i] + "-template" && isValidTXTFile(args[i+2])) {
        inputFilePath.add(args[i+2]);
        i += 2;
      }
      else {
        throw new IllegalArgumentException("label provided, but no template");
      }
    }

    if (inputFile == null || outputDir == null || inputFilePath.equals(new ArrayList<>())) {
      throw new IllegalArgumentException("required fields missed");
    }
    return true;
  }

  private boolean isValidCSVFile(String filename) {
    String patternString = "[^.]+(\\.csv)$";
    Pattern p = Pattern.compile(patternString);
    Matcher matcher = p.matcher(filename);
    return matcher.matches();
  }

  private boolean isValidTXTFile(String filename) {
    String patternString = "[^.]+(\\.txt)$";
    Pattern p = Pattern.compile(patternString);
    Matcher matcher = p.matcher(filename);
    return matcher.matches();
  }

  private boolean isValidPath(String filePath) {
    return true;
  }

  /**
   * Gets input file.
   *
   * @return the input file
   */
  public String getInputFile() {
    return inputFile;
  }

  /**
   * Gets input file path.
   *
   * @return the input file path
   */
  public ArrayList<String> getInputFilePath() {
    return inputFilePath;
  }

  /**
   * Gets output dir.
   *
   * @return the output dir
   */
  public String getOutputDir() {
    return outputDir;
  }

}
