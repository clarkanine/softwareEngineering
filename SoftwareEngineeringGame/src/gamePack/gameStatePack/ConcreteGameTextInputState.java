package gamePack.gameStatePack;

import java.io.PrintStream;
import java.util.Scanner;
import gamePack.gameEntityPack.gameLocalMapPack.MainWindow;

public class ConcreteGameTextInputState {
	static PrintStream printStream = new PrintStream(System.out);
	static Scanner scanner = new Scanner(System.in);
	public static String readWord() {
		String res = ConcreteGameTextInputState.scanner.next().trim();
		return res;
	}
	public static String readWord(Scanner scanner) {
				String res = scanner.next().trim();
		return res;
	}
	public static String readLine() {
				String res = ConcreteGameTextInputState.scanner.nextLine().trim();
		return res;
	}
	public static String readLine(Scanner scanner) {
				String res = scanner.nextLine().trim();
		return res;
	}
	public static int readInt()
	{
		int num=0;
		boolean parsedInt = true;
		String something = ConcreteGameTextInputState.scanner.nextLine();
		try {
			num = Integer.parseInt(something);
		} catch(NumberFormatException nfe) {
			MainWindow.updateTextArea("something didn't parse to an int\n");
			parsedInt = false;
		}
		while(! parsedInt){
			something = ConcreteGameTextInputState.scanner.nextLine();
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
	public static int readInt(Scanner scanner)
	{
		int num=0;
		boolean parsedInt = true;
		String something = scanner.nextLine();
		try {
			num = Integer.parseInt(something);
		} catch(NumberFormatException nfe) {
			MainWindow.updateTextArea("something didn't parse to an int\n");
			parsedInt = false;
		}
		while(! parsedInt){
			something = scanner.nextLine();
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
	public static char readChar()
	{
		char res = '?';
		try {
			res = ConcreteGameTextInputState.scanner.nextLine().trim().charAt(0);
		} catch (IndexOutOfBoundsException e) {
			printStream.println(e.getMessage());
		}
		return res;
	}
	public static char readChar(Scanner scanner)
	{
		char res = '?';
		try {
			res = scanner.nextLine().trim().charAt(0);
		} catch (IndexOutOfBoundsException e) {
			printStream.println(e.getMessage());
		}
		return res;
	}
}
