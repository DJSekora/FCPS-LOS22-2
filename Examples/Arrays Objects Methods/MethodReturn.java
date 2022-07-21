/* Methods can also have output. The output data is called the 'return value'.
   
   A method can only return one value, so if you want to return multiple pieces
   of information you will need to use an array or an object.
 */
public class MethodReturn
{
  public static void main(String[] args)
  {
    // We can use add2 anywhere we could use an int variable or constant
    int y = add2(7);
    
    System.out.println(y);
    System.out.println(add2(27));
    System.out.println(add2(y));
    System.out.println(y);
    
    System.out.println(add2(3, 5));
    
    // You can access public static methods from other files in the same folder:
    MethodsIntro.hiRoutine();
    // Also works for all imported classes:
    System.out.println(Math.sin(Math.PI/2)); // Math is always imported
  }
  
  // The int here instead of void means that the method 'returns' an int.
  public static int add2(int y)
  {
    return y + 2;
  }
  
  // You can have any number of parameters/arguments (inputs)
  // But, you can only have 1 return value (output)
  public static int add(int x, int y)
  {
    return x + y;
  }
  
  // If you want to return multiple values, use an array or an object:
  public static int[] add2(int x, int y)
  {
    return new int[]{x + 2, y + 2};
  }
  // Note that we can have multiple methods with the same name, as long as
  // we have different parameter numbers or types
  
  // public static void add2(String text){} // this one would be ok
  // public static void add2(int x){} // this one will throw an error already defined
}