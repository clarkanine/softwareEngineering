package gamePack.gameStatePack;

import java.util.*;
import java.io.*;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelpMenuTest 
{

	static GameStateContext gameStateContext;
	static Scanner scanner;
	static PrintStream printStream;
	static PrintStream errorLog;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		InputStream in = System.in;
		OutputStream out = System.out;
		
		scanner = new Scanner(in);
		printStream = new PrintStream(out);
		
		try
		{
			errorLog = new PrintStream(new File("TestLogs/HelpMenuErrorLog_" + System.currentTimeMillis()));
		}
		catch(FileNotFoundException nfe)
		{
			nfe.printStackTrace();
		}
		
		gameStateContext = new GameStateContext();
	}//end setupbeforeclass
	
	@After
	public void tearDown() throws Exception
	{
		
	}//end tearDown
	
	@Test
	public void testRun() 
	{
		gameStateContext.run();
	}//end testRun

}
