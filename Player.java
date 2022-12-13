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

    /*The user picks up an item
     * @itemName the name of the object being picked up
     */

    public void take(String itemName, Scanner scanner, Location start) {
        boolean correct = false;
        Item item = Item.nameToItem(itemName);
        if (item == null) {
            System.out.println("This item does not exist in the game");
        }
        else if (this.location.hasObject(item) == true) {
            System.out.println(this.location.riddle + " Enter answer below");
            String answer;
            for (int tries = 1; tries <=5; tries++) {
                answer = scanner.nextLine();
                if (answer.equals(this.location.answer) & tries <=5) {
                    this.inventory.add(item);
                    this.location.remove(item);
                    System.out.println("You have picked up " + item.name);
                    correct = true;
                    break;
                }
                else {
                    System.out.println("Not quite! You have " + (5-tries) + " tries left");
                }
            }
            if (correct == false) {
                System.out.println("Unfortunatley that is incorrect.");
                System.out.println("You have been sent back to the start of the game");
                this.location.equals(start);
                System.out.println(start.description);
            }
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

    /*Tests so the user can win
     * @param if the user has all the items or not
    */
    public boolean hasAll() {   
        if (this.inventory.containsAll(Item.allItems)) {
            return true;
        }
        return false;
    }


}

    
