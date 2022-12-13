import java.util.ArrayList;

public class Location {
    String name;
    private ArrayList<Item> items;
    String riddle;
    String answer;
    String description;

    /*Constructor  
     * @name the title of the place
     * @description helps the user know what they are doing
    */
    public Location(String name, String description) {
        this.items = new ArrayList<Item>();
        this.name = name;
        this.description = description;
    }

    /*Overloaded constructor for locations with more information (aka have an item to start with and need a riddle) 
     * @param riddle to pick up item
     * @param answer to the riddle
     * @param name of the location 
     * @param description of the location 
    */
    public Location(String riddle, String answer, String name, String description) {
        this.items = new ArrayList<Item>();
        this.riddle = riddle;
        this.answer = answer;
        this.name = name;
        this.description = description;
    }

    /*when a user picks up an item, takes it away from the location & changes the description 
     * @param item to remove from the location 
     */
    public void remove (Item item) {
        this.items.remove(item);
        if (this.name.equals("Campsite One")) {
            this.description = ("You made it to Campsite One! From here, you can paddle to Lake One");
        }
        else if (this.name.equals("Campsite Two")) {
            this.description = ("You made it to Campsite Two! There's a hole in the ground & it is empty. Looks like you've gotten everything.  \nFrom here, you can paddle to Lake One");
        }
        else if(this.name.equals("Campsite Three")) {
            this.description.equals("You made it to Campsite Three! \nFrom here, you can paddle to Lake One");
        }
        else if(this.name.equals("Campsite Four")) {
            this.description.equals("You made it to Campsite Four! From here you can paddle to Moose Lake");
        }
        else if(this.name.equals("Campsite Six")) {
            this.description.equals("You made it to Campsite Six! From here you can paddle to Moose Lake");
        }
        else if(this.name.equals("Campsite Seven")) {
            this.description.equals("You made it to Campsite Seven! From here you can paddle to Moose Lake");
        }
    }

    /*Tells the controller whether the location has the item or not
     * @param the item that the user wants to pick up
    */
    public boolean hasObject(Item wantTake) {
        if (items.contains(wantTake)) {
            return true;
        }
        return false;
    }

    /*puts an item on a location
     * @param the item to add to the location 
    */
    public void addItem(Item toAdd) {
        this.items.add(toAdd); 
    }
}
