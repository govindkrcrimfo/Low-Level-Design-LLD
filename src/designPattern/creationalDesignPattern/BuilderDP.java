package designPattern.creationalDesignPattern;
/*
 * Builder desing pattern 
 *  when object has many attribute or optional field then we use Builder desing pattern 
 */

class Car1 {
    private String engine;
    private String color;
    private int wheel;
    private Boolean sunRoof;

    // private constructor -> accessible inside class only
    private Car1(CarBuilder builder) {
        this.engine = builder.engine;
        this.color = builder.color;
        this.wheel = builder.wheel;
        this.sunRoof = builder.sunRoof;
    }

    // we can add getter to fetch the fields

    /*
     * CarBuilder class
     * ->static class , have setter to set the value of Entity and build method to
     * call the car constructor
     */
    public static class CarBuilder {
        private String engine;
        private String color;
        private int wheel = 4; // we can give default value as well
        private boolean sunRoof;

        // setters to set the value of Entity
        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setWheel(int wheel) {
            this.wheel = wheel;
            return this;
        }

        public CarBuilder setSunRoof(boolean flag) {
            this.sunRoof = flag;
            return this;
        }

        // build method to calling the contructor of Car with required setted value in
        // Carbuilder
        public Car1 build() {
            return new Car1(this);
        }
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", color=" + color + ", wheel=" + wheel + ", sunRoof=" + sunRoof + "]";
    }

}

public class BuilderDP {
    public static void main(String[] args) {
        // Calling the CarBuilder class through Car
        Car1 c = new Car1.CarBuilder()
                .setEngine("SZ-500")
                .setColor("Blue")
                .setWheel(4)
                .setSunRoof(true)
                .build();
        System.out.println(c);

        // 2nd way
        Car1.CarBuilder c1 = new Car1.CarBuilder();
        Car1 car = c1.setEngine("YM-400")
                .setColor("Black")
                .setWheel(6)
                .setSunRoof(false)
                .build();
        System.out.println(car);

    }
}
