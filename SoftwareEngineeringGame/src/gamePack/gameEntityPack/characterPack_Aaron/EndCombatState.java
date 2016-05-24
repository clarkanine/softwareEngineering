package characterPack;

public class EndCombatState implements CombatState
{

	@Override
	public void run()
	{
		System.out.println("Battle has ended");
		
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "End combat state";
	}
}
