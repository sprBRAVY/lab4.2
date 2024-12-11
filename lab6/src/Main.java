import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String brand;
    private String carClass;
    private double weight;
    private Driver driver;
    private Engine engine;

    public Car(String brand, String carClass, double weight, Driver driver, Engine engine) {
        this.brand = brand;
        this.carClass = carClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarClass() {
        return carClass;
    }

    public double getWeight() {
        return weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public Engine getEngine() {
        return engine;
    }
}

class Driver {
    private String fullName;
    private int experience;

    public Driver(String fullName, int experience) {
        this.fullName = fullName;
        this.experience = experience;
    }

    public String getFullName() {
        return fullName;
    }

    public int getExperience() {
        return experience;
    }
}

class Engine {
    private double power;
    private String manufacturer;

    public Engine(double power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    public double getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

public class Main{
    private List<Car> cars = new ArrayList<>();
    private DefaultTableModel tableModel;

    public Main() {
        JFrame frame = new JFrame("Управление автомобилями");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Таблица для отображения автомобилей
        String[] columnNames = {"Марка", "Класс", "Вес", "Водитель", "Двигатель"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Добавить автомобиль");
        JButton deleteButton = new JButton("Удалить автомобиль");
        JButton updateButton = new JButton("Обновить автомобиль");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Действия кнопок
        addButton.addActionListener(e -> addCar());
        deleteButton.addActionListener(e -> deleteCar(carTable));
        updateButton.addActionListener(e -> updateCar(carTable));

        frame.setVisible(true);
    }

    private void addCar() {
        JTextField brandField = new JTextField();
        JTextField classField = new JTextField();
        JTextField weightField = new JTextField();
        JTextField driverField = new JTextField();
        JTextField engineField = new JTextField();

        Object[] fields = {
                "Марка:", brandField,
                "Класс:", classField,
                "Вес:", weightField,
                "Водитель:", driverField,
                "Двигатель:", engineField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Добавить автомобиль", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                String brand = brandField.getText();
                String carClass = classField.getText();
                double weight = Double.parseDouble(weightField.getText());
                String driverName = driverField.getText();
                String engineDetails = engineField.getText();

                Driver driver = new Driver(driverName, 0); // Упрощённые данные водителя
                Engine engine = new Engine(0, engineDetails); // Упрощённые данные двигателя
                Car car = new Car(brand, carClass, weight, driver, engine);

                cars.add(car);
                tableModel.addRow(new Object[]{brand, carClass, weight, driverName, engineDetails});
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Некорректный ввод!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteCar(JTable carTable) {
        int selectedRow = carTable.getSelectedRow();
        if (selectedRow >= 0) {
            cars.remove(selectedRow);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Выберите автомобиль для удаления.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCar(JTable carTable) {
        int selectedRow = carTable.getSelectedRow();
        if (selectedRow >= 0) {
            Car car = cars.get(selectedRow);

            JTextField brandField = new JTextField(car.getBrand());
            JTextField classField = new JTextField(car.getCarClass());
            JTextField weightField = new JTextField(String.valueOf(car.getWeight()));
            JTextField driverField = new JTextField(car.getDriver().getFullName());
            JTextField engineField = new JTextField(car.getEngine().getManufacturer());

            Object[] fields = {
                    "Марка:", brandField,
                    "Класс:", classField,
                    "Вес:", weightField,
                    "Водитель:", driverField,
                    "Двигатель:", engineField
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Обновить автомобиль", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    car = new Car(
                            brandField.getText(),
                            classField.getText(),
                            Double.parseDouble(weightField.getText()),
                            new Driver(driverField.getText(), 0),
                            new Engine(0, engineField.getText())
                    );

                    cars.set(selectedRow, car);

                    tableModel.setValueAt(car.getBrand(), selectedRow, 0);
                    tableModel.setValueAt(car.getCarClass(), selectedRow, 1);
                    tableModel.setValueAt(car.getWeight(), selectedRow, 2);
                    tableModel.setValueAt(car.getDriver().getFullName(), selectedRow, 3);
                    tableModel.setValueAt(car.getEngine().getManufacturer(), selectedRow, 4);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Некорректный ввод!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите автомобиль для обновления.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
