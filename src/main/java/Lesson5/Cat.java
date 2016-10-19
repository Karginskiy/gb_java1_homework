package Lesson5;

class Cat extends Animal {

    private Speed speed;

    Cat(String name, boolean canSwim, double height, Speed speed) {
        super(name, canSwim, height);
        this.speed = speed;
        this.jumphigh = height * 6;
    }

    @Override
    protected void run() {
        System.out.println(this.getName() + " runs " + speed);
    }

}
