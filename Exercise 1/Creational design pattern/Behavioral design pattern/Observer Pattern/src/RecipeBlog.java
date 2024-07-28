import java.util.ArrayList;
import java.util.List;

public class RecipeBlog implements Subject {
    private List<Observer> observers;
    private String latestRecipe;

    public RecipeBlog() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestRecipe);
        }
    }

    public void postNewRecipe(String recipe) {
        this.latestRecipe = recipe;
        notifyObservers();
    }

    @Override
    public List<Observer> getObservers() {
        return new ArrayList<>(observers);
    }
}
