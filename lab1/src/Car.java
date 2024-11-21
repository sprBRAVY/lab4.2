/**
 * Класс, представляющий автомобиль.
 */
public class Car {
    private String brand;      // Марка автомобиля
    private String carClass;   // Класс автомобиля
    private double weight;     // Вес автомобиля
    private Driver driver;     // Водитель
    private Engine engine;     // Двигатель

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