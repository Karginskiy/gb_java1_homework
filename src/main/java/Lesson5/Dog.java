package Lesson5;

class Dog extends Animal {

    private Speed speed;

    Dog(String name, boolean canSwim, double length, Speed speed) {
        super(name, canSwim, length);
        this.speed = speed;
    }

    @Override
    protected void run() {
        System.out.println("Dog runs " + speed);
    }



}
