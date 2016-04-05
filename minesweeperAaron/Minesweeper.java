/*
  Coding Dream Team
  Aaron Clark
  Software Engineering
  April 5, 2016
*/

import java.io.*;
import java.util.*;

public class Minesweeper
{
    public static void main(String args[])
    {
	Scanner input = new Scanner(System.in);
        Board b;

	b = new Board();

	b.createFields(input, 0);
	
    }
}
