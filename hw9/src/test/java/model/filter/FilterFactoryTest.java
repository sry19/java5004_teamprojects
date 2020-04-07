package model.filter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilterFactoryTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void makeFilter() {
    CategoryFilter categoryFilter = new CategoryFilter(new String[]{"work"});
    assertEquals(FilterFactory.makeFilter("--show-category",  new String[]{"work"}),categoryFilter);

    IncompleteFilter incompleteFilter = new IncompleteFilter();
    assertEquals(FilterFactory.makeFilter("--show-incomplete",null),incompleteFilter);

    assertNull(FilterFactory.makeFilter("--option",null));
  }
}