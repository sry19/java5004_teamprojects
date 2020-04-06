package model.filter1;

import java.util.HashMap;

public class FilterSettings {

  HashMap<String,String> container;

  public FilterSettings() {
    this.container = new HashMap<>();
    this.container.put("--show-category","--show-category");
    this.container.put("--show-incomplete","--show-incomplete");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FilterSettings that = (FilterSettings) o;

    return container.equals(that.container);
  }

  @Override
  public int hashCode() {
    return container.hashCode();
  }

  @Override
  public String toString() {
    return "FilterSettings{" +
        "container=" + container +
        '}';
  }
}
