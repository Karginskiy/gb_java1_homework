package Lesson5;

abstract class AbstractAnimal {

    private String name;
    private Speed speed;
    private boolean canSwim;
    private double length;

    abstract protected void run();
    abstract protected void swim();
    abstract protected void leap();

    AbstractAnimal(String name, Speed speed, boolean canSwim, double length) {
        this.name = name;
        this.speed = speed;
        this.canSwim = canSwim;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public double getLength() {
        return length;
    }

    public Speed getSpeed() {
        return speed;
    }

    enum Speed {
        FAST, MIDDLING, SLOW;
    }

}
