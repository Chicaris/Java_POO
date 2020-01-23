package View;

/*** Allows the user to choose the house he wants to go to. ***/

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import Population.Population.MAISON;
import System.Game;

public class Choices {
	
	/*** Attributes ***/
	
	public class MenuItem {
		public String name;
		public int x1,y1,x2,y2;
		public MenuItem(String name, int x1, int y1, int x2, int y2){
			this.name = name;
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	static Game myGame;
	int screensize_x, screensize_y;
	public static MenuItem[] menuItems;
	
	/*** Constructor ***/
	
	public Choices (Game game){
		this.myGame = game;
		menuItems = new MenuItem[4];
		this.screensize_x = 1280;
		this.screensize_y = 1000;
		
		menuItems[0] = new MenuItem("Gryffondor",200 , 150, 500, 450);
		menuItems[1] = new MenuItem("Serpentard",700 , 150, 1000,450);
		menuItems[2] = new MenuItem("Serdaigle",200 , 550, 500, 850);
		menuItems[3] = new MenuItem("Poufsouffle",700 , 550, 1000,850);
	}
	
	
	/** Methods ***/
	
	public void showMenu(Graphics g){
		g.drawImage(new ImageIcon("images/Poudlard.png").getImage(),0,0,myGame);
		Font font = new Font("Arial", 1, 70);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Choose your real house !", (screensize_x-getStringSize("Choose your real house !",font))/2, screensize_y*1/10);
		g.drawImage(new ImageIcon("images/Blasons/BlasonDeGryffondor.png").getImage(),200 , 150, 300,300, myGame);
		g.drawImage(new ImageIcon("images/Blasons/BlasonDeSerpentard.png").getImage(),700 , 150, 300,300, myGame);
		g.drawImage(new ImageIcon("images/Blasons/BlasonDeSerdaigle.png").getImage(), 200 , 550, 300,300, myGame);
		g.drawImage(new ImageIcon("images/Blasons/BlasonDePoufsouffle.png").getImage(), 700 , 550, 300,300, myGame);
		if (myGame.getMaison1() == MAISON.Unknown){
			g.drawString("PLAYER 1", (screensize_x - getStringSize("PLAYER 1",font))/2, screensize_y-50);
		}else if (myGame.getMaison2() == MAISON.Unknown && myGame.getMultiplayer() == 1){
			g.drawString("PLAYER 2", (screensize_x - getStringSize("PLAYER 2",font))/2, screensize_y-50);
		}
	}
	
	public static void mouseEvent(int x, int y) {
		if (myGame.getMaison1() == MAISON.Unknown){
			maisonChoice(x,y);
			if (myGame.getMultiplayer() == 0){
				myGame.showButton() ;
			}
		}else{
			maisonChoice(x,y);
			myGame.showButton() ;
		}
	}
	
	public static void maisonChoice(int x, int y){
		for (int i=0;i< menuItems.length;i++){
			if (isincase(x,y,menuItems[i])){
				if (menuItems[i].name =="Gryffondor"){
					myGame.setMaison(MAISON.Gryffondor);
				}else if (menuItems[i].name =="Serpentard"){
					myGame.setMaison(MAISON.Serpentard);
				}else if (menuItems[i].name == "Serdaigle"){
					myGame.setMaison(MAISON.Serdaigle);
				}else if (menuItems[i].name == "Poufsouffle"){
					myGame.setMaison(MAISON.Poufsouffle);
				}
			}
		}
	}
	
	public static boolean isincase(int x, int y, MenuItem menuItem){
		boolean res = false;
		if (x<menuItem.x2 && x>menuItem.x1 && y<menuItem.y2 && y>menuItem.y1){
			res = true;
		}
		return res;
	}
	
	public int getStringSize(String string, Font font){
		FontMetrics metrics = new FontMetrics(font) {};
		Rectangle2D bounds = metrics.getStringBounds(string, null);
		int widthInPixels = (int) bounds.getWidth();
		return widthInPixels;
	}
}
