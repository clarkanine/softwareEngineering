package gamePack.gameEntityPack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.CombatShenanigans;
import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

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
			System.out.println("using item on " + c.getName() );
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
		
		System.out.println("Item chosen was " + me.getCurrentItem() );
		ArrayList<GameCharacter> everyone = new ArrayList<>();
		ArrayList<GameCharacter> target = new ArrayList<>();
		
		everyone.addAll(friends);
		everyone.addAll(foes);
		
		System.out.println("Who are you using the item on?");
		
		for(GameCharacter c : everyone)
		{
			System.out.println(i++ + ". " + c.getName() + ": " + c.getHealth() + "/" + c.getMaxHealth() );
		}
		
		choice = ConcreteCharacter.user.nextInt();
		target.add( everyone.get(choice - 1));
		
		me.setTargets(target);
	}

}
