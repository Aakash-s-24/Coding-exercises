import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter creature type (dragon/unicorn):");
            String type = scanner.nextLine();

            FantasyCreature creature = CreatureFactory.createCreature(type);
            creature.describe();
        } catch (Exception e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
        }
    }
}

