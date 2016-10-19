package Lesson5;

class Dog extends Animal {

    private Speed speed;

    Dog(String name, boolean canSwim, double height, Speed speed) {
        super(name, canSwim, height);
        this.speed = speed;
        this.jumphigh = height * 1.2;
    }

    @Override
    protected void run() {
        System.out.println(this.getName() + " runs " + speed);
    }



}
