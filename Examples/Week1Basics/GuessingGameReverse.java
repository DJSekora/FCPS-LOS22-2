/* Use Binary Search to play a guessing game with the user.
   The user picks a number, and the computer guesses it!
   (This is the opposite of GuessingGame.java)
   
   At each step, we divide the number of remaining possibilities by 2,
   hence the name "binary search"
   
   It takes log_2(highest - lowest) guesses in the worst case
   We call this "log time" (log means logarithm)
   
   Much better than "linear time"
    example: start at 0 and keep increasing by 1, this takes 512 guesses on average
    increases to 500000 if we use 1 million as our upper limit
    log time only increases to 20 guesses
 */
import java.util.Scanner;
public class GuessingGameReverse
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    
    int lowest = 0;
    int highest = 1024;
    
    int guess = (highest + lowest) /2;
    
    // We do highest-1 here because our routine rounds down
    System.out.println("Secretly pick a number between " + lowest + " and " + (highest-1));
    
    boolean wrong = true;
    
    while(wrong)
    {
      System.out.println("My guess is " + guess + ".");
      System.out.println("Is the real number equal, higher, or lower?");
      String response = scan.nextLine().toLowerCase();
      
      // If we get it wrong, update our bounds. New guess is the average.
      if(response.startsWith("hi"))
      {
        lowest = guess;
        guess = (lowest + highest)/2;
      }
      else if(response.startsWith("lo"))
      {
        highest = guess;
        guess = (lowest + highest)/2;
      }
      else
      {
        // If we got it right, trigger the end of the loop
        wrong = false;
      }
    }
    System.out.println("HAHAHA I GOT YOUR NUMBER");
  }
}