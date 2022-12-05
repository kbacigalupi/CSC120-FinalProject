
import java.util.ArrayList;

public class Item {
    public static Item flour = new Item("flour", "This item will be a key ingredient in the dough");
    public static Item saw = new Item("saw", "You need this to traverse the portage");
    public static Item sugar = new Item("sugar", "This is a key ingredient to make your cinnamon rolls taste good");
    public static Item recipe = new Item("recipe", "This item is the FINAL item! You must have all the ingredients first.");
    public static Item pan = new Item("pan", "You need this to cook your final masterpiece");
    public static Item cinnamon = new Item("cinnamon", "This makes your cinnamon rolls cinnamon rolls");

    public static ArrayList<Item> allItems = new ArrayList<Item>();
    
    public String name;
    private String use;

    public Item(String name, String use) {
        this.name = name;
        this.use = use;
    }

    public String getUse() {
        return this.use;
    }

    public static Item nameToItem(String name) {
        for (Item i : allItems) {
            if (name.equals(i.name)){
                return i;
            }
        }
        return null;

    }
    
    public static void addItems() {
        allItems.add(flour);
        allItems.add(saw);
        allItems.add(sugar);
        allItems.add(recipe);
        allItems.add(pan);
        allItems.add(cinnamon);
    }
}
