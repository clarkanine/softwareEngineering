package characterPack;

import java.util.ArrayList;

public class BattleWonState implements CombatState
{

	
	private ConcreteCharacter actor;
	
	public BattleWonState(ConcreteCharacter actor)
	{
		this.actor = actor;
	}
	
	@Override
	public void run()
	{
		System.out.println(actor.getName() + " has defeated all opponents!");
		actor.setState(new EndCombatState() );
		
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "Battle won state";
	}

}
