package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;
import gamePack.gameStatePack.gameTextStatePack.TextInputState;

public class SingleTargetCombat implements CombatState
{
	Scanner user;
	private GameCharacter actor;
	private ArrayList<GameCharacter> characters;
	private CombatShenanigans theCombat;
	
	/*
	public SingleTargetCombat(GameCharacter actor, ArrayList<GameCharacter> enemies)
	{
		this.actor = actor;
		this.characters = enemies;

	}
	*/
	
	private GameCharacter getChoice()
	{
		int i = 1;
		int choice;
		
		MainWindow.updateTextArea("Choose a target:\n");
		
		for(GameCharacter c : this.characters)
		{
			MainWindow.updateTextArea(i++ + ". " + c.getName()+"\n");
			if(c.isDead() == true)
				MainWindow.updateTextArea(" (dead)\n");
			MainWindow.updateTextArea("\n");
			
		}
		
		choice = TextInputState.readInt();
		
		/*Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		in.close();*/
		
		//choice = ConcreteCharacter.user.nextInt();
		
		return characters.get(choice - 1);
		
	}
	
	public String getName()
	{
		return "Single target ";
	}

	@Override
	public void run(GameCharacter me)
	{
		for(GameCharacter c : me.getTargets() )
			me.attack(c);
		
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
		ArrayList<GameCharacter> target = new ArrayList<>();
		
		MainWindow.updateTextArea("Choose a target:\n");
		
		for(GameCharacter c : foes)
		{
			MainWindow.updateTextArea(i++ + ". " + c.getName() + ": " + c.getHealth() + "/" + c.getMaxHealth() + "\n");
			if(c.isDead() == true)
				MainWindow.updateTextArea(" (dead)\n");
			MainWindow.updateTextArea("\n");
			
		}
		
		choice = TextInputState.readInt();
		
		/*Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		in.close();*/
		
		//choice = ConcreteCharacter.user.nextInt();
		target.add(foes.get(choice - 1) );
		
		me.setTargets(target);
			
		
	}
	

}
