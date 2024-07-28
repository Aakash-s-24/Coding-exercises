public class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Subscriber name cannot be null or empty");
        }
        this.name = name;
    }

    @Override
    public void update(String recipe) {
        System.out.println("Hey " + name + ", a new recipe has been posted: " + recipe);
    }
}
