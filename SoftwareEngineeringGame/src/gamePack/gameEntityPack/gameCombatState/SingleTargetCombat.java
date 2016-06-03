package gamePack.gameEntityPack.gameCombatState;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.CombatShenanigans;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class SingleTargetCombat implements CombatState
{
	Scanner user;
	private GameCharacter actor;
	private ArrayList<GameCharacter> characters;
	private CombatShenanigans theCombat;
	
	/*
	public SingleTargetCombat(GameCharacter actor, ArrayList<GameCharacter> enemies)
	{
		this.actor = actor;
		this.characters = enemies;

	}
	*/
	
	private GameCharacter getChoice()
	{
		int i = 1;
		int choice;
		
		System.out.println("Choose a target:");
		
		for(GameCharacter c : this.characters)
		{
			System.out.print(i++ + ". " + c.getName());
			if(c.isDead() == true)
				System.out.print(" (dead)");
			System.out.println();
			
		}
		
		choice = ConcreteCharacter.user.nextInt();
		
		return characters.get(choice - 1);
		
	}
	
	public String getName()
	{
		return "Single target ";
	}

	@Override
	public void run(GameCharacter me)
	{
		for(GameCharacter c : me.getTargets() )
			me.attack(c);
		
	}
	
	@Override
	public void setCombat(CombatShenanigans theCombat)
	{
		this.theCombat = theCombat;
		
	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		
		int i = 1;
		int choice;
		ArrayList<GameCharacter> target = new ArrayList<>();
		
		System.out.println("Choose a target:");
		
		for(GameCharacter c : foes)
		{
			System.out.print(i++ + ". " + c.getName() + ": " + c.getHealth() + "/" + c.getMaxHealth());
			if(c.isDead() == true)
				System.out.print(" (dead)");
			System.out.println();
			
		}
		
		choice = ConcreteCharacter.user.nextInt();
		target.add(foes.get(choice - 1) );
		
		me.setTargets(target);
			
		
	}
	

}
