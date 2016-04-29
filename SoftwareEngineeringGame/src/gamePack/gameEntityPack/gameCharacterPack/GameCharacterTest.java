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
import gamePack.gameEntityPack.GameEntity;
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
		double res;
		System.out.print("Enter 6.00 for acceleration: ");
		res = scanner.nextDouble();
		
		player.setAccel(res);
		assertEquals(6.00, player.getAccel(), .08);
	}
	
	@Test
	public void testMaxSpeed()
	{
		double res;
		System.out.print("Enter 23.23 for speed: ");
		res = scanner.nextDouble();
		
		player.setMaxSpeed(res);
		assertEquals(23.23, player.getMaxSpeed(), .08);
	}
	
	@Test
	public void testWeight()
	{
		double res;
		System.out.print("Enter 100.34 for weight: ");
		res = scanner.nextDouble();
		
		player.setWeight(res);
		assertEquals(100.34, player.getWeight(), .08);
	}
	
	@Test
	public void testHealth()
	{
		double res;
		System.out.println(("Enter 90.0 for health: "));
		res = scanner.nextDouble();
		
		player.setHealth(res);
		assertEquals(90.0, player.getHealth(), .08);
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

}
