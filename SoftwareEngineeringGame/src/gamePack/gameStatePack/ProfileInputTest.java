package gamePack.gameStatePack;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProfileInputTest {
	static GameState gameState;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gameState = new ProfileInput();
	}

	@After
	public void tearDown() throws Exception {
		//scanner.close();
	}

	@Test
	public void testReadWord() {
		System.out.println("type \"word\" with a single trailing space and return");
		String res = ((ProfileInput) gameState).readWord();
		assertEquals("word",res);
		((ProfileInput) gameState).readLine();

		System.out.println("type \"word\" with a single trailing space and return");
		res = ((ProfileInput) gameState).readWord();
		((ProfileInput) gameState).readLine();
		assertEquals("word",res);
	}

	@Test
	public void testReadLine() {
		System.out.println("type \"word\" with or without trailing space and return");
		String res = ((ProfileInput) gameState).readLine();
		assertEquals("word",res);

	}

	@Test
	public void testReadInt() {
		System.out.println("type \"2\" followed by any garbage and return");
		String res = Integer.toString(((ProfileInput) gameState).readInt());
		assertEquals("2",res);

	}

	@Test
	public void testReadChar() {
		System.out.println("type \"a\" followed by any garbage and return");
		String res = Character.toString(((ProfileInput) gameState).readChar());
		assertEquals("a",res);

	}

	@Test
	public void testOpenMenu() {
		((ProfileInput) gameState).openMenu();
	}
}
