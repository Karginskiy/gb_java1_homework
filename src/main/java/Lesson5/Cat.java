package Lesson5;

public class Cat extends Animal {

    private Speed speed;

    Cat(String name, boolean canSwim, double length, Speed speed) {
        super(name, canSwim, length);
        this.speed = speed;
    }

    @Override
    protected void run() {
        System.out.println("Cat runs " + speed);
    }

}
