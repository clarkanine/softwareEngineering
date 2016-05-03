package gamePack.gameEntityPack.gameCharacterPack;

public class Knight extends ConcreteGameCharacter
{
	public Knight()
	{
		this.setAccel(10);
		this.setExp(10);
		this.setHealth(10);
		this.setMaxSpeed(10);
		this.setName("Knight");
		this.setStrength(10);
		this.setView("../../views/knight");
		this.setWeight(10);
	}
}
