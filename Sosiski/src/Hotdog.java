import java.util.ArrayList;

public class Hotdog {
    private ArrayList<Ingridient> ingridients;
    int id;
    public Hotdog(ArrayList<Ingridient> ingridients,int id)
    {
        this.ingridients = ingridients;
        this.id = id;
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
    public int getId(){
        return id;
    }

    public void addIngridient(Ingridient ingridient)
    {
        ingridients.add(ingridient);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Hotdog)) {
            return false;
        }
        Hotdog hotdog = (Hotdog) obj;
        return ingridients == hotdog.ingridients &&
                id == hotdog.id;
    }
}

