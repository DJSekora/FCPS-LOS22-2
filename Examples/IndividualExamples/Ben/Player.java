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
  
  // Current equipment
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
    int attack = strength/2;
    if(equippedWeapon != null)
    {
      attack += equippedWeapon.power;
    }
    return attack;
  }
  
  // Same as getAttack, but with defense and armor.
  public int getDefense()
  {
    int defense = dexterity/3;
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
  
  /* Equip the Weapon passed in here. Unequip and return the previously
     equipped Weapon.
   */
  public Weapon equipWeapon(Weapon toEquip)
  {
    Weapon toReturn = equippedWeapon;
    equippedWeapon = toEquip;
    return toReturn;
  }
  
  public Armor equipArmor(Armor toEquip)
  {
    Armor toReturn = equippedArmor;
    equippedArmor = toEquip;
    return toReturn;
  }
  
  public void optionsMenu(Scanner scan)
  {
    System.out.println("What would you like to do?");
    System.out.println("(Options: bag, use, equip, status, quit)");
    
    String option = scan.next().toLowerCase();
    if(option.startsWith("bag"))
    {
      displayBag();
      scan.nextLine();
    }
    else if(option.startsWith("use"))
    {
      int index = promptForBagIndex(scan, "use", Item.CONSUMABLE);
      
      if(index > -1)
      {
        // inventory contains Item objects, so we need to tell it that this
        // specific object is definitely a Consumable.
        Consumable itemToUse = (Consumable)inventory.get(index);
        
        itemToUse.use(this); // this passes in the current player object
        
        System.out.println("Used 1 " + itemToUse.name);
        
        // Remove the item from the list if we used the last one
        if(itemToUse.quantity <= 0)
        {
          inventory.remove(index);
        }
      }
    }
    else if(option.startsWith("equip"))
    {
      System.out.println("Would you like to equip (w)eapons or (a)rmor?");
      option = scan.next();
      if(option.startsWith("w"))
      {
        int index = promptForBagIndex(scan, "equip", Item.WEAPON);
        if(index > -1)
        {
          Weapon previouslyEquipped = equipWeapon((Weapon)inventory.get(index));
          if(previouslyEquipped != null)
          {
            inventory.set(index, previouslyEquipped);
          }
        }
      }
      else // if not weapons, must be armor currently
      {
        int index = promptForBagIndex(scan, "equip", Item.ARMOR);
        if(index > -1)
        {
          Armor previouslyEquipped = equipArmor((Armor)inventory.get(index));
          if(previouslyEquipped != null)
          {
            inventory.set(index, previouslyEquipped);
          }
        }
      }
    }
    else if(option.startsWith("status"))
    {
      displayStatus();
    }
    else if(option.startsWith("quit"))
    {
      System.exit(0);
    }
    System.out.println();
  }
  
  /* Helper method re-used when selecting consumables, weapons, and armor from
     the inventory.
   */
  public int promptForBagIndex(Scanner scan, String verb, int itemType)
  {
    System.out.println("Items available to " + verb +":");
    displayItemsOfType(itemType);
    System.out.println("Enter the index of the item you would like to " + verb + ":");
    int index = scan.nextInt();
    scan.nextLine();
    
    if(index < 0 || index >= inventory.size())
    {
      System.out.println("Invalid bag slot selected.");
    }
    else if(!(inventory.get(index).type == itemType))
    {
      System.out.println("That item cannot be used.");
    }
    else // We get here if they entered a valid index
    {
      return index;
    }
    return -1;
  }
  
  public void displayBag()
  {
    for(int i=0; i<inventory.size(); i++)
    {
      System.out.println(i + ": " + inventory.get(i));
    }
  }
  
  /* Helper method used to display all items matching the entered type */
  public void displayItemsOfType(int type)
  {
    for(int i=0; i<inventory.size(); i++)
    {
      if(inventory.get(i).type == type)
      {
        System.out.println(i + ": " + inventory.get(i));
      }
    }
  }
  
  public void giveItem(Item item)
  {
    inventory.add(item);
  }
  
  public void displayStatus()
  {
    System.out.println("Health: " + currentHealth + "/" + maxHealth);
    System.out.println("Stats:");
    System.out.println(" Strength:     " + strength);
    System.out.println(" Dexterity:    " + dexterity);
    System.out.println(" Constitution: " + constitution);
    System.out.println(" Intelligence: " + intelligence);
    System.out.println(" Wisdom:       " + wisdom);
    System.out.println(" Charisma:     " + charisma);
    System.out.println("Equipment:");
    System.out.println(" Weapon: " + equippedWeapon);
    System.out.println(" Armor:  " + equippedArmor);
    System.out.println("Combat stats:");
    System.out.println(" Attack:  " + getAttack());
    System.out.println(" Defense: " + getDefense());
  }
  
  public void enemyEncounter(Scanner scan, Enemy enemy, String location)
  {
    System.out.println("You encounter a " + enemy.name + " in " + location + "! Would you like to fight? (y/n)");
    String response = scan.nextLine().toLowerCase();
    
    if(response.startsWith("y"))
    {
      while(isAlive() && enemy.isAlive())
      {
        fightEnemy(enemy);
      }
      if(!isAlive())
      {
        die();
      }
      else
      {
        defeatedEnemy(enemy);
      }
    }
  }
  
  public void die()
  {
    System.out.println("You died!");
  }
  
  public void defeatedEnemy(Enemy enemy)
  {
    System.out.println(enemy.name + " has been defeated!");
    
    // Do anything else you want to happen when you defeat an enemy like gaining loot, gaining xp points, etc. here
    enemy.transferDropItems(inventory);
    System.out.println();
  }
}