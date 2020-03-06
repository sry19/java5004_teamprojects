package fields;

import java.util.Objects;

/**
 * Field Class.
 */

public class Field<T> {

  private String label;
  private T value;
  private boolean required;
  private Validator<T> validator;

  /**
   * Constructor for Field.
   *
   * @param label     The String label associated with the form field.
   * @param required  A boolean indicating whether a particular field must be completed before the
   *                  form can be submitted.
   * @param validator a Validator (see below) that will perform input validation.
   */
  public Field(String label, boolean required, Validator<T> validator) {
    this.label = label;
    this.value = null;
    this.required = required;
    this.validator = validator;
  }

  /**
   * Update value.
   *
   * @param value the value to update.
   */
  public void updateValue(T value) {
    if (!validator.isValid(value)) {
      throw new IllegalArgumentException();
    }
    this.value = value;
  }

  /**
   * This method should return true if the Field has been filled out.
   *
   * @return true or false.
   */
  public boolean isFilled() {
    return !this.required || this.value != null;
  }

  /**
   * @return label.
   */
  public String getLabel() {
    return label;
  }

  /**
   * @return value.
   */
  public T getValue() {
    return value;
  }

  /**
   * @return required.
   */
  public boolean isRequired() {
    return required;
  }

  /**
   * @return validator.
   */
  public Validator<T> getValidator() {
    return validator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Field<?> field = (Field<?>) o;
    return isRequired() == field.isRequired() &&
        Objects.equals(getLabel(), field.getLabel()) &&
        Objects.equals(getValue(), field.getValue()) &&
        Objects.equals(getValidator(), field.getValidator());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLabel(), getValue(), isRequired(), getValidator());
  }

  @Override
  public String toString() {
    return "Field{" +
        "label='" + label + '\'' +
        ", value=" + value +
        ", required=" + required +
        ", validator=" + validator +
        '}';
  }
}
