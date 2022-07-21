/* Description: This is a template for a Java program to read text input from
 * the user's command line.
 * Replace this description with a description of what YOUR program does!
 *
 * Written by: [YOUR NAME HERE]
 */

// 'import' means we need something extra in our program that isn't part of the
// default Java library.
// All imports go BEFORE the public class line
import java.util.Scanner;

public class UserInputTemplate
{
  public static void main(String[] args)
  {
    /* Initialize the Scanner to read command line input.
       A Scanner can be used for other sources of input instead of System.in,
       such as a file on your computer.
       This line only needs to be here one time*/ 
    Scanner input = new Scanner(System.in);
    
    // Print a message to the user prompting them for input
    System.out.println("Hello! What is your name?");
    
    // Retrieve the input and store it in a variable
    String name = input.nextLine();
    
    // Print a message to the user prompting them for input
    System.out.println("How old are you?");
    
    // Retrieve the input and store it in a variable
    String age = input.nextLine();
    
    // Use the input to print with concatenation
    System.out.println("Hi " + name + ", must be hard to be " + age);
  }
}