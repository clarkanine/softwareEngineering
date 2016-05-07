package gamePack.gameStatePack;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;

public interface GameTextInputState extends GameState {
	static PrintStream printStream = new PrintStream(System.out);
	static Scanner scanner = new Scanner(System.in);
	static File errorLogFile = new File("GameData/ProfileInputErrorLog_"+System.currentTimeMillis());
	static PrintStream gameErrorLog = new PrintStream(System.out);

	default String readWord() {
		GameTextInputState.printStream.println("GameTextInputState.readWord()");
		String res = GameTextInputState.scanner.next().trim();
		return res;
	}
	
	default String readWord(Scanner scanner) {
		GameTextInputState.printStream.println("GameTextInputState.readWord(Scanner scanner)");
		String res = scanner.next().trim();
		return res;
	}
	
	default String readLine() {
		GameTextInputState.printStream.println("GameTextInputState.readLine()");
		String res = GameTextInputState.scanner.nextLine().trim();
		return res;
	}
	
	default String readLine(Scanner scanner) {
		GameTextInputState.printStream.println("GameTextInputState.readLine(Scanner scanner)");
		String res = scanner.nextLine().trim();
		return res;
	}
	
	default int readInt()
	{
		int num=0;
		boolean parsedInt = true;
		String something = GameTextInputState.scanner.nextLine();
		try {
			num = Integer.parseInt(something);
		} catch(NumberFormatException nfe) {
			GameTextInputState.printStream.println("something didn't parse to an int");
			parsedInt = false;
		}
		while(! parsedInt){
			something = GameTextInputState.scanner.nextLine();
			try {
				num = Integer.parseInt(something);

				parsedInt = true;       /*nfe skips this*/
			} catch(NumberFormatException nfe) {
				GameTextInputState.printStream.println("something didn't parse to an int");
				parsedInt = false;
			}
		}
		return num;
	}
	
	default int readInt(Scanner scanner)
	{
		int num=0;
		boolean parsedInt = true;
		String something = scanner.nextLine();
		try {
			num = Integer.parseInt(something);
		} catch(NumberFormatException nfe) {
			GameTextInputState.printStream.println("something didn't parse to an int");
			parsedInt = false;
		}
		while(! parsedInt){
			something = scanner.nextLine();
			try {
				num = Integer.parseInt(something);

				parsedInt = true;       /*nfe skips this*/
			} catch(NumberFormatException nfe) {
				GameTextInputState.printStream.println("something didn't parse to an int");
				parsedInt = false;
			}
		}
		return num;
	}
	
	default char readChar()
	{
		char res = '?';
		try {
			res = GameTextInputState.scanner.nextLine().trim().charAt(0);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace(GameTextInputState.gameErrorLog);
		}
		return res;
	}
	
	default char readChar(Scanner scanner)
	{
		char res = '?';
		try {
			res = scanner.nextLine().trim().charAt(0);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace(GameTextInputState.gameErrorLog);
		}
		return res;
	}
	
	void openMenu();
	void closeMenu();
	//etc

	public void setScanner(Scanner scanner);

	public void setPlayer(GamePlayer player);


}
