import java.util.ArrayList;
import java.util.List;
public class RepClass {
    private List<Hotdog> hotdogs = new ArrayList<>();
    private HotDogMaker maker = new HotDogMaker();

    public void addHotdog(String hotdogtype) {
        Hotdog hotdog = null;

        switch(hotdogtype)
        {
            case "Берлинка":
                hotdog = maker.MakeBerlinka(hotdogs.size() + 1);

                break;
            case "Мастер":
                hotdog = maker.MakeMasterDog(hotdogs.size() + 1);

                break;
            case "Хантер":
                hotdog = maker.MakeHunterDog(hotdogs.size() + 1);

                break;
        }

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

    public List<Hotdog> getHotdogs() {
        return hotdogs;
    }

    public void updateHotdog(Hotdog dogBefore, Hotdog dogAfter) {
        int index = 0;
        for(Hotdog dog:hotdogs){
            index++;
            if(dog.equals(dogBefore)) {
                hotdogs.set(index, dogAfter);
            }
        }
    }

}