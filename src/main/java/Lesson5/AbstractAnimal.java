package Lesson5;

abstract class AbstractAnimal {

    private String name;
    private boolean canSwim;
    private double length;

    AbstractAnimal(String name, boolean canSwim, double length) {
        this.name = name;
        this.canSwim = canSwim;
        this.length = length;
    }

    abstract protected void run();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void swim() {
        if (this.isCanSwim()) {
            System.out.println(this.name + " swimming!");
        } else {
            System.out.println(this.name + " can't swim. Teach him! :)");
        }
    }

    protected void leap() {
        System.out.println(this.name + " jumps on " + this.getLength() * 1.66);
    }

    private boolean isCanSwim() {
        return canSwim;
    }

    private double getLength() {
        return length;
    }

    enum Speed {
        fast, middling, slow;
    }

}
