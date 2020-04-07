package model.filter;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class FilterSettingsTest {
  FilterSettings filterSettings1;
  FilterSettings filterSettings2;

  @Before
  public void setUp() throws Exception {
    filterSettings1 = new FilterSettings();
    filterSettings2 = new FilterSettings();
  }

  @Test
  public void testEquals() {
    assertEquals(filterSettings1,filterSettings1);
    assertEquals(filterSettings1,filterSettings2);
    assertFalse(filterSettings1.equals(null));
    assertFalse(filterSettings1.equals(new HashMap<String,String>()));
  }

  @Test
  public void testHashCode() {
    assertEquals(filterSettings1.hashCode(),filterSettings2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("FilterSettings{container={--show-incomplete=--show-incomplete, --show-category=--show-category}}",filterSettings1.toString());
  }
}