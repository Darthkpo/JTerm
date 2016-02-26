package term;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.File;
import java.io.FileInputStream;

public class Terminal extends JFrame {

	private int charSizeX, charSizeY, width, height;
	private JLabel[][] text;
	private Font font;

	public Terminal(String title, int width, int height){

		super(title);
	
		font = new Font("Monospaced", Font.PLAIN, 10);

		this.width = width;
		this.height = height;

		try{
		
			File f = new File("../res/Consolas.ttf");
			FileInputStream inStream = new FileInputStream(f);
			font = Font.createFont(Font.TRUETYPE_FONT, inStream);
			font = font.deriveFont(12f);

		} catch (Exception e){

			e.printStackTrace();

		}

		FontMetrics metrics = new Canvas().getFontMetrics(font);
		charSizeY = metrics.getHeight();
		charSizeX = metrics.charWidth('O');

		this.setSize(width * charSizeX + 2, height * charSizeY + 25);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(null);
		
		text = new JLabel[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){

				text[x][y] = new JLabel(" ");
				text[x][y].setFont(font);
				text[x][y].setBounds(x * charSizeX,y * charSizeY,charSizeX,charSizeY);
				text[x][y].setBackground(Color.black);
				text[x][y].setOpaque(true);
				this.add(text[x][y]);

			}
		}

	}

	public void setChar(char c, int x, int y){ text[x][y].setText(Character.toString(c)); }
	public void setColor(boolean background, int x, int y, Color color){
	
		if(background){

			text[x][y].setBackground(color);

		} else {

			text[x][y].setForeground(color);

		}

	}
	public void printStringAt(String text, int x, int y){

		char[] chars = text.toCharArray();

		for(int i = 0; i < chars.length;i++){

			setChar(chars[i],x + i,y);

		}

	}

	public JLabel labelAt(int x, int y){

		return text[x][y];

	}

	public void clear(){

		for(int y = 0; y < height; y++){

			for(int x = 0; x < width; x++){

				setChar(' ', x, y);

			}

		}

	}

}
