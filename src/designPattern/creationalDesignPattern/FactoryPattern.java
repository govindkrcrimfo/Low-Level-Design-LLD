package designPattern.creationalDesignPattern;
/*
 *  Factory Desing pattern
 */

// This class responsible for creating the object of vehicles
class Vehicle {
    public Vehicle getVehicle(String type) {
        if (type.equals("car")) {
            return new Car();
        } else if (type.equals("truck")) {
            return new Truck();
        } else {
            throw new ExceptionInInitializerError("object type not matched");
        }
    }
}

class Car extends Vehicle {
    // Car entities
}

class Truck extends Vehicle {
    // Truck enities
}

public class FactoryPattern {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.getVehicle("car");
        v.getVehicle("truck");
        /*
         * here are not internally know how car or truck object is creating ,
         * we just calling to create car or truck object
         * By this way we creating object without exposing the logic to client ( Desing
         * factory pattern)
         */
    }

}
