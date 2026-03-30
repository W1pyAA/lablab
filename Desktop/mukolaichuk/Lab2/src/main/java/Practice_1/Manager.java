package Practice_1;
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, String position, int teamSize) {
        super(name, position);
        this.teamSize = teamSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Розмір команди: " + teamSize + " осіб");
    }
}