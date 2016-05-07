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
import gamePack.gameEntityPack.gameLocalMapPack.DefaultWindow;

public class ProfileInput implements GameTextInputState {
	private GamePlayer player = null;
	
	private Scanner scanner;
	private PrintStream printStream;
	private PrintStream gameErrorLog;
	private PrintStream profileOutputStream;
	private Scanner profileInputStream;

	private GameStateContext gameStateContext;

	public ProfileInput(Scanner scanner, PrintStream printStream) {
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
	}

	public ProfileInput() {
		this.setScanner(new Scanner(System.in));
		this.setPrintStream(new PrintStream(System.out));
		try {
			this.gameErrorLog = new PrintStream(new File("GameData/ProfileInputErrorLog_"+System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String readWord() {
		DefaultWindow.updateTextArea("ProfileInput.readWord()\n");
		String res = getScanner().next().trim();
		return res;
	}

	@Override
	public String readLine() {
		//DefaultWindow.updateTextArea("ProfileInput.readLine()\n");
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
			DefaultWindow.updateTextArea("something didn't parse to an int\n");
			parsedInt = false;
		}
		while(! parsedInt){
			something = getScanner().nextLine();
			try {
				num = Integer.parseInt(something);

				parsedInt = true;       /*nfe skips this*/
			} catch(NumberFormatException nfe) {
				DefaultWindow.updateTextArea("something didn't parse to an int\n");
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
		DefaultWindow.updateTextArea("enter new profileName\n");
		//getPrintStream().print("-->");
		String profileName = readLine();
		DefaultWindow.updateTextArea("enter new characterName\n");
		//getPrintStream().print("-->");
		String characterName = readLine();
		ArrayList<String> defaultWeaponsList = new ArrayList<>();
		defaultWeaponsList.add("defaultWeaponName0");
		defaultWeaponsList.add("defaultWeaponName1");
		defaultWeaponsList.add("defaultWeaponName2");
		DefaultWindow.updateTextArea("select a weapon: "+defaultWeaponsList+"\n");
		//getPrintStream().print("-->");
		String weaponName = readLine();
		while(! defaultWeaponsList.contains(weaponName)) {
			DefaultWindow.updateTextArea("select a weapon:\n");
			//getPrintStream().print("-->");
			weaponName = readLine();
		}
		DefaultWindow.updateTextArea("enter difficulty\n");
		//getPrintStream().print("-->");
		int difficulty = readInt();
		int experience = 0;
		try {
			this.profileInputStream = new Scanner(new FileInputStream("GameData/ProfileSource_"+profileName));

			profileFound = true;    //fnfe skips this line
		} catch(FileNotFoundException fnfe) {
			profileFound = false;
		}
		finally{
			if(profileFound)
				profileOutputStream.close();
		}
		while(profileFound){
			DefaultWindow.updateTextArea("profile source exists\n"
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
			this.profileOutputStream.println("profileName: "+profileName);
			this.profileOutputStream.println("characterName: "+characterName);
			this.profileOutputStream.println("weaponName: "+weaponName);
			this.profileOutputStream.println("difficulty: "+difficulty);
			this.profileOutputStream.println("experience: "+experience);
			//this.profileOutputStream.println("***end ProfileSource_"+profileName+"***");
			this.profileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

	public void loadProfile() {
		boolean profileFound = false;
		DefaultWindow.updateTextArea("enter profileName to load\n");
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
			DefaultWindow.updateTextArea("profile does not exist"
					+ "enter a profileName to load\n");
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
			DefaultWindow.updateTextArea("\n\t\t\t\t_____-----Game-----_____\t\t\t\t\n\n"
					+ "Welcome, choose an option:\n"
					+ "1)  readLine() --> Log\n"
					+ "2)  Create a new profile\n"
					+ "3)  Load an existing profile\n"
					+ "0)  EXIT\n");
			option = readInt();
			switch(option){
			case 1:
				gameErrorLog.println(readLine());
				break;
			case 2:
				createProfile();
				break;
			case 3:
				loadProfile();
				GameTextInputState newState = new StartMenu();
				newState.setScanner(new Scanner(System.in));
				gameStateContext.setState(newState);
				break;	
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
		DefaultWindow.updateTextArea(gameStateContext.getState().getClass().getSimpleName());
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
