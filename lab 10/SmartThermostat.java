// TODO: package, any includes, class declaration, constructor
//       and the methods performAction and update.
package edu.ucalgary.oop;

public class SmartThermostat extends SmartDevice<Integer> implements Observer{

    public SmartThermostat(){
        setState(20);
    }

    public void adjustTemperature(int desiredTemp) {
        int currentTemp = getState();
        int difference = desiredTemp - currentTemp;

        if (difference > 0) {
            System.out.println("Increasing temperature by " + difference + "°C.");
        } else if (difference < 0) {
            System.out.println("Decreasing temperature by " + Math.abs(difference) + "°C.");
        } else {
            System.out.println("Temperature is already at the desired level.");
        }

        setState(desiredTemp);
    }

    public void update(String message){
        String out = "Thermostat: " + state + "°C";
        performAction(out);
    } 

    public void performAction(String message){
        System.out.println(message);
    }
}
