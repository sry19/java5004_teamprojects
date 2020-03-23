package nonprofit_communication_automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ErrorLogger {
  private List<String> log;

  /**
   * Constructor for error logger
   */
  public ErrorLogger() {
    this.log = new ArrayList<>();
  }

  /**
   * add a message to log
   * @param event - message of an event
   */
  public void log(String event) {
    this.log.add(event);
  }

  /**
   * return if the log is empty
   * @return if the log is empty
   */
  public boolean isEmpty() {
    return this.log.size() == 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorLogger that = (ErrorLogger) o;
    return Objects.equals(log, that.log);
  }

  @Override
  public int hashCode() {
    return Objects.hash(log);
  }

  @Override
  public String toString() {
    if (this.log.isEmpty()) {
      return "Empty log";
    }
    String out = "";
    for (String entry: this.log) {
      out += entry + System.lineSeparator();
    }
    return out;
  }
}