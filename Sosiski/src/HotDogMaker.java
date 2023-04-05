import java.util.ArrayList;

public class HotDogMaker
{
    private double cucumberPrice = 0.5;
    private double HunterSausagePrice = 2;
    private double BunPrice = 1;
    private double ChickenSausagePrice = 2;
    private double BeafSausagePrice = 2;
    private double MayoPrice = 0.5;
    private double MustardPrice = 0.5;
    public HunterDog MakeHunterDog()
    {
        ArrayList<Ingridient> ingridients = new ArrayList<>();

        ingridients.add(new Cucumbers(cucumberPrice));
        ingridients.add(new HunterSausage(HunterSausagePrice));
        ingridients.add(new Mayo(MayoPrice));
        ingridients.add(new Bun(BunPrice));

        HunterDog hunterDog = new HunterDog(ingridients);

        return hunterDog;
    }

    public Berlinka MakeBerlinka()
    {
        ArrayList<Ingridient> ingridients = new ArrayList<>();

        ingridients.add(new Bun(BunPrice));
        ingridients.add(new Cucumbers(cucumberPrice));
        ingridients.add(new Mustard(MustardPrice));
        ingridients.add(new ChickenSausage(ChickenSausagePrice));
        ingridients.add(new Mayo(MayoPrice));

        Berlinka berlinka = new Berlinka(ingridients);

        return berlinka;
    }

    public MasterDog MakeMasterDog()
    {
        ArrayList<Ingridient> ingridients = new ArrayList<>();

        ingridients.add(new Bun(BunPrice));
        ingridients.add(new Cucumbers(cucumberPrice));
        ingridients.add(new Mustard(MustardPrice));
        ingridients.add(new BeafSausage(BeafSausagePrice));
        ingridients.add(new Mayo(MayoPrice));

        MasterDog masterDog = new MasterDog(ingridients);

        return masterDog;
    }
}
