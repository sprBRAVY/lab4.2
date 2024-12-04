/**
 * Утилитарный класс для работы с массивами.
 */
public class ArrayUtils {

    // Конструктор по умолчанию
    public ArrayUtils() {
    }

    /**
     * Проверяет, отсортирован ли массив по возрастанию.
     *
     * @param array массив целых чисел
     * @return true, если массив отсортирован; иначе false
     */
    public static boolean isSorted(int[] array) {
        // Проходим по массиву, начиная с 1-го элемента
        for (int i = 1; i < array.length; ++i) {
            // Если текущий элемент меньше предыдущего, массив не отсортирован
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        // Если не найдено нарушений, массив отсортирован
        return true;
    }
}
