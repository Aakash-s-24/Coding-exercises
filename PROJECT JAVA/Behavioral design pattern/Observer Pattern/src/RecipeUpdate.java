import java.util.logging.Level;
import java.util.logging.Logger;

public class RecipeUpdate {
    private static final Logger logger = Logger.getLogger(RecipeUpdate.class.getName());

    public static void main(String[] args) {
        try {
            RecipeBlog blog = new RecipeBlog();

            // Create subscribers
            Subscriber subscriber1 = new Subscriber("Alice");
            Subscriber subscriber2 = new Subscriber("Bob");

            // Register subscribers
            blog.registerObserver(subscriber1);
            blog.registerObserver(subscriber2);

            // Post new recipes
            blog.postNewRecipe("Spaghetti Carbonara");
            blog.postNewRecipe("Chicken Alfredo");

            // Unregister a subscriber
            blog.removeObserver(subscriber2);

            // Post another recipe
            blog.postNewRecipe("Beef Wellington");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred", e);
            System.out.println("Error: " + e.getMessage());
        }
    }
}
