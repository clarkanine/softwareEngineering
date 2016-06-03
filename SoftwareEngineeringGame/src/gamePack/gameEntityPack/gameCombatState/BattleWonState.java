package gamePack.gameEntityPack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.CombatShenanigans;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class BattleWonState implements CombatState
{

	private GameCharacter actor;
	
	public BattleWonState(GameCharacter thePlayer)
	{
		this.actor = thePlayer;
	}
	
	@Override
	public void run(GameCharacter me)
	{
		System.out.println(actor.getName() + " has defeated all opponents!");
		actor.setState(new EndCombatState(actor) );
		
	}

	@Override
	public String getName()
	{
		return "Battle won state";
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
