package gamePack.gameEntityPack.gameLocalMapPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyGrid extends JPanel {

        /**
	 * 
	 */
	private static final long serialVersionUID = -5542056167547175096L;

		public MyGrid(int row, int col) {

            int count = 0 ; // use to give a name to each box so that you can refer to them later
            setLayout(new GridLayout(row, col));
            //setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

            for (int i = 1; i <= (row * col); i++) {
                JPanel pan = new JPanel();

                pan.setEnabled(true);
                pan.setBackground(Color.BLACK);
                pan.setPreferredSize(new Dimension(3, 3));
                //pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                pan.addMouseListener(new BoxListener()); // add a mouse listener to make the panels clickable
                pan.setName(count+"");
                pan.setOpaque(true);
                ++count;
                add(pan);
            }
            this.setOpaque(false);
        }
		
    }
    
