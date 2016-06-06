package gamePack.gameStatePack.gameCombatState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.EndGame;
import gamePack.gameStatePack.GameState;
import gamePack.gameStatePack.GameStateContext;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;
import gamePack.gameStatePack.gameMapStatePack.MapCanvas;
import gamePack.gameStatePack.gameTextStatePack.GameTextInputState;
import gamePack.gameStatePack.gameTextStatePack.StartMenu;

public class CombatShenanigans implements GameTextInputState
{
	private ArrayList<GameCharacter> thePlayers;
	private ArrayList<GameCharacter> theEnemies;
	GameStateContext gameStateContext;
	
	
	@Override
	public void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName()+"\n");
		
		MainWindow.updateTextArea(" XP="+((GamePlayer) thePlayers.get(0)).getExperience()+" profileName="+((GamePlayer) thePlayers.get(0)).getProfileInfo()+"\n");

		doCombat();		
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
	
	public void doCombat()
	{
		ArrayList<GameCharacter> everyone = new ArrayList<>();
		GamePlayer thePlayer;
		while(true)
		{
			if(checkDeath(getTheEnemies()) )
			{
				MainWindow.updateTextArea("Players are successful!\n");
				for(GameCharacter character : getThePlayers())
				{
					thePlayer = (GamePlayer) character;
					thePlayer.setExperience(thePlayer.getExperience() + getTheEnemies().size());
				}
				//String stateStr = GameStateContext.getState().getClass().getSimpleName();
				GameState newState;
				//MainWindow.updateTextArea("\"" + stateStr + "\"\n");
				
				if(MapCanvas.mapState == MapCanvas.volcanoMap)
					newState = new EndGame();
				else
					newState = new StartMenu();
				//newState.setScanner(new Scanner(System.in));
				newState.setPlayer((GamePlayer)getThePlayers().get(0));
				GameStateContext.setState(newState);
				break;
			}
			
			if( checkDeath(getThePlayers()))
			{
				MainWindow.updateTextArea("Players have fallen :-(\n");
				GameStateContext.setState(new EndGame());
				break;
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
		GameStateContext.getState().setPlayer((GamePlayer) thePlayers.get(0));
		
		
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

	@Override
	public void addEnemy(GameCharacter enemy) {
		this.getTheEnemies().add(enemy);
		
	}

	@Override
	public GamePlayer getPlayer() {
		// TODO Auto-generated method stub
		return (GamePlayer) thePlayers.get(0);
	}

	
}


