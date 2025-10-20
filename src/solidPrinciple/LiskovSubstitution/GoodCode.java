package solidPrinciple.LiskovSubstitution;

/*
 * Liskov substitution principle (L)
 * -> Object of parent class should be replacable with Objec of child class ,
 *    without altering any existing functionality 
 * Good code example 
 * -> here we can replace NoEnigneVechile object (parent ) to Bicycle object (child)
 *    also  we can replace EnginVehicle object (parent ) to Car object (child)
 *
 */
class Vehicle {
    void move() {
        System.out.println("logic to move Vechile");
    }
}

class NoEnigneVechile extends Vehicle {
    void startPaddle() {
        System.out.println("No Engine Vehicle start logic ");
    }
}

class EngineVehicle extends Vehicle {
    void startEngine() {
        System.out.println("Engine start logic ");
    }
}

class Bicycle extends NoEnigneVechile {
    @Override
    void startPaddle() {
        System.out.println("logic to start paddle for BicCyle ");
    }
}

class Car extends EngineVehicle {
    @Override
    void startEngine() {
        System.out.println("logic to start engine for Car ");
    }
}

public class GoodCode {
    public static void main(String[] args) {
        // NoEnigneVechile v = new NoEnigneVechile();
        NoEnigneVechile v = new Bicycle(); // oject replaced (parent to child)
        v.startPaddle();

    }
}
