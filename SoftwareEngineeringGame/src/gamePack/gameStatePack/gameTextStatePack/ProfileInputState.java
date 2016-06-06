package gamePack.gameStatePack.gameTextStatePack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.ConcretePlayer;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.KnightPlayer;
import gamePack.gameEntityPack.gameWeaponPack.BattleAxe;
import gamePack.gameEntityPack.gameWeaponPack.GameWeapon;
import gamePack.gameEntityPack.gameWeaponPack.GreatHammer;
import gamePack.gameEntityPack.gameWeaponPack.WeaponOfTheGods;
import gamePack.gameStatePack.EndGame;
import gamePack.gameStatePack.GameState;
import gamePack.gameStatePack.GameStateContext;
import gamePack.gameStatePack.gameMapStatePack.MainWindow;

public class ProfileInputState implements GameTextInputState {
	private GamePlayer player = new ConcretePlayer();

	private Scanner scanner;
	private PrintStream printStream;
	private PrintStream gameErrorLog;
	private PrintStream profileOutputStream;
	private Scanner profileInputStream;

	private GameStateContext gameStateContext;

	/*public ProfileInputState(Scanner scanner, PrintStream printStream) {
		this.setScanner(scanner);
		this.setPrintStream(printStream);
		try {
			this.gameErrorLog = new PrintStream(new File("GameData/ProfileInputErrorLog_"+System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ProfileInputState(Scanner scanner, PrintStream printStream, PrintStream gameErrorLog) {
		this.setScanner(scanner);
		this.setPrintStream(printStream);
		this.gameErrorLog = gameErrorLog;
	}*/

	public ProfileInputState() {
		this.setScanner(new Scanner(System.in));
		this.setPrintStream(new PrintStream(System.out));
		/*try {
			this.gameErrorLog = new PrintStream(new File("GameData/ProfileInputErrorLog_"+System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public String readWord() {
		MainWindow.updateTextArea("ProfileInputState.readWord()\n");
		String res = getScanner().next().trim();
		return res;
	}

	@Override
	public String readLine() {
		//MainWindow.updateTextArea("ProfileInputState.readLine()\n");
		String res = getScanner().nextLine().trim();
		return res;
	}

	@Override
	public int readInt() {
		int num=0;
		boolean parsedInt = true;
		String something = getScanner().nextLine();
		try {
			num = Integer.parseInt(something);
		} catch(NumberFormatException nfe) {
			MainWindow.updateTextArea("something didn't parse to an int\n");
			parsedInt = false;
		}
		while(! parsedInt){
			something = getScanner().nextLine();
			try {
				num = Integer.parseInt(something);

				parsedInt = true;       /*nfe skips this*/
			} catch(NumberFormatException nfe) {
				MainWindow.updateTextArea("something didn't parse to an int\n");
				parsedInt = false;
			}
		}
		return num;
	}

	@Override
	public char readChar() {
		char res = '?';
		try {
			res = getScanner().nextLine().trim().charAt(0);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace(gameErrorLog);
		}
		return res;
	}

	public void createProfile() {
		GamePlayer profile = null;
		MainWindow.updateTextArea("enter new profileName\n");
		String profileName = readLine();
		
		boolean characterFound = false;
		String characterNameChoiceStr = "";
		GamePlayer character; 
		ArrayList<GameCharacter> defaultGameCharactersList = new ArrayList<>(Arrays.asList(new KnightPlayer()));
		while(!characterFound) {
			MainWindow.updateTextArea("select a characteer: "+defaultGameCharactersList+"\n");
			characterNameChoiceStr = readLine();
			for(GameCharacter cur: defaultGameCharactersList)
				if(cur.getName().equals(characterNameChoiceStr)) {
					player = (GamePlayer) cur;
					characterFound = true;
				}
		}
		
		ArrayList<GameWeapon> defaultWeaponsList = new ArrayList<>();
		defaultWeaponsList.addAll(player.getWeapons());

		
		boolean weaponFound = false;
		String weaponNameChoiceStr = "";
		GameWeapon weapon; 
		while(!weaponFound) {
			MainWindow.updateTextArea("select a weapon: "+defaultWeaponsList+"\n");
			weaponNameChoiceStr= readLine();
			for(GameWeapon cur: defaultWeaponsList)
				if(cur.getName().equals(weaponNameChoiceStr)) {
					player.addWeapon(cur);
					weaponFound = true;
				}
		}

		MainWindow.updateTextArea("enter difficulty\n");
		int difficulty = readInt();
		int experience = 0;
		/*try {
			this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));

			profileFound = true;    //fnfe skips this line
		} catch(FileNotFoundException fnfe) {
			//fnfe.printStackTrace(gameErrorLog);
			profileFound = false;
		}
		finally{
			if(profileFound)
				profileInputStream.close();
		}*/
		
		while((profile = SQLiteJDBC.selectProfile(profileName))==null){
			MainWindow.updateTextArea("profile source exists\n"
					+ "enter new profileName\n");
			//getPrintStream().print("-->");
			profileName = readLine();
			/*try {
				this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));

				profileFound = true;   //fnfe skips this line
			} catch(FileNotFoundException fnfe) {
				profileFound = false;
			}
			finally{
				if(profileFound)
					profileOutputStream.close();
			}*/
			
		} 
		/*try {
			this.profileOutputStream = new PrintStream("GameData/ProfileSource_"+profileName);*/

			//this.profileOutputStream.println("***begin ProfileSource_"+profileName+"***");
			/*MainWindow.updateTextArea("profileName: "+profileName+"\n"
			+"characterName: "+player.getName()+"\n"
			+"weaponName: "+player.getWeapons().get(0)+"\n"
			+"difficulty: "+difficulty+"\n"
			+"experience: "+experience+"\n"
			);*/
			
			SQLiteJDBC.insertProfile(profileName, characterNameChoiceStr, weaponNameChoiceStr, difficulty, experience);
			this.player=SQLiteJDBC.selectProfile(profileName);
		
			
			/*this.profileOutputStream.print("profileName: "+profileName+"\n"
					+"characterName: "+player.getName()+"\n"
					+"weaponName: "+player.getWeapons().get(0)+"\n"
					+"difficulty: "+difficulty+"\n"
					+"experience: "+experience+"\n"
					);
			//this.profileOutputStream.println("***end ProfileSource_"+profileName+"***");
			this.profileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/


	}

	public void loadProfile() {
		MainWindow.updateTextArea("enter profileName to load\n");
		String profileName = readLine();
		while((this.player = SQLiteJDBC.selectProfile(profileName))==null){
			MainWindow.updateTextArea("profile source exists\n"
					+ "enter new profileName\n");
			profileName = readLine();
		}
		MainWindow.updateTextArea(" XP="+player.getExperience()+" profileName="+player.getProfileInfo()+"\n");
		this.player.setExperience(0);
		MainWindow.updateTextArea(" XP="+player.getExperience()+" profileName="+player.getProfileInfo()+"\n");

	}

	@Override
	public void openMenu() {
		int option = 999;	
		do{
			MainWindow.updateTextArea("\n_____-----Game-----_____\n"
					+ "Welcome, choose an option:\n"
					+ "1)  Create a new profile\n"
					+ "2)  Load an existing profile\n"
					//+ "3)  readLine() --> Log\n"
					+ "0)  EXIT\n");
			option = readInt();
			switch(option){
			case 1:
				createProfile();
				break;
			case 2:
				loadProfile();
				GameTextInputState newState = new StartMenu();
				newState.setPlayer(player);
				newState.setScanner(new Scanner(System.in));
				GameStateContext.setState(newState);
				break;
				/*case 3:
				gameErrorLog.println(readLine());
				break;*/
			case 0: 
				GameStateContext.setState(new EndGame());
				break;
			default:
			}
		}
		while(option != 0 && getPlayer() == null);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public PrintStream getPrintStreamOut() {
		return getPrintStream();
	}

	public void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}

	public PrintStream getGameErrorLog() {
		return gameErrorLog;
	}

	public void setGameErrorLog(PrintStream gameErrorLog) {
		this.gameErrorLog = gameErrorLog;
	}

	@Override
	public void nextTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeTurn(GameCharacter character) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prelude() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interlude() {
		// TODO Auto-generated method stub

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
	public void closeMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(GameStateContext gameStateContext) {
		this.gameStateContext = gameStateContext;
		MainWindow.updateTextArea(GameStateContext.getState().getClass().getSimpleName());
		this.openMenu();
		gameStateContext.run();

	}

	private PrintStream getPrintStream() {
		return printStream;
	}

	@Override
	public void setPlayer(GamePlayer player) {
		this.player = player;		
	}

	public GamePlayer getPlayer() {
		return this.player;
	}

	@Override
	public void addEnemy(GameCharacter enemy) {
		// TODO Auto-generated method stub
		
	}

}
