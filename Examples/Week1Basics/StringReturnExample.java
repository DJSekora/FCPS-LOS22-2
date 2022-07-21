/*
   A quick example of one way to use the toLowerCase method

   .toLowerCase (and other string methods) don't actually modify the
   original String. Instead, they "return" a value, which means that they
   can be thought of as a function that outputs the value. The original
   String will be untouched, unless we explicitly overwrite it
   (example: name = name.toLowerCase() will do this overwrite).
   
   Sometimes, it's ok or desirable to overwrite the original String.
   But other times, we want to both keep the original String and a
   modified version. In this case, we will need another String
   variable to hold the modified version. Otherwise, we would have
   to re-process the String every time we wanted the lower case
   version.
 */
public class StringReturnExample
{
  public static void main(String[] args)
  {
    // Example String for demonstration. In a real scenario, you would
    // probably get this from user input.
    String name = "Johnathan";
    
    // Store the lower case version of the name so we don't have to do those
    // operations multiple times
    String lowerCaseName = name.toLowerCase();
    
    // There is an equalsIgnoreCase method, but no containsIgnoreCase method,
    // so this is the best solution.
    if(lowerCaseName.contains("john") || lowerCaseName.contains("jim"))
    {
      System.out.println("Found him!");
    }
    
    System.out.println(name);
  }
}