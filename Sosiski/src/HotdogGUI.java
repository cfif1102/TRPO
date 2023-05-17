import java.util.ArrayList;
import java.util.List;
public class Repository {
    private List<Hotdog> hotdogs = new ArrayList<>();

    public void addHotdog(Hotdog hotdog) {
        hotdogs.add(hotdog);
    }

    public void removeHotdog(Hotdog hotdog) {
        hotdogs.remove(hotdog);
    }

    public Hotdog findHotdog(int id) {
        for (Hotdog dog : hotdogs) {
            if (id == dog.getId())
                return dog;
        }
        return null;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void updatePizza(Pizza oldPizza, Pizza newPizza) {
        int index = pizzas.indexOf(oldPizza);
        if (index >= 0) {
            pizzas.set(index, newPizza);
        }
    }

}
