import java.util.ArrayList;
import java.util.List;

public class Repository(){
    private List<Hotdog> collection;


    public Repository(){
        this.collection = new ArrayList<>();
    }

    //метод который добавляет элемент в коллекцию
    public void addItem(Hotdog item){
        collection.add(item);
    }

    //метод который удаляет элемент в коллекции
    public void removeItem(Hotdog item){
        collection.remove(item);
    }

    //метод который ищет элемент в коллекции по индефикатору
    public void updateItem(Hotdog item){
        for(int i = 0; i < collection.size(); i++){
            if(collection.get(i).getId() == item.getId()){
                collection.set(i, item);
                break;
            }
        }
    }
}