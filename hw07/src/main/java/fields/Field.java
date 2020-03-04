package fields;

/**
 * Xuefeng
 *
 */

public class Field<T> {

  private String label;
  private T value;
  private boolean required;
  private Validator<T> validator;

  public Field(String label, boolean required, Validator<T> validator) {
    this.label = label;
    this.value = null;
    this.required = required;
    this.validator = validator;
  }

  public void updateValue(T value) {
    if (validator.isValid(value)) {
      this.value = value;
    }
    throw new IllegalArgumentException();
  }

  public boolean isFilled() {
    return !this.required || this.value != null;
  }

  public String getLabel() {
    return label;
  }

  public T getValue() {
    return value;
  }

  public boolean isRequired() {
    return required;
  }

  public Validator<T> getValidator() {
    return validator;
  }
}
