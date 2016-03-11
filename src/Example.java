import term.JTerminal;
import java.awt.Color;
import javax.swing.SwingUtilities;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import javax.swing.Timer;
import java.awt.image.BufferedImage;

public class Example implements ActionListener{

	private JTerminal jterm;
	private Timer timer;
	private int offset;
	private boolean incrementing = true;

	public Example(){

		jterm = new JTerminal("test",120,40);
		jterm.setLocation(100,100);
		jterm.setVisible(true);
		jterm.setCursor(jterm.getToolkit().createCustomCursor(
            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
            "null"));

		int delay = 17;
		timer = new Timer(delay, this);
		timer.start();

	}

	public void actionPerformed(ActionEvent e){

		if(JTerminal.k_0)
			System.exit(0);

		jterm.clear();
		
		if(incrementing){
			offset++;
		} else {
			offset--;
		}
		if(offset == 60 || offset == 0)
			incrementing = !incrementing;

		for(int x = 0; x < 120; x++){

			for(int y = 0; y < 40; y++){

				jterm.setColor(true,x,y,new Color((x+y+offset)/220f,(x+y+offset)/220f,(x+y+offset)/220f));
				
			}

		}
		/* MOUSE DEMO
		Point mousePos = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(mousePos,jterm);
		mousePos.y -= 25;
		Point charMousePos = jterm.screenToChar(mousePos);
		jterm.setColor(true,charMousePos.x,charMousePos.y,Color.red);
		jterm.setColor(false,charMousePos.x,charMousePos.y,Color.blue);
		jterm.setChar('0',charMousePos.x,charMousePos.y);
		*/
		jterm.render();

	}

	public static void main(String[] args){

		new Example();

	}

}
