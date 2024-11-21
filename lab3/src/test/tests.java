// CombinedTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class tests {

    // Тесты для BinarySearch
    @Test
    public void testBinarySearchElementFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {2, 3, 4, 10, 40};
        int target = 10;
        int result = binarySearch.binarySearch(array, target);
        assertEquals(3, result); // Индекс элемента 10
    }

    @Test
    public void testBinarySearchElementNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {2, 3, 4, 10, 40};
        int target = 5;
        int result = binarySearch.binarySearch(array, target);
        assertEquals(-1, result); // Элемент не найден
    }

    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {};
        int target = 1;
        int result = binarySearch.binarySearch(array, target);
        assertEquals(-1, result); // Элемент не найден
    }

    // Тесты для ArrayUtils
    @Test
    public void testArrayUtilsSortedArray() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        assertTrue(ArrayUtils.isSorted(sortedArray)); // Массив отсортирован
    }

    @Test
    public void testArrayUtilsUnsortedArray() {
        int[] unsortedArray = {5, 3, 4, 1, 2};
        assertFalse(ArrayUtils.isSorted(unsortedArray)); // Массив не отсортирован
    }

    @Test
    public void testArrayUtilsSingleElementArray() {
        int[] singleElementArray = {1};
        assertTrue(ArrayUtils.isSorted(singleElementArray)); // Массив отсортирован
    }

    @Test
    public void testArrayUtilsEmptyArray() {
        int[] emptyArray = {};
        assertTrue(ArrayUtils.isSorted(emptyArray)); // Пустой массив считается отсортированным
    }
}