package gamePack.gameStatePack;
import java.util.*;
import java.io.*;

public class HelpMenuState extends StartMenu
{
	private GameStateContext GameStateContext;
	private Scanner scanner = new Scanner(System.in);


	public HelpMenuState()
	{
		this.setScanner( new Scanner(System.in) );
		this.setPrintStream( new PrintStream(System.out) );
		try
		{
			this.setGameErrorLog(new PrintStream(new File("GameData/HelpMenuErrorLog_"+System.currentTimeMillis() ) ) );
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}//end catch
	}//end HelpMenuState
	
	
	public void run(GameStateContext gameStateContext)
	{
		this.GameStateContext = gameStateContext;
		System.out.println( gameStateContext.getState().getClass().getSimpleName()+ "\n" );
		this.openMenu();
		gameStateContext.run();
	}//end run
	
	
	public void openMenu()
	{
		System.out.println("\t\t\t\t______-------Help-------______\t\t\t\t");
		System.out.println("This is the help menu.");
	}//end openMenu()
	
}//end HelpMenuState
