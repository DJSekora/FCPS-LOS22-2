/* This program demonstrates a while loop */
import java.util.Scanner;
public class Loops
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter password:");
    
    String password = input.nextLine();
    
    // Repeats all code in the brackets as long as condition is true
    while(!password.equals("123"))
    {
      System.out.println("Incorrect, please try again!");
      password = input.nextLine();
    }
    System.out.println("You got the password! Congratulations!");
  }
}