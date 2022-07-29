/* Item is the parent class of Weapon, Armor, and Consumable.
   This is a class you won't need to actually make any objects of, but all of 
   the other types of Item should extend this class. */
public abstract class Item
{
  // Constants that tell us what type of item this is
  // (There are other ways to accomplish this, such as the instanceof keyword)
  // (but we haven't covered that in class)
  public static final int INVALID = 0;    // 0000
  public static final int CONSUMABLE = 1; // 0001
  public static final int WEAPON = 2;     // 0010
  public static final int ARMOR = 4;      // 0100

  public String name;
  
  // this should be set to one of the above constants in the constructor of each extending class
  public int type = 0;
  
  public Item(String itemName)
  {
    name = itemName;
  }
  
  public String toString()
  {
    return name;
  }
}