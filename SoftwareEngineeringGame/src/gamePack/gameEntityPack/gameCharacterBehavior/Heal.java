package gamePack.gameEntityPack.gameCharacterBehavior;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCombatState.InitialCombatState;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;
import gamePack.gameStatePack.CombatShenanigans;
import gamePack.gameStatePack.ConcreteGameTextInputState;
import gamePack.gameStatePack.GameTextInputState;

public class Heal implements Special
{
	private GameCharacter actor;
	private ArrayList<GameCharacter> enemies;
	private CombatShenanigans theCombat;
	private int healPoints = 100;
	
	public Heal(GameCharacter actor, ArrayList<GameCharacter> enemies2)
	{
		this.actor = actor;
		this.enemies = enemies2;
	}
	
	public void useSpecial(ConcreteCharacter me, ConcreteCharacter you)
	{
		me.setHealth(me.getHealth() + healPoints);
		
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "heal power";
	}

	@Override
	public void run(GameCharacter me)
	{
		for(GameCharacter c : me.getTargets() )
			c.setHealth(c.getHealth() + healPoints);;

		theCombat.printStatus();
		
	}

	@Override
	public void setCombat(CombatShenanigans theCombat)
	{
		this.theCombat = theCombat;
		
	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		int i = 1;
		int choice;
		
		ArrayList<GameCharacter> everyone = new ArrayList<>();
		ArrayList<GameCharacter> target = new ArrayList<>();
		
		everyone.addAll(friends);
		everyone.addAll(foes);
		
		for(GameCharacter c : everyone)
		{
			MainWindow.updateTextArea(i + ". " + c.getName()+"\n" );
		}
		
		choice = ConcreteGameTextInputState.readInt();
		
//		Scanner in = new Scanner(System.in);
//		choice = in.nextInt();
//		in.close();
		
		//choice = ConcreteCharacter.user.nextInt();
		target.add( everyone.get(choice - 1));
	}

}
