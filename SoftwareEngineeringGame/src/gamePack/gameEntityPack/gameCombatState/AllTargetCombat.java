package gamePack.gameEntityPack.gameCombatState;

import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.CombatShenanigans;

public class AllTargetCombat implements CombatState
{
	
	Scanner user;
	private GameCharacter actor;
	private ArrayList<GameCharacter> characters;
	private CombatShenanigans theCombat;
	
	public AllTargetCombat(){}
	
	public AllTargetCombat(GameCharacter player, ArrayList<GameCharacter> enemies)
	{
		this.actor = player;
		this.characters = enemies;
		
	}
	
	@Override
	public void run(GameCharacter me)
	{
		for(GameCharacter c : me.getTargets() )
			me.attack(c);
		
		//actor.setState( new EnemyCombat(actor, characters));
		//theCombat.printStatus();
		
	}


	
	public String getName()
	{
		return "All target ";
	}

	
	@Override
	public void setCombat(CombatShenanigans theCombat)
	{
		this.theCombat = theCombat;
		
	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		me.setTargets(foes);
		
	}
	
}
