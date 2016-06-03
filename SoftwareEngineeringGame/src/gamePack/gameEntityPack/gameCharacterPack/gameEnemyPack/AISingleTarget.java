package gamePack.gameEntityPack.gameCharacterPack.gameEnemyPack;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCombatState.SingleTargetCombat;

public class AISingleTarget extends SingleTargetCombat
{
	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		int choice;
		ArrayList<GameCharacter> target = new ArrayList<>();
		
		choice = ConcreteCharacter.random.nextInt(foes.size());
		target.add(foes.get( Math.abs(choice) ) );
		
		me.setTargets(target);
		//System.out.println(me.getName() + " has chosen " + choice + " as a target");
			
	}
	
	public String getName()
	{
		return "AI single target";
	}
}
