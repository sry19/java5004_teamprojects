package nonprofit_communication_automation;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

  @Test
  public void main() {
    String[] args = {"--letter", "--letter-template", "src/main/resources/email-template.txt", "--email", "--email-template", "src/main/resources/email-template.txt",
        "--output-dir", "src/main/resources/output/", "--csv-file",
        "src/main/resources/nonprofit-supporters.csv"};
    Main.main(args);
  }
}