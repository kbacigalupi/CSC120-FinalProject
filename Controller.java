import java.util.Scanner;
import java.util.ArrayList;

public class Controller {

    public static void help() {
        System.out.println(" ");
        System.out.println("Here are the commands you can use in this game:" 
         + "\npaddle to 'location' : allows you to paddle to a campsite, lake, or portage" 
         + "\nlook : tells you where you are and where you can move (if you happen to forget)"
         + "\nportage : In the Boundary Waters, you might have to walk your canoe between lakes to get to further campsites. You can ONLY portage if you are at one end of a portage and if you have the correct items to do so"
         + "\ntake 'item' : if you come across something you want to pick up, you can pick the item with this command" 
         + "\ndrop 'item' : if you wish to drop an item at any time, you can with this command"
         + "\nexamine 'item' : some items in the game have information that you can get by examining them."
         + "\nexit : to exit the game"
         + "\nmake cinnamon rolls : if you believe you have all the ingredients to do so and are in the correct place this command allows you to win"
         + "\n  You may only attempt to make the cinnamon rolls once-and must have all the ingredients to do so"
         + "\n");
    }
    
    public Item stringToItem(String item, ArrayList<Item> allItems) {
        for (int i = 0; i<=allItems.size(); i++) {
            if (allItems.get(i).name.equals(item)) {    
                return allItems.get(i);
            }
        }
        return null;
    }

    public void checkWin(Player player, Map map) {
        if (player.hasAll() == true && player.location.equals(map.finalCamp)){
            System.out.println("Drumrollll pleasee......");
            System.out.println("You have just made the best cinnamon rolls in your life & won the game! Congrats");
        }
        else {
            System.out.println("You have NOT been successful in making cinnamon rolls. Unfortunately this means the game is over :(. Hope your trip to the Boundary Waters ends up ok");
        }

    }

    

    public static void main(String[] args) {
        Controller game = new Controller();
        /*Locations loaded in to be passed into map constructor*/
        //I don't think this is the best way to do this, but this is the best that I have now....
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
        butterCamp.dropItem(Item.butter);

        //Starts the game
        System.out.println("************************************");
        System.out.println("              NEW GAME             ");
        System.out.println("Welcome to the BOUNDARY WATERS - an area in Northern Minnesota filled with lakes and canoes.");
        System.out.println("Today you are the most RAVENOUS that you have been in your life. \nYou must move from campsite to campsite through the lakes, portages, and campsites to pick up all the ingredients to make the BEST cinnamon roll of your life.");
        System.out.println("However-you only have enough firewood to make the cinnamon rolls ONCE and at the correct campsite. You must have all of the ingredients to do so first. Good luck!");
        System.out.println("You are currently at a drop off point-good luck! Enter help for more information.");


        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String command = "";


        /*Game loop */
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
            //I think that the take sequence should be in a different function, however I'm not sure how to avoid scanner errors 
            else if (command.startsWith("take")) {
                try {
                    command = command.substring(5);
                    Item item = Item.nameToItem(command);
                    if (item == null) {
                        System.out.println("This item does not exist in the game");
                    }
                    else if (player.inventory.contains(item)) {
                        System.out.println("You already have this item");
                    }
                    else if (!player.location.hasObject(item)) {
                        System.out.println("There's no " + command + " here");
                    }
                    else {
                        System.out.println("");
                        System.out.println("You must answer a TRIVIA question first:");
                        for (int i = 1; i<= 5; i++) {
                            System.out.println(player.location.riddle + " Enter answer below:");
                            String answer = myObj.nextLine();
                            answer = answer.toLowerCase();
                            if (answer.equals(player.getLocation().answer)) {
                                player.inventory.add(item);
                                player.location.remove(item);
                                System.out.println("You have picked up " + item.name);
                                break;
                            }
                            else {
                                System.out.println("Not quite! You have " + (5-i) + " tries left.");
                            }
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println("Please enter take 'item' ");
                }
            }
            else if (command.startsWith("drop")) {
                try {
                    command = command.substring(4);
                    player.drop(command);
                }
                catch (Exception e) {
                    System.out.println("Please enter drop 'item' ");
                }
            }
            else if(command.equals("help")){
                help();
            } 
            else if (command.startsWith("portage")) {
                player.portage(portageStart, portageEnd);
            }
            else if(command.equals("make cinnamon rolls")) {
                game.checkWin(player, worldMap); 
                break;
            }
            //else if(command.startsWith("examine")) { - Not yet implemented but want to be able to examine items
                //command = command.substring(8);


            //}
            else if(command.startsWith("open")) {
                if (command.endsWith("chest")) {
                    System.out.println("There is a recipe inside!");
                }
            }
            else {
                System.out.println("I'm sorry I don't understand that command. Enter 'help' to get a reminder of what you can do");
            }
        }
        System.out.println("Thank you for playing!");
        myObj.close();
        
    }
}
