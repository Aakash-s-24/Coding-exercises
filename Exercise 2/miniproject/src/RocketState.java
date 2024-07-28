import java.util.logging.Logger;

public interface RocketState {
    void startChecks(RocketLaunchSimulator rocket);
    void launch(RocketLaunchSimulator rocket);
    void fastForward(RocketLaunchSimulator rocket, int seconds);
}
