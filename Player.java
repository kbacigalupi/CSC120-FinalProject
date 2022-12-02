import java.util.ArrayList;

/*The person class is the user */
public class Player {
    Location location;
    ArrayList<item> inventory;
    Map world;


    public Player(Map world, Location start) {
        this.inventory = new ArrayList<item>();
        this.world = world;
        this.location = start;
    }

    public void paddle(Location location) {
        //I need to figure out how to check if the person has a correct item to move past a certain location-suggestions?
        if (this.world.canMove(this.location, location) == true) {
            this.location = location;
            System.out.println("You are now at " + this.location.name);
        }
        else {
            System.out.println("You cannot move to this location");
        }

    }

    public void portage(String location) {

    }

    public void drop(item item) {
        this.inventory.remove(item);
        System.out.println("You have dropped " + item + " at " + this.location.name);
    }

    public void take(item item) {
        this.inventory.add(item);
        System.out.println("You have picked up" + item);
    }

    public void lookAround() {
        System.out.println(this.location.description);
    }

    public void help() {
        
    }

    public void haveItem() {

    }

    //Maybe unnecesary 
    public void examine() {
        
    }


    public static void main(String[] args) {
        
    }
    
}
