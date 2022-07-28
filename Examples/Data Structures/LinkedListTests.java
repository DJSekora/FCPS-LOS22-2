/* An example of how we could write a set of tests for our MyLinkedList method.
   In a real industry setting, you would probably have a specialized tool to
   streamline and standardize this process, but this is a good approximation of
   the types of thinking you need to employ.
   
   Good tests test a variety of cases, covering as much of the spectrum of
   possibility as is feasible. For example, if you have any reason to suspect
   that your program might behave differently for negative numbers than
   positive numbers, make sure to test some of each!
   
   In the world of data structures, two very important cases to consider are
    1. The case where the data structure is empty (e.g. no nodes in the list)
    2. The case where the data structure contains exactly one element (in
       a linked list, this means that the head and the tail should be the same)
   If you aren't careful, it's easy to make mistakes when trying to add the
   first element to an empty list or remove the last element from a list with
   one element.
*/
public class LinkedListTests
{
  public static void main(String[] args)
  {
    testAll();
  }
  
  public static void testAll()
  {
    testAddToHead();
    testAddToTail();
    testGets();
    testRemoveHead();
    testRemoveTail();
  }
  
  // Tests addToHead and size()
  public static void testAddToHead()
  {
    MyLinkedList list = new MyLinkedList();
    
    for(int i=0; i<100; i++)
    {
      if(list.size() != i)
      {
        System.out.println("size() incorrect after addToHead. Expected " + i + ", was " + list.size());
        break;
      }
      list.addToHead(i);
    }
  }
  
  // Tests addToTail and size()
  public static void testAddToTail()
  {
    MyLinkedList list = new MyLinkedList();
    
    for(int i=0; i<100; i++)
    {
      if(list.size() != i)
      {
        System.out.println("size() incorrect after addToHead. Expected " + i + ", was " + list.size());
        break;
      }
      list.addToTail(i);
    }
  }
  
  /* Tests the getHead and getTail methods in several scenarios
     We add some numbers to each of 3 different lists, and make sure that the
     head and tail have the correct values after each addition.
     The first list we always add to the head, the second list we always add to
     the tail, and the third list we alternate head and tail.
     (There are shorter ways to accomplish this kind of testing, but this one
      is serviceable.)*/
  public static void testGets()
  {
    int[] stuff = new int[]{-5, 9, 3, 8, 4, 66, -19, 3, 612123, 0};
    
    MyLinkedList list1 = new MyLinkedList();
    MyLinkedList list2 = new MyLinkedList();
    MyLinkedList list3 = new MyLinkedList();
    
    int item;
    
    for(int i=0; i<stuff.length; i++)
    {
      list1.addToHead(stuff[i]);
      item = list1.getHead();
      if(item != stuff[i])
      {
        System.out.println("Error with getHead after addToHead for list1. Expected " + stuff[i] + " was " + item);
        break;
      }
      
      item = list1.getTail();
      if(item != stuff[0])
      {
        System.out.println("Error with getTail after addToHead for list1. Expected " + stuff[0] + " was " + item);
        break;
      }
      
      
      list2.addToTail(stuff[i]);
      item = list2.getTail();
      if(item != stuff[i])
      {
        System.out.println("Error with getTail after addToTail for list2. Expected " + stuff[i] + " was " + item);
        break;
      }
      
      item = list2.getHead();
      if(item != stuff[0])
      {
        System.out.println("Error with getHead after addToTail for list2. Expected " + stuff[0] + " was " + item);
        break;
      }
      
      
      list3.addToHead(stuff[i]);
      list3.addToTail(stuff[i]);
      item = list3.getTail();
      if(item != stuff[i])
      {
        System.out.println("Error with getTail after addToHead and addToTail for list3. Expected " + stuff[i] + " was " + item);
        break;
      }
      
      item = list3.getHead();
      if(item != stuff[i])
      {
        System.out.println("Error with getHead after addToHead and addToTail for list3. Expected " + stuff[i] + " was " + item);
        break;
      }
    }
  }
    
  /* Writing tests for multiple methods at once can result in a lot of code
     (and the inability to test each one separately). So, we often like to
     split up our tests by method:
   */
  public static void testRemoveHead()
  {
    int[] stuff = new int[]{-5, 9, 3, 8, 4, 66, -19, 3, 612123, 0};
    int item;
  
    MyLinkedList list = new MyLinkedList();
    
    for(int i=0; i<stuff.length; i++)
    {
      list.addToHead(stuff[i]);
    }
    
    // test removing all but the last element
    for(int i=stuff.length-2; i>=0; i--)
    {
      list.removeHead();
      item = list.getHead();
      if(item != stuff[i])
      {
        System.out.println("Error with getHead after addHead and removeHead. Expected " + stuff[i] + ", was " + item);
        break;
      }
      item = list.getTail();
      if(item != stuff[0])
      {
        System.out.println("Error with getTail after addHead and removeHead. Expected " + stuff[i] + ", was " + item);
        break;
      }
    }
    
    // test removing the last element
    list.removeHead();
    if(list.size() != 0)
    {
      System.out.println("Error when removing last element with removeHead: size 0 expected, " + list.size() + " found.");
    }
    if(list.head != null)
    {
      System.out.println("Error when removing last element with removeHead: head is not null.");
    }
    if(list.tail != null)
    {
      System.out.println("Error when removing last element with removeHead: tail is not null.");
    }
  }
  
  public static void testRemoveTail()
  {
    int[] stuff = new int[]{-5, 9, 3, 8, 4, 66, -19, 3, 612123, 0};
    int item;
  
    MyLinkedList list = new MyLinkedList();
    
    for(int i=0; i<stuff.length; i++)
    {
      list.addToHead(stuff[i]);
    }
    
    int head = 0;
    
    // test removing all but the last element
    for(int i=1; i< stuff.length; i++)
    {
      list.removeTail();
      item = list.getHead();
      if(item != head)
      {
        System.out.println("Error with getHead after addHead and removeTail. Expected " + head + ", was " + item);
        return;
      }
      item = list.getTail();
      if(item != stuff[i])
      {
        System.out.println("Error with getTail after addHead and removeTail. Expected " + stuff[i] + ", was " + item);
        return;
      }
    }
    
    // test removing the last element
    list.removeTail();
    if(list.size() != 0)
    {
      System.out.println("Error when removing last element with removeTail: size 0 expected, " + list.size() + " found.");
    }
    if(list.head != null)
    {
      System.out.println("Error when removing last element with removeTail: head is not null.");
    }
    if(list.tail != null)
    {
      System.out.println("Error when removing last element with removeTail: tail is not null.");
    }
  }
}