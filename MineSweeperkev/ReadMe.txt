Team:		CodingDreamTeam

Names:		Aaron Clark
			James Ralston
			Kevin Chumbley
			
Course:		CSCD350 - Software Engineering

Assignment:	Assignment 2 - Team Coding Exercise

Title:		MineSweeper

Description:
	reads field dimensions from standard input
	reads each line of field as String of . (no mine) or * (mine)
	stores field
	store a padded array of zeros and increment hints surrounding mines
	print all stored hints fields

Setup:
	Unzip the submitted MineSweeper.zip, you get
	a folder named MineSweeper. Compile from
	source files and run.

	Terminal:
		Open Terminal and Change directory into MineSweeper/bin
		Clean, compile and run (See below for commands).
		To Clean from Terminal:
			cd bin
			rm -rd ./*.class
		To Compile from Terminal:
			cd bin
			javac -d ./ ../src/*.java ../src/*.java
		To Run:
			cd bin
			java MineSweeper < ../input.txt
 
	Eclipse:
		Open Eclipse and Drag all files in MineSweeper/src into an
		existing project source folder then compile and run as a Java Application

Developed for:
	Terminal (for Darwin) 
		Version: 2.6.1 (361.1)
	Eclipse IDE for Java Developers
		Version: Mars.2 Release (4.5.2)
	
Note:
	input file is redirected to standard input

	input file is of the form:
	3 3
	...
	.*.
	...
	
	



