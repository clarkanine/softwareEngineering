package gamePack.gameStatePack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;

public class ProfileInput implements GameTextInputState {
	private GamePlayer player = null;
	
	private Scanner scanner;
	private PrintStream printStream;
	private PrintStream gameErrorLog;
	private PrintStream profileOutputStream;
	private Scanner profileInputStream;

	private GameStateContext gameStateContext;

	/*public ProfileInput(Scanner scanner, PrintStream printStream) {
		this.setScanner(scanner);
		this.setPrintStream(printStream);
		try {
			this.gameErrorLog = new PrintStream(new File("GameData/ProfileInputErrorLog_"+System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ProfileInput(Scanner scanner, PrintStream printStream, PrintStream gameErrorLog) {
		this.setScanner(scanner);
		this.setPrintStream(printStream);
		this.gameErrorLog = gameErrorLog;
	}*/

	public ProfileInput() {
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
		MainWindow.updateTextArea("ProfileInput.readWord()\n");
		String res = getScanner().next().trim();
		return res;
	}

	@Override
	public String readLine() {
		//MainWindow.updateTextArea("ProfileInput.readLine()\n");
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
		boolean profileFound = false;
		MainWindow.updateTextArea("enter new profileName\n");
		//getPrintStream().print("-->");
		String profileName = readLine();
		MainWindow.updateTextArea("enter new characterName\n");
		//getPrintStream().print("-->");
		String characterName = readLine();
		ArrayList<String> defaultWeaponsList = new ArrayList<>();
		defaultWeaponsList.add("defaultWeaponName0");
		defaultWeaponsList.add("defaultWeaponName1");
		defaultWeaponsList.add("defaultWeaponName2");
		MainWindow.updateTextArea("select a weapon: "+defaultWeaponsList+"\n");
		//getPrintStream().print("-->");
		String weaponName = readLine();
		while(! defaultWeaponsList.contains(weaponName)) {
			MainWindow.updateTextArea("select a weapon:\n");
			//getPrintStream().print("-->");
			weaponName = readLine();
		}
		MainWindow.updateTextArea("enter difficulty\n");
		//getPrintStream().print("-->");
		int difficulty = readInt();
		int experience = 0;
		try {
			this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));

			profileFound = true;    //fnfe skips this line
		} catch(FileNotFoundException fnfe) {
			//fnfe.printStackTrace(gameErrorLog);
			profileFound = false;
		}
		finally{
			if(profileFound)
				profileInputStream.close();
		}
		while(profileFound){
			MainWindow.updateTextArea("profile source exists\n"
									+ "enter new profileName\n");
			//getPrintStream().print("-->");
			profileName = getScanner().nextLine();
			try {
				this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));

				profileFound = true;   //fnfe skips this line
			} catch(FileNotFoundException fnfe) {
				profileFound = false;
			}
			finally{
				if(profileFound)
					profileOutputStream.close();
			}
		} 
		try {
			this.profileOutputStream = new PrintStream("GameData/ProfileSource_"+profileName);

			//this.profileOutputStream.println("***begin ProfileSource_"+profileName+"***");
			MainWindow.updateTextArea("profileName: "+profileName+"\n");
			MainWindow.updateTextArea("characterName: "+characterName+"\n");
			MainWindow.updateTextArea("weaponName: "+weaponName+"\n");
			MainWindow.updateTextArea("difficulty: "+difficulty+"\n");
			MainWindow.updateTextArea("experience: "+experience+"\n");
			//this.profileOutputStream.println("***end ProfileSource_"+profileName+"***");
			this.profileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

	public void loadProfile() {
		boolean profileFound = false;
		MainWindow.updateTextArea("enter profileName to load\n");
		//getPrintStream().print("-->");
		String profileName = readLine();
		String characterName = "";
		String weaponName = "";
		int difficulty = 0;
		int experience = 0;

		try {
			this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));

			profileFound = true;    //fnfe skips this line
		} catch(FileNotFoundException fnfe) {
			profileFound = false;
		}
		finally{
			if(profileFound)
				profileInputStream.close();
		}
		while(!profileFound){
			MainWindow.updateTextArea("profile does not exist. \nEnter a profileName to load\n");
			//getPrintStream().print("-->");
			profileName = readLine();
			try {
				this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));

				profileFound = true;   //fnfe skips this line
			} catch(FileNotFoundException fnfe) {
				profileFound = false;
			}
			finally{
				if(profileFound)
					profileInputStream.close();
			}
		} 
		
		this.setPlayer(ProfileSourceHandler.profileSourceParser(profileName));
		

/*
		try {
			this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));
			String profileSourceString = "";
			while(this.profileInputStream.hasNextLine())
				profileSourceString += this.profileInputStream.nextLine()+"\n";
			printStream.print(profileSourceString);
			profileInputStream.close();
			ProfileSourceHandler.profileParser();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
*/


	}

	@Override
	public void openMenu() {
		
		//System.out.println();
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
				gameStateContext.setState(newState);
				break;
			/*case 3:
				gameErrorLog.println(readLine());
				break;*/
			case 0: 
				gameStateContext.setState(new EndGame());
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
		MainWindow.updateTextArea(gameStateContext.getState().getClass().getSimpleName());
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

	GamePlayer getPlayer() {
		return player;
	}

}
