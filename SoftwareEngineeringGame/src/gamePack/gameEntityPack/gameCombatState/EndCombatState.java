package gamePack.gameEntityPack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.CombatShenanigans;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class EndCombatState implements CombatState
{
	private GameCharacter player;
	
	public EndCombatState(GameCharacter actor)
	{
		this.player = actor;
	}

	@Override
	public void run(GameCharacter me)
	{
		player.restore();
		System.out.println("Battle has ended");
		
	}

	@Override
	public String getName()
	{
		return "End combat state";
	}

	@Override
	public void setCombat(CombatShenanigans theCombat)
	{
		
		
	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		
	}
}
