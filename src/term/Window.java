package term;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.File;
import java.io.FileInputStream;

public class Window extends JFrame {

	private int charSizeX, charSizeY;
	private JLabel[][] line;
	private Font font;

	public Window(String title, int width, int height){

		super(title);
	
		font = new Font("Monospaced", Font.PLAIN, 10);

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
		System.out.println(charSizeX);

		this.setSize(width * charSizeX + 2, height * charSizeY + 25);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(null);
		
		line = new JLabel[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){

				line[x][y] = new JLabel(String.valueOf(x % 10));
				line[x][y].setFont(font);
				line[x][y].setBounds(x * charSizeX,y * charSizeY,charSizeX,charSizeY);
				line[x][y].setBackground(new Color((x+y) / (float)(width+height),
							           (x+y) / (float)(width+height),
								   (x+y) / (float)(width+height)));
				line[x][y].setOpaque(true);
				this.add(line[x][y]);

			}
		}

	}

}
