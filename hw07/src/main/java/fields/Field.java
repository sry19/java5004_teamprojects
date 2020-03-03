package fields;

/**
 * Xuefeng
 *
 * @param <S>
 * @param <T>
 */

public class Field<S, T extends Validator<S>> {

  private S input;

  public Field(S value) {
    this.input = null;
  }

  public void updateValue(S input) {
    this.input = input;
  }
}
