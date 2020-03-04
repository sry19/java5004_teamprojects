package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PasswordTest {

  private Password p1, p2, p3, p4;

  @Before
  public void setUp() throws Exception {
    this.p1 = new Password(8, 16);
    this.p2 = new Password(8, 16, 4);
    this.p3 = new Password(8, 16, 4, 4);
    this.p4 = new Password(8, 16, 4, 4, 4);
  }

  @Test
  public void tooShort() {
    assertFalse(this.p1.isValid("123"));
  }

  @Test
  public void tooLong() {
    assertFalse(this.p1.isValid("123456789123456789"));
  }

  @Test
  public void tooFewLowerCases() {
    assertFalse(this.p2.isValid("ab123456789"));
  }

  @Test
  public void tooFewUpperCases() {
    assertFalse(this.p3.isValid("abcdAB56789"));
  }

  @Test
  public void tooFewDigits() {
    assertFalse(this.p4.isValid("12abcdABCD"));
  }

  @Test
  public void containsSpace() {
    assertFalse(this.p4.isValid("1234abcdABCD  "));
  }

  @Test
  public void isValid() {
    assertTrue(this.p4.isValid("1234abcdABCD&#"));
  }
}