
import java.util.ArrayList;

public class Item {
    public static Item flour = new Item("flour", "This item will be a key ingredient in the dough");
    public static Item saw = new Item("saw", "You need this to traverse the portage");
    public static Item butter = new Item("butter", "You need this to cook your cinnamon rolls!");
    public static Item sugar = new Item("sugar", "This is a key ingredient to make your cinnamon rolls taste good");
    public static Item recipe = new Item("recipe", "This item is the FINAL item! You must have all the ingredients first.");
    public static Item pan = new Item("pan", "You need this to cook your final masterpiece");
    public static Item cinnamon = new Item("cinnamon", "This makes your cinnamon rolls cinnamon rolls");

    public static ArrayList<Item> allItems = new ArrayList<Item>();
    
    public String name;
    private String use;

    /*Item constructor
     * @param the name and use of the object
     * @param the use of the object
     */
    public Item(String name, String use) {
        this.name = name;
        this.use = use;
    }

    /*Accessor for use */
    public String getUse() {
        return this.use;
    }

    /*Takes user input of string and converts it to an item
     * @param string name
     * @return the object with that name
     */
    public static Item nameToItem(String name) {
        for (Item i : allItems) {
            if (name.equals(i.name)){
                return i;
            }
        }
        return null;

    }
    
    /*Adds all the items to the Items arraylist */
    public static void addItems() {
        allItems.add(flour);
        allItems.add(saw);
        allItems.add(sugar);
        allItems.add(recipe);
        allItems.add(pan);
        allItems.add(cinnamon);
        allItems.add(butter);
    }
}
