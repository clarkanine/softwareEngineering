package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;


import gamePack.gameEntityPack.GameEntity;

public interface GamePlayer extends GameEntity {
	public String getProfileInfo();
	public void setProfileInfo(String info); //name, config, lastSavedateTime...
	
	public String getStats();
	public void setStats(String stats); //survivability, experience, narrative completion, difficulty, handicap...
}
