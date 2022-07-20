/* Here we'll demonstrate more variable types other than
   byte short int long
 */
public class MoreVariables
{
  public static void main(String[] args)
  {
    // Floating point numbers (approximations of rational numbers)
    // double is the default, so you need the f to force 32-bit
    float x = 3.1f; // 32 bit (1 23 8)
    double y = 3.1; // 64 bit (1 52 11)
    
    // Store a single character (in this case the letter 'a')
    char c = 'a';
    
    // Stores true or false
    boolean b = true;
    
    // Prints... 98? Why? Mystery! Find out next time!
    System.out.println(c + 1);
  }
}