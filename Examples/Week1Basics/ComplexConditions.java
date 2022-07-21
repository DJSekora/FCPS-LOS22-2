/* This file contains examples of how to form more complex boolean expressions
   using three different operators:
    &&  AND (ampersand, located on the 7 key)
    ||  OR  (vertical bar, located on the backslash key)
    !   NOT (exclamation point/bang, located on the 1 key)
 */
public class ComplexConditions
{
  public static void main(String[] args)
  {
    System.out.println("AND:");
    System.out.println(true && true);
    System.out.println(true && false);
    System.out.println(false && true);
    System.out.println(false && false);
    System.out.println();
    
    System.out.println("OR:");
    System.out.println(true || true);
    System.out.println(true || false);
    System.out.println(false || true);
    System.out.println(false || false);
    System.out.println();
    
    System.out.println("NOT:");
    System.out.println(!(true));
    System.out.println(!(false));
    
    // Example of more complicated usage from here to the end:
    int x = 5;
    int y = 7;
    boolean p = (x < y); // true if x is less than y, false otherwise
    boolean q = (x == 5); // true if x is equal to 5, false otherwise
    
    // This condition is logically equivalent to p XOR q
    if((p && !q) || (!p && q))
    {
      System.out.println("In!");
    }
    else
    {
      System.out.println("Out!");
    }
  }
}