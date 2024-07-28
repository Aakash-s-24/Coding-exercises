import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.logging.Level;

public class RocketLaunchSimulator {
    private static final Logger LOGGER = Logger.getLogger(RocketLaunchSimulator.class.getName());

    private String stage;
    private int fuel;
    private int altitude;
    private int speed;
    private int stageNumber;
    private RocketState state;
    private final ScheduledExecutorService executorService;
    private final Scanner scanner;

    public RocketLaunchSimulator() {
        this.stage = "Pre-Launch";
        this.fuel = 100;
        this.altitude = 0;
        this.speed = 0;
        this.stageNumber = 1;
        this.state = new PreLaunchState();
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.scanner = new Scanner(System.in);
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
        if ("Ready for Launch".equals(stage)) {
            this.state = new LaunchState();
        }
    }

    public int getFuel() {
        return fuel;
    }

    public int getAltitude() {
        return altitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void startChecks() {
        state.startChecks(this);
    }

    public void launch() {
        state.launch(this);
    }

    public void fastForward(int seconds) {
        state.fastForward(this, seconds);
    }

    public void updateStatus() {
        if (stageNumber == 1) {
            fuel -= 10;
            altitude += 10;
            speed += 1000;
            System.out.println(String.format("Stage: %d, Fuel: %d%%, Altitude: %d km, Speed: %d km/h", stageNumber, fuel, altitude, speed));
            if (fuel <= 50) {
                System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
                stageNumber = 2;
            }
        } else if (stageNumber == 2) {
            fuel -= 5;
            altitude += 20;
            speed += 2000;
            System.out.println(String.format("Stage: %d, Fuel: %d%%, Altitude: %d km, Speed: %d km/h", stageNumber, fuel, altitude, speed));
        }
    }

    public void start() {
        executorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Enter command (start_checks, launch, fast_forward X):");
                System.out.print("Enter command: ");
                if (scanner.hasNextLine()) {
                    String command = scanner.nextLine();

                    if ("start_checks".equals(command)) {
                        startChecks();
                    } else if ("launch".equals(command)) {
                        launch();
                    } else if (command.startsWith("fast_forward")) {
                        String[] parts = command.split(" ");
                        if (parts.length == 2) {
                            int seconds = Integer.parseInt(parts[1]);
                            fastForward(seconds);
                        } else {
                            System.out.println("Invalid command format for fast_forward. Use: fast_forward X");
                        }
                    } else {
                        System.out.println("Unknown command.");
                    }
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Exception occurred: ", e);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        RocketLaunchSimulator rocket = new RocketLaunchSimulator();
        rocket.start();
    }
}
