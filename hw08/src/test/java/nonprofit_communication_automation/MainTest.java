package nonprofit_communication_automation;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

  @Test
  public void illegalArgument() {
    Usage usage = new Usage();
    String[] args = {"--letter-template", "src/main/resources/letter-template.txt", "--email",
        "--email-template", "src/main/resources/email-template.txt",
        "--output-dir", "src/main/resources/output/",
        "src/main/resources/nonprofit-supporters_2row.csv"};
    Main.main(args);
  }

  @Test
  public void main() {
    String[] args = {"--letter", "--letter-template", "src/main/resources/letter-template.txt",
        "--email", "--email-template", "src/main/resources/email-template.txt",
        "--output-dir", "src/main/resources/output/", "--csv-file",
        "src/main/resources/nonprofit-supporters_2row.csv"};
    Main.main(args);
  }
}