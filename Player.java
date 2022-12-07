import java.util.ArrayList;

/*The person class is the user*/
public class Player {
    Location location; //Where the person is
    ArrayList<Item> inventory; //What the person has
    Map world; //What world they're moving around 

    /*Constructor for the player
     * @param the world the player is moving around in (a map)
     * @param the location the player is starting 
     */
    public Player(Map world, Location start) {
        this.inventory = new ArrayList<Item>();
        this.world = world;
        this.location = start;
    }

    /*Allows the player to paddle to a new location if they are next to it
     * @param location that the user types in 
    */
    public void paddle(String location) {
        Location newloc = this.world.stringtoLocation(location); //Takes the input and makes it a location-only the map can access all its' locations
        if (newloc == null) {
            System.out.println("This location does not exist-please try a new location");
        }
        else if (this.world.canMove(this.location, newloc) == true) { //Only the map knows locations, if statement "moves" the player & prints out new location
            this.location = newloc;
            System.out.println(this.location.description);
        }
        else {
            System.out.println("You cannot move to this location-you are not next to " + location);
        }

    }
    /*The portage function allows the user to move from one side of the portage to the other if they have the saw
     * @param the locations needed to compare to the player's location 
    */
    public void portage(Location portageStart, Location portageEnd) {
        if(!this.inventory.contains(Item.saw)) {
            System.out.println("You do not have the saw and cannot pass through the portage right now");
            return;
        }
        Location newloc = this.world.canPortage(this.location, portageStart, portageEnd);
        if (newloc != null) {
            this.location = newloc;
            System.out.println(this.location.description);
           return;
        }
        System.out.println("You cannot portage from this location");
    }

    /*Drops an item at any location the user is in the water they lose the item
     * @param the name of the item that is being dropped
     * Now that I think about it this may not be necessary
    */
    public void drop(String itemName) {
        Item toDrop = Item.nameToItem(itemName);
        if (toDrop == null) {
            System.out.println("This item does not exist in the game");
        }
        if (this.inventory.contains(toDrop)) {
            this.inventory.remove(toDrop);
            this.location.addItem(toDrop);
            System.out.println("You have dropped " + toDrop + " at " + this.location.name);
            return;
        } 
        System.out.println("You do not have this item in your inventory");
    }

    /*The user picks up an item
     * @itemName the name of the object being picked up - could not use this method once I implemented the trivia questions
     */
    /*public void take(Item item) {
        //Item item = Item.nameToItem(itemName);
        //if (item == null) {
            //System.out.println("This item does not exist in the game");
        //}
        if (this.location.hasObject(item) == true) {
            int tries = 1;
            System.out.println(this.location.riddle + ": Enter answer below");
            if (answer.equals(this.location.answer) & tries <=5) {
                this.inventory.add(item);
                this.location.remove(item);
                System.out.println("You have picked up " + item.name);
            }
            else {
                System.out.println("Not quite! You have" + (5-tries) + "tries left");
            }
        }
        else {
            System.out.println("This item's not here");
        }
    }*/

    /*Accessor for the location of the person
     * @return location of player
     */
    public Location getLocation() {
        return this.location;
    }

    /*Tells the user what is going on around them*/
    public void lookAround() {
        System.out.println(this.location.description);
    }

    /*Tells the user all of the items that are in their inventory*/
    public void myItems() {
        for (int i = 0; i<inventory.size(); i++) {
            if (i <inventory.size() +1) {
                System.out.print(inventory.get(i).name + ", ");
            }
        }
    }

    /*Not in use yet in controller, but allows user to examine an item*/
    public void examine(Item item) {
        System.out.println(item.getUse());
    }

    /*Tests so the user can win */
    public boolean hasAll() {   
        if (this.inventory.containsAll(Item.allItems)) {
            return true;
        }
        return false;
    }
}
    
