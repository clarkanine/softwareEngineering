package gamePack.gameEntityPack.gameBehaviorPack;

import gamePack.gameEntityPack.GameEntity;

public interface GameBehavior extends GameEntity {
	public String getBehavior();

	void setBehavior(GameBehavior behavior);

	public void executeBehavior();

	public void executeBehavior(GameEntity ge1, GameEntity ge2);
}
