/* Manage all of the player stuff in this class */
import java.util.ArrayList;
import java.util.Scanner;
public class Player extends Entity
{
  // List of properties the player has
  int strength;
  int dexterity;
  int constitution;
  int intelligence;
  int wisdom;
  int charisma;
  
  
  
  Weapon equippedWeapon;
  Armor equippedArmor;
  
  ArrayList<Item> inventory;
  
  // Constructor - initialize all the properties of the player
  // Usage example: Player p = new Player("John", 8, 9, 6, 12, 7, 10);
  public Player(String playername, int str, int dex, int con, int intel, int wis, int cha)
  {
    // Max health is currently always 20, feel free to put a different formula in here
    super(playername, 20);
    strength = str;
    dexterity = dex;
    constitution = con;
    intelligence = intel;
    wisdom = wis;
    charisma = cha;
    
    // Make sure to do any required setup for other variables
    equippedWeapon = new Weapon("Dull Knife", 1);
    equippedArmor = new Armor("Tattered Clothes", 1);
    
    inventory = new ArrayList<Item>();
  }
  
  // Returns how much attack power the player has with his stats and weapon
  // Feel free to make your own formula, this is just a starting point
  // (I assume you will want to do some dice rolls here if it's DnD)
  public int getAttack()
  {
    int attack = strength;
    if(equippedWeapon != null)
    {
      attack += equippedWeapon.power;
    }
    return attack;
  }
  
  // Same as getAttack, but with defense and armor.
  public int getDefense()
  {
    int defense = strength;
    if(equippedArmor != null)
    {
      defense += equippedArmor.defense;
    }
    return defense;
  }
  
  // One round of combat with enemy
  public void fightEnemy(Entity enemy)
  {
    int playerDamageDealt = launchAttack(enemy);
    int playerDamageTaken = enemy.launchAttack(this); // "this" means "the current Player object"
    
    System.out.println(name + " attacked " + enemy.name + " with " + equippedWeapon.name + ". It dealt " + playerDamageDealt + " damage.");
    System.out.println(enemy.name + " attacked " + name + ". It dealt " + playerDamageTaken + " damage.");
  }
  
  public void equipWeapon(Weapon weapon)
  {
    equippedWeapon = weapon;
  }
  
  public void equipArmor(Armor armor)
  {
    equippedArmor = armor;
  }
  
  public void optionsMenu(Scanner scan)
  {
    System.out.println("What would you like to do?");
    String option = scan.nextLine().toLowerCase();
    if(option.startsWith("show bag"))
    {
      displayBag();
    }
  }
  
  public void displayBag()
  {
    for(int i=0; i<inventory.size(); i++)
    {
      System.out.println(inventory.get(i));
    }
  }
  
  public void giveItem(Item item)
  {
    inventory.add(item);
  }
}