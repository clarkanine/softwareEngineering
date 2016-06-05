package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;
import gamePack.gameStatePack.gameTextStatePack.TextInputState;

public class UseItemState implements CombatState
{

	private GameCharacter player;
	private ArrayList<GameCharacter> enemies;
	
	public UseItemState(){}
	
	public UseItemState(GameCharacter player2, ArrayList<GameCharacter> enemies2)
	{
		this.player = player2;
		this.enemies = enemies2;
	}
	@Override
	public void run(GameCharacter me)
	{
		
		for(GameCharacter c : me.getTargets() )
		{
			MainWindow.updateTextArea("using item on " + c.getName() + "\n");
			c.useItem(me.getCurrentItem());
			
		}
		
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "Use item";
	}

	@Override
	public void setCombat(CombatShenanigans theCombat)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		int i = 1;
		int choice;
		
		me.setCurrentItem( me.chooseItem() );
		
		MainWindow.updateTextArea("Item chosen was " + me.getCurrentItem() + "\n");
		ArrayList<GameCharacter> everyone = new ArrayList<>();
		ArrayList<GameCharacter> target = new ArrayList<>();
		
		everyone.addAll(friends);
		everyone.addAll(foes);
		
		MainWindow.updateTextArea("Who are you using the item on?"+ "\n");
		
		for(GameCharacter c : everyone)
		{
			MainWindow.updateTextArea(i++ + ". " + c.getName() + ": " + c.getHealth() + "/" + c.getMaxHealth() + "\n");
		}
		
		choice = TextInputState.readInt();
		
		/*Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		in.close();*/
		
		//choice = ConcreteCharacter.user.nextInt();
		target.add( everyone.get(choice - 1));
		
		me.setTargets(target);
	}

}
