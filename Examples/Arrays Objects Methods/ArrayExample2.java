/* Another way to create an array. This one is actually the more common
   way, because you usually don't know all of the elements at the time you
   make the array, or you don't want to enter them all manually.
 */
public class ArrayExample2
{
  public static void main(String[] args)
  {
    // Another way to make an array. Put the length you want in the brackets
    int[] nums = new int[5];
    
    // Default for ints is 0
    System.out.println(nums[4]);
    
    // We can set the entries manually, or with a loop:
    for(int i=0; i<nums.length; i++)
    {
      nums[i] = i*i;
    }
    
    System.out.println(nums[4]);
  }
}