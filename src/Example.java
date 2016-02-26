import term.Terminal;
import java.awt.Color;

public class Example {

	private Terminal jterm;

	public Example(){

		jterm = new Terminal("test",120,40);
		jterm.setVisible(true);
		
		for(int x = 0; x < 120; x++){

			for(int y = 0; y < 40; y++){

				jterm.setColor(false,x,y,Color.green);
				jterm.setColor(true,x,y,new Color(0.03f,0.03f,0.03f));

			}

		}

		jterm.printStringAt("This is a test.",0,0);
	
		jterm.clear();	

	}

	public static void main(String[] args){

		new Example();

	}

}
