package View;

/*** Shows the GameOver window if the player lost ***/

import java.awt.Graphics;



import javax.swing.ImageIcon;

import System.Game;



public class Gameover{
	Game myGame;
	
	/*** Constructor ***/
	
	public Gameover(Game game){
		myGame =game;
	}
	
	/*** Method ***/
	
	public void showMenu(Graphics g) {
		g.drawImage(new ImageIcon("images/gameover.png").getImage(),0,0,myGame); 
	}

}
