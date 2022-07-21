public class ForVSWhile
{
  public static void main(String[] args)
  {
    // This proves that while loops are at least as powerful as for loops:
    for(int i=0; i<10; i++)
    {
      System.out.println(i);
    }
    
    // Recreate the above using only a while loop and other code:
    {
      int i=0;
      while(i < 10)
      {
        System.out.println(i);
        i++; // alternatively: i = i+1
      }
    }
    
    // This proves that for loops are at least as powerful as while loops:
    /*
    while(condition)
    {
      body
    }
    
    for(;condition;)
    {
      body
    }
    */
    
    // Conclusion: they are equally powerful!
    // for loops we tend to use 
  }
}