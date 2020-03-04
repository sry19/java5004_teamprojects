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

  @Test
  public void testEquals() {
    assertEquals(this.p1, this.p1);
    assertNotEquals(this.p1, null);
    assertNotEquals(this.p1, new CheckBox());

    Password o1 = new Password(1, 16);
    Password o2 = new Password(8, 10);
    Password o3 = new Password(8, 16);
    assertNotEquals(this.p1, o1);
    assertNotEquals(this.p1, o2);
    assertNotEquals(this.p1, this.p2);
    assertNotEquals(this.p2, this.p3);
    assertNotEquals(this.p3, this.p4);
    assertEquals(this.p1, o3);
  }

  @Test
  public void testHashCode() {
    Password o1 = new Password(8, 16);
    assertEquals(this.p1.hashCode(), o1.hashCode());
    assertNotEquals(this.p1.hashCode(), this.p2.hashCode());
  }

  @Test
  public void testToString() {
    System.out.println(this.p1.toString());
    assertEquals(this.p1.toString(),
        "Password{minLen=8, maxLen=16, minNumLowerCase=0, minNumUpperCase=0, minNumDigit=0}");
  }

}