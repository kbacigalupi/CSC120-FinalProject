import java.util.ArrayList;

public class Location {
    String name;
    boolean has_object;
    private ArrayList<item> items;
    String riddle;
    String answer;
    String description;

    public Location(String name, String description) {
        this.items = new ArrayList<item>();
        this.name = name;
        this.description = description;
    }

    public Location(String riddle, String answer, String name, String description) {
        this.items = new ArrayList<item>();
        this.riddle = riddle;
        this.answer = answer;
        this.name = name;
        this.description = description;
    }

    public void dropItem(item item) {
        this.items.add(item);
    }

    public static void main(String[] args) {
        
    }
}