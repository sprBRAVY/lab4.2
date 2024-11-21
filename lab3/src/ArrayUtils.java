// ArrayUtils.java
public class ArrayUtils {
    // Метод для проверки, отсортирован ли массив
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false; // Массив не отсортирован
            }
        }
        return true; // Массив отсортирован
    }
}