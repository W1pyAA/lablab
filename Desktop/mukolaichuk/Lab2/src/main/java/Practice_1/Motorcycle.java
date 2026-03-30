package Practice_1;
class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String make, String model, int engineCapacity) {
        super(make, model); // Виклик конструктора базового класу
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Об'єм двигуна: " + engineCapacity + " куб.см");
    }
}