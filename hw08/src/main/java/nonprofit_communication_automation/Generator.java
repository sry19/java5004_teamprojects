package nonprofit_communication_automation;

public class Generator implements IGenerator {

  private final String templatePath;
  private final String dataPath;
  private final String outputPath;

  public Generator(String templatePath, String dataPath, String outputPath) {
    this.templatePath = templatePath;
    this.dataPath = dataPath;
    this.outputPath = outputPath;
  }

  /**
   * Default generate behavior.
   * Static method or non-static method? Helper method might needed. So choose non-static.
   */
  @Override
  public void generate() {

  }
}
