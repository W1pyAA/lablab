package Practice_1;
class Notification {
    public void send() {
        System.out.println("Надсилання базового повідомлення...");
    }
}

class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Надсилання Email-повідомлення...");
    }
}

class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Надсилання SMS-повідомлення...");
    }
}