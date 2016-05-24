package characterPack;

import java.util.ArrayList;

public class InitialCombatState implements CombatState
{

	private ConcreteCharacter actor;
	private ArrayList<ConcreteCharacter> enemies;
	
	public InitialCombatState(ConcreteCharacter actor, ArrayList<ConcreteCharacter> enemies)
	{
		this.actor = actor;
		this.enemies = enemies;
	}
	
	@Override
	public void run()
	{
		
		int choice, i = 1;
		
		for(CombatState combatState : actor.getCombatStates())
		{
			//behavior.initCombatState(this, enemies);
			System.out.println(i++ + ". " + combatState.getName());
		}
		
		choice = ConcreteCharacter.user.nextInt();
		//System.out.println("Chosen state is " + actor.getCombatStates().get(choice-1).getName());
		actor.setState( actor.getCombatStates().get(choice - 1));
		actor.runState();
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "Beginning combat";
	}

}
