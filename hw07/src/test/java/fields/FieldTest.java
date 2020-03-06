package fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

  Field<String> field1, field2, field3, field4, field5;
  Password password1, password2;

  @Before
  public void setUp() throws Exception {
    this.password1 = new Password(6, 10);
    this.password2 = new Password(8, 12);
    this.field1 = new Field<>("password1", true, this.password1);
    this.field2 = new Field<>("password2", true, this.password1);
    this.field3 = new Field<>("password1", true, this.password2);
    this.field4 = new Field<>("password1", false, this.password1);
    this.field5 = new Field<>("password1", true, this.password1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInput() {
    this.field1.updateValue("1");
  }

  @Test
  public void updateValue() {
    this.field1.updateValue("12345678");
    assertEquals("12345678", this.field1.getValue());
  }

  @Test
  public void isFilled() {
    assertTrue(this.field4.isFilled());
    assertFalse(this.field1.isFilled());
    this.field1.updateValue("12345678");
    assertTrue(this.field1.isFilled());
  }

  @Test
  public void testEquals() {
    assertEquals(this.field1, this.field1);
    assertNotEquals(this.field1, null);
    assertNotEquals(this.field1, this.password1);
    assertNotEquals(this.field1, this.field2);
    assertNotEquals(this.field1, this.field3);
    assertNotEquals(this.field1, this.field4);

    this.field1.updateValue("12345678");
    assertNotEquals(this.field1, this.field5);
    this.field5.updateValue("12345678");
    assertEquals(this.field1, this.field5);
  }

  @Test
  public void testHashCode() {
    assertEquals(this.field1.hashCode(), this.field5.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(
        "Field{label='password1', value=null, required=true, validator=Password{minLen=6, maxLen=10, minNumLowerCase=0, minNumUpperCase=0, minNumDigit=0}}",
        this.field1.toString());
  }
}