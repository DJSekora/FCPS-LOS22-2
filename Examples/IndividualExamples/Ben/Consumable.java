/* This represents an item that has a fixed number of uses.
   Again, don't actually create an object of type Consumable. Instead, extend
   the class Consumable and give it the behavior you want.
 */
public abstract class Consumable extends Item
{
  public int quantity;
  public Consumable(String itemName, int itemQuantity)
  {
    super(itemName);
    quantity = itemQuantity;
    type = Item.CONSUMABLE;
  }
  
  // When you extend Consumable, make sure to override this method with actual behavior
  public void use(Player player)
  {
    quantity--;
  }
  
  public String toString()
  {
    return name + " x" + quantity;
  }
}