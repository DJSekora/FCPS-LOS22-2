/* Subclass of Item so we can store Armor objects in the bag */
public class Armor extends Item
{
  public int defense;
  public Armor(String armorName, int armorDef)
  {
    super(armorName);
    defense = armorDef;
    type = Item.ARMOR;
  }
}