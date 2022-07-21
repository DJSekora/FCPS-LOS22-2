/* This program plays a guessing game with the user!
   
   The computer picks a random number, then the user
 */

import java.util.Random;
import java.util.Scanner;
public class GuessingGame
{
  public static void main(String[] args)
  {
    // Pick a random number between 1 and 1000
    Random rng = new Random();
    
    // nextInt gives a number between 0 and 999 here, so need to add 1
    int number = rng.nextInt(1000) + 1;
    
    // Get a guess from the user
    Scanner scan = new Scanner(System.in);
    System.out.println("Guess a number between 1 and 1000:");
    int guess = scan.nextInt();
    
    // While guess is wrong, print message and get another guess
    while(guess != number)
    {
      // Pick message based on what they need to do
      if(guess < number)
      {
        System.out.println("higher");
      }
      else // dont need to check guess > number here because that's the only possibility left
      {
        System.out.println("lower");
      }
      guess = scan.nextInt();
    }
    
    System.out.println("Congratulations!");
  }
}