package gamePack.gameEntityPack.gameCharacterPack;

public class Thief extends ConcreteGameCharacter
{
	public Thief()
	{

	}
	
	public void setDefault()
	{
		this.setAccel(15);
		this.setExp(10);
		this.setHealth(7);
		this.setMaxSpeed(12);
		this.setName("Thief");
		this.setStrength(8);
		this.setView("../../view/thief");
		this.setWeight(7);
	}
}
