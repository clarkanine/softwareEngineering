/*
  Coding Dream Team
  Aaron Clark
  Software Engineering
  April 5, 2016
*/


// README: To use this program, run it with
//         a redirection to an output file.
//         Usage: java GenerateField > output.txt
//         once running, two ints are required.
//         The first will be the number of rows,
//         the second will be the number of cols.
//         EX: 7 <Enter> 9 <Enter> will create
//         a 7 x 9 randomized field.

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

	double bombRate = .30; // 30% bomb rate

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
