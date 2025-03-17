package edu.ucalgary.oop;

public class SmartLight extends SmartDevice<Boolean> {

    // Constructor: default state is OFF
    public SmartLight() {
        setState(false);
    }

    // A method to perform the default action (for demonstration)
    public void performAction() {
        System.out.println("SmartLight performing action. It is currently " + (getState() ? "ON" : "OFF") + ".");
    }

    @Override
    public void update(String message) {
        switch (message) {
            case "Sleep":
                setState(false);
                break;
            case "Vacation":
                setState(Math.random() < 0.5); // Randomly turn ON/OFF
                break;
            default:
                System.out.println("SmartLight: Unknown message - " + message);
        }
    }

    public void dim(int percentage) {
        if (getState()) {
            System.out.println("Dimming the light to " + percentage + "%.");
        } else {
            System.out.println("Cannot dim the light. It is currently OFF.");
        }
    }
}
