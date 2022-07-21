/* Description: This file describes how to go to the next line when
 * printing out text, and also shows
 *
 * Written by: David Sekora
 */

public class NewlinesAndDelay
{
  public static void main(String[] args)
  {
    // We can print new lines with additional print statments
    System.out.println("I like pie");
    System.out.println(); // no input = blank line
    System.out.println("Cake is ok too");
    
    // Or we can do it like this with an escape character:
    System.out.println("I like pie\n\nCake is ok too");
    
    // The backslash \ indicates that the next character is a special
    // command. This means that it's more difficult if we actually want
    // to print out the backslash \ character: we need TWO!
    System.out.println("\\");
    
    // This waits 1000ms = 1s
    // Don't worry about the weird new syntax for now!
    try
    {
      Thread.sleep(1000);
    }
    catch(Exception e){}
    
    System.out.println("This will print after 1 second");
  }
}