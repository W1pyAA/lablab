package Practice_1;
interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Грає гітара: брень-брень!");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Грає піаніно: до-ре-мі!");
    }
}