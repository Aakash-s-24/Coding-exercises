import java.util.logging.Logger;

public class PreLaunchState implements RocketState {
    private static final Logger LOGGER = Logger.getLogger(PreLaunchState.class.getName());

    @Override
    public void startChecks(RocketLaunchSimulator rocket) {
        if ("Pre-Launch".equals(rocket.getStage())) {
            System.out.println("All systems are 'Go' for launch.");
            rocket.setStage("Ready for Launch");
        } else {
            System.out.println("Checks already completed or invalid state.");
        }
    }

    @Override
    public void launch(RocketLaunchSimulator rocket) {
        System.out.println("Pre-Launch checks not completed.");
    }

    @Override
    public void fastForward(RocketLaunchSimulator rocket, int seconds) {
        System.out.println("Cannot fast forward in pre-launch state.");
    }
}
