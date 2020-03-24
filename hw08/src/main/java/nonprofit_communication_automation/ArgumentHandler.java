package nonprofit_communication_automation;

/**
 * Handle arguments passed in to the program.
 * Give feedback to the user.
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
  private ArrayList<String> templateList;
  private String outputDir;
  protected Set<String> visitedLabel;
  protected Map<String,String> visitedTemplate;
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
   * Command line parser.
   *
   * @return the boolean
   */
  public boolean commandLineParser(String[] args) {
    int length = args.length;
    int i = 0;
    while (i < length) {
      if (args[i].equals("--csv-file")) {
        if (i + 1 < length && this.isValidCSVFile(args[i + 1])) {
          if (this.csvFile == null) {
            this.csvFile = args[i + 1];
            i += 1;
          } else {
            this.log.log("CSV file has already provided");
          }
        } else {
          this.log.log("CSV file was not provided");
        }
      } else if (args[i].equals("--output-dir")) {
        if (i + 1 < length) {
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
          if (this.templateParser(args, i, matcher.group(1))) {
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
    if (!this.visitedLabel.isEmpty()) {
      this.log.log("lack template");
      throw new IllegalArgumentException("lack template");
    } else if (!this.visitedTemplate.isEmpty()) {
      this.log.log("lack label");
      throw new IllegalArgumentException("lack label");
    } else {
      if (checkRequiredArguments() && this.log.isEmpty()) {
        return true;
      } else {
        this.log.log("required fields missed");
        throw new IllegalArgumentException("required fields missed");
      }
    }
  }

  public boolean labelParser(String label) {
    if (this.visitedTemplate.containsKey(label)) {
      this.templateList.add(this.visitedTemplate.get(label));
      this.visitedTemplate.remove(label);
    } else {
      this.visitedLabel.add(label);
    }
    return true;
  }

  public boolean templateParser(String[] args, int i, String label) {
    if (this.visitedLabel.contains(label)) {
      this.visitedLabel.remove(label);
      if (i + 1 < args.length && isValidTXTFile(args[i + 1])) {
        this.templateList.add(args[i + 1]);
      } else {
        return false;
      }
    } else {
      if (i + 1 < args.length && isValidTXTFile(args[i + 1])) {
        this.visitedTemplate.put(label, args[i + 1]);
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean checkRequiredArguments() {
    if (this.csvFile == null || this.outputDir == null || this.templateList.isEmpty()) {
      return false;
    }
    return true;
  }

  public boolean isValidCSVFile(String filename) {
    String patternString = ".+\\.csv$";
    Pattern p = Pattern.compile(patternString);
    Matcher matcher = p.matcher(filename);
    return matcher.matches();
  }

  private boolean isValidTXTFile(String filename) {
    String patternString = ".+\\.txt$";
    Pattern p = Pattern.compile(patternString);
    Matcher matcher = p.matcher(filename);
    return matcher.matches();
  }

  public boolean isValidPath(String filePath) {
    String[] path = filePath.split(File.pathSeparator);
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

  public Set<String> getVisitedLabel() {
    return visitedLabel;
  }

  public Map<String, String> getVisitedTemplate() {
    return visitedTemplate;
  }

  public void setVisitedLabel(Set<String> visitedLabel) {
    this.visitedLabel = visitedLabel;
  }

  public void setVisitedTemplate(Map<String, String> visitedTemplate) {
    this.visitedTemplate = visitedTemplate;
  }

  public void setCsvFile(String csvFile) {
    this.csvFile = csvFile;
  }

  public void setTemplateList(ArrayList<String> templateList) {
    this.templateList = templateList;
  }

  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }
}
