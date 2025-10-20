package solidPrinciple.LiskovSubstitution;

/*
 * Liskov substitution principle (L)
 * -> Object of parent class should be replacable with Objec of child class ,
 *    without altering any existing functionality 
 * Bad code example 
 * -> Bicycle  cannot startEngine (not matching with behaviour of Bicycle )
 */
class Vehicle1 {
    void startEngine() {
        System.out.println("Start Engine logic");
    }
}

class Car1 extends Vehicle1 {
    @Override
    void startEngine() {
        System.out.println("StartEngine logic for Car");
    }
}

/*
 * if we replace the objec of Vehilce1 (parent) to obje of Bicycle (child),
 * then Bicycle have not any enigne to start (not matching with behaviour of
 * Bicycle ).
 */
class Bicycle1 extends Vehicle1 {
    @Override
    void startEngine() {
        System.out.println("Bicycle have not any Egnine to Start");
    }
}

public class BadCode {
    public static void main(String[] args) {
        // Vehicle1 v=new Vehicle1();
        Vehicle1 v = new Bicycle1(); // object replaced
        v.startEngine();

    }

}
