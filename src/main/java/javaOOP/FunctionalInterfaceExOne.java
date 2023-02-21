package javaOOP;

@FunctionalInterface
interface Animal {
    public void makeSound(String sound);
}

public class FunctionalInterfaceExOne {

    public static void main(String[] args) {

        Animal animal = (sound) -> {
            System.out.println("Ducks go " + sound);
        };

        animal.makeSound("Quack quack...");
    }
}
