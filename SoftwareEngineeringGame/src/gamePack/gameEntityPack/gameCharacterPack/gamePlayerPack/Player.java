package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteGameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class Player extends ConcreteGameCharacter implements GamePlayer
{

	private String profileInfo;
	private String stats;
	
	public String getProfileInfo()
	{
		return profileInfo;
	}

	public void setProfileInfo(String info)
	{
		profileInfo = info;
	}

	public String getStats()
	{
		// TODO Auto-generated method stub
		return stats;
	}

	public void setStats(String stats)
	{
		this.stats = stats;
		
	}

}
