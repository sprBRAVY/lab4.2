import java.util.List;

/**
 * Класс, содержащий методы для работы с автомобилями.
 */
public class VehicleMethods {

    /**
     * Выводит водителей со стажем более 5 лет.
     */
    public static void printExperiencedDrivers(List<Car> cars) {
        System.out.println("Водители со стажем более 5 лет:");
        for (Car car : cars) {
            if (car.getDriver().getExperience() > 5) {
                System.out.println(car.getDriver().getFullName());
            }
        }
    }

    /**
     * Выводит автомобили советского производства.
     */
    public static void printSovietCars(List<Car> cars) {
        System.out.println("\nАвтомобили советского производства:");
        for (Car car : cars) {
            if (car.getBrand().contains("ВАЗ") || car.getBrand().contains("Москвич")) {
                System.out.println(car.getBrand());
            }
        }
    }
}