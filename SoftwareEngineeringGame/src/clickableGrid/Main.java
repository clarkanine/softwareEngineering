package clickableGrid;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Main {

	private JFrame frame;
	JLayeredPane layeredPane;
	JScrollPane scrollPane;
	JTextArea textArea_bg;
	JTextArea textArea_player;
	JTextArea textArea_enemy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
//		BoxListener b = new BoxListener();
//		ArrayList<JPanel> nearbyBoxs = b.getNearbyBoxes(0, 0, 100); 
//		for(JPanel box: nearbyBoxs) {
//			if(box.isOpaque())
//				box.setOpaque(false);
//		}
		//testWithRobot();	
	}

	private void testWithRobot() {
		new Thread(new Runnable() {
			public void run() {
				Robot robot = null;
				try {
					robot = new Robot(frame.getGraphicsConfiguration().getDevice());
				} catch (AWTException e) {
					e.printStackTrace();
				}
				robot.waitForIdle();
				robot.mouseMove(150, 150);
				robot.mousePress(InputEvent.getMaskForButton(1));
				robot.mouseRelease(InputEvent.getMaskForButton(1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				robot.mouseMove(250, 250);
				robot.mousePress(InputEvent.getMaskForButton(1));
				robot.mouseRelease(InputEvent.getMaskForButton(1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				robot.mouseMove(350, 350);
				robot.mousePress(InputEvent.getMaskForButton(1));
				robot.mouseRelease(InputEvent.getMaskForButton(1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				robot.mouseMove(450, 450);
				robot.mousePress(InputEvent.getMaskForButton(1));
				robot.mouseRelease(InputEvent.getMaskForButton(1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				robot.mouseMove(550, 550);
				robot.mousePress(InputEvent.getMaskForButton(1));
				robot.mouseRelease(InputEvent.getMaskForButton(1));
			}
		}).start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		MyGrid myGrid = new MyGrid(42, 100);
		myGrid.setBounds(0, 0, 1000, 800);
		myGrid.setPreferredSize(new Dimension(1000, 800));
		//myGrid.setOpaque(false);
		
		
		textArea_bg = new JTextArea();//"", 100, 100, TextArea.SCROLLBARS_NONE);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
		textArea_bg.setForeground(Color.WHITE);
		textArea_bg.setBackground(Color.BLACK);
		textArea_bg.setFont(font);
		textArea_bg.setEditable(false);
		textArea_bg.setBounds(0, 0, 1000, 1000);
		textArea_bg.setPreferredSize(new Dimension(1000, 800));
		textArea_bg.setName("bg");
		
		textArea_player = new JTextArea();//"", 100, 100, TextArea.SCROLLBARS_NONE);
		Font font_1 = new Font(Font.MONOSPACED, Font.PLAIN, 2);
		textArea_player.setForeground(Color.BLACK);
		textArea_player.setBackground(Color.WHITE);
		textArea_player.setFont(font_1);
		textArea_player.setEditable(false);
		textArea_player.setBounds(0, 0, 45, 70);
		textArea_player.setPreferredSize(new Dimension(100, 100));
		textArea_player.setName("player");
		
		textArea_enemy = new JTextArea();//"", 100, 100, TextArea.SCROLLBARS_NONE);
		textArea_enemy.setForeground(Color.WHITE);
		textArea_enemy.setBackground(Color.BLACK);
		textArea_enemy.setFont(font_1);
		textArea_enemy.setEditable(false);
		textArea_enemy.setBounds(250, 250, 45, 70);
		textArea_enemy.setPreferredSize(new Dimension(100, 100));
		textArea_enemy.setName("enemy0");

		Scanner fin = null;
		try {
			fin = new Scanner(new FileInputStream("Backgrounds/WorldMapAscii"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String bg = "";
		while(fin.hasNextLine())
			bg+=fin.nextLine()+"\n";

		fin.close();
		try {
			fin = new Scanner(new FileInputStream("Backgrounds/DefaultPlayerAscii"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String player = "";
		while(fin.hasNextLine())
			player+=fin.nextLine()+"\n";
		fin.close();
		
		try {
			fin = new Scanner(new FileInputStream("Backgrounds/DefaultPlayerAscii"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String enemy = "";
		while(fin.hasNextLine())
			enemy+=fin.nextLine()+"\n";
		fin.close();

		/*		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++)
				bg += ". ";
			bg += "\n";
		}*/

		textArea_bg.setText(bg);
		textArea_player.setText(player);
		textArea_enemy.setText(enemy);

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1000, 800));
		layeredPane.add(myGrid);
		layeredPane.setLayer(myGrid, 2);
		layeredPane.add(textArea_bg);
		layeredPane.setLayer(textArea_bg, 0);
		layeredPane.add(textArea_player);
		layeredPane.setLayer(textArea_player, 3);
		layeredPane.add(textArea_enemy);
		layeredPane.setLayer(textArea_enemy, 1);


		scrollPane = new JScrollPane(layeredPane);
		scrollPane.setLayout(new ScrollPaneLayout());



		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);



	}
	
	
	
}
