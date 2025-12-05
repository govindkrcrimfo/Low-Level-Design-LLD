package designPattern.behavioralDesignPattern;

// Command interface - every command must implement execute()
interface Command {
    void execute();
}

// Receiver class - this is the actual object performing the action
class Light {
    void turnOn() {
        System.out.println("Light is turned ON");
    }

    void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

// Concrete Command to turn ON the light
class TurnOnCommand implements Command {
    private Light light; // important: store receiver inside command

    TurnOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn(); // important: command calls receiver's method
    }
}

// Concrete Command to turn OFF the light
class TurnOffCommand implements Command {
    private Light light; // important: same receiver

    TurnOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff(); // important: command triggers receiver
    }
}

// Invoker class - doesn't know the logic, just runs the command
class Remote {
    private Command command; // important: remote stores a command

    void setCommand(Command command) {
        this.command = command; // important: inject a command
    }

    void pressButton() {
        command.execute(); // important: button executes the command
    }
}

public class CommandPattern {
    public static void main(String[] args) {

        Light light = new Light(); // receiver

        Command turnOn = new TurnOnCommand(light); // create command object
        Command turnOff = new TurnOffCommand(light); // create command object

        Remote remote = new Remote(); // invoker

        remote.setCommand(turnOn); // important: set command
        remote.pressButton(); // execute -> Light ON

        remote.setCommand(turnOff); // change command
        remote.pressButton(); // execute -> Light OFF
    }
}
