package Controller;

/*** Controller part 2. Gets the MouseClick and according to the GameState chooses the right MouseEvent ***/

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import System.Game;
import System.Game.STATE;
import View.Choices;
import View.Inventory1;
import View.Inventory2;
import View.Load;
import View.ParametreMenu;
import View.PrincipalMenu;


public class MouseInput extends MouseAdapter{
	
	/*** Attributes ***/
	
	Game myGame;
	
	/*** Constructor ***/
	
	public MouseInput(Game game){
		myGame = game;
	}
	
	/*** Methods ***/
	
	public void mousePressed( MouseEvent e){
		int x = e.getX(); 
		int y = e.getY(); 
		System.out.println("coucou") ;
		if( myGame.getGameState() == STATE.Menu) {
			PrincipalMenu.mouseEvent(x,y);
		}else if (myGame.getGameState() == STATE.Choices){
			Choices.mouseEvent(x, y);
		}else if (myGame.getGameState() == STATE.Parametre){
			ParametreMenu.mouseEvent(x, y);
		}else if ( myGame.getGameState() == STATE.Inventory ){
			Inventory1.mouseEvent(x,y) ;
			if(myGame.getMultiplayer() == 1 ){
				Inventory2.mouseEvent(x, y);
			}
		}else if (myGame.getGameState() == STATE.Load){
			Load.mouseEvent(x, y);
		}
		
	}

	public void mouseReleased( MouseEvent e ){
		
	}
}
