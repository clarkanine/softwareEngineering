package characterPack;

import java.util.ArrayList;

public class Heal implements Special
{
	private ConcreteCharacter actor;
	private ArrayList<ConcreteCharacter> enemies;
	private int healPoints = 100;
	
	public Heal(ConcreteCharacter actor, ArrayList<ConcreteCharacter> enemies)
	{
		this.actor = actor;
		this.enemies = enemies;
	}
	public void useSpecial(ConcreteCharacter me, ConcreteCharacter you)
	{
		me.setHealth(me.getHealth() + healPoints);
		
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "heal power";
	}

	@Override
	public void run()
	{
		actor.setHealth(actor.getHealth() + healPoints);
		actor.setState(new InitialCombatState(actor, enemies));
		
	}

}
