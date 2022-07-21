/* This program plays a game of Mad Libs with the user. It begins by prompting
   the user for several words and phrases. It stores those inputs into
   variables, then uses them to fill in the blanks of a story and produce
   a wacky output.
 */
import java.util.Scanner;
public class MadLibsExample
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter a person's name:");
    String name1 = input.nextLine();
    
    System.out.println("Enter a past tense verb:");
    String pastverb = input.nextLine();
    
    System.out.println("Enter an adjective:");
    String adjective1 = input.nextLine();
    
    System.out.println("Enter another adjective:");
    String adjective2 = input.nextLine();
    
    System.out.println("Enter another person's name:");
    String name2 = input.nextLine();
    
    System.out.println("Enter a plural noun:");
    String pluralnoun = input.nextLine();
    
    System.out.println(name1 + " and " + name2 + " were the best of " + pluralnoun + ".");
    System.out.println("They " + pastverb + " everywhere together.");
    System.out.println("Their friendship was " + adjective1 + ", and " + name1 +
                       " felt " + adjective2 + " about it.");
                       // Note how we can split this up onto multiple lines if we need to
  }
}