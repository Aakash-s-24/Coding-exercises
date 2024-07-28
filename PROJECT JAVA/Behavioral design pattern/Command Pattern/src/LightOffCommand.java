public class LightOffCommand implements Command {
    private SmartLight light;

    public LightOffCommand(SmartLight light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

