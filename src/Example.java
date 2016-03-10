import term.Terminal;
import java.awt.Color;
import javax.swing.SwingWorker;

public class Example extends SwingWorker<Integer, Void> {

	private Terminal jterm;

	public Example(){

		jterm = new Terminal("test",120,40);
		jterm.setVisible(true);
		execute();
	}

	@Override
	public Integer doInBackground(){

		int i = 0;

		while(!Terminal.k_0){

			try{
				Thread.sleep(15);
			}catch(InterruptedException e){



			}
			i++;
			System.out.println("tick " + i);

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
