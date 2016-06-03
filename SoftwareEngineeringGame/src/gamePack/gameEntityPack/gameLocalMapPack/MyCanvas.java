package gamePack.gameEntityPack.gameLocalMapPack;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;


public class MyCanvas extends Canvas {

	private static final long serialVersionUID = 4487681749374778705L;
	
	MediaTracker mt = new MediaTracker(this);

	Image offscreen;
	Dimension offscreenSize;

	Graphics2D offGraphics;

	MyCanvas() {
		super();
		initBg(); 		//read one background +
		initPlayer(); 	//read three player states +
		initEnemy(); 	//read three enemy states = 7 images total in tracker
		try {
			for(int k = 0; k< 1+playerStates.size()+enemyStates.size(); k++)
				mt.waitForID(k);
		} catch (java.lang.InterruptedException e) {
			System.out.println("Couldn't load one of the images");
		}
	}


	public static void main(String args[]) {
		JFrame mainFrame = new JFrame("Graphics demo");
		mainFrame.getContentPane().add(new MyCanvas());
		mainFrame.pack();
		mainFrame.setVisible(true);
	}




	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Dimension d = getSize();
		if ((offscreen == null) || (d.width != offscreenSize.width)
				|| (d.height != offscreenSize.height)) {
			offscreen = createImage(d.width, d.height);
			offscreenSize = d;
			offGraphics = (Graphics2D) offscreen.getGraphics();
			offGraphics.setFont(new Font("Helvetica",Font.BOLD,18));

		}
		bgPaint();

		
		bgMaskPaint();
		enemyPaint();
		playerPaint();

		g.drawImage(offscreen, 0, 0, null);
		g.dispose();
	}






	private static final String bgPathStr = "image/worldmap.gif";
	private static Image bg;

	private static BufferedImage bgMask = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
	private static final Graphics2D bgMaskG2D = bgMask.createGraphics();

	void initBg() {
		if(Files.exists(Paths.get(bgPathStr), LinkOption.NOFOLLOW_LINKS)) {
			bg = Toolkit.getDefaultToolkit().createImage(bgPathStr);
			mt.addImage(bg, 0);
		}
		else {
			System.out.println(bgPathStr+" was not found");
			System.exit(-1);
		}
	}

	void bgPaint() {
		offGraphics.setColor(getBackground());
		offGraphics.fill(getBounds());
		offGraphics.drawImage(bg, 0, 0, this);
	}

	private void bgMaskPaint() {

		/* Draw the grey rectangle */
		bgMaskG2D.setColor(Color.GRAY);
		bgMaskG2D.fillRect(0, 0, getWidth(), getHeight());

		/* Enable Anti-Alias */
		bgMaskG2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		/* Clear the circle away */
		bgMaskG2D.setComposite(AlphaComposite.Clear);
		int ovalX = MainWindow.getPlayerCurX();
		int ovalY =	MainWindow.getPlayerCurY();
		int ovalRadius = playerImgs[0].getWidth(this)*2;
		bgMaskG2D.fillOval(ovalX - ovalRadius, ovalY - ovalRadius, 2 * ovalRadius, 2 * ovalRadius);
		bgMaskG2D.setComposite(AlphaComposite.Src);

		offGraphics.drawImage(bgMask, 0, 0, bgMask.getWidth(this), bgMask.getHeight(this), this);
	}



	static final int PLAYERSTOPPED = 0,
			PLAYERMOVING = 1,
			PLAYERATTACKING = 2;

	private static final ArrayList<Integer> playerStates = new ArrayList<>(Arrays.asList(
			PLAYERSTOPPED,
			PLAYERMOVING, 
			PLAYERATTACKING
			));

	private static final String playerStoppedPathStr = "image/stopped.gif", 
			playerAttackingPathStr = "image/attacking.gif", 
			playerMovingPathStr = "image/moving.gif";

	private static final ArrayList<String> playerImgPaths = new ArrayList<>(Arrays.asList(
			playerStoppedPathStr, 
			playerMovingPathStr, 
			playerAttackingPathStr
			));
	private static int playerAngle = 0;
	private static Image[] playerImgs = new Image[3];
	private static AffineTransform playerAffine;// =  new AffineTransform();

	private static int playerState;
	private static boolean playerFrozen = true;

	void initPlayer() {

		int i = 0;
		for(String path: playerImgPaths) {
			if(Files.exists(Paths.get(path), LinkOption.NOFOLLOW_LINKS)) {
				playerImgs[i] = Toolkit.getDefaultToolkit().createImage(path);
				mt.addImage(playerImgs[i], i+1);
			}
			else {
				System.out.println(path+" was not found");
				System.exit(-1);
			}
			i++;
		}

		AffineTransform newAffine = new AffineTransform();
		int tx = MainWindow.getPlayerCurX()-playerImgs[playerState].getWidth(this)/2;
		int ty = MainWindow.getPlayerCurY()-playerImgs[playerState].getHeight(this)/2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI*(1.0 - (double) playerAngle/360);
		newAffine.rotate(radians);
		setPlayerAffine(newAffine);
	}

	void playerPaint() {
		offGraphics.drawImage(playerImgs[playerState], getPlayerAffine(), this);
	}

	synchronized void setPlayerState(int s)  {
		while (playerFrozen)
			try {
				playerState = 0;
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		playerState = s;
		AffineTransform newAffine = new AffineTransform();
		int tx = MainWindow.getPlayerCurX()-playerImgs[playerState].getWidth(this)/2;
		int ty = MainWindow.getPlayerCurY()-playerImgs[playerState].getHeight(this)/2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI*(1.0 - (double) playerAngle/360);
		newAffine.rotate(radians);
		setPlayerAffine(newAffine);
		repaint();
	}

	public static synchronized void freezePlayer(){
		playerFrozen = true;
	}

	public synchronized void thawPlayer() {
		playerFrozen = false;
		notifyAll();
	}

	synchronized static AffineTransform getPlayerAffine() {
		return playerAffine;
	}

	synchronized static void setPlayerAffine(AffineTransform playerAffine) {
		MyCanvas.playerAffine = playerAffine;
	}







	static final int ENEMYSTOPPED = 0,
			ENEMYMOVING = 1,
			ENEMYATTACKING = 2;
	static final int[] ENEMYSTOPPEDBOUNDS = {0,0,75,35};

	private static final ArrayList<Integer> enemyStates = new ArrayList<>(Arrays.asList(
			ENEMYSTOPPED,
			ENEMYMOVING, 
			ENEMYATTACKING
			));

	private static final String enemyStoppedPathStr = "image/stopped.gif", 
			enemyAttackingPathStr = "image/attacking.gif", 
			enemyMovingPathStr = "image/moving.gif",
			enemyImgsPathStr = "image/Genesis 32X SCD - Aladdin - Snake.gif";

	private static final ArrayList<String> enemyImgPaths = new ArrayList<>(Arrays.asList(
			enemyStoppedPathStr, 
			enemyMovingPathStr, 
			enemyAttackingPathStr
			));
	private static AffineTransform enemyAffine;// =  new AffineTransform();
	private Image[] enemyImgs = new Image[3];
	private int enemyState;
	private static boolean enemyFrozen = true;
	private double enemyAngle = 0;

	void initEnemy() {

		int j = 0;
		for(String path: enemyImgPaths) {
			if(Files.exists(Paths.get(path), LinkOption.NOFOLLOW_LINKS)) {
				enemyImgs[j] = Toolkit.getDefaultToolkit().createImage(path);
				mt.addImage(enemyImgs[j], j+3);
			}
			else {
				System.out.println(path+" was not found");
				System.exit(-1);
			}
			j++;
		}

		AffineTransform newAffine = new AffineTransform();
		int tx = MainWindow.getEnemyCurX()-enemyImgs[enemyState].getWidth(this)/2;
		int ty = MainWindow.getEnemyCurY()-enemyImgs[enemyState].getHeight(this)/2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI*(1.0 - (double) playerAngle/360);
		newAffine.rotate(radians);
		setEnemyAffine(newAffine);
	}


	void enemyPaint() {
		offGraphics.drawImage(enemyImgs[enemyState], getEnemyAffine(), this);
	}

	synchronized void setEnemyState(int s)  {
		while (enemyFrozen)
			try {
				enemyState = 0;
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		enemyState = s;
		AffineTransform newAffine = new AffineTransform();
		int tx = MainWindow.getEnemyCurX()-enemyImgs[enemyState].getWidth(this)/2;
		int ty = MainWindow.getEnemyCurY()-enemyImgs[enemyState].getHeight(this)/2;
		newAffine.translate(tx, ty);
		double radians = 2.0 * Math.PI*(1.0 - (double) enemyAngle/360);
		newAffine.rotate(radians);
		setEnemyAffine(newAffine);
		repaint();
	}

	public synchronized static void freezeEnemy(){
		enemyFrozen = true;
	}

	public synchronized void thawEnemy() {
		enemyFrozen = false;
		notifyAll();
	}

	synchronized static AffineTransform getEnemyAffine() {
		/*return enemyAffine =  new AffineTransform();*/  //took awhile to find this for some reason
		return enemyAffine;
	}

	synchronized static void setEnemyAffine(AffineTransform enemyAffine) {
		MyCanvas.enemyAffine = enemyAffine;
	}







}