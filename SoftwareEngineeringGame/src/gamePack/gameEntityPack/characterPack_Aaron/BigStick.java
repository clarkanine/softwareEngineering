package characterPack;

public class BigStick implements GameWeapon
{

	private int power = 5;
	private int durability = 20;
	private int absorbtion = 5;
	private Attack axeAttack;
	private Defend axeDefend;
	private String name = "Big Stick";
	
	@Override
	public void weaponAttack(ConcreteCharacter me, ConcreteCharacter you)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void weaponDefend(ConcreteCharacter me)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPower()
	{
		// TODO Auto-generated method stub
		return this.power;
	}
	
	public String getName()
	{
		return name;
	}

}
