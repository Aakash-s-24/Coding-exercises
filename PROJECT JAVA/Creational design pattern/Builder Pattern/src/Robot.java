import java.util.logging.Level;
import java.util.logging.Logger;

public class Robot {
    private String head;
    private String body;
    private String legs;
    private static final Logger LOGGER = Logger.getLogger(Robot.class.getName());

    private Robot(Builder builder) {
        this.head = builder.head;
        this.body = builder.body;
        this.legs = builder.legs;
    }

    public static class Builder {
        private String head;
        private String body;
        private String legs;

        public Builder head(String head) {
            this.head = head;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder legs(String legs) {
            this.legs = legs;
            return this;
        }

        public Robot build() {
            return new Robot(this);
        }
    }

    @Override
    public String toString() {
        return "Robot [Head=" + head + ", Body=" + body + ", Legs=" + legs + "]";
    }
}
