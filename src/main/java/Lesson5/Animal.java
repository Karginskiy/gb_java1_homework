package Lesson5;

abstract class Animal {

    private String name;
    private boolean canSwim;
    private double length;

    Animal(String name, boolean canSwim, double length) {
        this.name = name;
        this.canSwim = canSwim;
        this.length = length;
    }

    // Overriding representation
    abstract protected void run();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Representation of inheritance
    void swim() {
        if (this.isCanSwim()) {
            System.out.println(this.name + " swimming!");
        } else {
            System.out.println(this.name + " can't swim. Teach him! :)");
        }
    }

    // Representation of inheritance
    void leap() {
        System.out.printf(this.name + " jumps on %.2f\n", this.getLength() * 1.66);
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
