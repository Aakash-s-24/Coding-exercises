import java.util.logging.Logger;

public class SmartLight {
    private static final Logger LOGGER = Logger.getLogger(SmartLight.class.getName());

    public void turnOn() {
        LOGGER.info("The smart light is now ON.");
    }

    public void turnOff() {
        LOGGER.info("The smart light is now OFF.");
    }
}

