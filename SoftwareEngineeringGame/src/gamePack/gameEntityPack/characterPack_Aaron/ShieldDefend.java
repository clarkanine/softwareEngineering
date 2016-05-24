package characterPack;

public class ShieldDefend implements Defend
{

	@Override
	public void defend(ConcreteCharacter me)
	{
		System.out.println(me.getName() + " is defending!");
		
	}
	
}
