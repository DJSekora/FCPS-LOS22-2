/* An example of creating a particular type of consumable object.
   This one represents a potion that can be drunk to recover health.
 */
public class HealthPotion extends Consumable
{
  int healingPower;
  
  public HealthPotion(String itemName, int itemQuantity, int power)
  {
    super(itemName, itemQuantity);
    healingPower = power;
  }
  
  public void use(Player player)
  {
    super.use(player);
    player.recoverHealth(healingPower);
  }
}