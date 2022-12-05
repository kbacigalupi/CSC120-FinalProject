import java.util.ArrayList;

public class Location {
    String name;
    private ArrayList<Item> items;
    String riddle;
    String answer;
    String description;

    public Location(String name, String description) {
        this.items = new ArrayList<Item>();
        this.name = name;
        this.description = description;
    }

    public Location(String riddle, String answer, String name, String description) {
        this.items = new ArrayList<Item>();
        this.riddle = riddle;
        this.answer = answer;
        this.name = name;
        this.description = description;
    }

    public void dropItem(Item item) {
        this.items.add(item);
    }

    public void remove (Item item) {
        this.items.remove(item);
    }

    /* */
    public boolean hasObject(Item wantTake) {
        if (items.contains(wantTake)) {
            return true;
        }
        return false;
    }

    public void addItem(Item toAdd) {
        this.items.add(toAdd); 
    }

    public static void main(String[] args) {
        
    }
}