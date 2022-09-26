import java.util.Scanner;
import java.util.ArrayList;

class Conversation {
// String userInput = input.next();
// String[] words = userInput.split(" ");

  public static void main(String[] arguments) {
    // You will start the conversation here.

    Scanner input = new Scanner(System.in);
    System.out.println("How many rounds?");
    int numRounds = input.nextInt();

    ArrayList<String> transcript = new ArrayList<String>();

    //it doens't like it when I put static in front of String[] cannedResponses
    String[] cannedResponses = {"Mhm.", "Ok.", "That's nice."};

    String greeting = "Hi there! What's on your mind?";
    System.out.println(greeting);
    transcript.add(greeting);
    input.nextLine();

    
    for (int i = 0; i < numRounds; i++){
      String dialogue = input.nextLine();
      String response = dialogue;
      int charactersLeft = dialogue.length();

      if (dialogue.indexOf("I") != -1){
        int locationOfWord = dialogue.indexOf("I");
        response = response.substring(0, locationOfWord) + "you" + dialogue.substring(locationOfWord + 4);
        charactersLeft -= (locationOfWord + 1);
      }
      if (dialogue.indexOf("me") != -1){
        int locationOfWord = dialogue.indexOf("me");
        response = response.substring(0, locationOfWord) + "you" + dialogue.substring(locationOfWord + 3);
        charactersLeft -= (locationOfWord + 2);
      }
      if (dialogue.indexOf("am") != -1){
        int locationOfWord = dialogue.indexOf("am");
        response = response.substring(0, locationOfWord) + "are" + dialogue.substring(locationOfWord + 4);
        charactersLeft -= (locationOfWord + 2);
      }
      if (dialogue.indexOf("you") != -1){
        int locationOfWord = dialogue.indexOf("you");
        response = response.substring(0, locationOfWord) + "I" + dialogue.substring(locationOfWord + 1);
        charactersLeft -= (locationOfWord + 3);
      }
      if (dialogue.indexOf("my") != -1){
        int locationOfWord = dialogue.indexOf("my");
        response = response.substring(0, locationOfWord) + "your" + dialogue.substring(locationOfWord + 4);
        charactersLeft -= (locationOfWord + 2);
      }
      if (dialogue.indexOf("your") != -1){
        int locationOfWord = dialogue.indexOf("your");
        response = response.substring(0, locationOfWord) + "my" + dialogue.substring(locationOfWord + 2);
        charactersLeft -= (locationOfWord + 4);
      }

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