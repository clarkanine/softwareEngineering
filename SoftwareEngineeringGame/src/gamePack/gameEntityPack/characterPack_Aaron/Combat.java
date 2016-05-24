package characterPack;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat
{
	public static void main(String[] args)
	{
		int numAliveEnemies;
		ConcreteCharacter player;
		ArrayList<ConcreteCharacter> enemies;
		Scanner user = new Scanner(System.in);
		String again = "y";

		
		while( again.compareTo("y") == 0 )
		{
			
			player = new KnightCharacter("Player Knight");
			player.addWeapon(new BigStick());
			player.addWeapon(new GreatHammer());
			player.addWeapon(new BattleAxe() );
			player.addWeapon(new WeaponOfTheGods());
			

			enemies = new ArrayList<>();
			
			enemies.add( new KnightCharacter("attacking knight") );
			enemies.add( new KnightCharacter("defending knight") );
			enemies.add( new KnightCharacter("Worthless knight") );
			
			numAliveEnemies = enemies.size();
			
			player.addCombatState(new SingleTargetCombat(player, enemies));
			player.addCombatState(new AllTargetCombat(player, enemies));
			player.addCombatState(new ChangeWeapon(player, enemies));
			player.addCombatState(new Heal(player, enemies));
			
			while(true)
			{
				System.out.println(player.getName() + " has " + player.getHealth() + " health points");
				
				for(ConcreteCharacter c : enemies)
				{
					if(!c.isDead())
						System.out.println(c.getName() + " has " + c.getHealth() + " health points");
				}
				
				for(ConcreteCharacter c : enemies)
				{
					if(c.isDead() == true)
						numAliveEnemies--;
				}
				
				if(numAliveEnemies <= 0)
				{
					player.setState(new BattleWonState(player));
					break;
				}
				
				player.setState(new InitialCombatState(player, enemies));
				player.runState();
				
				enemies.get(0).attack(player);
				enemies.get(1).setDefense(15);
				
				for(ConcreteCharacter c : enemies)
					c.checkDead();
		
				
				if(player.isDead())
				{
					System.out.println(player.getName() + " has fallen :-(");
					break;
				}
			}
			System.out.print("Play again? (y/n): ");
			again = user.next();
		}
		
		user.close();
	}
	
}
