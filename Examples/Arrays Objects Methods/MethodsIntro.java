/* Demonstrates how to declare (create) and call (use) methods */
public class MethodsIntro
{
   public static void main(String[] args)
   {
      // This is how we 'call' a method
      hiRoutine(); 
      hiRoutine();
      
      System.out.println("Great weather huh?");
      
      hiLoop(3);
   }
   
   // This is a method (sometimes called a function, subroutine, or subprogram)
   // It's a piece of code with a name that we can call on command
   // Notice how we don't have to define it before we call it
   public static void hiRoutine()
   {
      System.out.println("Hi");
      System.out.println("How are you?");
      System.out.println("Have a nice day!");
   }
   
   // We can pass information into methods like this.
   // 'int amount' indicates that we have put an integer in when we call the
   // method, and the name of that integer during the method will be 'amount'
   public static void hiLoop(int amount)
   {
      for(int i=0; i<amount; i++)
      {
         hiRoutine();
      }
   }
}