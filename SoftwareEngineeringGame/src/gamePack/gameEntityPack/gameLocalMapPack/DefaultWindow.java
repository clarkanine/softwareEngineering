package gamePack.gameEntityPack.gameLocalMapPack;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.DefaultMapState;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
//import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.InputEvent;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
//import java.awt.FlowLayout;
import javax.swing.JTextField;

public class DefaultWindow implements GameLocalMap{




	private static DefaultWindow window;
	private static JFrame frame;
	//private static JPanel textIOPanel;
	private static JLayeredPane layeredPane;
	private static JScrollPane scrollPane;
	private static MyGrid myGrid;
	private static JTextArea textArea_bg;
	private static JTextArea textArea_player;
	private static JTextArea textArea_enemy;
	private static JSplitPane splitPane;
	private static JTextArea textArea;
	private static JTextField textField;
	private static TextFieldStreamer textFieldStreamer;
	private static JScrollPane scrollPane0;
	private static Font bgFont = new Font(Font.MONOSPACED, Font.PLAIN, 16);
	private static Font gameCharacterFont = new Font(Font.MONOSPACED, Font.PLAIN, 2);
	private static String asciiBgPathStr = "Backgrounds/WorldMapAscii";
	private static String asciiPlayerPathStr = "Backgrounds/DefaultPlayerAscii";
	private static String asciiEnemyPathStr = "Backgrounds/DefaultPlayerAscii";

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(DefaultWindow.window == null)
						window = new DefaultWindow();
					//window.getContentPane().add(frame);

					DefaultWindow.frame.setVisible(true);
					//window.frame.addNotify();
					//window.frame.requestFocus();
					//notifyAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DefaultWindow() {
		initialize();
		//testWithRobot();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.toFront();

		makeMapPane();
		makeTextPane();
		DefaultMapState.setMapIsVisible(false);
	}

	public static void updateTextArea(final String text) {
		if(scrollPane0==null)
			makeTextPane();
		synchronized(textArea) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					textArea.append(text);
					textField.requestFocus();
					textArea.setCaretPosition(textArea.getDocument().getLength());
					
				}
			});
		}
	}

	public static void restartMap() {
		makeMapPane();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				textArea_player.setLocation(0,0);
				textArea_player.setLocation(0,0);
				myGrid.setOpaque(true);
				for(Component c: myGrid.getComponents())
					((JPanel)c).setOpaque(true);

				scrollPane.setVisible(true);

				textArea_bg.setOpaque(true);
				myGrid.requestFocus();
			}
		});
	}

	public static void newTextPane() {
		if(scrollPane0==null)
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					makeTextPane();
				}
			});
	}

	public static void newMapPane() {
		if(scrollPane==null)
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					makeMapPane();
					scrollPane.setVisible(true);
					textArea_enemy.setVisible(true);
					textArea_player.setVisible(true);
					myGrid.setVisible(true);
					textArea_player.getParent().getComponent(0).setVisible(true);
					frame.getContentPane().setVisible(true);
					//DefaultMapState.setMapIsVisible(true);

					textArea_player.requestFocus();
				}
			});
	}









	public static void makeTextPane() {

		if(window ==null)
			main(null);
		textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setAutoscrolls(true);
		DefaultCaret caret0 = (DefaultCaret)textArea.getCaret();
		caret0.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		textField = new JTextField();
		textFieldStreamer = new TextFieldStreamer(textField);
		//maybe this next line should be done in the TextFieldStreamer ctor
		//but that would cause a "leak a this from the ctor" warning
		textField.addActionListener(textFieldStreamer);
		DefaultCaret caret1 = (DefaultCaret)textField.getCaret();
		caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		System.setIn(textFieldStreamer);

		textField.setColumns(100);

		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setAutoscrolls(true);

		splitPane.setTopComponent(textArea);
		splitPane.setBottomComponent(textField);

		scrollPane0 = new JScrollPane(splitPane);
		scrollPane0.setViewportBorder(null);
		scrollPane0.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane0.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane0.setLayout(new ScrollPaneLayout());
		scrollPane0.setAutoscrolls(true);


		//textIOPanel = new JPanel();
		//textIOPanel.add(scrollPane0, BorderLayout.CENTER);

		frame.getContentPane().add(scrollPane0, BorderLayout.SOUTH);

	}




	private static void makeMapPane() {
		if(window ==null)
			main(null);



		myGrid = new MyGrid(42, 100);
		myGrid.setBounds(0, 0, 1000, 800);
		//myGrid.setPreferredSize(new Dimension(1000, 800));

		makeTextArea_Bg();
		makeTextArea_Player();
		makeTextArea_Enemy();

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
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setLayout(new ScrollPaneLayout());
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	private static void makeTextArea_Enemy() {
		textArea_enemy = new JTextArea();//"", 100, 100, TextArea.SCROLLBARS_NONE);
		textArea_enemy.setForeground(Color.WHITE);
		textArea_enemy.setBackground(Color.BLACK);
		textArea_enemy.setFont(DefaultWindow.gameCharacterFont);
		textArea_enemy.setEditable(false);
		textArea_enemy.setBounds(250, 250, 45, 70);
		textArea_enemy.setPreferredSize(new Dimension(100, 100));
		textArea_enemy.setName("enemy0");
		Scanner fin=null;
		try {
			fin = new Scanner(new FileInputStream(DefaultWindow.asciiEnemyPathStr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String enemy = "";
		while(fin.hasNextLine())
			enemy+=fin.nextLine()+"\n";
		fin.close();
		textArea_enemy.setText(enemy);

	}

	private static void makeTextArea_Player() {
		textArea_player = new JTextArea();//"", 100, 100, TextArea.SCROLLBARS_NONE);
		textArea_player.setForeground(Color.BLACK);
		textArea_player.setBackground(Color.WHITE);
		textArea_player.setFont(DefaultWindow.gameCharacterFont);
		textArea_player.setEditable(false);
		textArea_player.setBounds(0, 0, 45, 70);
		textArea_player.setPreferredSize(new Dimension(100, 100));
		textArea_player.setName("player");
		Scanner fin=null;
		try {
			fin = new Scanner(new FileInputStream(DefaultWindow.asciiPlayerPathStr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String player = "";
		while(fin.hasNextLine())
			player+=fin.nextLine()+"\n";

		fin.close();
		textArea_player.setText(player);
	}

	private static void makeTextArea_Bg() {
		textArea_bg = new JTextArea();//"", 100, 100, TextArea.SCROLLBARS_NONE);
		textArea_bg.setForeground(Color.WHITE);
		textArea_bg.setBackground(Color.BLACK);
		textArea_bg.setFont(bgFont);
		textArea_bg.setEditable(false);
		textArea_bg.setBounds(0, 0, 1000, 1000);
		textArea_bg.setPreferredSize(new Dimension(1000, 800));
		textArea_bg.setName("bg");
		Scanner fin=null;
		try {
			fin = new Scanner(new FileInputStream(asciiBgPathStr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String bg = "";
		while(fin.hasNextLine())
			bg+=fin.nextLine()+"\n";

		fin.close();
		textArea_bg.setText(bg);
	}


	/*	static String res = "";
	public static String readTextField(final String text) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				res = textArea.getText();
			}
		});
		return res;
	}*/



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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setView(String view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacters(ArrayList<GameCharacter> characters) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<GameCharacter> getCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayers(ArrayList<GamePlayer> player) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<GamePlayer> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLocalX(GameEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLocalX(int x, GameEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLocalY(GameEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLocalY(int y, GameEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public double distanceTo(GameEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}



}
