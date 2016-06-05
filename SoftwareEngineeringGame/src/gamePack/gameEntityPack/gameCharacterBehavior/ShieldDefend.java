package gamePack.gameEntityPack.gameCharacterBehavior;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.Defend;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;

public class ShieldDefend implements Defend
{

	@Override
	public void defend(ConcreteCharacter me)
	{
		MainWindow.updateTextArea(me.getName() + " is defending!\n");
		
	}
	
}
