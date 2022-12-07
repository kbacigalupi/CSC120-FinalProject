/*Chat bot sits at the start and also at the first portage(? - RN this is fully code from the chatbot assignment and is NOT being used)*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

/**
 * The class that runs the conversation
 * Returns a full conversation & transcript
 */

public class Chatbot {

/** 
 * Main runs the conversation 
*/

  public static void main(String[] arguments) {
    System.out.println("Hello! Nice to meet you. I'm a squirrel ");
    Scanner input = new Scanner(System.in); 
    int rounds = input.nextInt(); //Takes in the number of rounds, used in for loop below to determine number of computer replies
    System.out.println("What are you stuck with in the Boundary Waters TOday?"); //Starts the conversation the same way every time 

    //Starts the transcript with the original question-this transcript array is added onto throughout
    ArrayList<String> transcript = new ArrayList<String>();
      transcript.add("What are you thinking about today?");
      String reply = input.nextLine();

    //For loop creates the rounds of the question-has already had one input so does less rounds
    for (int i = 0; i < rounds-1; i++) {
      reply = input.nextLine(); //First gets a reply 
      transcript.add(reply); //Adds the reply to the transcript
      reply = reply.toLowerCase();//Makes input lower case after it has been added to the transcript to mirror words more easily

      String[] strSplit = reply.split(" "); //Splits the reply up by spaces into words
      ArrayList<String> mirrored = new ArrayList<String>(Arrays.asList(strSplit)); ; // Adds each word into an array list (so length can be changed)
      String response = ""; //Starts the new string that is created by mirroring the "mirrored" array 


      for (String str: mirrored) { //Loops through all of the words in the array list and performs the mirror function--this puts together a mirrored response
        response += mirror(str);
      }


      response = response.substring(1, response.length()); //This gets rid of the space at the beginning as every word through has a space in front

      if (response.substring(response.length()-1, response.length()).equals("I")) {
        response = response.substring(0, response.length()-1) + response.substring(response.length()-1, response.length()).replace("I", "me");
        
      }
      //If the response has changed prints out the mirrored version
      if (!response.toLowerCase().equals(reply)) { 
        response = response.substring(0, 1).toUpperCase() + response.substring(1, response.length()); //Makes the first uppercase
        response += "?"; //Adds a question mark at the end before adding to the transcript
        transcript.add(response); //Adds the new question to the transcript
        System.out.println(response); //Prints out the new question
      }
      else { //Runs if there were no mirror words detected
        String[] canned_response = { //list of canned responses
            "Really?", "Definitley", "Hmmm tell me more about that", "Interesting", "Wait me too!", "Hmmm I understand", "Wow I was thinking the same!", "slayyyy"
        };
        Random rand = new Random(); //Starts a random object
        int index = rand.nextInt(canned_response.length); //Picks a random number between 0 and the length 
        String question = canned_response[index]; // gets & prints the question at the index of the random number
        System.out.println(question);
        transcript.add(question); //Adds the question to the transcript 
      }

    }

  //If it is the last round of conversation, the program takes one more line & then goes to the ending sequence
    String last_response = input.nextLine();
    transcript.add(last_response);
    transcript.add("Mmmhmmm"); //Adds Mmmhmmm to the transcript
    System.out.println("Mmmhmmm"); 
    System.out.println("See ya!");
    transcript.add("See ya!");
    System.out.println(" "); //Creates a space
    System.out.println("TRANSCRIPT:"); //Tells the user that a transcript is coming
    for (int j = 0; j < transcript.size(); j++) { //prints every item in the transcript 
      System.out.println(transcript.get(j));
    }

    input.close();
  }


/** 
 * Function for mirroring a word-each mirror word is an if statement. 
 * If it is detected the opposite word is returned (and added to the reply) & the function ends. 
 * The function is run for each word 
*/
public static String mirror (String word) {
    if (word.equals("i")) {
      return " you";
    }
    if (word.equals("me")) {
      return " you";
    }
    if (word.equals("am")) {
      return " are ";
    }
    if (word.equals("are")) {
      return " am";
    }
    if (word.equals("you")) {
      return " I";
    }
    if (word.equals("my")) {
      return " your";
    }
    if (word.equals("your")) {
      return " my";
    }
    if (word.equals("i'm")) {
      return " you're";
    }
    if (word.equals("you're")) {
      return " I'm";
    }
    if (word.equals("myself")) {
      return " yourself";
    }
    if (word.equals("yourself")) {
      return " myself";
    }
    if (word.equals("yours")) {
      return " mine";
    }
    if (word.equals("mine")) {
      return " yours";
    }
    else {
      return (" " + word);
    }
  }

}
