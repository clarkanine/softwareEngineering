package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;


import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public interface GamePlayer extends GameCharacter {
	public String getProfileInfo();
	public void setProfileInfo(String info); //name, config, lastSavedateTime...
	
	public String getStats();
	public void setStats(String stats); //survivability, experience, narrative completion, difficulty, handicap...
	//public void attack(GameCharacter target);
	public void setExperience(int experienceInt);
	public int getExperience();
}
