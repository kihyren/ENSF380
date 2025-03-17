package edu.ucalgary.oop;
import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private List<SmartDevice<?>> devices = new ArrayList<>();
    private boolean isBuilt = false;

    // Add a device (allowed before build)
    public SmartHome addDevice(SmartDevice<?> device) {
        // TODO: Implement addDevice functionality
        if (!isBuilt) {
            devices.add(device);
        } else {
            throw new IllegalStateException("Cannot add devices after building the SmartHome.");
        }
        return this;
    }

    // Build the SmartHome (finalizes the setup)
    public SmartHome build() {
        isBuilt = true;
        return this;
    }

    // Set device state (only allowed after build)
    public <T> void setDeviceState(SmartDevice<T> device, T state) {
        // TODO: Implement setDeviceState functionality
        if (!isBuilt){
            throw new IllegalStateException("Cannot set device state before building the SmartHome.");
        }

        device.setState(state);
    }

    // Send overarching messages (only allowed after build)
    public void sendMessage(String message) {
        // TODO: Implement sendMessage functionality
        if (!isBuilt) {
            throw new IllegalStateException("Cannot send message before building the SmartHome.");
        }
        System.out.println("SmartHome: Sending message - " + message);
        for (SmartDevice<?> device : devices) {
            device.update(message);
        }
    }
}
