package gamePack.gameEntityPack.gameCharacterPack;

public class Peasant extends ConcreteGameCharacter
{
	
	public Peasant()
	{


	}
	
	public void setDefault()
	{
		this.setAccel(1);
		this.setExp(1);
		this.setHealth(1);
		this.setMaxSpeed(1);
		this.setName("Peasant");
		this.setStrength(1);
		this.setView("../../views/peasant");
		this.setWeight(1);
	}
}
