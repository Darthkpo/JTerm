import term.JTerminal;
import java.awt.Color;
import javax.swing.SwingWorker;
import javax.swing.SwingUtilities;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.image.BufferedImage;

public class Example extends SwingWorker<Integer, Void> {

	private JTerminal jterm;

	public Example(){

		jterm = new JTerminal("test",120,40);
		jterm.setLocation(100,100);
		jterm.setVisible(true);
		/*jterm.setCursor(jterm.getToolkit().createCustomCursor(
            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
            "null"));*/
		execute();
	}

	@Override
	public Integer doInBackground(){

		while(!JTerminal.k_0){
			
			try{

				Thread.sleep(17);

			} catch (InterruptedException e){



			}
			jterm.clear();
			/* MOUSE POS DEMO
			Point mousePos = MouseInfo.getPointerInfo().getLocation();
			SwingUtilities.convertPointFromScreen(mousePos,jterm);
			mousePos.y -= 25;
			Point charMousePos = jterm.screenToChar(mousePos);
			jterm.setColor(true,charMousePos.x,charMousePos.y,Color.red);
			jterm.setColor(false,charMousePos.x,charMousePos.y,Color.blue);
			jterm.setChar('0',charMousePos.x,charMousePos.y);
			*/
			for(int x = 0; x < 120; x++){

				for(int y = 0; y < 40; y++){

					jterm.setColor(true,x,y,new Color(x/120f,x/120f,x/120f));
				
				}

			}
			jterm.render();

		}

		return 0;

	}

	@Override
	public void done(){

		System.exit(0);

	}

	public static void main(String[] args){

		new Example();

	}

}
