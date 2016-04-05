import java.io.*;
import java.util.*;

public class Board
{
    private Cell[][] theBoard;
    private int rows, cols;

    public Board()
    {
	int i, j;
	String line;

	theBoard = new Cell[102][102];
	
	for(i = 0; i < theBoard.length; i++)
	    for(j = 0; j < theBoard.length; j++)
		theBoard[i][j] = new Cell(' ');
    } // end Board Constructor

    // Creates and prints out a minefield recursively until "0 0"
    // line appears, or invalid field size is entered
    
    public void createFields(Scanner input, int i)
    {
	if( i == 0 && !input.hasNextInt() )
	    {
		System.out.println("Empty file");
		System.exit(1);
	    }
	
	rows = input.nextInt();
	cols = input.nextInt();

	if(rows == 0 && cols == 0)
	    System.exit(1);

	if(rows <= 0 || cols <= 0 || rows > 100 || cols > 100)
	    {
		System.out.println("Invalid field size.");
		System.exit(1);
	    }
	
	fillBoard(input);
	System.out.println("Field #" + (++i) + ":");
	System.out.print(this.toString() );
	clearBoard();
	
	createFields(input, i);
    } // end createFields


   // Fills board with input from
    // a redirected input file
    // in the form of a 2d array
    // of characters
    public void fillBoard(Scanner input)
    {
	int i, j;
	String line;
	char c;

	line = input.nextLine();
	System.out.println(line);

	for(i = 1; i < rows + 1; i++)
	    {
		line = input.nextLine();
	        //System.out.println(line);
		for(j = 1; j < cols + 1; j++)
		    if( ( c = line.charAt(j - 1) ) == '*')
			this.setMine(i, j);
	    } // end i loop
	
    } // end fillBoard

    private void setMine(int i, int j)
    {
	int r, c;
	theBoard[i][j].setMine();

	for(r = i - 1; r < i + 2; r++)
	    for(c = j - 1; c < j + 2; c++)
		if(  !(r == i && c == j) )
		    theBoard[r][c].incAdjMines();
    } // end setMine

    public String toString()
    {
	int i, j;
	String ret = "";

	for(i = 1; i < rows + 1; i++)
	    {
		for(j = 1; j < cols + 1; j++)
		    {
			if(theBoard[i][j].isMine() )
			    ret += "*";
			else
			    ret += theBoard[i][j].getNumMines() + "";
		    } // end j loop
		ret += "\n";
	    } // end i loop
	
	return ret;
    } // end toString

    public void clearBoard()
    {
	int i, j;

	for(i = 0; i < theBoard.length; i++)
	    for(j = 0; j < theBoard.length; j++)
		theBoard[i][j].resetCell();
    } // end clearBoard
}
