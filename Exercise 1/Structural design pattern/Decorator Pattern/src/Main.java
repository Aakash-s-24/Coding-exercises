import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Pizza pizza = new BasicPizza();
            System.out.println("Available toppings: 1) Cheese 2) Pepperoni");
            System.out.print("Enter your choice (comma separated): ");
            String[] toppings = scanner.nextLine().split(",");

            for (String topping : toppings) {
                switch (topping.trim()) {
                    case "Cheese":
                        pizza = new CheeseTopping(pizza);
                        break;
                    case "Pepperoni":
                        pizza = new PepperoniTopping(pizza);
                        break;
                    default:
                        System.out.println("Warning: " + topping + " is not a valid topping.");
                        break;
                }
            }

            System.out.println("Description: " + pizza.getDescription());
            System.out.println("Cost: $" + String.format("%.2f", pizza.getCost()));
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "An error occurred", ex);
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
