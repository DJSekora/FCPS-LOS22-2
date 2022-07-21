/* Example demonstrating char variables and newlines */
public class CharExample
{
  public static void main(String[] args)
  {
    // Use single quotes for characters
    char c = 'a';
    
    // This prints 'a' as expected
    System.out.println(c);
    
    /* This prints "98" instead of "b", because 1 is an integer.
       int is 32 bit, char is 16 bit, so when you add them together
       Java defaults to 32 bit for safety.
     */
    System.out.println(c + 1);
    
    // casting fixes this problem:
    System.out.println((char)(c + 1)); // This prints "b"
    
    // This is the long way to print multiple lines:
    System.out.println("Hi");
    System.out.println(); // blank line
    System.out.println("Class");
    
    // Faster way to print multiple lines: use \n for newline
    System.out.println("Hi\n\nClass");
    
    // Characters are 16 bit Unicode:
    // (Source code is generally saved in 8 bit ASCII though)
    // ((you can apparently put Unicode characters in your code and they
    //   will count as 2 bytes per character instead of 1 byte))
    // (((this may depending on the encoding of your source code file)))
    c = (char) 400;
    System.out.println(c);
  }
}