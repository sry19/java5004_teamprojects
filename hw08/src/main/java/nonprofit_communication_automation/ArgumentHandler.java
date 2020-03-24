package nonprofit_communication_automation;

/**
 * Handle arguments passed in to the program. Give feedback to the user.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wrong argument 1. no "--email" and no "--letter". These two are required(at least one of them).
 * 2. no "--csv-file". 3. no "--output-dir". 4. "--email" but no "--email-template" 5. "--letter"
 * but no "--letter-template" 6. option that doesn't exit like "--dog". 7. wrong file type. For
 * example ".jpg". 8. argument is valid.
 */
public class ArgumentHandler {

  private String csvFile;
  private ArrayList<String> templateList; //the list of templates to generate output
  private String outputDir;
  protected Set<String> visitedLabel; //set of unmatched labels
  protected Map<String, String> visitedTemplate; //unmatched templates and their labels to match
  private ErrorLogger log;

  /**
   * Instantiates a new Argument handler.
   */
  public ArgumentHandler() {
    this.templateList = new ArrayList<>();
    this.csvFile = null;
    this.outputDir = null;
    this.visitedLabel = new HashSet<>();
    this.visitedTemplate = new HashMap<>();
    this.log = new ErrorLogger();
  }

  /**
   * Return if command line arguments are valid
   * @param args arguments from the command line
   * @return if command line arguments are valid
   */
  public boolean commandLineParser(String[] args) {
    int length = args.length;
    int i = 0;
    while (i < length) {
      if (args[i].equals("--csv-file")) { //check for valid csv file
        if (i + 1 < length && this.isValidCSVFile(args[i + 1])) {
          if (this.csvFile == null) {  //if no csvFile existing, set it to the captured file
            this.csvFile = args[i + 1];
            i += 1;
          } else {
            this.log.log("CSV file has already provided");
          }
        } else {
          this.log.log("CSV file was not provided");
        }
      } else if (args[i].equals("--output-dir")) { //similar to csv file
        if (i + 1 < length && this.isValidPath(args[i+1])) {
          if (this.outputDir == null) {
            this.outputDir = args[i + 1];
            i += 1;
          } else {
            this.log.log("output directory has already provided");
          }
        } else {
          this.log.log("output directory was not provided");
        }
      } else {
        Pattern pattern = Pattern.compile("(--.+)-template");
        Matcher matcher = pattern.matcher(args[i]);
        if (matcher.matches()) { // args[i] = xx-template
          if (this.templateParser(args, i, matcher.group(1))) { //group(1) gets the (--.+) part
            i += 1;
          } else {
            this.log.log("no template files");
          }
        } else { // args[i] = xx
          this.labelParser(args[i]);
        }
      }
      i += 1;
    }
    //if the unmatched label list is not empty, it means we lack template
    if (!this.visitedLabel.isEmpty()) {
      this.log.log("lack template");
      throw new IllegalArgumentException("lack template");
      //if the unmatched template list hash map is not empty, it means we lack template
    } else if (!this.visitedTemplate.isEmpty()) {
      this.log.log("lack label");
      throw new IllegalArgumentException("lack label");
    } else {
      //no errors, and all required fields fulfilled
      if (checkRequiredArguments() && this.log.isEmpty()) {
        return true;
      } else {
        this.log.log("required fields missed");
        throw new IllegalArgumentException("required fields missed");
      }
    }
  }

  /**
   * Modified lists and hash maps of labels and commands
   * @param label the label
   * @return true when executed
   */
  public boolean labelParser(String label) {
    if (this.visitedTemplate.containsKey(label)) { //if the label is to be matched for any template
      //add the template to the list to generate
      this.templateList.add(this.visitedTemplate.get(label));
      //then the pair is clean. remove it from unmatched template
      this.visitedTemplate.remove(label);
    } else {
      //if not to be matched for any template, add it in unmatched labels
      this.visitedLabel.add(label);
    }
    return true;
  }

  /**
   * Check if a template is matched to a label, modifies according hashmap and lists
   * Returns if the argument is legal
   * @param args the command line args
   * @param i the index
   * @param label the label of command line
   * @return if the argument is legal
   */
  public boolean templateParser(String[] args, int i, String label) {
    // if label already exists, remove the label and add template file to template list
    if (this.visitedLabel.contains(label)) {
      this.visitedLabel.remove(label);
      if (i + 1 < args.length && isValidTXTFile(args[i + 1])) {
        this.templateList.add(args[i + 1]);
      } else {
        return false;
      }
    } else {  // if label not existing, add label to visited template hash map
      if (i + 1 < args.length && isValidTXTFile(args[i + 1])) {
        this.visitedTemplate.put(label, args[i + 1]);
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * Check if all required arguments are met
   * @return if all required arguments are met
   */
  public boolean checkRequiredArguments() {
    if (this.csvFile == null || this.outputDir == null || this.templateList.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Check if a csv file is valid
   * @param filename the file name to check
   * @return if a csv file is valid
   */
  public boolean isValidCSVFile(String filename) {
    String patternString = ".+\\.csv$";
    Pattern p = Pattern.compile(patternString);
    Matcher matcher = p.matcher(filename);
    return matcher.matches();
  }

  /**
   * Check if a txt file is valid
   * @param filename the file name
   * @return if a txt file is valid
   */
  private boolean isValidTXTFile(String filename) {
    String patternString = ".+\\.txt$";
    Pattern p = Pattern.compile(patternString);
    Matcher matcher = p.matcher(filename);
    return matcher.matches();
  }

  /**
   * Check if path is valid
   * @param filePath the file path
   * @return if path is valid
   */
  public boolean isValidPath(String filePath) {
    String[] path = filePath.split("[/\\\\]");
    for (int i = 0; i < path.length; i++) {
      String patternString = "[\\w\\d_]+";
      Pattern p = Pattern.compile(patternString);
      Matcher matcher = p.matcher(path[i]);
      if (!matcher.matches()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Gets input file.
   *
   * @return the input file
   */
  public String getCsvFile() {
    return this.csvFile;
  }

  /**
   * Gets input file path.
   *
   * @return the input file path
   */
  public ArrayList<String> getTemplateList() {
    return templateList;
  }

  /**
   * Gets output dir.
   *
   * @return the output dir
   */
  public String getOutputDir() {
    return outputDir;
  }

  /**
   * Get the visited label
   * @return the visited label
   */
  public Set<String> getVisitedLabel() {
    return visitedLabel;
  }

  /**
   * Get the visited template
   * @return the visited template
   */
  public Map<String, String> getVisitedTemplate() {
    return visitedTemplate;
  }

  /**
   * Set the visited label
   * @param visitedLabel the visited label
   */
  public void setVisitedLabel(Set<String> visitedLabel) {
    this.visitedLabel = visitedLabel;
  }

  /**
   * Set the visited template
   * @param visitedTemplate the visited template
   */
  public void setVisitedTemplate(Map<String, String> visitedTemplate) {
    this.visitedTemplate = visitedTemplate;
  }

  /**
   * Set the csv file
   * @param csvFile the csv file
   */
  public void setCsvFile(String csvFile) {
    this.csvFile = csvFile;
  }

  /**
   * Set the template list
   * @param templateList the template list
   */
  public void setTemplateList(ArrayList<String> templateList) {
    this.templateList = templateList;
  }

  /**
   * Set the output directory
   * @param outputDir the output directory
   */
  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }
}
