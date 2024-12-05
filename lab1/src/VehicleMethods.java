import java.util.List;

/**
 * Класс, содержащий методы для работы с автомобилями.
 */
public class VehicleMethods {

    /**
     * Выводит водителей со стажем более 5 лет.
     *
     * @param cars список автомобилей
     */
    public static void printExperiencedDrivers(List<Car> cars) {
        System.out.println("Водители со стажем более 5 лет:");

        // Используем Stream API для упрощения кода и повышения читаемости
        cars.stream()
            .filter(car -> car.getDriver().getExperience() > 5) // Фильтруем автомобили по стажу водителя
            .map(car -> car.getDriver().getFullName())         // Преобразуем в имена водителей
            .forEach(System.out::println);                    // Печатаем имена
    }

    /**
     * Выводит автомобили советского производства.
     *
     * @param cars список автомобилей
     */
    public static void printSovietCars(List<Car> cars) {
        System.out.println("\nАвтомобили советского производства:");

        // Используем Stream API для упрощения и лаконичности
        cars.stream()
            .filter(car -> car.getBrand().contains("ВАЗ") || car.getBrand().contains("Москвич")) // Фильтруем марки
            .map(Car::getBrand)                                                                // Преобразуем в названия брендов
            .forEach(System.out::println);                                                    // Печатаем бренды
    }
}
