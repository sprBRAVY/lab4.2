import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    private JTextArea arrayInputField;
    private JTextField targetField;
    private JLabel resultLabel;

    public Main() {
        JFrame frame = new JFrame("Работа с массивом");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Поле для ввода массива
        arrayInputField = new JTextArea(5, 40);
        arrayInputField.setBorder(BorderFactory.createTitledBorder("Введите элементы массива через пробел (отсортированные):"));

        // Поле для ввода целевого значения
        targetField = new JTextField();
        targetField.setBorder(BorderFactory.createTitledBorder("Введите элемент для поиска:"));

        // Кнопки
        JButton checkSortButton = new JButton("Проверить сортировку");
        JButton searchButton = new JButton("Выполнить бинарный поиск");

        // Результат
        resultLabel = new JLabel("Результат будет отображён здесь");
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Добавляем элементы в панель
        panel.add(arrayInputField);
        panel.add(targetField);
        panel.add(checkSortButton);
        panel.add(searchButton);
        panel.add(resultLabel);

        frame.add(panel);

        // Действия кнопок
        checkSortButton.addActionListener(e -> checkSort());
        searchButton.addActionListener(e -> performSearch());

        frame.setVisible(true);
    }

    private void checkSort() {
        try {
            int[] array = parseArray(arrayInputField.getText());

            if (ArrayUtils.isSorted(array)) {
                resultLabel.setText("Массив отсортирован.");
            } else {
                resultLabel.setText("Массив не отсортирован.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Ошибка: некорректный ввод массива.");
        }
    }

    private void performSearch() {
        try {
            int[] array = parseArray(arrayInputField.getText());

            if (!ArrayUtils.isSorted(array)) {
                resultLabel.setText("Ошибка: массив не отсортирован.");
                return;
            }

            int target = Integer.parseInt(targetField.getText());
            BinarySearch binarySearch = new BinarySearch();
            int result = binarySearch.binarySearch(array, target);

            if (result == -1) {
                resultLabel.setText("Элемент не найден.");
            } else {
                resultLabel.setText("Элемент найден на индексе: " + result);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Ошибка: некорректный ввод массива или элемента.");
        }
    }

    private int[] parseArray(String text) throws NumberFormatException {
        return Arrays.stream(text.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

class ArrayUtils {
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}

class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
