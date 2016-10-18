package Lesson5;

public class Horse extends Animal {

    private Speed speed;

    Horse(String name, boolean canSwim, double length, Speed speed) {
        super(name, canSwim, length);
        this.speed = speed;
    }

    @Override
    protected void run() {
        System.out.println("House runs " + speed);
    }
}
