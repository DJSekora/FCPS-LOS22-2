import java.util.ArrayList;
public class Enemy extends Entity
{
  // For now, enemies have fixed attack and defense values
  int attack;
  int defense;
  
  // The list of items that can be dropped
  // For now, all items are dropped on death. In the future, you can add a random system
  ArrayList<Item> dropsOnDeath;
  
  public Enemy(String enemyName, int enemyHealth, int enemyAttack, int enemyDefense)
  {
    super(enemyName, enemyHealth);
    attack = enemyAttack;
    defense = enemyDefense;
    
    dropsOnDeath = new ArrayList<Item>();
  }
  
  public void addDropItem(Item item)
  {
    dropsOnDeath.add(item);
  }
  
  // getAttack and getDefense methods for consistency with player syntax
  public int getAttack()
  {
    return attack;
  }
  
  public int getDefense()
  {
    return defense;
  }
  
  public void transferDropItems(ArrayList<Item> target)
  {
    for(int i=0; i<dropsOnDeath.size(); i++)
    {
      target.add(dropsOnDeath.get(i));
    }
  }
}

// Preset enemy types can go here for convenience
class EnemyPresets
{
  public static Enemy generateWeakGoblin()
  {
    // Make the Enemy object
    Enemy enemy = new Enemy("Weak Goblin", 10, 5, 2);
    
    // Set up loot drops, if any
    enemy.addDropItem(new Weapon("Goblin Sword", 2));
    return enemy;
  }
}