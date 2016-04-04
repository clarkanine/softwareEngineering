import java.io.*;
import java.util.*;

class MineSweeper
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		ArrayList<String[][]> inputs = new ArrayList<>();
		ArrayList<String[][]> outputs = new ArrayList<>();
		int n, m, f = 0;

		while( (n = parseMyInt(kb)) != 0 && (m = parseMyInt(kb)) != 0)
		{
			kb.nextLine();
			String[][] arr = storeField(kb, n, m);
			inputs.add(arr);
			String[][] hints = getHints(arr);
			outputs.add(hints);
		}

		for(String[][] output: outputs)
		{
			ps.println();
			printHints(ps, ++f, output);
		}
	}

	private static String[][] storeField(Scanner kb, int n, int m)
	{
		String [][] arr = new String [n][m];

		for(int i = 0; i< n ; i++)
		{
			String curLine = kb.nextLine();

			for(int j = 0; j< m ; j++)
			{
				String curElem = ""+curLine.toCharArray()[j];
				arr[i][j] = curElem;
			}
		}
		return arr;
	}

	private static String[][] getHints(String[][] arr) 
	{
		int n = arr.length, m = arr[0].length;
		String [][] hints = new String [n+2][m+2];

		for(int i = 0; i< n+2 ; i++)
		{
			for(int j = 0; j< m+2 ; j++)
			{
				hints[i][j]="0";
			}
		}

		for(int i = 1; i< n+2-1 ; i++)
		{
			for(int j = 1; j< m+2-1 ; j++)
			{
				if(arr[i-1][j-1].equals("*"))
				{
					hints[i][j] = "*";
					incrementAdjacentHints(hints, i, j);
				}
			}
		}
		return hints;
	}

	private static void incrementAdjacentHints(String[][] hints, int i, int j)
	{
		hints[i-1][j-1] = increment(hints[i-1][j-1]);
		hints[i-1][j]   = increment(hints[i-1][j]);
		hints[i-1][j+1] = increment(hints[i-1][j+1]);
		hints[i][j-1]   = increment(hints[i][j-1]);
		hints[i][j+1]   = increment(hints[i][j+1]);
		hints[i+1][j-1] = increment(hints[i+1][j-1]);
		hints[i+1][j]   = increment(hints[i+1][j]);
		hints[i+1][j+1] = increment(hints[i+1][j+1]);
	}

	private static void printHints(PrintStream ps, int f, String[][] hints) 
	{
		if(f == 0)
			return;

		int n = hints.length, m = hints[0].length;
		ps.println("Field #"+f+":");

		for(int i = 1; i < n-1; i++) 
		{
			for(int j = 1; j < m-1; j++) 
			{
				if(hints[i][j] == "*")
					ps.print("*");
				else
					ps.print(hints[i][j]);
			}
			ps.println();
		}
	}

	private static String increment(String passedIn) 
	{
		if( passedIn.equals("*") )
			return "*";
		
		int num = 0;
		boolean parsedInt = true;
		
		try 
		{
			num = Integer.parseInt(passedIn);
		} 
		catch(NumberFormatException nfe) 
		{
			//System.out.println("something didn't parse to an int");
			parsedInt = false;
		}
		num++;
		return parsedInt ? ""+num : "?" ;
	}

	private static int parseMyInt(Scanner kb)
	{
		int num=0;
		boolean parsedInt = true;

		if(! kb.hasNext() )
			return 0;
		
		String something = kb.next();

		try
		{
			num = Integer.parseInt(something);
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("something didn't parse to an int");
			parsedInt = false;
		}

		while(! parsedInt)
		{
			something = kb.nextLine();

			try
			{
				num = Integer.parseInt(something);

				parsedInt = true;       /*nfe skips this*/
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("something didn't parse to an int");
				parsedInt = false;
			}
		}
		return num;
	}
}