package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;

public class ChangeWeapon implements CombatState
{

	private GameCharacter actor;
	private ArrayList<GameCharacter> enemies;
	private CombatShenanigans theCombat;
	
	public ChangeWeapon(){}
	
	public ChangeWeapon(GameCharacter player, ArrayList<GameCharacter> enemies2)
	{
		this.actor = player;
		this.enemies = enemies2;
	}
	
	@Override
	public String getName()
	{
		return "change weapon";
	}

	@Override
	public void run(GameCharacter me)
	{
		;
		
	}

	@Override
	public void setCombat(CombatShenanigans theCombat)
	{
		this.theCombat = theCombat;
		
	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		me.changeWeapon();
	}


}
