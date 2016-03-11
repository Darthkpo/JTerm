# JTerm
A simple terminal written in java.

![Demo](https://raw.githubusercontent.com/Darthkpo/JTerm/master/doc/img0.png)

Here is an example:

```java

public Example(){

        jterm = new Terminal("test",120,40); //Create window with title "test", 
                                             //with 120 chars spaces of width and 40 chars of height
        
        jterm.setVisible(true); //Because Terminal.java extends JFrame its posible to call
                                //JFrame methods directly, and for example setVisible() is needed
                                //to display the window.
		
        //Iterate over all the chars in the terminal
        for(int x = 0; x < 120; x++){ //X-axis

                for(int y = 0; y < 40; y++){ //Y-axis

                        //Set color of text to:
                        //1337 green for the foreground.
                        jterm.setColor(false,x,y,Color.green);
                        //dark grey for the background.
                        jterm.setColor(true,x,y,new Color(0.03f,0.03f,0.03f));

                }

        }
    
        //Print string starting at 0,0
        jterm.printStringAt("This is a test.",0,0);
	
        //Clear console
        jterm.clear();	

}

```
