// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] sortedArray = new int[size];

        // Ввод элементов массива
        System.out.println("Введите " + size + " отсортированных элементов массива:");
        for (int i = 0; i < size; i++) {
            sortedArray[i] = scanner.nextInt();
        }

        // Проверка, отсортирован ли массив
        if (!ArrayUtils.isSorted(sortedArray)) {
            System.out.println("Ошибка: массив не отсортирован.");
            scanner.close();
            return; // Завершение программы
        }

        // Ввод элемента для поиска
        System.out.print("Введите элемент для поиска: ");
        int target = scanner.nextInt();

        // Создание экземпляра BinarySearch и поиск элемента
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearch(sortedArray, target);

        if (result == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println("Элемент найден на индексе: " + result);
        }

        scanner.close();
    }
}