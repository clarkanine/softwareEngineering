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

public class ProfileInput implements GameTextInputState {
	private Scanner scanner = new Scanner(System.in);
	private PrintStream printStream = new PrintStream(System.out);
	private PrintStream gameErrorLog;
	private PrintStream profileOutputStream;
	private Scanner profileInputStream;

	public ProfileInput(Scanner scanner, OutputStream printStream) {
		this.scanner = scanner;
		this.printStream = new PrintStream(printStream);
		try {
			this.gameErrorLog = new PrintStream(new File("GameData/ProfileInputErrorLog_"+System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ProfileInput(Scanner scanner, OutputStream printStream, PrintStream gameErrorLog) {
		this.scanner = scanner;
		this.printStream = new PrintStream(printStream);
		this.gameErrorLog = gameErrorLog;
	}

	@Override
	public String readWord() {
		printStream.println("ProfileInput.readWord()");
		String res = scanner.next().trim();
		return res;
	}

	@Override
	public String readLine() {
		//printStream.println("ProfileInput.readLine()");
		String res = scanner.nextLine().trim();
		return res;
	}

	@Override
	public int readInt() {
		int num=0;
		boolean parsedInt = true;
		String something = scanner.nextLine();
		try {
			num = Integer.parseInt(something);
		} catch(NumberFormatException nfe) {
			System.out.println("something didn't parse to an int");
			parsedInt = false;
		}
		while(! parsedInt){
			something = scanner.nextLine();
			try {
				num = Integer.parseInt(something);

				parsedInt = true;       /*nfe skips this*/
			} catch(NumberFormatException nfe) {
				System.out.println("something didn't parse to an int");
				parsedInt = false;
			}
		}
		return num;
	}

	@Override
	public char readChar() {
		char res = '?';
		try {
			res = scanner.nextLine().trim().charAt(0);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace(gameErrorLog);
		}
		return res;
	}

	public void createProfile() {
		boolean profileFound = false;
		printStream.println("enter new profileName");
		printStream.print("-->");
		String profileName = readLine();
		printStream.println("enter new characterName");
		printStream.print("-->");
		String characterName = readLine();
		ArrayList<String> defaultWeaponsList = new ArrayList<>();
		defaultWeaponsList.add("defaultWeaponName0");
		defaultWeaponsList.add("defaultWeaponName1");
		defaultWeaponsList.add("defaultWeaponName2");
		printStream.println("select a weapon: "+defaultWeaponsList);
		printStream.print("-->");
		String weaponName = readLine();
		while(! defaultWeaponsList.contains(weaponName)) {
			printStream.println("select a weapon: ");
			printStream.print("-->");
			weaponName = readLine();
		}
		printStream.println("enter difficulty");
		printStream.print("-->");
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
			printStream.println("profile source exists");
			printStream.println("enter new profileName");
			printStream.print("-->");
			profileName = scanner.nextLine();
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
		printStream.println("enter profileName to load");
		printStream.print("-->");
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
			printStream.println("profile does not exist");
			printStream.println("enter a profileName to load");
			printStream.print("-->");
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
		ProfileSourceHandler.profileSourceParser(profileName);

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
		System.out.println("\n\t\t\t\t_____-----Game-----_____\t\t\t\t\n");
		int option = 999;	
		do{
			System.out.println("\nWelcome, choose an option:\n"
					+ "1)  readLine() --> Log\n"
					+ "2)  Create a new profile\n"
					+ "3)  Load an existing profile\n"
					+ "0)  EXIT");
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
				break;	
			case 0: 
				System.out.println("\nThank you for playing the game\n\n");
				break;
			default:
			}
		}
		while(option != 0);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public PrintStream getPrintStreamOut() {
		return printStream;
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

}
