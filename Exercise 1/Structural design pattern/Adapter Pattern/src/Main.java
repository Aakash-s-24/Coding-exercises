import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            // Create an instance of 110V appliance
            Appliance appliance = new Appliance110V();

            // Create an adapter to use 110V appliance with 220V power supply
            Voltage220V voltage220V = new Voltage220V() {
                @Override
                public void supply220V() {
                    System.out.println("Supplying 220V power.");
                }
            };

            Appliance adapter = new VoltageAdapter(voltage220V);
            adapter.plugIn();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred", e);
            System.out.println("Error: " + e.getMessage());
        }
    }
}
