import java.util.ArrayList;
import java.util.List;

/**
 * Главный класс для запуска приложения.
 */
public class Main {
    public static void main(String[] args) {
        // Создаем водителей
        Driver driver1 = new Driver("Литошик Максим", 6);
        Driver driver2 = new Driver("Алексей Николайчик", 8);
        Driver driver3 = new Driver("Саня Фаер", 2);

        // Создаем двигатели
        Engine engine1 = new Engine(150, "ВАЗ");
        Engine engine2 = new Engine(200, "Москвич");

        // Создаем автомобили
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ВАЗ 2101", "Легковой", 850, driver1, engine1));
        cars.add(new Car("Москвич 408", "Легковой", 950, driver2, engine2));
        cars.add(new Car("Жигули", "Легковой", 900, driver3, engine1));

        // Вывод водителей со стажем более 5 лет
        VehicleMethods.printExperiencedDrivers(cars);

        // Вывод автомобилей советского производства
        VehicleMethods.printSovietCars(cars);
    }
}