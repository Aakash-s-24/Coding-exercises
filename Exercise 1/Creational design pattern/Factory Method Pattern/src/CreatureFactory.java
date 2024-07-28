import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatureFactory {
    private static final Logger LOGGER = Logger.getLogger(CreatureFactory.class.getName());

    public static FantasyCreature createCreature(String type) {
        try {
            switch (type.toLowerCase()) {
                case "dragon":
                    return new Dragon();
                case "unicorn":
                    return new Unicorn();
                default:
                    throw new IllegalArgumentException("Unknown creature type: " + type);
            }
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Error creating creature", e);
            throw e;
        }
    }
}
