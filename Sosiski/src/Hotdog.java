import java.util.ArrayList;

public class Hotdog {
    private ArrayList<Ingridient> ingridients;

    public Hotdog(ArrayList<Ingridient> ingridients)
    {
        this.ingridients = ingridients;
    }
    public double price()
    {
        double price = 0;

        for (Ingridient ingridient : ingridients)
        {
            price += ingridient.GetPrice();
        }

        return price;
    }

    public void addIngridient(Ingridient ingridient)
    {
        ingridients.add(ingridient);
    }
}

