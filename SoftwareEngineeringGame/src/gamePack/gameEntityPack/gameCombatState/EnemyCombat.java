package gamePack.gameEntityPack.gameCombatState;

import java.util.ArrayList;

import gamePack.gameEntityPack.gameCharacterPack.ConcreteCharacter;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameStatePack.CombatShenanigans;

public class EnemyCombat implements CombatState
{

	private ConcreteCharacter thePlayer;
	private ArrayList<ConcreteCharacter> theEnemies;
	private CombatShenanigans theCombat;
	
	public EnemyCombat(){}
	
	public EnemyCombat(ConcreteCharacter player, ArrayList<ConcreteCharacter> enemies)
	{
		thePlayer = player;
		theEnemies = enemies;
		this.run();
	}
	
	//@Override
	public void run()
	{
		for(ConcreteCharacter c : theEnemies)
			c.attack(thePlayer);
		
		//thePlayer.setState(new InitialCombatState(thePlayer, theEnemies) );
		//thePlayer.runState();
		
		
		
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCombat(CombatShenanigans theCombat)
	{
		this.theCombat = theCombat;
		
	}

	@Override
	public void setTargets(GameCharacter me, ArrayList<GameCharacter> friends, ArrayList<GameCharacter> foes)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(GameCharacter me)
	{
		// TODO Auto-generated method stub
		
	}

}
