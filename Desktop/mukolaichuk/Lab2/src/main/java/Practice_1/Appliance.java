package Practice_1;
abstract class Appliance {
    public abstract void turnOn();
}

class WashingMachine extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Пральна машина увімкнена. Починається прання.");
    }
}

class Microwave extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Мікрохвильовка увімкнена. Розігрів їжі.");
    }
}