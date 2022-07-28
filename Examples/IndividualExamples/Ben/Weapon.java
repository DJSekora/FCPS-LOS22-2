/* Subclass of Item so we can store Weapon objects in the bag */
public class Weapon extends Item
{
  public int power;
  
  public Weapon(String weaponName, int weaponPower)
  {
    super(weaponName);
    power = weaponPower;
    type = Item.WEAPON;
  }
}