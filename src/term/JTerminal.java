package term;

import term.JTermPanel;

import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.JComponent;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.WindowConstants;
import javax.swing.Action;
import javax.swing.AbstractAction;

public class JTerminal extends JFrame {

	private int charSizeX, charSizeY, width, height;
	protected JLabel[][] text;
	protected Font font;
	private Color backgroundClearColor;
	private JTermPanel rootPane;
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

	public static boolean k_0, k_1, k_2, k_3, k_4, k_5, k_6, k_7, k_8, k_9,
	                      k_a, k_b, k_c, k_d, k_e, k_f, k_g, k_h, k_i, k_j, k_k, k_l, k_m, k_n, k_o, k_p, k_q, k_r, k_s, k_t, k_u, k_v, k_w, k_x, k_y, k_z
	                      = false;

	public JTerminal(String title, int width, int height){

		super(title);
	
		font = new Font("Monospaced", Font.PLAIN, 10);

		this.width = width;
		this.height = height;

		try{
		
			File f = new File("../res/Consolas.ttf");
			FileInputStream inStream = new FileInputStream(f);
			font = Font.createFont(Font.TRUETYPE_FONT, inStream);
			font = font.deriveFont(18f);

		} catch (Exception e){

			e.printStackTrace();

		}

		backgroundClearColor = new Color(0,0,0);

		FontMetrics metrics = new Canvas().getFontMetrics(font);
		charSizeY = metrics.getHeight();
		charSizeX = metrics.charWidth('O');

		this.setSize(width * charSizeX + 2, height * charSizeY + 25);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		rootPane = new JTermPanel(width,height,charSizeX,charSizeY,this);
		this.setContentPane(rootPane);
		
		text = new JLabel[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){

				text[x][y] = new JLabel(" ");
				text[x][y].setBackground(Color.black);
				text[x][y].setOpaque(true);

			}
		}

		getRootPane().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0,0), "PRESSED_0");
		getRootPane().getActionMap().put("PRESSED_0", new KeyDown(KeyEvent.VK_0));

		getRootPane().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0,0, true), "RELEASED_0");
		getRootPane().getActionMap().put("RELEASED_0", new KeyUp(KeyEvent.VK_0));

	}

	public void render(){

		rootPane.repaint();

	}

	public Point screenToChar(Point screenPoint){

		//returns the char position in the Jterminal to the cursor

		if(screenPoint.x > width * charSizeX - 1)
			screenPoint.x = width * charSizeX - 1;
		if(screenPoint.y > height * charSizeY - 1)
			screenPoint.y = height * charSizeY - 1;
		if(screenPoint.x < 0)
			screenPoint.x = 1;
		if(screenPoint.y < 0)
			screenPoint.y = 1;

		Point result = new Point((int)(screenPoint.x / charSizeX),(int)(screenPoint.y / charSizeY));

		return result;

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

	@Deprecated
	public JLabel labelAt(int x, int y){

		return text[x][y];

	}
	public JTermPanel getTermPanel(){

		return rootPane;

	}

	public void clear(){

		for(int y = 0; y < height; y++){

			for(int x = 0; x < width; x++){

				setChar(' ', x, y);
				setColor(false,x,y,backgroundClearColor);
				setColor(true,x,y,backgroundClearColor);

			}

		}

	}

}
class KeyDown extends AbstractAction {

	private int keyCode;

	public KeyDown(int keyCode){

		this.keyCode = keyCode;

	}

	public void actionPerformed(ActionEvent e){

		switch(keyCode){

			case KeyEvent.VK_0 : { JTerminal.k_0 = true; break; }
			case KeyEvent.VK_1 : { JTerminal.k_1 = true; break; }
			case KeyEvent.VK_2 : { JTerminal.k_2 = true; break; }
			case KeyEvent.VK_3 : { JTerminal.k_3 = true; break; }
			case KeyEvent.VK_4 : { JTerminal.k_4 = true; break; }
			case KeyEvent.VK_5 : { JTerminal.k_5 = true; break; }
			case KeyEvent.VK_6 : { JTerminal.k_6 = true; break; }
			case KeyEvent.VK_7 : { JTerminal.k_7 = true; break; }
			case KeyEvent.VK_8 : { JTerminal.k_8 = true; break; }
			case KeyEvent.VK_9 : { JTerminal.k_9 = true; break; }

			case KeyEvent.VK_A : { JTerminal.k_a = true; break; }
			case KeyEvent.VK_B : { JTerminal.k_b = true; break; }
			case KeyEvent.VK_C : { JTerminal.k_c = true; break; }
			case KeyEvent.VK_D : { JTerminal.k_d = true; break; }
			case KeyEvent.VK_E : { JTerminal.k_e = true; break; }
			case KeyEvent.VK_F : { JTerminal.k_f = true; break; }
			case KeyEvent.VK_G : { JTerminal.k_g = true; break; }
			case KeyEvent.VK_H : { JTerminal.k_h = true; break; }
			case KeyEvent.VK_I : { JTerminal.k_i = true; break; }
			case KeyEvent.VK_J : { JTerminal.k_j = true; break; }
			case KeyEvent.VK_K : { JTerminal.k_k = true; break; }
			case KeyEvent.VK_L : { JTerminal.k_l = true; break; }
			case KeyEvent.VK_M : { JTerminal.k_m = true; break; }
			case KeyEvent.VK_N : { JTerminal.k_n = true; break; }
			case KeyEvent.VK_O : { JTerminal.k_o = true; break; }
			case KeyEvent.VK_P : { JTerminal.k_p = true; break; }
			case KeyEvent.VK_Q : { JTerminal.k_q = true; break; }
			case KeyEvent.VK_R : { JTerminal.k_r = true; break; }
			case KeyEvent.VK_S : { JTerminal.k_s = true; break; }
			case KeyEvent.VK_T : { JTerminal.k_t = true; break; }
			case KeyEvent.VK_U : { JTerminal.k_u = true; break; }
			case KeyEvent.VK_V : { JTerminal.k_v = true; break; }
			case KeyEvent.VK_W : { JTerminal.k_w = true; break; }
			case KeyEvent.VK_X : { JTerminal.k_x = true; break; }
			case KeyEvent.VK_Y : { JTerminal.k_y = true; break; }
			case KeyEvent.VK_Z : { JTerminal.k_z = true; break; }

		}

	}

}
class KeyUp extends AbstractAction {

	private int keyCode;

	public KeyUp(int keyCode){

		this.keyCode = keyCode;

	}

	public void actionPerformed(ActionEvent e){

		switch(keyCode){

			case KeyEvent.VK_0 : { JTerminal.k_0 = false; break; }
			case KeyEvent.VK_1 : { JTerminal.k_1 = false; break; }
			case KeyEvent.VK_2 : { JTerminal.k_2 = false; break; }
			case KeyEvent.VK_3 : { JTerminal.k_3 = false; break; }
			case KeyEvent.VK_4 : { JTerminal.k_4 = false; break; }
			case KeyEvent.VK_5 : { JTerminal.k_5 = false; break; }
			case KeyEvent.VK_6 : { JTerminal.k_6 = false; break; }
			case KeyEvent.VK_7 : { JTerminal.k_7 = false; break; }
			case KeyEvent.VK_8 : { JTerminal.k_8 = false; break; }
			case KeyEvent.VK_9 : { JTerminal.k_9 = false; break; }

			case KeyEvent.VK_A : { JTerminal.k_a = false; break; }
			case KeyEvent.VK_B : { JTerminal.k_b = false; break; }
			case KeyEvent.VK_C : { JTerminal.k_c = false; break; }
			case KeyEvent.VK_D : { JTerminal.k_d = false; break; }
			case KeyEvent.VK_E : { JTerminal.k_e = false; break; }
			case KeyEvent.VK_F : { JTerminal.k_f = false; break; }
			case KeyEvent.VK_G : { JTerminal.k_g = false; break; }
			case KeyEvent.VK_H : { JTerminal.k_h = false; break; }
			case KeyEvent.VK_I : { JTerminal.k_i = false; break; }
			case KeyEvent.VK_J : { JTerminal.k_j = false; break; }
			case KeyEvent.VK_K : { JTerminal.k_k = false; break; }
			case KeyEvent.VK_L : { JTerminal.k_l = false; break; }
			case KeyEvent.VK_M : { JTerminal.k_m = false; break; }
			case KeyEvent.VK_N : { JTerminal.k_n = false; break; }
			case KeyEvent.VK_O : { JTerminal.k_o = false; break; }
			case KeyEvent.VK_P : { JTerminal.k_p = false; break; }
			case KeyEvent.VK_Q : { JTerminal.k_q = false; break; }
			case KeyEvent.VK_R : { JTerminal.k_r = false; break; }
			case KeyEvent.VK_S : { JTerminal.k_s = false; break; }
			case KeyEvent.VK_T : { JTerminal.k_t = false; break; }
			case KeyEvent.VK_U : { JTerminal.k_u = false; break; }
			case KeyEvent.VK_V : { JTerminal.k_v = false; break; }
			case KeyEvent.VK_W : { JTerminal.k_w = false; break; }
			case KeyEvent.VK_X : { JTerminal.k_x = false; break; }
			case KeyEvent.VK_Y : { JTerminal.k_y = false; break; }
			case KeyEvent.VK_Z : { JTerminal.k_z = false; break; }

		}

	}

}