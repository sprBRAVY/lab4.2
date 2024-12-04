import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для управления коллекцией автомобилей.
 */
public class CarRepository {
    private List<Car> cars; // Коллекция автомобилей

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    /**
     * Добавляет новый автомобиль в коллекцию.
     *
     * @param car автомобиль для добавления
     */
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Автомобиль добавлен: " + car.getBrand());
    }

    /**
     * Удаляет автомобиль из коллекции по объекту.
     *
     * @param car автомобиль для удаления
     */
    public void removeCar(Car car) {
        if (cars.remove(car)) {
            System.out.println("Автомобиль удален: " + car.getBrand());
        } else {
            System.out.println("Автомобиль не найден: " + car.getBrand());
        }
    }

    /**
     * Удаляет автомобиль из коллекции по индексу.
     *
     * @param index индекс автомобиля для удаления
     */
    public void removeCarByIndex(int index) {
        if (index >= 0 && index < cars.size()) {
            Car removedCar = cars.remove(index);
            System.out.println("Автомобиль удален: " + removedCar.getBrand());
        } else {
            System.out.println("Неверный индекс: " + index);
        }
    }

    /**
     * Обновляет информацию об автомобиле.
     *
     * @param index индекс автомобиля для обновления
     * @param newCar новый объект автомобиля
     */
    public void updateCar(int index, Car newCar) {
        if (index >= 0 && index < cars.size()) {
            cars.set(index, newCar);
            System.out.println("Автомобиль обновлен: " + newCar.getBrand());
        } else {
            System.out.println("Неверный индекс: " + index);
        }
    }

    /**
     * Возвращает список всех автомобилей.
     *
     * @return список автомобилей
     */
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }
}
