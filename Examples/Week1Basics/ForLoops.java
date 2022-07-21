public class ForLoops
{
  public static void main(String[] args)
  {
    // i++ increases the stored value of i by 1
    // equivalent to i = i+1;
    //  initialization  condition  iteration
    for(int i=0;        i<10;      i++)
    {
      // body
      System.out.println(i);
    }
    
    // The iteration step can be anything, including increasing
    // by a different amount:
    for(int i=0; i<=10; i += 2)
    {
      System.out.println(i);
    }
    
    // It's common to use i as the index for characters in a String:
    String david = "David Sekora";
    for(int i=0; i<david.length(); i += 2)
    {
      System.out.print(david.charAt(i));
    }
    // Every other character in the String is printed!
  }
}