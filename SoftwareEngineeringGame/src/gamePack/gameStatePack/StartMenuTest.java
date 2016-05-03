package gamePack.gameStatePack;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StartMenuTest {

	static GameState gameState;
	static Scanner scanner;
	static PrintStream printStream;
	static PrintStream errorLog;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InputStream in = System.in;
		OutputStream out = System.out;
		scanner = new Scanner(in);
		printStream = new PrintStream(out);
		try {
			errorLog = new PrintStream(new File("TestLogs/TestProfileInputErrorLog_"+System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		gameState = new StartMenu(scanner, printStream, errorLog);
	}

	@After
	public void tearDown() throws Exception {
		//scanner.close();
	}

	@Test
	public void testOpenMenu() {
		((StartMenu) gameState).openMenu();
	}

}
