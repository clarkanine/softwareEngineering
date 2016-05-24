package characterPack;

public class BattleAxe implements GameWeapon
{
	private int power = 10;
	private int durability = 20;
	private int absorbtion = 5;
	private Attack axeAttack;
	private Defend axeDefend;
	private String name = "Battle Axe";
	
	public BattleAxe()
	{
		axeAttack = new AxeAttack();
		axeDefend = new AxeDefend();
	}
	
	public int getPower()
	{
		return power;
	}
	@Override
	public void weaponAttack(ConcreteCharacter me, ConcreteCharacter you)
	{
		axeAttack.attack(me, you);
	}
	@Override
	public void weaponDefend(ConcreteCharacter me)
	{
		axeDefend.defend(me);
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return name;
	}
	


}
