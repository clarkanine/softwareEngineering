package gamePack.gameEntityPack.gameCharacterPack;

import static org.junit.Assert.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameArtifactPack.ConcreteArtifact;
import gamePack.gameEntityPack.gameArtifactPack.GameArtifact;
import gamePack.gameEntityPack.gameBehaviorPack.*;

public class GameCharacterTest
{
	static GameCharacter player;
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
		player = new ConcreteGameCharacter();
	}
	
	@After
	public void tearDown() throws Exception
	{
		//scanner.close();
	}
	
	@Test
	public void testAccel()
	{
		
		player.setAccel(6.00);
		assertEquals(6.00, player.getAccel(), .08);
	}
	
	@Test
	public void testMaxSpeed()
	{
		player.setMaxSpeed(23.23);
		assertEquals(23.23, player.getMaxSpeed(), .08);
	}
	
	@Test
	public void testWeight()
	{	
		player.setWeight(100.34);
		assertEquals(100.34, player.getWeight(), .08);
	}
	
	@Test
	public void testHealth()
	{
		player.setHealth(90);
		assertEquals(90, player.getHealth());
	}
	
	@Test
	public void testBehaviors()
	{
		ArrayList<GameBehavior> behav = new ArrayList<>();
		GameBehavior test;
		test = new ConcreteBehavior();
		behav.add( (GameBehavior) test);
		
		System.out.println("Setting behaviors...\n");
		player.setBehaviors(behav);
		
		assertEquals(behav, player.getBehaviors() );
		
	}
	
	@Test 
	public void testArtifacts()
	{
		ArrayList<GameArtifact> art = new ArrayList<>();
		GameArtifact test;
		test = new ConcreteArtifact();
		art.add( (GameArtifact) test);
		
		System.out.println("Setting artifacts...\n");
		player.setArtifacts(art);
		
		assertEquals(art, player.getArtifacts() );
	}
	
	@Test 
	public void testStrength()
	{
		player.setStrength(100);
		assertEquals(100, player.getStrength() );
	}
	
	@Test
	public void testExp()
	{
		player.setExp(3000);
		assertEquals( 3000, player.getExp() );
	}
	
	@Test 
	public void testLoad()
	{
		
	}

}
