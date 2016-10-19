package Lesson5;

abstract class Animal {

    private String name;
    private boolean canSwim;
    private double height;

    Animal(String name, boolean canSwim, double height) {
        this.name = name;
        this.canSwim = canSwim;
        this.height = height;
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
    void leap(double height) {

        if (this.height > height) {
            System.out.printf("%s has leaped the obstacle %.2f meters high\n", this.getName(), this.getHeight());
        }

    }

    private boolean isCanSwim() {
        return canSwim;
    }

    private double getHeight() {
        return height;
    }

    enum Speed {
        fast, middling, slow;
    }

}
