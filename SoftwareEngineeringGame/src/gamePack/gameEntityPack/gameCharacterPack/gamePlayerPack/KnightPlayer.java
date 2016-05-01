package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

public class KnightPlayer extends ConcretePlayer
{
	public KnightPlayer()
	{
		this.setAccel(5.5);
		this.setName("Godric_The_Brave");
		this.setProfileName("Aaron");
		this.setProfileInfo("<<ProfileInfor>>");
		this.setStats("<<Stats>>");
		this.setExp(100);
		this.setHealth(200);
		this.setWeight(75.5);
		this.setMaxSpeed(15.9);
		this.setView("../../views/knight");
	}
}
