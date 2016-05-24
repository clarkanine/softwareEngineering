package characterPack;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleTargetCombat implements CombatState
{
	Scanner user;
	private ConcreteCharacter actor;
	private ArrayList<ConcreteCharacter> characters;
	
	public SingleTargetCombat(ConcreteCharacter actor, ArrayList<ConcreteCharacter> enemies)
	{
		this.actor = actor;
		this.characters = enemies;
	}
	
	private ConcreteCharacter getChoice()
	{
		int i = 1;
		int choice;
		
		System.out.println("Choose a target:");
		
		for(ConcreteCharacter c : this.characters)
		{
			System.out.print(i++ + ". " + c.getName());
			if(c.isDead() == true)
				System.out.print(" (dead)");
			System.out.println();
			
		}
		
		choice = actor.user.nextInt();
		
		return characters.get(choice - 1);
		
	}
	
	public String getName()
	{
		actor.getName();
		return "Single target " + actor.getAttackWeapon().getName() + " attack";
	}

	@Override
	public void run()
	{
		ConcreteCharacter enemy = getChoice();
		actor.attack(enemy);
		actor.setState(new InitialCombatState(actor, characters));
		
	}
	

}
