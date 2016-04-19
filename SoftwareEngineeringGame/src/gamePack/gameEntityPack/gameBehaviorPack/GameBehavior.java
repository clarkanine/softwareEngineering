package gamePack.gameEntityPack.gameBehaviorPack;

import gamePack.gameEntityPack.GameEntity;

public interface GameBehavior extends GameEntity{
	public String getBehavior();
	void setBehavior(GameBehavior behavior);
	
	void executeBehavior();
}
