package model.comparators;

import static org.junit.Assert.*;


import controller.OptionConstants;
import org.junit.Before;
import org.junit.Test;

public class ComparatorFactoryTest {
  AbstractComparator comparator1;
  AbstractComparator comparator2;

  @Test
  public void makeComparator() {
    OptionConstants constants =  new OptionConstants();
    ComparatorFactory comparatorFactory = new ComparatorFactory();
    comparator1 = ComparatorFactory.makeComparator(constants.DUE);
    comparator2 = ComparatorFactory.makeComparator(constants.PRIORITY);
    assertTrue(comparator1 instanceof DateComparator);
    assertTrue(comparator2 instanceof PriorityComparator);
  }

}