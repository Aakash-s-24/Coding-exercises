import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        SmartLight light = new SmartLight();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter command (on/off or exit):");
                String input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "on":
                        remote.setCommand(lightOn);
                        remote.pressButton();
                        break;
                    case "off":
                        remote.setCommand(lightOff);
                        remote.pressButton();
                        break;
                    case "exit":
                        return;
                    default:
                        LOGGER.warning("Invalid command. Try again.");
                }
            }
        } catch (Exception e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
        }
    }
}
