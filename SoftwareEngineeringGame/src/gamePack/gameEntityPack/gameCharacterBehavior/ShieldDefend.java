package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;

public class ShieldDefend implements Defend
{

	@Override
	public void defend(ConcreteCharacter me)
	{
		System.out.println(me.getName() + " is defending!");
		
	}
	
}
