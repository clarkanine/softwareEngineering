import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.ConcretePlayer;



public class KnightPlayer extends ConcretePlayer
{
	public KnightPlayer()
	{
		this.setAccel(5.5);
		this.setExp(100);
		this.setHealth(200);
		this.setWeight(75.5);
		this.setMaxSpeed(15.9);
		this.setView("knight");
	}
}
