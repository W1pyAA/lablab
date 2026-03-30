package Practice_1;
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void calculateArea() {
        System.out.println("Площа квадрата: " + (side * side));
    }
}