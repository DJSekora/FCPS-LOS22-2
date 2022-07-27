/* The beginning of a more sophisticated testing framework for MyArrayList.
   A core idea here is that we want to test rigorously, but only want to print
   what we need to.
   
   Consider what happens when you compile a program. If there were no errors,
   the compiler says nothing. We are abiding by the same principle for the
   most part - if the code has the expected behavior, we don't need to print
   anything in our tests. This way, we can quickly tell if anything is wrong
   and what that thing is.
   
   You also want to try to test each piece of your code individually, if
   possible. There are some core pieces of most programs that are required
   to make any functionality possible (in our example, it's difficult to test
   get in a way that doesn't use add), but once you have those core pieces
   try to find ways to test that will let you quickly figure out where the
   error lies (this usually involves isolating individual components of your
   code as much as possible).
   
   This file contains examples of how to test out the add and get methods.
   I encourage you to try writing tests for some of the other methods on your
   own!
 */
public class MyArrayListTester
{
  public static void main(String[] args)
  {
    testAddAndSize();
    testGet();
  }
  
  public static void testAddAndSize()
  {
    MyArrayList test = new MyArrayList();
    
    // Adding 100 Strings makes sure the resizing functions correctly.
    for(int i=0; i<100; i++)
    {
      test.add("Thing " + i);
    }
    
    if(test.size() != 100)
    {
      System.out.println("Size 100 expected. Actual size: " + test.size());
    }
  }
  
  public static void testGet()
  {
    MyArrayList test = new MyArrayList();
    String[] testStrings = new String[]{"AAAA","BBBB","CCCC"};
    
    // Add several elements in a row, using the convenience of arrays and loops
    for(int i=0; i<testStrings.length; i++)
    {
      test.add(testStrings[i]);
    }
    
    // Make sure that the things we added are actually at the correct positions
    // in the list
    for(int i=0; i<testStrings.length; i++)
    {
      if(!test.get(i).equals(testStrings[i]))
      {
        System.out.println("At position " + i + ", expected " + testStrings[i] + ", was " + test.get(i));
      }
    }
    
    // Negative numbers and numbers that are too large should throw an
    // ArrayIndexOutOfBoundsException. This is one way we can test to make
    // sure that happens:
    try
    {
      test.get(-1);
      
      // The previous line should have thrown an exception, which will end the
      // try block. If no exception is thrown, the try block will continue and
      // print this error message.
      System.out.println("No exception thrown for negative numbers.");
    }
    catch(ArrayIndexOutOfBoundsException e){}
    
    try
    {
      test.get(4);
      System.out.println("No exception thrown for numbers that are too large.");
    }
    catch(ArrayIndexOutOfBoundsException e){}
  }
}