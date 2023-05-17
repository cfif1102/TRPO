import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Hotdog> hotdogs = new ArrayList<Hotdog>();
        HotDogMaker maker = new HotDogMaker();
        hotdogs.add(maker.MakeBerlinka(1));
        hotdogs.add(maker.MakeMasterDog(2));
        hotdogs.add(maker.MakeMasterDog(3));
        CalcTotalPrice(hotdogs);
        CalcHotdogSpecies(hotdogs);

    }

    public static double CalcTotalPrice(ArrayList<Hotdog> hotdogs) {
        double price = 0;

        for (Hotdog hotdog : hotdogs) {
            price += hotdog.price();
        }

        return price;
    }

    public static double Average(ArrayList<Hotdog> hotdogs) {
        return CalcTotalPrice(hotdogs) / hotdogs.size();
    }


    public static void CalcHotdogSpecies(ArrayList<Hotdog> hotdogs) {
        int masterAmount = 0, hunterAmount = 0, berlinkaAmount = 0;

        for (Hotdog hotdog : hotdogs) {
            if (hotdog.getClass() == MasterDog.class) {
                masterAmount++;
            }
            if (hotdog.getClass() == Berlinka.class) {
                berlinkaAmount++;
            }
            if (hotdog.getClass() == HunterDog.class) {
                hunterAmount++;
            }
        }

        System.out.println("MasterDog: " + masterAmount);
        System.out.println("Berlinka: " + berlinkaAmount);
        System.out.println("HunterDog: " + hunterAmount);
        System.out.println("TotalPrice: " + CalcTotalPrice(hotdogs));
        System.out.println("AveragePrice: " + Average(hotdogs));
    }
}