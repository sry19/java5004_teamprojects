package tools;

/**
 * An array helper class.
 */
public class ArrayHelper {

  /**
   * Combine two String arrays.
   *
   * @param array1 the first array.
   * @param array2 the second array.
   * @return the combined array.
   */
  public static String[] combineAll(String[] array1, String[] array2) {
    if (array1 == null) {
      return array2.clone();
    } else if (array2 == null) {
      return array1.clone();
    }

    String[] newArray = new String[array1.length + array2.length];
    System.arraycopy(array1, 0, newArray, 1, array1.length);
    System.arraycopy(array2, 0, newArray, array1.length, array2.length);
    return newArray;
  }
}
