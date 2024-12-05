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

        // Создаем репозиторий автомобилей
        CarRepository carRepository = new CarRepository();

        // Добавляем автомобили в репозиторий
        carRepository.addCar(new Car("ВАЗ 2101", "Легковой", 850, driver1, engine1));
        carRepository.addCar(new Car("Москвич 408", "Легковой", 950, driver2, engine2));
        carRepository.addCar(new Car("Жигули", "Легковой", 900, driver3, engine1));

        // Получаем список автомобилей из репозитория List<Car> cars = carRepository.getAllCars();

        // Вывод водителей со стажем более 5 лет
        VehicleMethods.printExperiencedDrivers(cars);

        // Вывод автомобилей советского производства
        VehicleMethods.printSovietCars(cars);

        // Пример удаления автомобиля
        carRepository.removeCarByIndex(0);

        // Пример обновления автомобиля
        carRepository.updateCar(0, new Car("Лада Веста", "Легковой", 1200, driver3, engine2));

        // Проверяем текущий список автомобилей
        System.out.println("\nТекущий список автомобилей:");
        carRepository.getAllCars().forEach(car -> System.out.println(car.getBrand()));
    }
}
