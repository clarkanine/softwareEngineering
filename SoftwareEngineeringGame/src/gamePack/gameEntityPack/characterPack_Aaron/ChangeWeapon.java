package characterPack;

import java.util.ArrayList;

public class ChangeWeapon implements CombatState
{

	private ConcreteCharacter actor;
	private ArrayList<ConcreteCharacter> enemies;
	
	public ChangeWeapon(ConcreteCharacter actor, ArrayList<ConcreteCharacter> enemies)
	{
		this.actor = actor;
		this.enemies = enemies;
	}
	
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "change weapon";
	}

	@Override
	public void run()
	{
		actor.changeWeapon();
		actor.setState( new InitialCombatState(actor, enemies) );
		
	}


}
