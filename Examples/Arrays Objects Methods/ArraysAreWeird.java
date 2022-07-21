public class ArraysAreWeird
{
  public static void main(String[] args)
  {
    // Experiment 1
    int x = 4;
    int y = x;
    x = 7;
    System.out.println(x); // prints 7
    System.out.println(y); // prints 4
    // Conclusion: x and y are not linked

    // Experiment 2
    int[] a = new int[]{4,5,6};
    int[] b = a;
    a[2] = 47;
    System.out.println(a[2]); // Prints 47
    System.out.println(b[2]); // Prints 47
    // Conclusion: a and b point at the same array in memory
    // There is only ONE copy of the array! a and b hold references.
    // Proof of claim: The following two statements print the same location
    System.out.println(a);
    System.out.println(b);
    
    // Experiment 3
    a = new int[]{7, 5, 12};
    System.out.println(a[2]); // Prints 12
    System.out.println(b[2]); // Prints 47
    // Conclusion: A new array has been created in memory, so a and b are
    // now pointing at different arrays that can be changed separately.
    
    // If we do this, the original array {4, 5, 47} will no longer
    // have any references to it, so will be removed by garbage collection
    b = new int[]{8, 8, 8};
  }
}