package solidPrinciple.InterfaceSegregation;

/*
 * Interface Segregation (I) of SOLID principle
 * -> seperate intefaces for seperate functionality 
 * -> not forced client to implement unwanted methods 
 * 
 * Bad code example 
 * -> Car cannot fly but interface forces the car to implement the fly method
 */
interface Vehicle1 {
    void drive();

    void fly();
}

class Car implements Vehicle1 {
    @Override
    public void drive() {
        System.out.println("Drive the car ");
    }

    /*
     * car cannot fly but interface forces the car to implement the fly method
     * voilates the Interface segregation
     */
    @Override
    public void fly() {
        System.out.println("Car cannot fly");
    }

}

public class BadCode {
    public static void main(String[] args) {

    }

}
