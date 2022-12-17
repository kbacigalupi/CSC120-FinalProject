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
        else if (this.location.equals(newloc)) {
            System.out.println("You are already here :)");
        }
        else if (this.world.canMove(this.location, newloc)) { //Only the map knows locations, if statement "moves" the player & prints out new location
            this.location = newloc;
            System.out.println(this.location.description);
        }
        else {
            System.out.println("You cannot move to this location-you are not next to " + location);
        }

    }
    /*The portage function allows the user to move from one side of the portage to the other if they have the saw
     * @param the locations needed to compare to the player's location - the end of the portage & the start of the portage
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
     * @param itemName the name of the object being picked up
     * @param the Scanner from the game loop to not run into scanner issues
     * @param the location the user is sent back to if they don't get the game right
     * @param the game (so the user can be sent back to game.start)
     */

    public void take(String itemName, Scanner scanner, Location start, Controller game) {
        boolean correct = false;
        Item item = Item.nameToItem(itemName);
        if (item == null) {
            System.out.println("This item does not exist in the game");
        }
        else if (inventory.contains(item)) {
            System.out.println("You already own this item-you cannot pick it up again.");
        }
        else if (this.location.hasObject(item)) {
            System.out.println(this.location.riddle + " Enter answer below");
            String answer;
            for (int tries = 1; tries <=5; tries++) {
                answer = scanner.nextLine();
                answer = answer.toLowerCase().trim();
                if (answer.equals(this.location.answer) & tries <=5) {
                    this.inventory.add(item);
                    this.location.remove(item, this.location);
                    System.out.println("You have picked up " + item.name);
                    correct = true;
                    break;
                }
                else {
                    System.out.println("Not quite! You have " + (5-tries) + " tries left");
                }
            }
            if (!correct) {
                System.out.println("Unfortunatley that is incorrect.");
                System.out.println("You have been sent back to the start of the game");
                this.location = game.start;
                System.out.println(this.location.description);
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
        if (inventory.size() == 0) {
            System.out.println("You do not have any items yet");
            return;
        }
        System.out.println("You have:");
        for (int i = 0; i<inventory.size(); i++) {
            if (inventory.size() == 1) {
                System.out.println(inventory.get(0));
                break;
            }
            if (i==(inventory.size()-1)) {
                System.out.print(" &" + inventory.get(i).name + ".");
            }
            else {System.out.print(inventory.get(i).name + ", ");}
        }
        System.out.println("");
    }

    /*Tests so the user can win
     * @param if the user has all the items or not
     * @return if the user does or doesn't have all of the items
    */
    public boolean hasAll() {   
        if (this.inventory.containsAll(Item.allItems)) {
            return true;
        }
        else {
            return false;
        }
    }

    /*Tells the user what items they need to pick up to win
     */
    public void need() {
        if (this.hasAll()) {
            System.out.println("You have everything you need");
        }
        ArrayList<String> dontHave = new ArrayList<String>();
        for (int i = 0; i<= Item.allItems.size()-1; i++) {
            if (!this.inventory.contains(Item.allItems.get(i))) {
                dontHave.add(Item.allItems.get(i).name);
            }
        }
        System.out.print("You still need to pick up ");
        for (int i = 0; i<=dontHave.size()-1; i++) {
            if(dontHave.size() == 1) {
                System.out.println(dontHave.get(0));
                break;
            }
            if (i == dontHave.size()-1) {
                System.out.print("& " + dontHave.get(i) + ".");
            }
            else {System.out.print(dontHave.get(i) + ", ");}
        }
        System.out.println("");
    }

    /*Examines an item if the user is at the same location as the item
     * @param the command that the user entered
     */
    public void examine(String command) {
        Item examining;
        try { 
            examining = Item.nameToItem(command.substring(8));
            if (examining == null) {
                System.out.println("That item doesn't exist");
            }
            else if (this.location.hasObject(examining)) {
                System.out.println(examining.getUse());
            }
            else {
                System.out.println("This item is not here at the moment");
            }
        }
        catch(Exception e) {
            System.out.println("That item does not exist");
        }
    }


}

    
