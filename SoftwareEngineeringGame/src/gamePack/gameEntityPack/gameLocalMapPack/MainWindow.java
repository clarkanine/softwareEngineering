package gamePack.gameEntityPack.gameLocalMapPack;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import gamePack.gameEntityPack.GameEntity;
import gamePack.gameEntityPack.gameCharacterPack.GameCharacter;
import gamePack.gameEntityPack.gameCharacterPack.gamePlayerPack.GamePlayer;
import gamePack.gameStatePack.DefaultMapState;
import sun.awt.image.ToolkitImage;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;


public class MainWindow implements GameLocalMap{

	/**
	 * 
	 */

	private static String playerName = "";
	private static String characterName = "";
	ArrayList<String> gameCharacterNames = new ArrayList<>();


	public static MainWindow window;

	private static JFrame frame;
	private static JTextField txtTextfield;
	private static TextFieldStreamer textFieldStreamer;
	private static JTextArea txtrTextarea;
	private static JTextArea txtrTextarea_1;
	private static JScrollPane scrollPane;
	private static JScrollPane scrollPane_1;
	private static JLayeredPane layeredPane;
	private static Thread[] threads = new Thread[3];
	private static MyCanvas canvas;
	//private static PlayerCanvas canvas_1 = new PlayerCanvas();


	//private static Canvas canvas_2;
	private static Boolean isPlayerMoving = false;
	private static Boolean isEnemyMoving = false;
	private static Integer xClicked = 0;
	private static Integer yClicked = 0;

	private static Integer playerInitX = 0;
	private static Integer playerInitY = 0;
	private static Integer playerCurX = playerInitX;
	private static Integer playerCurY = playerInitY;

	private static Integer enemyInitX = 200;
	private static Integer enemyInitY = 200;
	private static Integer enemyCurX = enemyInitX;
	private static Integer enemyCurY = enemyInitY;

	private static Boolean isGamePaused = true;

	private static int playerHitCount = 0;
	private static int enemyHitCount = 0;
	private static final int enemyMoveSleepMillis = 100;
	private static final double enemyStepPixels = 10;
	private static final int playerMoveSleepMillis = 50;
	private static final double playerStepPixels = 10;

	private double enemyPursuitRadius = 100;
	private double enemyCollisionRadius = 20;



	private final Action pauseAction = new PauseButtonSwingAction();
	private static JButton btnPause;



	/**
	 * Launch the application.
	 */
	//	protected static PlayerCanvas getCanvas_1() {
	//		return canvas_1;
	//	}
	//
	//	protected static void setCanvas_1(PlayerCanvas canvas_1) {
	//		MainWindow.canvas_1 = canvas_1;
	//	}

	private void movePlayer(int x, int y) {
		final Thread mover = new Thread(new Runnable() {




			public void run() {
				setIsPlayerMoving(true);
				/*int x0 = canvas.getX();
				int y0 = canvas.getY();*/
				int x0 = getPlayerCurX();
				int y0 = getPlayerCurY();

				double dx = getXClicked() - x0;
				double dy = getYClicked() - y0;
				double ds = Math.sqrt(dx*dx+dy*dy);
				double m = dy/dx;
				double b = getYClicked()-m*getXClicked();
				int xr = (int) Math.round(x0+ playerStepPixels*(dx/ds)), 
						yr = (int) Math.round(y0 + playerStepPixels*(dy/ds));
				while(ds>playerStepPixels && ! isGamePaused()) {
					canvas.thawPlayer();
					setPlayerCurX(xr);
					setPlayerCurY(yr);
					/*canvas.setLocation(xr, yr);
					x0 = canvas.getX();
					y0 = canvas.getY();*/
					x0 = getPlayerCurX();
					y0 = getPlayerCurY();
					dx = getXClicked() - x0;
					dy = getYClicked() - y0;
					ds = Math.sqrt(dx*dx+dy*dy);
					m = dy/dx;
					b = getYClicked()-m*getXClicked();
					xr = (int) Math.round((x0+ playerStepPixels*(dx/ds)));
					yr = (int) Math.round((y0 + playerStepPixels*(dy/ds)));
					try {
						Thread.sleep(playerMoveSleepMillis);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				setIsPlayerMoving(false);
				MyCanvas.freezePlayer();
			}
		});
		if(!getIsPlayerMoving() && !isGamePaused())
			mover.start();
	}

	private void pursue() {
		Thread pursuer = new Thread(new Runnable() {






			public void run() {
				while(!isGamePaused()) {
					if(/*distance(enemy, player)*/ distance(getEnemyCurX(), getEnemyCurY(), getPlayerCurX(), getPlayerCurY()) < 100) {
						setIsEnemyMoving(true);
						double ds;
						/*int x0 = enemy.getX();
						int y0 = enemy.getY();
						double dx = player.getX() - x0;
						double dy = player.getY() - y0;*/
						int x0 = getEnemyCurX();
						int y0 = getEnemyCurY();
						double dx = getPlayerCurX() - x0;
						double dy = getPlayerCurY() - y0;
						ds = Math.sqrt(dx*dx+dy*dy);
						double m = dy/dx;
						double b = getPlayerCurY() - m*getPlayerCurX();
						int xr = (int) Math.round(x0+ enemyStepPixels*(dx/ds)), 
								yr = (int) Math.round(y0 + enemyStepPixels*(dy/ds));
						while(ds < enemyPursuitRadius 
								&& ds>enemyCollisionRadius
								&& getIsEnemyMoving() 
								&& !isGamePaused()) {
							/*enemy.setLocation(xr, yr);*/
							canvas.thawEnemy();
							setEnemyCurX(xr);
							setEnemyCurY(yr);
							/*x0 = enemy.getX();
							y0 = enemy.getY();
							dx = player.getX()  - x0;
							dy = player.getY()  - y0;*/
							x0 = getEnemyCurX();
							y0 = getEnemyCurY();
							dx = getPlayerCurX() - x0;
							dy = getPlayerCurY() - y0;
							ds = Math.sqrt(dx*dx+dy*dy);
							m = dy/dx;
							b = getPlayerCurY() - m*getPlayerCurX();
							xr = (int) Math.round((x0+ enemyStepPixels*(dx/ds)));
							yr = (int) Math.round((y0 + enemyStepPixels*(dy/ds)));
							try {
								Thread.sleep(enemyMoveSleepMillis);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						if(ds<=enemyCollisionRadius) {
							synchronized(isEnemyMoving) {
								if(isEnemyMoving == true)
									txtrTextarea_1.append("enemy engaged you.\n");
								isEnemyMoving = false;
							}

							/*setIsPlayerMoving(false);
							MyCanvas.freezeEnemy();
							MyCanvas.freezePlayer();*/
							setGamePaused(true);

							setEnemyCurX(enemyInitX);
							setEnemyCurY(enemyInitY);

							setPlayerCurX(playerInitX);
							setPlayerCurY(playerInitY);

							pauseAction.putValue("NAME", "PLAY");
							pauseAction.putValue("SHORT_DESCRIPTION", "PLAY GAME");
							btnPause.setText("PLAY");
							DefaultMapState.setMapIsVisible(false);
						}
						setIsEnemyMoving(false);
						MyCanvas.freezeEnemy();
					}
				}
			}
		});
		if(!getIsEnemyMoving() && !isGamePaused())
			pursuer.start();

		//		while(getIsPlayerMoving()) {
		//			if(/*distance(enemy, player)*/distance(getEnemyCurX(), getEnemyCurY(), getPlayerCurX(), getPlayerCurY()) < 100 && !getIsEnemyMoving())
		//				pursuer.start();
		//			try {
		//				Thread.sleep(1);
		//			} catch (InterruptedException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//		}
	}

	//	private int distance(Canvas canvas0, Canvas canvas1) {
	//		return (int) Math.sqrt( Math.pow( canvas1.getX()-canvas0.getX(), 2) + Math.pow( canvas1.getY()-canvas0.getY(), 2 ) );
	//	}




	protected int distance(int enemyCurX2, int enemyCurY2, int playerCurX2, int playerCurY2) {
		return (int) Math.sqrt( Math.pow( getPlayerCurX()-getEnemyCurX(), 2) + Math.pow( getPlayerCurY()-getEnemyCurY(), 2 ) );
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainWindow();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	static Thread makePlayer() {
		return new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						canvas.setPlayerState(MyCanvas.PLAYERSTOPPED);
						//canvas_3.paint(canvas_3.getGraphics());
						Thread.sleep(100);

						canvas.setPlayerState(MyCanvas.PLAYERMOVING);
						Thread.sleep(100);

						canvas.setPlayerState(MyCanvas.PLAYERATTACKING);
						Thread.sleep(100);
					} catch (java.lang.InterruptedException e) {}
				}
			}
		});
	}

	static Thread makeEnemy() {
		return new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						canvas.setEnemyState(MyCanvas.ENEMYSTOPPED);
						//canvas_3.paint(canvas_3.getGraphics());
						Thread.sleep(100);

						canvas.setEnemyState(MyCanvas.ENEMYMOVING);
						Thread.sleep(100);

						canvas.setEnemyState(MyCanvas.ENEMYATTACKING);
						Thread.sleep(100);
					} catch (java.lang.InterruptedException e) {}
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		frame.setVisible(true);
		threads[0] = makePlayer();
		threads[0].start();
		threads[1] = makeEnemy();
		threads[1].start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 671, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtrTextarea = new JTextArea();
		txtrTextarea.setEditable(false);
		txtrTextarea.setText("textArea_0 ");
		frame.getContentPane().add(txtrTextarea, BorderLayout.NORTH);
		txtrTextarea.setColumns(10);
		txtrTextarea.setRows(1);

		txtTextfield = new JTextField();




		textFieldStreamer = new TextFieldStreamer(txtTextfield);
		//maybe this next line should be done in the TextFieldStreamer ctor
		//but that would cause a "leak a this from the ctor" warning
		txtTextfield.addActionListener(textFieldStreamer);
		DefaultCaret caret1 = (DefaultCaret)txtTextfield.getCaret();
		caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		System.setIn(textFieldStreamer);


		/*txtTextfield.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==(Character.valueOf('\n'))) {
				txtrTextarea_1.append("textArea_0 "+txtTextfield.getText());
				//txtrTextarea_1.append(txtTextfield.getText()+'\n');
				txtTextfield.setText("");
			}
		}
	});*/
		txtTextfield.setText("textField_0");
		frame.getContentPane().add(txtTextfield, BorderLayout.SOUTH);
		txtTextfield.setColumns(10);


		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.EAST);

		txtrTextarea_1 = new JTextArea();
		scrollPane.setViewportView(txtrTextarea_1);
		txtrTextarea_1.setEditable(false);
		txtrTextarea_1.setText("textArea_1\n");
		txtrTextarea_1.setRows(3);
		txtrTextarea_1.setColumns(20);



		btnPause = new JButton("Pause");
		btnPause.setAction(pauseAction);
		scrollPane.setColumnHeaderView(btnPause);




		scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1, BorderLayout.CENTER);

		layeredPane = new JLayeredPane();
		//layeredPane.setBackground(Color.BLACK);
		scrollPane_1.setViewportView(layeredPane);
		layeredPane.setLayout(null);

		canvas = new MyCanvas();
		//canvas.setBackground(Color.BLACK);
		//bg0.setPlayerState(1);
		layeredPane.setLayer(canvas, 0);
		canvas.setBounds(0, 0, 543, 332);
		layeredPane.add(canvas);


		//		canvas_1 = new PlayerCanvas();
		//		canvas_1.setPlayer(1);
		//		//canvas_1.setBackground(Color.WHITE);
		//		layeredPane.setLayer(canvas_1, 1);
		//		canvas_1.setBounds(0, 0, 100, 100);
		//		layeredPane.add(canvas_1);
		//
		//		canvas_2 = new Canvas();
		//		//bg0.setPlayerState(1);
		//		
		//		//canvas_2.setBackground(Color.BLACK);
		//		
		//		layeredPane.add(canvas_2);
		//		layeredPane.setLayer(canvas_2, 1);
		//		canvas_2.setBounds(259, 136, 1, 1);

		//		canvas_3 = new PlayerCanvas();
		//		canvas_3.setBounds(0,0,58,63);
		//		canvas_3.setPlayer(1);
		//		layeredPane.setLayer(canvas_3, 4);
		//		canvas_3.setBackground(Color.WHITE);
		//		layeredPane.add(canvas_3);

		/*ToolkitImage i = Toolkit.getDefaultToolkit().createImage("image/stopped.gif");
		MediaTracker mt = new MediaTracker(new Applet());
		mt.addImage(i, 0);*/
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!isGamePaused()) {
					int x = e.getX(), y = e.getY();
					MainWindow.setXClicked(x);
					MainWindow.setYClicked(y);
					txtrTextarea.setText("textArea_0 " + x + ", " + y);
					txtrTextarea_1.append(x + ", " + y + '\n');
					//canvas.thawPlayer();
					movePlayer(x, y);
					//canvas.thawEnemy();
					pursue();
					//canvas_1.setLocation(x-canvas_1.getWidth()/2, y-canvas_1.getHeight()/2);
				}
			}
		});


		txtTextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_UP
						|| e.getKeyCode()==KeyEvent.VK_DOWN
						|| e.getKeyCode()==KeyEvent.VK_LEFT
						|| e.getKeyCode()==KeyEvent.VK_RIGHT
						) {
					txtrTextarea_1.append(KeyEvent.getKeyText(e.getExtendedKeyCode())+"\n");
					//txtrTextarea_1.append(txtTextfield.getText()+'\n');
					txtTextfield.setText("");
					synchronized(playerCurY) {
						synchronized(playerCurX) {
							if(!isGamePaused 
									&& playerCurY>=0 
									&& playerCurY<canvas.getHeight() 
									&& playerCurX>=0 
									&& playerCurX<canvas.getWidth()) {
								switch(e.getKeyCode()) {
								case KeyEvent.VK_UP:
									if(playerCurY- (int)playerStepPixels >0)
										playerCurY -= (int)playerStepPixels;
									break;
								case KeyEvent.VK_DOWN:
									if(playerCurY + (int)playerStepPixels<canvas.getHeight())
										playerCurY += (int)playerStepPixels;
									break;
								case KeyEvent.VK_LEFT:
									if(playerCurX - (int)playerStepPixels>0)
										playerCurX -= (int)playerStepPixels;
									break;
								case KeyEvent.VK_RIGHT:
									if(playerCurX + (int)playerStepPixels<canvas.getWidth())
										playerCurX += (int)playerStepPixels;
									break;
								default:
									txtrTextarea_1.append(KeyEvent.getKeyText(e.getExtendedKeyCode())+"\n");
								}
								canvas.thawPlayer();
								canvas.update(canvas.getGraphics());
								MyCanvas.freezePlayer();
								txtrTextarea.setText(" ("+playerCurX + ", " + playerCurY +")");
								//txtrTextarea.append(KeyEvent.getKeyText(e.getExtendedKeyCode()));
							}
						}
					}
					
				}
			}
		});

	}

	public static void updateTextArea(final String text) {
		if(window==null)
			window = new MainWindow();
		synchronized(txtrTextarea_1) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					//txtrTextarea_1.setText(text);
					txtrTextarea_1.append(text);
					txtTextfield.requestFocus();
					txtrTextarea_1.setCaretPosition(txtrTextarea_1.getDocument().getLength());

				}
			});
		}
	}

	private Boolean getIsPlayerMoving() {
		synchronized(isPlayerMoving) {
			return isPlayerMoving;
		}
	}

	private static void setIsPlayerMoving(Boolean moving) {
		synchronized(moving) {
			MainWindow.isPlayerMoving = moving;
		}
	}

	static int getXClicked() {
		synchronized(xClicked) {
			return xClicked;
		}
	}

	static void setXClicked(int x1) {
		synchronized(MainWindow.xClicked) {
			MainWindow.xClicked = x1;
		}
	}

	static int getYClicked() {
		synchronized(yClicked) {
			return yClicked;
		}
	}

	static void setYClicked(int y1) {
		synchronized(MainWindow.yClicked) {
			MainWindow.yClicked = y1;
		}
	}

	private static Boolean getIsEnemyMoving() {
		synchronized(isEnemyMoving) {
			return isEnemyMoving;
		}
	}

	private static void setIsEnemyMoving(Boolean enemyMoving) {
		synchronized(enemyMoving) {
			MainWindow.isEnemyMoving = enemyMoving;
		}
	}

	private static int getPlayerHitCount() {
		return playerHitCount;
	}

	private static void setPlayerHitCount(int contactCount) {
		MainWindow.playerHitCount = contactCount;
	}

	private static int getEnemyHitCount() {
		return enemyHitCount;
	}

	private static void setEnemyHitCount(int enemyHitCount) {
		MainWindow.enemyHitCount = enemyHitCount;
	}

	static int getPlayerCurX() {
		synchronized(playerCurX) {
			return playerCurX;
		}
	}

	static void setPlayerCurX(int playerCurX) {
		synchronized(MainWindow.playerCurX) {
			MainWindow.playerCurX = playerCurX;
		}
	}

	static int getPlayerCurY() {
		synchronized(playerCurY) {
			return playerCurY;
		}
	}

	static void setPlayerCurY(int playerCurY) {
		synchronized(MainWindow.playerCurY) {
			MainWindow.playerCurY = playerCurY;
		}
	}

	static int getEnemyCurX() {
		synchronized(enemyCurX) {
			return enemyCurX;
		}
	}

	static void setEnemyCurX(int enemyCurX) {
		synchronized(MainWindow.enemyCurX) {
			MainWindow.enemyCurX = enemyCurX;
		}
	}

	static int getEnemyCurY() {
		synchronized(enemyCurY) {
			return enemyCurY;
		}
	}

	static void setEnemyCurY(int enemyCurY) {
		synchronized(MainWindow.enemyCurY) {
			MainWindow.enemyCurY = enemyCurY;
		}
	}
	private static boolean isGamePaused() {
		synchronized(isGamePaused) {
			return isGamePaused;
		}
	}

	private static void setGamePaused(boolean isGamePaused) {
		synchronized(MainWindow.isGamePaused) {
			MainWindow.isGamePaused = isGamePaused;
		}
	}
	private class PauseButtonSwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6138967167992441528L;
		public PauseButtonSwingAction() {
			putValue(NAME, "PLAY");
			putValue(SHORT_DESCRIPTION, "PLAY GAME?");
		}
		public synchronized void actionPerformed(ActionEvent e) {
			if(! DefaultMapState.mapIsVisible())
				return;
			if(isGamePaused() == true) {
				setGamePaused(false);
				btnPause.setText("PAUSE");
				pursue();
				canvas.thawEnemy();
				canvas.thawPlayer();
				canvas.update(canvas.getGraphics());
				MyCanvas.freezeEnemy();
				MyCanvas.freezePlayer();
				//setIsEnemyMoving(false);
				//setIsPlayerMoving(false);
				putValue(NAME, "PAUSE");
				putValue(SHORT_DESCRIPTION, "PAUSE GAME?");
				this.notifyAll();
			}
			else {
				setGamePaused(true);
				btnPause.setText("PLAY");
				//					MyCanvas.freezeEnemy();
				//					MyCanvas.freezePlayer();
				//					setIsEnemyMoving(false);
				//					setIsPlayerMoving(false);
				putValue(NAME, "PLAY");
				putValue(SHORT_DESCRIPTION, "PLAY GAME");
				this.notifyAll();
			}
		}
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


















