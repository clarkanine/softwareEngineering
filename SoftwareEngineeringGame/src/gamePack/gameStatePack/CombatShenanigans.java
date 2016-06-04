package gamePack.gameStatePack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameEntityPack.gameCombatState.BattleLostState;
import gamePack.gameEntityPack.gameCombatState.BattleWonState;
import gamePack.gameEntityPack.gameCombatState.EnemyCombat;
import gamePack.gameEntityPack.gameCombatState.InitialCombatState;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;

public class CombatShenanigans implements GameTextInputState
{
	private ArrayList<GameCharacter> thePlayers;
	private ArrayList<GameCharacter> theEnemies;
	GameStateContext gameStateContext;
	
	
	@Override
	public void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(gameStateContext.getState().getClass().getSimpleName()+"\n");
		run();		
		/*GameTextInputState newState = new StartMenu();
		newState.setScanner(new Scanner(System.in));
		newState.setPlayer((GamePlayer)getThePlayers().get(0));
		gameStateContext.setState(newState);*/
		gameStateContext.run();
	}
	
	public CombatShenanigans()
	{
		setThePlayers(new ArrayList<>());
		setTheEnemies(new ArrayList<>());
	}
	
	public CombatShenanigans(ArrayList<GameCharacter> thePlayers, ArrayList<GameCharacter> enemies)
	{
		this.setThePlayers(thePlayers);
		setTheEnemies(enemies);
	}
	
	public void printStatus()
	{
		MainWindow.updateTextArea("-------------------------------------------\n");
		for(GameCharacter c : getThePlayers())
			MainWindow.updateTextArea(c.getName() + " HP: " + c.getHealth() + "/" + c.getMaxHealth() + "\n");
		
		MainWindow.updateTextArea("-------------------------------------------\n");
		
		for(GameCharacter c : getTheEnemies())
			MainWindow.updateTextArea(c.getName() + " HP:" + c.getHealth() + "/" + c.getMaxHealth()+ "\n");
		MainWindow.updateTextArea("-------------------------------------------\n");
		
	}
	
	public void run()
	{
		ArrayList<GameCharacter> everyone = new ArrayList<>();
		while(true)
		{
			if(checkDeath(getTheEnemies()) )
			{
				MainWindow.updateTextArea("Players are successful!\n");
				GameTextInputState newState = new StartMenu();
				newState.setScanner(new Scanner(System.in));
				newState.setPlayer((GamePlayer)getThePlayers().get(0));
				this.gameStateContext.setState(newState);
				return;
			}
			
			if( checkDeath(getThePlayers()))
			{
				MainWindow.updateTextArea("Players have fallen :-(\n");
				this.gameStateContext.setState(new EndGame());
				return;
			}
			
			printStatus();
			
			for(GameCharacter c : getTheEnemies())
			{
				c.getCombatChoice();
				c.chooseTarget(getTheEnemies(), getThePlayers());
			}
			
			
			for(GameCharacter c : getThePlayers())
			{
				c.getCombatChoice();
				c.chooseTarget(getThePlayers(), getTheEnemies());
			}
			
			everyone.addAll(getThePlayers());
			everyone.addAll(getTheEnemies());
			
			Collections.sort(everyone);
			
			for(GameCharacter c : everyone)
			{
				if(!c.isDead())
					c.runState();
				c.clearTargets();
			}
		}
		
		
		
	}
	
	public boolean checkDeath(ArrayList<GameCharacter> theCharacters)
	{
		int numCharacters = theCharacters.size();
		int count = 0;
		for(GameCharacter c : theCharacters)
			if(c.isDead() )
				count++;
		return count >= numCharacters;
	}

	@Override
	public void nextTurn() {
		
		
	}

	@Override
	public void executeTurn(GameCharacter character) {
		
		
	}

	@Override
	public void prelude() {
		
		
	}

	@Override
	public void interlude() {
		
		
	}

	@Override
	public void cutScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitGame(GamePlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterState(GameState state) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void openMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScanner(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayer(GamePlayer player) {
		this.getThePlayers().add(player);
		
	}

	public ArrayList<GameCharacter> getThePlayers() {
		return thePlayers;
	}

	public void setThePlayers(ArrayList<GameCharacter> thePlayers) {
		this.thePlayers = thePlayers;
	}

	public ArrayList<GameCharacter> getTheEnemies() {
		return theEnemies;
	}

	public void setTheEnemies(ArrayList<GameCharacter> theEnemies) {
		this.theEnemies = theEnemies;
	}

	
}


