import java.util.Scanner;
import java.util.ArrayList;

public class Controller {

    public static void help() {
        System.out.println("Here are the commands you can use in this game: \npaddle to 'location' : allows you to paddle to a campsite, lake, or portage \nlook : tells you where you are and where you can move (if you happen to forget) \nportage : In the Boundary Waters, you might have to walk your canoe between lakes to get to further campsites. You can ONLY portage if you are at a portage \n take 'item' : if you come across something you want to pick up, you can pick the item with this command \n drop 'item' : if you wish to drop an item at any time, you can with this command");
    }
    
    public Item stringToItem(String item, ArrayList<Item> allItems) {
        for (int i = 0; i<=allItems.size(); i++) {
            if (allItems.get(i).name.equals(item)) {    
                return allItems.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //Locations loaded in to be passed into map constructor & a list used to iterate through 
        //I don't think this is the best way to do this
        Location start = new Location("Drop Off", "This is the area you began in. There are no items in the area. From here, you must 'paddle to lake one' ");
        Location lakeOne = new Location("Lake one", "You made it to the middle of Lake 1! From here, you can paddle to Campsite One, Campsite Three, Campsite Two, Bushwack Portage, and Campsite Three");
        Location sawCamp = new Location("What is the name of the park in Canada directy north of the Boundary Waters?", "Quetico", "Campsite One", "You made it to Campsite One! In the middle of the campsite, there is a sharp saw. From here, you can paddle to Lake 1");
        Location butterCamp = new Location( "The Boundary Waters is a apart of the Superior National Forest in Minnesota. What percentage of the US forest system is the Superior National Forest? Answer with a number only.", "20", "Campsite Two", "You made it to Campsite Two! There's a hole in the ground! Inside the hole is butter. \nFrom here, you can paddle to Lake 1");
        Location flourCamp = new Location("What are the length of portages (walking with gear between lakes) measured in?", "rods", "Campsite Three", "You made it to Campsite Three! There is a bag of flour hanging from a tree. \nFrom here, you can paddle to Lake 1");
        Location portageStart = new Location("Bushwack Portage Start", "You made it to Bushwack Portage! The trees seem rather overgrown. Seems like you might need a saw to get through today");
        Location portageEnd = new Location("Bushwack Portage end", "You're at the Moose Lake side of Bushwack Portage! From here, you can paddle to Moose Lake");
        Location mooseLake = new Location("Moose Lake", "You made it to Moose Lake! From here, you can paddle to Campsite Four, Campsite Five, Campsite Six, Campsite Seven, Campsite Eight, and Campsite Nine");
        Location sugarCamp = new Location("About how many lakes are there in the boundary waters?", "2000", "Campsite Four", "You made it to Campsite Four! There's a sack of something useful in some blueberry bushes. \nFrom here you can paddle to Moose Lake");
        Location emptyCamp1 = new Location("Campsite Five", "You made it to Campsite Five! There are gorgeous pine trees all around & it appears someone is already here--maybe you could ask them for help. \n From here you can paddle to Lake One");
        Location finalCamp = new Location("What animal lives in the boundary waters and is known for making dams?", "beaver", "Campsite Six", "You made it to Campsite Six! There is a chest at this campsite.");
        Location panCamp = new Location("What kind of boat is the world's oldest boat?", "canoe", "Campsite Seven", "Welcome to Campsite Seven- it's a marshy one. Hopefully you won't have to be here for long. ");
        Location cinnamonCamp = new Location("What large animal found in the Boundary Waters can run up to 35 mph?", "moose", "Campsite Eight", "You made it to campsite Eight!");
        Location emptyCamp2 = new Location("Campsite Nine", "You made it to Campsite Nine! It's a beautiful place. You walk around and find no ingredients");
    

        /* A map of the World is created*/
        Map worldMap = new Map(start, lakeOne, sawCamp, butterCamp, flourCamp, portageStart, portageEnd, mooseLake, sugarCamp, emptyCamp1, finalCamp, panCamp, cinnamonCamp, emptyCamp2);
        
        Item.addItems();

        /*Initiates The player of the game*/
        Player player = new Player(worldMap, start);

        // Adding items to their location
        sawCamp.dropItem(Item.saw);
        flourCamp.dropItem(Item.flour);
        sugarCamp.dropItem(Item.sugar);
        finalCamp.dropItem(Item.recipe);
        panCamp.dropItem(Item.pan);
        cinnamonCamp.dropItem(Item.cinnamon);


        System.out.println("************************************");
        System.out.println("              NEW GAME             ");
        System.out.println("Welcome to the BOUNDARY WATERS - an area in Northern Minnesota filled with lakes and canoes.");
        System.out.println("You are currently at a drop off point");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String command = "";

        /*Prints out all directions that a person can move/do */
        help();

        while (!command.equals("exit")) {
            System.out.println("Enter next command");
            command = myObj.nextLine();  // Read user input & make it lower case
            command = command.toLowerCase();
            if (command.equals("look")) {
                player.lookAround();
            }
            else if (command.startsWith("paddle to")) {
                try{
                    command = command.substring(10);
                    player.paddle(command);
                } 
                catch (Exception e) {
                    System.out.println("Please enter 'paddle to 'location' ' ");
                }
            }  
            else if (command.startsWith("take")) {
                try {
                    command = command.substring(5);
                    //Location loc = stringToItem(command, allItems);
                    player.take(command);
                }
                catch (Exception e) {
                    System.out.println("Please enter take 'item' ");
                }
            }
            else if (command.startsWith("drop")) {
                try {
                    command = command.substring(6);
                    player.drop(command);
                }
                catch (Exception e) {
                    System.out.println("Please enter drop 'item' ");
                }
            }
            else if(command.equals("help")){
                help();
            } 
            else if (command.equals("portage")) {
                player.portage();
            }
            else {
                System.out.println("I'm sorry I don't understand that command. Enter 'help' to get a reminder of what you can do");
            }
        }
        System.out.println("Thank you for playing!");
        myObj.close();
        
    }
}
