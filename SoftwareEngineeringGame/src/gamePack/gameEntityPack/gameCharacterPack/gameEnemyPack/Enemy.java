package gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteGameCharacter;

public class Enemy extends ConcreteGameCharacter implements GameEnemy 
{

	private int difficulty;
	
	@Override
	public int getDifficulty() 
	{
		return this.difficulty;
	}//end getDifficulty

	
	
}//end class
