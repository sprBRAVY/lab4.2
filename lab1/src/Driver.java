public class Driver {
    private String fullName; // ФИО водителя
    private int experience;   // Стаж вождения

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
