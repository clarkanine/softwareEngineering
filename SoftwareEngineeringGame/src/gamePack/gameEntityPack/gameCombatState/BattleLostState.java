package gamePack.gameEntityPack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;
import gamePack.gameStatePack.CombatShenanigans;

public class BattleLostState implements CombatState
{

	private GameCharacter actor;
	
	public BattleLostState(GameCharacter thePlayer)
	{
		this.actor = thePlayer;
	}
	
	@Override
	public void run(GameCharacter me)
	{
		MainWindow.updateTextArea(actor.getName() + " has fallen!\n");
		actor.setState(new EndCombatState(actor) );
		
	}

	@Override
	public String getName()
	{
		return "Battle Lost State";
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
