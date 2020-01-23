package View;

/*** Shows the window to load previous games   ***/

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import System.Game;
import System.Game.STATE;
import View.PrincipalMenu.MenuItem;

public class Load {
	
	public class MenuItem {
		
		/*** Attributes ***/
		
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
	public static MenuItem[] menuItems;
	public static int screensize_x;
	public static int screensize_y;
	
	/*** Constructor ***/
	
	public Load(Game game){
		myGame = game;
		menuItems = new MenuItem[4];
		
		screensize_x = 640;
		screensize_y = 500;
		
		menuItems[0] = new MenuItem("Save 1",screensize_x/2-100,screensize_y*2/10,screensize_x/2+50,screensize_y*3/10);
		menuItems[1] = new MenuItem("Save 2",screensize_x/2-100,screensize_y*4/10,screensize_x/2+50,screensize_y*5/10);
		menuItems[2] = new MenuItem("Save 3",screensize_x/2-100,screensize_y*6/10,screensize_x/2+50,screensize_y*7/10);
		menuItems[3] = new MenuItem("Save 4",screensize_x/2-100,screensize_y*8/10,screensize_x/2+50,screensize_y*9/10);
	
	}
	
	/*** Methods ***/
	
	public static void showMenu(Graphics g) {
		g.drawImage(new ImageIcon("images/HarryPotterBackGround.png").getImage(),0,0,myGame); 
		
		
		Font font = new Font("Arial", 1, 50) ; 
		Font font2 = new Font("Arial", 1, 30) ; 

		g.setFont(font); 
		g.setColor(Color.white);
		g.drawString("Load",(screensize_x-getStringSize("Load",font))/2	 , screensize_y*1/10);
		
		g.setFont(font2); 
		
		for (int i=0;i< menuItems.length;i++){
			g.setColor(Color.gray);
			g.drawRect(menuItems[i].x1,menuItems[i].y1,menuItems[i].x2-menuItems[i].x1+100,menuItems[i].y2-menuItems[i].y1);
			g.setColor(Color.white);
			g.drawString(menuItems[i].name, (screensize_x-getStringSize(menuItems[i].name,font2))/2 , menuItems[i].y1+40);
		}
	}
	
	public static int getStringSize(String string, Font font){
		FontMetrics metrics = new FontMetrics(font) {};
		Rectangle2D bounds = metrics.getStringBounds(string, null);
		int widthInPixels = (int) bounds.getWidth();
		return widthInPixels;
	}
	
	public static void mouseEvent(int x, int y) {
		for (int i=0;i< menuItems.length;i++){
			if (isincase(x,y,menuItems[i])){
				if (menuItems[i].name=="Save 1"){
					myGame.loadGame("HarryPotter1.save");
				}
				else if (menuItems[i].name=="Save 2"){
					myGame.loadGame("HarryPotter2.save");
				}
				else if (menuItems[i].name=="Save 3"){
					myGame.loadGame("HarryPotter3.save");
				}
				else if (menuItems[i].name == "Save 4"){
					myGame.loadGame("HarryPotter4.save");
				}
			}
		}
		myGame.setGamestate(STATE.Game);
	}
	
	public static boolean isincase(int x, int y, MenuItem menuItem){
		boolean res = false;
		if (x<menuItem.x2 && x>menuItem.x1 && y<menuItem.y2 && y>menuItem.y1){
			res = true;
		}
		return res;
	}
	
}
