/* Show some other things you can do with Strings, including:
    - How to convert a String to lowercase
    - Three different ways to check String equality without case sensitivity
    - startsWith() and contains() methods to give us a greater ability to
      parse input (so we can, for example, check for any String starting with
      "ye" instead of individually testing for "yes", "yeah", "yea", etc.
 */
import java.util.Scanner;
public class MoreStringStuff
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Do you like pie?");
    
    String text = input.nextLine();
    
    // toLowerCase returns a copy of the String, but with all of the UPPERCASE
    // letters converted to lowercase.
    String lc = text.toLowerCase();
    
    // Checking to see if two strings are the same WITHOUT case sensitivity
    // (e.g. "yes" and "YES" should be considered equal)
    /*
    // Shorter way
    if(text.equalsIgnoreCase("yes"))
    {
      System.out.println("Cool me too");
    }
    else
    {
      System.out.println("Yeah me neither");
    }
    
    // Slightly longer way
    if(lc.equals("yes"))
    {
      System.out.println("Cool me too");
    }
    else
    {
      System.out.println("Yeah me neither");
    }
    
    // Bad way don't do
    if(text.equals("yes") || text.equals("YES") || text.equals("Yes"))
    {
      System.out.println("Cool me too");
    }
    else
    {
      System.out.println("Yeah me neither");
    }
    */
    
    // Check for yes, yeah, yea, ye, yep, yeet, yes absolutely
    // Make sure to use the lowercase version because there is no
    // startsWithIgnoreCase or charAtIgnoreCase!
    if(lc.startsWith("ye"))
    {
      System.out.println("Cool me too");
    }
    else
    {
      System.out.println("Yeah me neither");
    }
    // If we just want to check the first character we can do this:
    if(lc.charAt(0) == 'y')
    {
      System.out.println("Cool me too");
    }
    else
    {
      System.out.println("Yeah me neither");
    }
    
    // If we want to see if yes appears anywhere in the String
    // ("I think yes" or "The answer is yes" etc.):
    if(lc.contains("yes"))
    {
      System.out.println("Cool me too");
    }
    else
    {
      System.out.println("Yeah me neither");
    }
    // Watch out for "Not yes" or "yes but actually no"
  }
}