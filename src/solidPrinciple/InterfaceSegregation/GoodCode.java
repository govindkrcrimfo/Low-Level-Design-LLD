package solidPrinciple.InterfaceSegregation;

/*
 * Interface Segregation (I) of SOLID principle
 * -> seperate intefaces for seperate functionality 
 * -> not forced client to implement unwanted methods 
 * 
 * Good  code example 
 * -> Two seperate interfaces 
 *    1. Drivable for Drive ( Drivable object can implements it eg, Car,Scooty , bus )
 *    2. Flyable for fly. (Flyable objce can implements it eg, AeroPlane , Rokcket)
 * 
 * So here , not forced to implements unnecessary method 
 */
interface Drivable {
    void Drive();
}

interface Flyable {
    void fly();
}

class Car1 implements Drivable {

    @Override
    public void Drive() {
        System.out.println("Logic to drive the car");
    }
}

class AeroPlane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Logic to fly the Aeroplane");
    }
}

public class GoodCode {

}
