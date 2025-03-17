// TODO: package, any includes, class declaration, constructor
//       and the methods performAction and update.
package edu.ucalgary.oop;

public class SmartLock extends SmartDevice<Boolean> implements Observer{

    public SmartLock(){
        setState(false);
    }

    public void autoLock(int delayInSeconds) {
        System.out.println("Auto-lock enabled. Door will lock in " + delayInSeconds + " seconds.");
        new Thread(() -> {
            try {
                Thread.sleep(delayInSeconds * 1000L);
                setState(true);
                System.out.println("Door auto-locked.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void performAction(String message){
        System.out.println(message);
    }

    public void update(String message){
        String out = "SmartLock is" + (state) ? "LOCKED. Securing the door." : "UNLOCKED. Door is open.";
        performAction(out);
    }
}
