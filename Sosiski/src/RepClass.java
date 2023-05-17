//package Hotdog;
import java.util.ArrayList;
import java.util.List;
public class RepClass {
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