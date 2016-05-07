package gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteGameCharacter;

public class Player extends ConcreteGameCharacter implements GamePlayer
<<<<<<< HEAD
{

=======
{	
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
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
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
		return stats;
	}

	public void setStats(String stats)
	{
		this.stats = stats;
		
	}

<<<<<<< HEAD
=======
	@Override
	public void attack()
	{
		
		
	}

>>>>>>> 68a0ca0680ed1fec3e33bc5d234c4e351df78b6a
}
