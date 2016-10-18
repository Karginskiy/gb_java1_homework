package Lesson5;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Shreddinger", false, 70, Animal.Speed.middling);
        animals[1] = new Dog("Dirt", true, 120, Animal.Speed.slow);
        animals[2] = new Horse("Speedy", true, 170, Animal.Speed.fast);

        for (Animal animal : animals) {
            animal.run();
            animal.swim();
            animal.leap();
        }

    }

}
