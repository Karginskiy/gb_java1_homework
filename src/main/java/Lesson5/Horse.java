package Lesson5;

class Horse extends Animal {

    private Speed speed;

    Horse(String name, boolean canSwim, double height, Speed speed) {
        super(name, canSwim, height);
        this.speed = speed;
        this.jumphigh = height * 1.1;
    }

    @Override
    protected void run() {
        System.out.println(this.getName() + " runs " + speed);
    }
}
