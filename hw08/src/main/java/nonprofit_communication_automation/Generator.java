package nonprofit_communication_automation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import nonprofit_communication_automation.exceptions.InvalidCSVFileException;
import nonprofit_communication_automation.exceptions.InvalidTemplateException;

/**
 * Generator takes a input csv file, template and output directory to generate new txt.
 */
public class Generator {

  private String inputDataPath;
  private List<String> templatePathList;
  private String outputDir;
  private IFormatter formatter;

  /**
   * Initialize the generator with a single template.
   *
   * @param inputDataPath inputDataPath
   * @param templatePath  templatePath
   * @param outputDir     outputDir
   */
  public Generator(String inputDataPath, String templatePath, String outputDir,
      IFormatter formatter) {
    this.inputDataPath = inputDataPath;
    this.templatePathList = new ArrayList<>();
    this.templatePathList.add(templatePath);
    this.outputDir = outputDir;
    this.formatter = formatter;
  }

  /**
   * Initialize the generator with a list of template.
   *
   * @param inputDataPath    inputDataPath
   * @param templatePathList templatePathList
   * @param outputDir        outputDir
   */
  public Generator(String inputDataPath, List<String> templatePathList, String outputDir,
      IFormatter formatter) {
    this.inputDataPath = inputDataPath;
    this.templatePathList = templatePathList;
    this.outputDir = outputDir;
    this.formatter = formatter;
  }

  /**
   * generate all output.
   *
   * @throws IOException              if IO error happens.
   * @throws InvalidCSVFileException  if the CSV File is invalid.
   * @throws InvalidTemplateException if the variable in template is not in provided table.
   */
  public void generate() throws IOException, InvalidCSVFileException, InvalidTemplateException {
    for (String template : templatePathList) {
      generateSingleFile(template);
    }
  }

  /**
   * Generate all output from a single template with provided csv file.
   *
   * @param inputFilePath the input template.
   * @throws IOException              if IO error happens.
   * @throws InvalidCSVFileException  if the CSV File is invalid.
   * @throws InvalidTemplateException if the variable in template is not in provided table.
   */
  private void generateSingleFile(String inputFilePath)
      throws IOException, InvalidCSVFileException, InvalidTemplateException {
    CSVReader csvReader = new CSVReader(inputDataPath);
    BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath));

    HashMap<String, String> map;
    int i = 0;
    while ((map = csvReader.readNextRow()) != null) {
      String outputFilePath = getOutPutFilePath(inputFilePath, i);
      generateSingleRow(inputFile, outputFilePath, map);
      i++;
    }
    csvReader.close();
    inputFile.close();
  }

  /**
   * Create a output file from a single row.
   *
   * @param inputFile      the input file buffer.
   * @param outputFilePath the output file path,
   * @param map            the map to replace the placeholder.
   * @throws IOException              if IO error happens.
   * @throws InvalidTemplateException if the variable in template is not in provided table.
   */
  private void generateSingleRow(BufferedReader inputFile, String outputFilePath,
      HashMap<String, String> map)
      throws IOException, InvalidTemplateException {
    System.out.println(outputFilePath);
    BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFilePath));
    String line;
    while ((line = inputFile.readLine()) != null) {
      outputFile.write(this.formatter.format(line, map) + "\n");
    }
    outputFile.close();
  }

  /**
   * Generate output file name and path.
   *
   * @param inputFilePath the inputFilePath.
   * @param i             the index to distinguish different output.
   * @return outputFilePath.
   */
  private String getOutPutFilePath(String inputFilePath, int i) {
    String[] splits = inputFilePath.split("[/\\\\]");
    String filename = splits[splits.length-1].split("\\.")[0];
    return this.outputDir + filename + "_" + i + "_.out.txt";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Generator generator = (Generator) o;
    return inputDataPath.equals(generator.inputDataPath) &&
        templatePathList.equals(generator.templatePathList) &&
        outputDir.equals(generator.outputDir) &&
        formatter.equals(generator.formatter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputDataPath, templatePathList, outputDir, formatter);
  }

  @Override
  public String toString() {
    return "Generator{" +
        "inputDataPath='" + inputDataPath + '\'' +
        ", templatePathList=" + templatePathList +
        ", outputDir='" + outputDir + '\'' +
        ", formatter=" + formatter +
        '}';
  }
}
