package gamePack.gameEntityPack.gameBehaviorPack;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class KnightAttackBehavior implements GameBehavior
{
	@Override
	public void executeBehavior(GameEntity attacker, GameEntity defender)
	{
		GameCharacter atk, def;
		atk = (GameCharacter) attacker;
		def = (GameCharacter) defender;
		
		def.setHealth( def.getHealth() - atk.getStrength() );
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getView()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setView(String view)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateView()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spawn()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBehavior()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBehavior(GameBehavior behavior)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeBehavior()
	{
		// TODO Auto-generated method stub
		
	}

}
