/* Basics of arrays */
public class ArrayExample
{
  public static void main(String[] args)
  {
    // Create an array and fill it with data
    // Must specify the type, so arrays can only hold one type of information
    String[] names = new String[]{"Daniel", "Kylar", "Ben", "Jay", "Kenneth",
                                  "Tyler", "Robin", "William"};
                                  
    // Access one piece of data (index starts at 0)
    System.out.println(names[3]);
    
    // Loops are useful to do an operation on every element of the array
    // names.length gives the number of elements in the array
    for(int i=0; i<names.length; i++)
    {
      // We can both modify and access elements
      names[i] = names[i] + " the great";
      System.out.println(names[i]);
    }
    
    // We can't change the size later without creating a new array.
    // This line will produce a runtime error because 30 is too big:
    //System.out.println(names[30]);
  }
}