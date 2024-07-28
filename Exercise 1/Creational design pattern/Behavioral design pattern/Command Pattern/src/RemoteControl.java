import java.util.logging.Logger;

public class RemoteControl {
    private Command command;
    private static final Logger LOGGER = Logger.getLogger(RemoteControl.class.getName());

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            LOGGER.warning("No command set.");
        }
    }
}
