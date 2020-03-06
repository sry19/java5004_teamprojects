package fields;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class NumberTest {
  Number num1;
  Number num2;
  Number num3;
  Number num4;
  Number num5;

  @Before
  public void setUp() throws Exception {
    num1 = new Number(-2, 100, 2);
    num2 = new Number(-2, 100, 2);
    num3 = new Number(3, 100, -2);
    num4 = new Number(-2, 101, 2);
    num5 = new Number(-2, 100, 4);
  }

  @Test
  public void testIsValid() {
    assertTrue(num1.isValid("-2.0"));
    assertTrue(num1.isValid("100"));

    assertTrue(num3.isValid("4"));
    assertFalse(num1.isValid("-3"));
    assertTrue(num1.isValid("1.00"));
    assertFalse(num1.isValid("3.345"));
    assertFalse(num1.isValid("101.1"));

    assertFalse(num1.isValid(null));
    assertFalse(num1.isValid("AB2C"));
    assertFalse(num1.isValid("    14    "));
    assertFalse(num1.isValid(""));
    assertFalse(num1.isValid(" "));
  }


  @Test
  public void testEquals() {
    assertTrue(num1.equals(num1));
    assertFalse(num1.equals(null));
    assertTrue(num1.equals(num2));
    assertFalse(num1.equals(num3));
    assertFalse(num1.equals(num4));
    assertFalse(num1.equals(num5));
    assertFalse(num1.equals(new ArrayList<>()));
  }

  @Test
  public void testHashCode() {
    assertTrue(num1.hashCode() == num2.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "Number{minValue=-2, maxValue=100, decimalPlaces=2}";
    assertEquals(expected, num1.toString());
  }
}