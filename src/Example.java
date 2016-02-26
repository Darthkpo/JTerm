import term.Window;

public class Example {

	private Window win;

	public Example(){

		win = new Window("test",120,40);
		win.setVisible(true);

	}

	public static void main(String[] args){

		new Example();

	}

}
