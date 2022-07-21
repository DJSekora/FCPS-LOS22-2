/* This file contains an example of how you might start a ChatBot project.

   Tips:
    - Keep the chatbot in control of the conversation. It's much easier to
      parse answers to direct questions than it is to parse general English.
    - Draw a flowchart of what you want the conversation to look like before
      you try to put it into code. This way, you have a clear plan!
    - As always, save and compile frequently. Test your code periodically to
      make sure the branches work the way you expect.
 */
import java.util.Scanner;
public class ChatBot
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hi, I'm ChatBot9000, what's your name?");
        String name = input.nextLine();
        
        // Optional: give a title to the person you're speaking to
        name = name + " the Great";
        
        System.out.println(name + "? That's a pretty name!");
        
        // Notice how we keep the conversation moving on our terms
        System.out.println("Do you like dogs, " + name + "?");
        
        // We can save an input in lower case right away if we know that we'll
        // never need the original version
        String likesDogs = input.nextLine().toLowerCase();
        
        // Make use of our smart ways to check for "yes"
        //   Remember that || means OR
        if(likesDogs.contains("ye") || likesDogs.startsWith("you bet") || likesDogs.equals("affirmative"))
        {
            System.out.println("What's your favorite breed?");
            // Conversation can continue from here
        }
        // This is where the "likes dogs" branch rejoins the rest of the code
        
        
        // Example of how to add a delay: this waits 1000 ms = 1s
        try
        {
          Thread.sleep(1000);
        }
        catch(Exception e){}
        
        System.out.println("Sorry, I was sleeping. What did I miss?");
    }
}