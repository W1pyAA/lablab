package Practice_1;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. ІНКАПСУЛЯЦІЯ ===");
        // Завдання 1: Book
        Book book = new Book("Кобзар", "Тарас Шевченко", 1840);
        book.printInfo();
        book.setYear(1841); // Перевірка сеттера
        System.out.println("Оновлений рік видання: " + book.getYear());

        // Завдання 2: Account
        Account account = new Account("UA1234567890", 1000.0);
        account.checkBalance();
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(5000.0); // Спроба зняти більше, ніж є

        System.out.println("\n=== 2. НАСЛІДУВАННЯ ===");
        // Завдання 1: Vehicle та Motorcycle
        Vehicle car = new Vehicle("Toyota", "Camry");
        car.displayInfo();

        Motorcycle moto = new Motorcycle("Yamaha", "MT-07", 689);
        moto.displayInfo(); // Викличе перевизначений метод

        // Завдання 2: Employee та Manager
        Employee emp = new Employee("Іван", "Junior Розробник");
        emp.displayInfo();

        Manager mgr = new Manager("Олена", "Project Manager", 5);
        mgr.displayInfo(); // Викличе перевизначений метод з розміром команди

        System.out.println("\n=== 3. ПОЛІМОРФІЗМ ===");
        // Завдання 1: Shape, Triangle, Square
        Shape myTriangle = new Triangle(10.0, 5.0);
        Shape mySquare = new Square(4.0);
        myTriangle.calculateArea();
        mySquare.calculateArea();

        // Завдання 2: Notifications
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        email.send();
        sms.send();

        System.out.println("\n=== 4. АБСТРАКТНІ КЛАСИ ТА ІНТЕРФЕЙСИ ===");
        // Завдання 1: Appliance
        Appliance washingMachine = new WashingMachine();
        Appliance microwave = new Microwave();
        washingMachine.turnOn();
        microwave.turnOn();

        // Завдання 2: Playable
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }
}