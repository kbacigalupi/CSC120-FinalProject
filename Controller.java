import java.util.Scanner;
import java.util.ArrayList;

public class Controller {

    //TODO function that prints out the commands that the user needs

    public static void main(String[] args) {
        //Locations loaded in to be passed into map constructor & a list used to iterate through 
        //I don't think this is the best way to do this
        Location start = new Location("Drop Off", "This is the area you began in. There are no items in the area");
        Location lakeOne = new Location("Lake 1", "You made it to the middle of Lake 1! From here, you can paddle to Campsite One, Campsite Three, Campsite Two, Bushwack Portage, and Campsite Three");
        Location sawCamp = new Location("What is the name of the park in Canada directy north of the Boundary Waters?", "Quetico", "Campsite One", "You made it to Campsite One! In the middle of the campsite, there is a sharp saw. From here, you can paddle to Lake 1");
        Location butterCamp = new Location( "The Boundary Waters is a apart of the Superior National Forest in Minnesota. What percentage of the US forest system is the Superior National Forest? Answer with a number only.", "20", "Campsite Two", "You made it to Campsite Two! There is a chest in the middle of the campsite. \nFrom here, you can paddle to Lake 1");
        Location flourCamp = new Location("What are the length of portages (walking with gear between lakes) measured in?", "rods", "Campsite Three", "You made it to Campsite Three! ");
        Location portage = new Location("Bushwack Portage", "You made it to Bushwack Portage! The trees seem rather overgrown. Seems like you might need a saw to get through today");
        Location mooseLake = new Location("Moose Lake", "You made it to Moose Lake! From here, you can paddle to Campsite Four, Campsite Five, Campsite Six, Campsite Seven, Campsite Eight, and Campsite Nine");
        Location sugarCamp = new Location("About how many lakes are there in the boundary waters?", "2000", "Campsite Four", "You made it to Campsite Four! There's a sack of something useful hanging from a tree. \nFrom here you can paddle to Moose Lake");
        Location emptyCamp1 = new Location("Campsite Five", "You made it to Campsite Five! There are gorgeous pine trees all around & it appears someone is already here--maybe you could ask them for help. \n From here you can paddle to Lake One");
        Location finalCamp = new Location("What animal lives in the boundary waters and is known for making dams?", "beaver", "Campsite Six", "You made it to Campsite Six!");
        Location panCamp = new Location("What kind of boat is the world's oldest boat?", "canoe", "Campsite Seven", "Welcome to Campsite Seven- it's a marshy one. Hopefully you won't have to be here for long. ");
        Location cinnamonCamp = new Location("What large animal found in the Boundary Waters can run up to 35 mph?", "moose", "Campsite Eight", "You made it to campsite Eight!");
        Location emptyCamp2 = new Location("Campsite Nine", "You made it to Campsite Nine! It's a beautiful place. You walk around and find no ingredients");
        
        //I don't want to use this arraylist...but I'm unsure of how to point to the location without iterating through a list of locations
        ArrayList<Location> locationList= new ArrayList<Location>();
        locationList.add(start);
        locationList.add(lakeOne);
        locationList.add(sawCamp);
        locationList.add(butterCamp);
        locationList.add(flourCamp);
        locationList.add(portage);
        locationList.add(mooseLake);
        locationList.add(sugarCamp);
        locationList.add(emptyCamp1);
        locationList.add(finalCamp);
        locationList.add(panCamp);
        locationList.add(cinnamonCamp);
        
        /* A map of the World is created*/
        //TODO pass an arrayList into map

        Map worldMap = new Map(start, lakeOne, sawCamp, butterCamp, flourCamp, portage, mooseLake, sugarCamp, emptyCamp1, finalCamp, panCamp, cinnamonCamp, emptyCamp2);
        
        item flour = new item("flour", "This item will be a key ingredient in the dough", flourCamp);
        item saw = new item("saw", "You need this to traverse the portage", sawCamp);
        item sugar = new item("sugar", "This is a key ingredient to make your cinnamon rolls taste good", sugarCamp);
        item recipe = new item("recipe", "This item is the FINAL item! You must have all the ingredients first.", finalCamp);
        item pan = new item("pan", "You need this to cook your final masterpiece", panCamp);
        item cinnamon = new item("cinnamon", "This makes your cinnamon rolls cinnamon rolls", cinnamonCamp);

        /*The player */
        Player player = new Player(worldMap, start);

        //TODO Adding items to their location
        sawCamp.dropItem(saw);
        flourCamp.dropItem(flour);


        System.out.println("************************************");
        System.out.println("              NEW GAME             ");
        System.out.println("Welcome to the BOUNDARY WATERS");
        System.out.println("You are currently at a drop off point");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String command = "";

        while (!command.equals("exit")) {
            System.out.println("Enter next command");
            command = myObj.nextLine();  // Read user input & make it lower case
            command = command.toLowerCase();
            if (command.equals("look")) {
                player.lookAround();
            }
            if (command.startsWith("paddle to")) {
                try{
                    command = command.substring(10);
                    //Strugging to figure out how to go from input typed to a location....suggestions??? player.

                } 
                catch (Exception e) {
                    System.out.println("Please enter 'paddle to 'location' ' ");
            }
        }
        System.out.println("Thank you for playing!");
        myObj.close();
        }
    }
}
