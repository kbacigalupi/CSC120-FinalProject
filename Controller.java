import java.util.Scanner;
 
public class Controller {
    int moves;
    public Location start;
    public Location lakeOne;
    public Location sawCamp;
    public Location butterCamp;
    public Location flourCamp;
    public Location portageStart;
    public Location portageEnd;
    public Location mooseLake;
    public Location sugarCamp;
    public Location emptyCamp1;
    public Location finalCamp;
    public Location panCamp;
    public Location cinnamonCamp;
    public Location emptyCamp2;

    /*Constructor of game is similar to a set up-however the locations must be accessed from everywhere and are thus attributes
     */
    public Controller () {
        this.moves = 0;
        /*Locations loaded in to be passed into map constructor*/
       this.start = new Location("Drop Off", "This is the area you began in. There are no items in the area. From here, you must 'paddle to lake one' ");
       this.lakeOne = new Location("Lake one", "You made it to the middle of Lake One! From here, you can paddle to Campsite One, Campsite Two, Bushwack Portage, and Campsite Three");
       this.sawCamp = new Location("What is the name of the park in Canada directly north of the Boundary Waters?", "quetico", "Campsite One", "You made it to Campsite One! In the middle of the campsite, there is a sharp saw. From here, you can paddle to Lake One");
       this.butterCamp = new Location( "The Boundary Waters is a apart of the Superior National Forest in Minnesota. What percentage of the US forest system is the Superior National Forest? Answer with a number only.", "20", "Campsite Two", "You made it to Campsite Two! There's a hole in the ground! Inside the hole is butter. \nFrom here, you can paddle to Lake One");
       this.flourCamp = new Location("What are the length of portages (walking with gear between lakes) measured in?", "rods", "Campsite Three", "You made it to Campsite Three! There is a bag of flour hanging from a tree. \nFrom here, you can paddle to Lake One");
       this.portageStart = new Location("Bushwack Portage", "You made it to the Lake One side of Bushwack Portage! The trees seem rather overgrown. Seems like you might need a saw to get through today");
       this.portageEnd = new Location("Bushwack Portage end", "You're at the Moose Lake side of Bushwack Portage! From here, you can paddle to Moose Lake or portage back to Lake One");
       this.mooseLake = new Location("Moose Lake", "You made it to Moose Lake! From here, you can paddle to Bushwack Portage end, Campsite Four, Campsite Five, Campsite Six, Campsite Seven, Campsite Eight, and Campsite Nine");
       this.sugarCamp = new Location("About how many lakes are there in the boundary waters? Answer in a whole number in the thousands (ex. 1 is 1000)", "2", "Campsite Four", "You made it to Campsite Four! There's a sack of sugar in some blueberry bushes. \nFrom here you can paddle to Moose Lake");
       this.emptyCamp1 = new Location("Campsite Five", "You made it to Campsite Five! There are gorgeous pine trees all around but no ingredients :( From here you can paddle to moose lake");
       this.finalCamp = new Location("What animal lives in the boundary waters and is known for making dams?", "beaver", "Campsite Six", "You made it to Campsite Six! This is the campsite where you can make your cinnamon rolls. There is a recipe pinned to a tree here");
       this.panCamp = new Location("What kind of boat is the world's oldest boat?", "canoe", "Campsite Seven", "Welcome to Campsite Seven. There's a pan for your cinnamon rolls! \n From here you can paddle to Moose Lake");
       this.cinnamonCamp = new Location("What large animal found in the Boundary Waters can run up to 35 mph?", "moose", "Campsite Eight", "You made it to campsite Eight! There are beautiful birch trees all around! There's also some cinnamon\nFrom here you can paddle to Moose Lake");
       this.emptyCamp2 = new Location("Campsite Nine", "You made it to Campsite Nine! It's a beautiful place. You walk around and find no ingredients");
    }

    /*Another way to shorten the main method-in the set up of the game */
    public void dropItems() {
    //Adding items to their location
     sawCamp.dropItem(Item.saw);
     flourCamp.dropItem(Item.flour);
     sugarCamp.dropItem(Item.sugar);
     finalCamp.dropItem(Item.recipe);
     panCamp.dropItem(Item.pan);
     cinnamonCamp.dropItem(Item.cinnamon);
     butterCamp.dropItem(Item.butter);
    }

    /*Words/directions for the beginning of the game */
   public static void startGame() {
       System.out.println("************************************");
       System.out.println("              NEW GAME             ");
       System.out.println("Welcome to the BOUNDARY WATERS - an area in Northern Minnesota filled with lakes and canoes.");
       System.out.println("Today you are the most RAVENOUS that you have been in your life. \nYou must move from campsite to campsite through the lakes, portages, and campsites to pick up all the ingredients to make the BEST cinnamon roll of your life.");
       System.out.println("However-you only have enough firewood to make the cinnamon rolls ONCE and at the correct campsite. You must have all of the ingredients to do so first. Good luck!");
       System.out.println("You are currently at a drop off point-good luck!");
       System.out.println("Enter help for more information");
   }

   /*Tells the user the commands that they can type in  */
   public static void help() {
       System.out.println(" ");
       System.out.println("Here are the commands you can use in this game:"
        + "\npaddle to 'location' : allows you to paddle to a campsite, lake, or portage"
        + "\nhelp tells you what commands you can use in the game"
        + "\nlook : tells you where you are and where you can move (if you happen to forget)"
        + "\nportage : In the Boundary Waters, you might have to walk your canoe between lakes to get to further campsites. You can ONLY portage if you are at one end of a portage and if you have the correct items to do so"
        + "\ntake 'item' : if you come across something you want to pick up, you can pick the item with this command"
        + "\nexit : to exit the game"
        +"\n you may have to enter some trivia questions to pick up all of your items."
        + "\nmake cinnamon rolls : if you believe you have all the ingredients to do so and are in the correct place this command allows you to win"
        + "\n  You may only attempt to make the cinnamon rolls once-and must have all the ingredients to do so"
        + "\n");
   }

   /*Determines if the user has won/ends the game
    * @param the player of the game
    * @param the location that the player must be at to win
    */
   public void checkWin(Player player, Location finalCamp) {
       if (!player.location.equals(finalCamp)) {
           System.out.println("You are at the wrong location-Unfortunately you cannot make cinnamon rolls here. Unfortunately this means the game is over");
       }
       else if (player.hasAll() == true){
           System.out.println("Drumrollll pleasee......");
           System.out.println("You have just made the best cinnamon rolls in your life & won the game! Congrats");
           System.out.println("It took you " + this.moves + "to finish the game. Play again to beat this score!");
       }
       else {
           System.out.println("You have NOT been successful in making cinnamon rolls. Unfortunately this means the game is over :(. Hope your trip to the Boundary Waters ends up ok");
       }
 
   }
 
   public static void main(String[] args) {

       Controller game = new Controller();
       game.dropItems();
 
       /* A map of the World is created*/
       Map worldMap = new Map(game.start, game.lakeOne, game.sawCamp, game.butterCamp, game.flourCamp, game.portageStart, game.portageEnd, game.mooseLake, game.sugarCamp, game.emptyCamp1, game.finalCamp, game.panCamp, game.cinnamonCamp, game.emptyCamp2);
      
       //Items are all added into a list that can be compared to the user's list
       Item.addItems();
 
       /*Initiates The player of the game*/
       Player player = new Player(worldMap, game.start);
  
       //Prints out all the information for the start of the game
       startGame();
 
       Scanner myObj = new Scanner(System.in);  // Create a Scanner object
       String command = "";
 
       //Game loop - could not figure out the logic to use switch() effectively--
       //there are a variety of multiple word commands that have the same first word 
       while (!command.equals("exit")) {
        System.out.println("Enter next command");
        command = myObj.nextLine();  // Read user input & make it lower case
        command = command.toLowerCase();
        game.moves +=1;
        if (command.equals("exit")) {
            break;
        }
        if (command.equals("look")) {
            player.lookAround();
        }
        else if (command.startsWith("paddle to")) {
            player.paddle(command.substring(10));
        }
        else if (command.startsWith("take")) {
            player.take(command.substring(5), myObj, game.start);
        }
        else if(command.equals("help")){
            help();
        }
        else if (command.startsWith("portage")) {
            player.portage(game.portageStart, game.portageEnd);
        }
        else if(command.equals("make cinnamon rolls")) {
            if (player.location.equals(game.finalCamp)) {
                game.checkWin(player, game.finalCamp);
            }
            break;
        }
        else if(command.equals("have")) {
            player.myItems();
        }
        else {
            System.out.println("I'm sorry I don't understand that command. Enter 'help' to get a reminder of what you can do");
        }
    }
    System.out.println("Thank you for playing!");
    myObj.close();
}
}
