package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

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
		return stats;
	}

	public void setStats(String stats)
	{
		this.stats = stats;
		
	}

//	@Override
//	public void attack()
//	{
//		
//		
//	}

}
