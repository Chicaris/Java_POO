package View;

/*** Shows the commands of the player at the beginning of the Game ***/
/*** This window disappears by itself with a thread ***/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import System.Game;


public class ButtonMenu extends JFrame implements Runnable{
	
	/*** Attributes ***/
	
	static Game game ;
	private Thread thread ;
	private boolean res = true ; 
	
	/*** Constructor ***/

	public ButtonMenu(Game game){
		this.game = game ;
		
	}
	
	/*** Methods ***/
	
	public void showButton(Graphics g, int multiplayer){
		
		Thread thread = new Thread (this);
		thread.start();
		Font font = new Font("Arial", 1, 50) ; 
		g.setFont(font) ; 
		g.setColor(Color.black);
		if(multiplayer == 0){
			g.drawImage(new ImageIcon("images/ShowButtonOnePlayer.jpg").getImage(),0,0,game); 
		}
		else{
			g.drawImage(new ImageIcon("images/ShowButtonTwoPlayer.jpg").getImage(),0,0,game); 
		}
	}
	
	public void run() {
		try{
			while( res == true){
				Thread.sleep(2000);
				game.StartGame(); // Change to State of the game to begin playing.
				res = false ;
			}
		}
		catch(Exception e){
			
		}
	}
}
