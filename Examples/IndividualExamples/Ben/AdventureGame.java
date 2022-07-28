import java.util.Scanner;
public class AdventureGame
{
  public static void main(String[] args)
  {
    /* Set up variables here */
    Player player;
    Scanner scan = new Scanner(System.in);
    
    // We put player initialization in a helper method since it's a long process
    player = initializePlayer(scan);
    
    player.giveItem(new HealthPotion("Small Health Potion", 3, 10));
    
    // Once our player is ready, we can begin
    
    enemyEncounter(scan, player, new Enemy("Weak Goblin", 10, 5, 5), "the forest");
    
    player.optionsMenu(scan);
  }
  
  // Write helper methods so you don't cram so many things into the main method
  // Make sure to pass in any data we need (we pass in the scanner for example)
  public static Player initializePlayer(Scanner scan)
  {
    System.out.println("What is your name?");
    String name = scan.nextLine();
    
    // Do stuff to pick stats here
    
    // Hardcoded numbers for stats for now, but replace these with whatever you
    // pick above.
    return new Player(name, 8, 9, 6, 12, 7, 10);
  }
  
  public static void enemyEncounter(Scanner scan, Player player, Enemy enemy, String location)
  {
    System.out.println("You encounter a " + enemy.name + " in " + location + "! Would you like to fight? (y/n)");
    String response = scan.nextLine().toLowerCase();
    
    if(response.startsWith("y"))
    {
      while(enemy.isAlive() && player.isAlive())
      {
        player.fightEnemy(enemy);
      }
    }
  }
}