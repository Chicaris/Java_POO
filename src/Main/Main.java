package Main;

/*** Begins the Game. Creates the Game object to let the game begin ***/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import System.Game;

public class Main extends JFrame {
	
	/*** Constructor ***/
	
    public Main() {
        
        add(new Game());
        setTitle("Harry Potter et la réussite de la BA2");
    	setSize(640,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0,0);
        setVisible(true);        
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main ex = new Main();
            }
        });
    }
}
