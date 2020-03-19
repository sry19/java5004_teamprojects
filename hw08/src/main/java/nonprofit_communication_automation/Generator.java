package nonprofit_communication_automation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The type Generator.
 */
public class Generator implements IGenerator {

  private final ArrayList<String> templatePath;
  private final String outputPath;

  /**
   * Instantiates a new Generator.
   *
   * @param templatePath the template path
   * @param outputPath   the output path
   */
  public Generator(ArrayList<String> templatePath, String outputPath) {
    this.templatePath = templatePath;
    this.outputPath = outputPath;
  }

  /**
   * generates a file with a template and a user data map corresponding the type with the value
   *
   * @param map          the map that correspond the type with the value
   * @param templatePath the template path
   * @param index        the index of the output file
   * @throws FileNotFoundException the file not found exception
   * @throws IOException           the io exception
   */
  public void generate(Map<String,String> map, String templatePath, Integer index) throws FileNotFoundException, IOException {

    String outputFileName = outputFileName(templatePath, index);

    BufferedReader templateFile = new BufferedReader(new FileReader(templatePath));
    BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFileName));
    String currentTemplateLine;
    while ((currentTemplateLine = templateFile.readLine()) != null) {
      String newLine = this.replaceTitle(map, currentTemplateLine);
      outputFile.write(newLine);
    }
  }

  /**
   * generates the output file name based on the template name and the index of the user data
   *
   * @param templatePath the template path
   * @param index the index of the user data
   * @return the output file name
   */
  private String outputFileName(String templatePath, Integer index) {
    int endPosition = templatePath.lastIndexOf(".");
    int startPosition = templatePath.lastIndexOf(File.separator) + 1;
    String filename = templatePath.substring(startPosition, endPosition);
    String outputFileName = this.outputPath + File.separator + filename + index.toString() + "out.txt";
    return outputFileName;
  }

  /**
   * a iterator to generate all output files
   *
   * @param dataPath the data path
   * @throws FileNotFoundException the file not found exception
   * @throws IOException           the io exception
   */
  public void iterator(String dataPath) throws FileNotFoundException, IOException{
    BufferedReader dataFile = new BufferedReader(new FileReader(dataPath));
    String line;
    line = dataFile.readLine();
    CSVParser csvParser = new CSVParser(line);
    Integer i = 1;
    while ((line = dataFile.readLine()) != null) {
      Map<String,String> map = csvParser.dataMatcher(line);
      for (String filePath : this.templatePath) {
        this.generate(map, filePath, i);
      }
      i += 1;
    }
  }

  /**
   * Replace title string.
   *
   * @param map                 the map
   * @param currentTemplateLine the current template line
   * @return the string
   */
  public String replaceTitle(Map<String,String> map, String currentTemplateLine) {
    for (String key: map.keySet()) {
      currentTemplateLine = currentTemplateLine.replaceAll("[[" + key + "]]", map.get(key));
    }
    return currentTemplateLine;
  }
}