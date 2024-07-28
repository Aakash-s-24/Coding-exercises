import java.util.logging.Logger;
import java.util.logging.Level;

public class LaunchState implements RocketState {
    private static final Logger LOGGER = Logger.getLogger(LaunchState.class.getName());

    @Override
    public void startChecks(RocketLaunchSimulator rocket) {
        System.out.println("Checks already completed or invalid state.");
    }

    @Override
    public void launch(RocketLaunchSimulator rocket) {
        while (rocket.getFuel() > 0 && rocket.getAltitude() < 100) {
            rocket.updateStatus();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "Thread interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
        if (rocket.getAltitude() >= 100) {
            System.out.println("Orbit achieved! Mission Successful.");
        } else {
            System.out.println("Mission Failed due to insufficient fuel.");
        }
    }

    @Override
    public void fastForward(RocketLaunchSimulator rocket, int seconds) {
        for (int i = 0; i < seconds; i++) {
            if (rocket.getFuel() > 0 && rocket.getAltitude() < 100) {
                rocket.updateStatus();
            } else {
                break;
            }
        }
        if (rocket.getAltitude() >= 100) {
            System.out.println("Orbit achieved! Mission Successful.");
        } else if (rocket.getFuel() <= 0) {
            System.out.println("Mission Failed due to insufficient fuel.");
        }
    }
}
