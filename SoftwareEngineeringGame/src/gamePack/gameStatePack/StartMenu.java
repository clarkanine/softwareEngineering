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
import clickableGrid.Main;

public class StartMenu implements GameTextInputState {
	private Scanner scanner = new Scanner(System.in);
	private PrintStream printStream = new PrintStream(System.out);
	private PrintStream gameErrorLog;
	private PrintStream profileOutputStream;
	private Scanner profileInputStream;

	public StartMenu(Scanner scanner, OutputStream printStream) {
		this.scanner = scanner;
		this.printStream = new PrintStream(printStream);
		try {
			this.gameErrorLog = new PrintStream(new File("GameData/ProfileInputErrorLog_"+System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public StartMenu(Scanner scanner, OutputStream printStream, PrintStream gameErrorLog) {
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

	



	@Override
	public void openMenu() {
		System.out.println("\n\t\t\t\t_____-----Game-----_____\t\t\t\t\n");
		int option = 999;	
		do{
			System.out.println("\nchoose an option:\n"
					+ "1)  play game\n"
					+ "2)  back\n"
					+ "0)  EXIT");
			option = readInt();
			switch(option){
			case 1:
				clickableGrid.Main.main(null);
				
				break;
			case 2:
				ProfileInput p = new ProfileInput(scanner, printStream);
				p.openMenu();
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
