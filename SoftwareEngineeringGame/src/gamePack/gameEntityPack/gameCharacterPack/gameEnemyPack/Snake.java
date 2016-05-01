package gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack;

public class Snake extends ConcreteGameEnemy 
{
	public Snake()
	{
		this.setAccel(5.0);
		this.setDifficulty(1);
		this.setHealth(5);
		this.setMaxSpeed(10.0);
		this.setName("Snake");
		this.setStrength(7);
		this.setView("../views/snake");
		this.setWeight(0);
	}
}
