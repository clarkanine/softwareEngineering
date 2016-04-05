import java.util.*;
import java.io.*;

public class GenerateField
{
    public static void main(String[] args)
    {
	Scanner user = new Scanner(System.in);
	int rows, cols, i, j;
	char[][] field;
	Random gen = new Random();
	double num;

	double bombRate = .30;

	rows = user.nextInt();
	cols = user.nextInt();

	field = new char[rows][cols];

	System.out.println(rows + " " + cols);

	for(i = 0; i < rows; i++)
	    {
		for(j = 0; j < cols; j++)
		    {
			num = gen.nextDouble();
			if(num < bombRate)
			    System.out.print('*');
			else
			    System.out.print('.');
		    }
		System.out.println();
	    }

	System.out.println("0 0");
	
    }
}
