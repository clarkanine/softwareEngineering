package characterPack;

import java.util.ArrayList;
import java.util.Scanner;

public class AllTargetCombat implements CombatState
{
	
	Scanner user;
	private ConcreteCharacter actor;
	private ArrayList<ConcreteCharacter> characters;
	
	public AllTargetCombat(ConcreteCharacter actor, ArrayList<ConcreteCharacter> characters)
	{
		this.actor = actor;
		this.characters = characters;
		
	}
	
	@Override
	public void run()
	{
		for(ConcreteCharacter c : characters)
		{
			if(c.isDead() == false)
				actor.attack(c);
		}
		
		actor.setState(new InitialCombatState(actor, characters));
		
	}


	
	public String getName()
	{
		return "All target " + actor.getAttackWeapon().getName() + " attack";
	}

	
}
