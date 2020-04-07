package model.comparators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComparatorFactoryTest {
  AbstractComparator comparator1;
  AbstractComparator comparator2;

  @Test
  public void makeComparator() {
    Constants constants =  new Constants();
    ComparatorFactory comparatorFactory = new ComparatorFactory();
    comparator1 = ComparatorFactory.makeComparator(constants.DATE);
    comparator2 = ComparatorFactory.makeComparator(constants.PRIORITY);
    assertTrue(comparator1 instanceof DateComparator);
    assertTrue(comparator2 instanceof PriorityComparator);
  }

}