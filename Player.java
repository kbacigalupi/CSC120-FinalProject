import java.util.ArrayList;
import java.util.Scanner;

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
     * TO DO decide if you want to keep this/be able to drop 
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
     * @itemName the name of the object being picked up
     */

    public void take(String itemName, Scanner scanner) {
        Item item = Item.nameToItem(itemName);
        if (item == null) {
            System.out.println("This item does not exist in the game");
        }
        else if (this.location.hasObject(item) == true) {
            System.out.println(this.location.riddle + " Enter answer below");
            String answer = scanner.nextLine();
            for (int tries = 1; tries <=5; tries++) {
                if (answer.equals(this.location.answer) & tries <=5) {
                    this.inventory.add(item);
                    this.location.remove(item);
                    System.out.println("You have picked up " + item.name);
                    break;
                }
                else {
                    System.out.println("Not quite! You have " + (5-tries) + " tries left");
                }
            }
            //TODO WHAT HAPPENS AFTER 5 TRIES
            System.out.println("");
        }
        else {
            System.out.println("This item's not here");
        }
    }

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

    /*Tests so the user can win
     * @param if the user has all the items or not
    */
    public boolean hasAll() {   
        if (this.inventory.containsAll(Item.allItems)) {
            return true;
        }
        return false;
    }

    public void openChest(String command, Scanner scanner, Location playerLocation) {
        if (command.endsWith("chest")) {
            System.out.println("There is a recipe inside!"); 
        }
    }


    public static void main(String[] args) {
        Location start = new Location("Drop Off", "This is the area you began in. There are no items in the area. From here, you must 'paddle to lake one' ");
        Location lakeOne = new Location("Lake one", "You made it to the middle of Lake One! From here, you can paddle to Campsite One, Campsite Three, Campsite Two, Bushwack Portage, and Campsite Three");
        Location sawCamp = new Location("What is the name of the park in Canada directy north of the Boundary Waters?", "quetico", "Campsite One", "You made it to Campsite One! In the middle of the campsite, there is a sharp saw. From here, you can paddle to Lake 1");
        Location butterCamp = new Location( "The Boundary Waters is a apart of the Superior National Forest in Minnesota. What percentage of the US forest system is the Superior National Forest? Answer with a number only.", "20", "Campsite Two", "You made it to Campsite Two! There's a hole in the ground! Inside the hole is butter. \nFrom here, you can paddle to Lake One");
        Location flourCamp = new Location("What are the length of portages (walking with gear between lakes) measured in?", "rods", "Campsite Three", "You made it to Campsite Three! There is a bag of flour hanging from a tree. \nFrom here, you can paddle to Lake 1");
        Location portageStart = new Location("Bushwack Portage", "You made it to the Lake One side of Bushwack Portage! The trees seem rather overgrown. Seems like you might need a saw to get through today");
        Location portageEnd = new Location("Bushwack Portage end", "You're at the Moose Lake side of Bushwack Portage! From here, you can paddle to Moose Lake or portage back to Lake One");
        Location mooseLake = new Location("Moose Lake", "You made it to Moose Lake! From here, you can paddle to Campsite Four, Campsite Five, Campsite Six, Campsite Seven, Campsite Eight, and Campsite Nine");
        Location sugarCamp = new Location("About how many lakes are there in the boundary waters? Answer in a whole number in the thousands (ex. 1 is 1000)", "2", "Campsite Four", "You made it to Campsite Four! There's a sack of sugar in some blueberry bushes. \nFrom here you can paddle to Moose Lake");
        Location emptyCamp1 = new Location("Campsite Five", "You made it to Campsite Five! There are gorgeous pine trees all around & it appears someone is already here--maybe you could ask them for help. (THIS FEATURE IS NOT IMPLEMENTED YET & MAY NOT BE)\n From here you can paddle to Lake One");
        Location finalCamp = new Location("What animal lives in the boundary waters and is known for making dams?", "beaver", "Campsite Six", "You made it to Campsite Six! There is a chest at this campsite.");
        Location panCamp = new Location("What kind of boat is the world's oldest boat?", "canoe", "Campsite Seven", "Welcome to Campsite Seven. There's a cast iron pan for your cinnamon rolls! \n From here you can paddle to Moose Lake");
        Location cinnamonCamp = new Location("What large animal found in the Boundary Waters can run up to 35 mph?", "moose", "Campsite Eight", "You made it to campsite Eight! There are beautiful birch trees all around! There's also a shaker filled with cinnamon\nFrom here you can paddle to Moose Lake");
        Location emptyCamp2 = new Location("Campsite Nine", "You made it to Campsite Nine! It's a beautiful place. You walk around and find no ingredients");
    

        /* A map of the World is created*/
        Map worldMapone = new Map(start, lakeOne, sawCamp, butterCamp, flourCamp, portageStart, portageEnd, mooseLake, sugarCamp, emptyCamp1, finalCamp, panCamp, cinnamonCamp, emptyCamp2);
        
        Item.addItems();

        /*Initiates The player of the game*/
        Player player = new Player(worldMapone, finalCamp);

        player.inventory.add(Item.butter);
        player.inventory.add(Item.cinnamon);
        player.inventory.add(Item.saw);
        player.inventory.add(Item.sugar);
        player.inventory.add(Item.flour);
        player.inventory.add(Item.pan);
        player.inventory.add(Item.recipe);

        player.myItems();

        System.out.println(player.hasAll());

    }
}
    
