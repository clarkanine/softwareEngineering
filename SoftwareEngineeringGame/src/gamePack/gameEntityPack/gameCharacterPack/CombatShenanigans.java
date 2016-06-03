package gamePack.gameEntityPack.gameCharacterPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import gamePack.gameEntityPack.gameCombatState.BattleLostState;
import gamePack.gameEntityPack.gameCombatState.BattleWonState;
import gamePack.gameEntityPack.gameCombatState.EnemyCombat;
import gamePack.gameEntityPack.gameCombatState.InitialCombatState;

public class CombatShenanigans
{
	ArrayList<GameCharacter> thePlayers;
	ArrayList<GameCharacter> theEnemies;
	
	public CombatShenanigans(ArrayList<GameCharacter> thePlayers, ArrayList<GameCharacter> enemies)
	{
		this.thePlayers = thePlayers;
		theEnemies = enemies;
	}
	
	public void printStatus()
	{
		System.out.println("-------------------------------------------");
		for(GameCharacter c : thePlayers)
			System.out.println(c.getName() + " HP: " + c.getHealth() + "/" + c.getMaxHealth() );
		
		System.out.println("-------------------------------------------");
		
		for(GameCharacter c : theEnemies)
			System.out.println(c.getName() + " HP:" + c.getHealth() + "/" + c.getMaxHealth());
		System.out.println("-------------------------------------------");
		
	}
	
	public void run()
	{
		ArrayList<GameCharacter> everyone = new ArrayList<>();
		while(true)
		{
			if(checkDeath(theEnemies) )
			{
				System.out.println("Players are successful!");
				return;
			}
			
			if( checkDeath(thePlayers))
			{
				System.out.println("Players have fallen :-(");
				return;
			}
			
			printStatus();
			
			for(GameCharacter c : theEnemies)
			{
				c.getCombatChoice();
				c.chooseTarget(theEnemies, thePlayers);
			}
			
			
			for(GameCharacter c : thePlayers)
			{
				c.getCombatChoice();
				c.chooseTarget(thePlayers, theEnemies);
			}
			
			everyone.addAll(thePlayers);
			everyone.addAll(theEnemies);
			
			Collections.sort(everyone);
			
			for(GameCharacter c : everyone)
			{
				if(!c.isDead())
					c.runState();
				c.clearTargets();
			}
		}
		
		
		
	}
	
	public boolean checkDeath(ArrayList<GameCharacter> theCharacters)
	{
		int numCharacters = theCharacters.size();
		int count = 0;
		for(GameCharacter c : theCharacters)
			if(c.isDead() )
				count++;
		return count >= numCharacters;
	}
	
}


