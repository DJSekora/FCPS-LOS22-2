/* FILLED-IN INSTRUCTOR GUIDE

   This class is an implementation of an ArrayList, a data structure similar
   to an array but that has several nice features (such as automatic resizing
   to accommodate extra information and an "add" method that adds a piece
   of information to the end of the array).
   
   The functionality of this is very similar to (a restricted version of) the
   built in ArrayList class from java.util.ArrayList.
 */
public class MyArrayList
{
  // Store the actual data. For now, we can only use this to store Strings.
  private String[] array;
  
  // How many of the slots are currently filled
  // Private because we don't want it to be modified anywhere else
  private int length;
  
  // Constructor
  // tells us how to initialize the data structure for an empty list
  public MyArrayList()
  {
    // default to 10 slots to start
    array = new String[10];
    
    // When you first make the array list, there is nothing in it. So, the
    // length should be 0.
    length = 0;
  }
  
  // Alternate constructor
  // allows us to convert an existing array into a MyArrayList object
  // we should copy over each element individually, so don't do this:
  //     array = inputArray;
  // That would be bad, because then the array backing this ArrayList might
  // change without us knowing.
  public MyArrayList(String[] inputArray)
  {
    array = new String[inputArray.length];
    for(int i=0; i<inputArray.length; i++)
    {
      array[i] = inputArray[i];
    }
  }
  
  /* Retrieves and returns the element at position 'index' */
  public String get(int index)
  {
    // Make sure the index is valid
    // (we don't need to check negative numbers since the array itself will
    //  already throw the appropriate exception for us)
    if(index >= length)
    {
      throw new ArrayIndexOutOfBoundsException("Index: " + index + "  Size: " + size());
    }
    return array[index];
  }
  
  /* Add the specified element to the end of the array.
     Automatically resizes the array if it runs out of space by doubling
     the amount of available slots.
   */
  public void add(String toAdd)
  {
    // If we are out of space, double the capacity
    resizeIfNeeded();
  
    // Add the new item to the end
    array[length] = toAdd;
    
    // Update where the end is
    length++;
  }
  
  /* A helper method we use to avoid having to copy-paste all the array
     resizing code, since we need it in multiple methods (add and insert)
   */
  private void resizeIfNeeded()
  {
    if(length >= array.length)
    {
      String[] temp = new String[2*array.length];
      // Copy over all of the old stuff
      for(int i=0; i<array.length; i++)
      {
        temp[i] = array[i];
      }
      // Update array to point to our new improved one
      array = temp;
    }
  }
  
  /* Overwrite the data in slot 'index' of the array.
     Throws an exception if the index is negative or greater than the length
  */
  public void set(int index, String toAdd)
  {
    // Again, we make sure the index is valid (copied and pasted from get)
    if(index >= length)
    {
      throw new ArrayIndexOutOfBoundsException("Index: " + index + "  Size: " + size());
    }
    array[index] = toAdd;
  }
  
  /* Return the number of elements stored in the array
     not counting the blank slots
   */
  public int size()
  {
    return length; // This is why we have been maintaining the length variable
  }
  
  /* Delete the item at the specified index.
     All entries after that index will be shifted by 1,
     and the length will be decreased by 1 to accurately
     reflect the number of elements.
   */
  public void remove(int index)
  {
    if(index >= length)
    {
      throw new ArrayIndexOutOfBoundsException("Index: " + index + "  Size: " + size());
    }
    for(int i=index; i<length-1; i++)
    {
      // Shift everything after index to the left
      array[i] = array[i+1];
    }
    length--;
  }
  
  /* Add the specified element to the beginning of the list */
  public void addToFront(String toAdd)
  {
    // Make the array bigger if we're at capacity already
    resizeIfNeeded();
    
    // Scoot everything else over
    for(int i=size(); i>0; i--)
    {
      array[i] = array[i-1];
    }
    
    // Add the actual element we wanted to add.
    array[0] = toAdd;
  }
  
  /* Remove everything from the list */
  public void removeAll()
  {
    // Option 1: Remove the end repeatedly until everything has been removed.
    while(size() > 0)
    {
      remove(length-1);
    }
    
    // The following would also work; it would be much more efficient but is
    // less resilient to changes in other parts of the code:
    /*array = new int[10];
    length = 0;*/
  }
  
  /* Insert a String at the specified position.
     The String previously at that location is
     shifted forward one slot, along with everything
     after it.
   */
  public void insert(int index, String toAdd)
  {
    // Use our helper method since we already wrote all the code for the
    // add method - no need to do resizing from scratch again!
    resizeIfNeeded();
    
    // Shift everything from index onwards one slot to the right, to 
    // make room for the new thing we want to insert.
    // (We have to do this FIRST, otherwise we would forget what was
    //  previously stored in array[index]).
    for(int i=length; i > index; i--)
    {
      array[i] = array[i-1];
    }
    
    // Add the actual element we wanted to add.
    array[index] = toAdd;
  }
}