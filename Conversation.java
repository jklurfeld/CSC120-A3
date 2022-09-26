import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class takes in user input and responds based on detected mirror words.
 */
class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.

    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds?");
    int numRounds = input.nextInt();

    //is it okay if I us ean arraylist rather than an array
    ArrayList<String> transcript = new ArrayList<String>();

    //it doens't like it when I put static in front of String[] cannedResponses
    // why does it have to be static?
    String[] cannedResponses = {"Mhm.", "Ok.", "That's nice."};

    String greeting = "Hi there! What's on your mind?";
    System.out.println(greeting);
    transcript.add(greeting);
    input.nextLine();

    
    for (int i = 0; i < numRounds; i++){
      String dialogue = input.nextLine();

      String[] words = dialogue.split(" ");
      for (int k = 0; k < words.length; k++){
        if (words[k].equals("I")){
          words[k] = "you";
        }
        else if (words[k].equals("me")){
          words[k] = "you";
        }
        else if (words[k].equals("am")){
          words[k] = "are";
        }
        else if (words[k].equals("you")){
          words[k] = "I";
        }
        else if (words[k].equals("my")){
          words[k] = "your";
        }
        else if (words[k].equals("your")){
          words[k] = "my";
        }
        else if (words[k].equals("are")){
          words[k] = "am";
        }
      }

      String response = "";
      for (int j = 0; j < words.length; j++){
        if (j != words.length - 1){
          response += words[j] + " "; 
        }
        else {
          response += words[j];
        }
      }

      //if there are no mirror words, give a canned response
      if (dialogue.equals(response)){
        response = cannedResponses[(int)(Math.random() * 3)];
      }
      else {
        response += "?";
      }
      transcript.add(dialogue);
      transcript.add(response);
      System.out.println(response);
    }

    String closer = "See ya!";
    transcript.add(closer);
    System.out.println(closer);

    System.out.println();
    System.out.println("TRANSCRIPT:");
    for (int k = 0; k < transcript.size(); k++){
      System.out.println(transcript.get(k));
    }

    input.close();
  }
}