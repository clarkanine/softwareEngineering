package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;

public class AxeDefend implements Defend
{

	@Override
	public void defend(ConcreteCharacter me)
	{
		if(!me.isDead())
			System.out.println(me.getName() + " is defending with axe");
		
		me.setDefending(true);
		
	}

}
