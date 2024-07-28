import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter robot head:");
            String head = scanner.nextLine();
            System.out.println("Enter robot body:");
            String body = scanner.nextLine();
            System.out.println("Enter robot legs:");
            String legs = scanner.nextLine();

            Robot robot = new Robot.Builder()
                    .head(head)
                    .body(body)
                    .legs(legs)
                    .build();

            System.out.println(robot);
        } catch (Exception e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
        }
    }
}
