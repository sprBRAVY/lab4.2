public class Engine {
    private double power;         // Мощность двигателя
    private String manufacturer; // Производитель двигателя

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
