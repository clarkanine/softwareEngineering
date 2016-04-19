package gamePack.gameEntityPack.gameWorldMapPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameLocalMapPack.GameLocalMap;

public interface GameWorldMap extends GameEntity {
	void setLocalMaps(ArrayList<GameLocalMap> localMaps);
	public ArrayList<GameLocalMap> getLocalMaps();
	
	public int getWorldX(GameEntity entity);
	void setWorldX(int x, GameEntity entity);
	
	public int getWorldY(GameEntity entity);
	void setWorldY(int y, GameEntity entity);
}