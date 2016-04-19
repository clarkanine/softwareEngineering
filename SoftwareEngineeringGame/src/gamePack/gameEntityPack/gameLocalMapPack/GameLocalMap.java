package gamePack.gameEntityPack.gameLocalMapPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;

public interface GameLocalMap extends GameEntity {
	void setCharacters(ArrayList<GameCharacter> characters);
	public ArrayList<GameCharacter> getCharacters();
	
	void setPlayers(ArrayList<GamePlayer> player);
	public ArrayList<GamePlayer> getPlayers();
	
	public int getLocalX(GameEntity entity);
	void setLocalX(int x, GameEntity entity);
	
	public int getLocalY(GameEntity entity);
	void setLocalY(int y, GameEntity entity);
	
	public double distanceTo(GameEntity entity);
}
