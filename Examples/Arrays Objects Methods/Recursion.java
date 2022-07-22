/* Recursion demonstrates the principle of recursion.
   
   Jokes aside: recursion is when a method calls itself, or more generally
   when a chain of methods contains a cycle (e.g. 1 -> 2 -> 3 -> 1 -> 2 ...).
   
   If you aren't careful, it's easy to get into an infinite loop (which
   typically leads to a stack overflow error). But, as long as you write your
   termination conditions sensibly, you can use recursion to do anything a
   loop can do.
   
   Recursion isn't any more powerful than loops in terms of what can be
   computed. But, some problems are more naturally expressed via recursion
   than via a loop.
 */
public class Recursion
{
  public static void main(String[] args)
  {
    
  }
  
  // Self-recursive infinite loop
  public static void myMethod()
  {
    System.out.println("HELP");
    myMethod();
  }
  
  // Infinite loop of calls between myMethod2 and myMethod3
  public static void myMethod2()
  {
    System.out.println("Marco!");
    myMethod3();
  }
  
  public static void myMethod3()
  {
    System.out.println("Polo!");
    myMethod2();
  }
}