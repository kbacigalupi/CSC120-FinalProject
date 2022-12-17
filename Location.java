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

    /*puts each item at a location to start with 
     * @param the item to remove
    */
    public void dropItem(Item item) {
        this.items.add(item);
    }
    /*when a user picks up an item, takes it away from the location & changes the description 
     * @param item to remove from the location 
     * @param the current location of the player to be compared with all of the locations in order to change the description if an item has been picked up
     */
    public void remove (Item item, Location playerLoc) {
        this.items.remove(item);
        System.out.println(playerLoc.name);
        switch (playerLoc.name) {
            case  "Campsite One":   
                this.description = ("You made it to Campsite One! Looks like you already picked up what you needed. From here, you can paddle to Lake One or Campsite Two.");
                break;
            case "Campsite Two":
                this.description = ("You made it to Campsite Two! There's a hole in the ground & it is empty. Looks like you've gotten everything. From here, you can paddle to Lake One, Campsite One, or Bushwack Portage");
                break;
            case "Campsite Three":
                this.description = ("You made it to Campsite Three! From here, you can paddle to Lake One or Bushwack Portage. Looks like you've picked up everything you need");
                break;
            case "Campsite Four":
                this.description = ("You made it to Campsite Four! From here you can paddle to Moose Lake or Campsite Five. Congrats on already collecting the sugar");
                break;
            case "Campsite Six":
                this.description = ("You made it to Campsite Six! This is the campsite where you can make your cinnamon rolls. Seems like you already have your recipe. From here you can paddle to Moose Lake, Campsite Five, or Campsite Seven");
                break;
            case "Campsite Seven":
                this.description = ("You made it to Campsite Seven! From here you can paddle to Moose Lake, Campsite Six, or Campsite Eight. You've already collected everything from here!");
                break;
            default:
                return;
            

        }
    }

    /*Tells the controller whether the location has the item or not
     * @param the item that the user wants to pick up
     * @return whether the location has the item the user wants to pick up
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
