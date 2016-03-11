package term;

import term.JTerminal;

import javax.swing.JPanel;
import java.awt.Graphics;

public class JTermPanel extends JPanel {
	
	private int width, height, charWidth, charHeight;
	private JTerminal parent;

	public JTermPanel(int width, int height, int charWidth, int charHeight, JTerminal parent){

		this.width = width;
		this.height = height;
		this.charWidth = charWidth;
		this.charHeight = charHeight;
		this.parent = parent;

		this.setBounds(0,0,width * charWidth,height * charHeight);

	}

	@Override
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.setFont(parent.font);

		for(int x = 0; x < width; x++){

			for(int y = 0; y < height; y++){

				//Paint the back of the char
				g.setColor(parent.text[x][y].getBackground());
				g.fillRect(x * charWidth, y * charHeight, charWidth, charHeight);
				g.setColor(parent.text[x][y].getForeground());
				g.drawString(parent.text[x][y].getText(), x * charWidth, (y + 1) * charHeight);

			}

		}

	}

}