package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;

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
		MainWindow.updateTextArea(actor.getName() + " has defeated all opponents!\n");
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
