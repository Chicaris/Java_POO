package View;

/*** Shows the parameter menu ***/

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import System.Game;
import System.Game.STATE;


public class ParametreMenu extends JFrame{
	
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
	public static MenuItem[] menuItemsPlayer, menuItemsSound, menuItemsSize, menuItemsDifficult;
	public static int screensize_x;
	public static int screensize_y;
	
	private static boolean onePlayer ;
	private static boolean twoPlayers ;
	 
	private static boolean soundOn ;
	private static boolean soundOff ;
	
	private static boolean easy ;
	private static boolean normalDifficulty ;
	private static boolean difficult ;
	
	private static boolean small ;
	private static boolean normalSize ;
	private static boolean big ;
	
	Font font = new Font("Arial", 1, 50) ; 
	Font font2 = new Font("Arial",1,30);
	
	/*** Constructor ***/
	
	public ParametreMenu(Game game){
		
		myGame = game;
		menuItemsPlayer = new MenuItem[2];
		menuItemsSound = new MenuItem[3];
		menuItemsSize = new MenuItem[4];
		menuItemsDifficult = new MenuItem[4];
		
		this.onePlayer = false ;
		this.twoPlayers = false ;
		
		this.soundOn = false ;
		this.soundOff = false ;
		
		this.easy = false ;
		this.normalDifficulty = false ; 
		this.difficult = false ;
		
		this.small = false ;
		this.normalSize = false ;
		this.big = false ;		
		
		screensize_x = 640;
		screensize_y = 500;
		
		menuItemsPlayer[0] = new MenuItem("1 PLAYER",screensize_x/3-getStringSize("1 PLAYER",font2)/2-20,screensize_y*3/10-40,screensize_x/3+90,screensize_y*3/10+20);
		menuItemsPlayer[1] = new MenuItem("2 PLAYERS",screensize_x*2/3-getStringSize("2 PLAYERS",font2)/2-20,screensize_y*3/10-40,screensize_x*2/3+100,screensize_y*3/10+20);
	
		menuItemsSound[0] = new MenuItem("Sound",screensize_x/4-getStringSize("Sound",font2)/2-20, screensize_y*5/10-40,screensize_x/4+90,screensize_y*5/10+20);
		menuItemsSound[1] = new MenuItem("ON",screensize_x*2/4-getStringSize("ON",font2)/2-20, screensize_y*5/10-40,screensize_x*2/4+90,screensize_y*5/10+20);
		menuItemsSound[2] = new MenuItem("OFF",screensize_x*3/4-getStringSize("OFF",font2)/2-20, screensize_y*5/10-40,screensize_x*3/4+90,screensize_y*5/10+20);
		
		menuItemsSize[0] = new MenuItem("Size" , screensize_x/5-getStringSize("Size",font2)/2, screensize_y*7/10-40,screensize_x/5+90,screensize_y*7/10+20);
		menuItemsSize[1] = new MenuItem("Small" , screensize_x*2/5-getStringSize("Small",font2)/2, screensize_y*7/10-40,screensize_x*2/5+50,screensize_y*7/10+20);
		menuItemsSize[2] = new MenuItem("Normal" , screensize_x*3/5-getStringSize("Normal",font2)/2, screensize_y*7/10-40,screensize_x*3/5+90,screensize_y*7/10+20);
		menuItemsSize[3] = new MenuItem("Big" , screensize_x*4/5-getStringSize("Big",font2)/2, screensize_y*7/10-40,screensize_x*4/5+90,screensize_y*7/10+20);
		
		menuItemsDifficult[0] = new MenuItem("Difficulty" , screensize_x/5-getStringSize("Difficulty",font2)/2, screensize_y*9/10-40,screensize_x/5+90,screensize_y*9/10+20);
		menuItemsDifficult[1] = new MenuItem("Easy" , screensize_x*2/5-getStringSize("Easy",font2)/2, screensize_y*9/10-40,screensize_x*2/5+50,screensize_y*9/10+20);
		menuItemsDifficult[2] = new MenuItem("Normal" , screensize_x*3/5-getStringSize("Normal",font2)/2, screensize_y*9/10-40,screensize_x*3/5+90,screensize_y*9/10+20);
		menuItemsDifficult[3] = new MenuItem("Hard" , screensize_x*4/5-getStringSize("Hard",font2)/2, screensize_y*9/10-40,screensize_x*4/5+90,screensize_y*9/10+20);
	}	
	
	/*** Methods ***/
	
	public void showMenu(Graphics g){	
		g.setColor(Color.white);
		g.drawImage(new ImageIcon("images/HarryPotterBackGround.png").getImage(),0,0,myGame); 
		
		g.setFont(font) ; 
		
		g.drawString("Parametre",screensize_x/2-getStringSize("Parametre",font)/2  , screensize_y*1/10 ) ;
		g.setFont(font2) ; 
		g.drawString("1 PLAYER", screensize_x/3-getStringSize("1 PLAYER",font2)/2 , screensize_y*3/10);
		g.drawString("2 PLAYERS", screensize_x*2/3-getStringSize("2 PLAYERS",font2)/2, screensize_y*3/10);
		if(this.onePlayer){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsPlayer[0].x1,menuItemsPlayer[0].y1,menuItemsPlayer[0].x2-menuItemsPlayer[0].x1,menuItemsPlayer[0].y2-menuItemsPlayer[0].y1);
		g.setColor(Color.white) ;
		if(this.twoPlayers){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsPlayer[1].x1,menuItemsPlayer[1].y1,menuItemsPlayer[1].x2-menuItemsPlayer[1].x1,menuItemsPlayer[1].y2-menuItemsPlayer[1].y1);
		g.setColor(Color.white);
		
		g.drawString("Sound", menuItemsSound[0].x1 +20, menuItemsSound[0].y1 +40);
		g.drawString("ON", menuItemsSound[1].x1 +20, menuItemsSound[1].y1 + 40);
		g.drawString("OFF", menuItemsSound[2].x1 +20, menuItemsSound[2].y1 + 40);
		if(this.soundOn){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsSound[1].x1,menuItemsSound[1].y1,menuItemsSound[1].x2-menuItemsSound[1].x1 - 20,menuItemsSound[1].y2-menuItemsSound[1].y1);
		g.setColor(Color.white);
		if(this.soundOff){
			g.setColor(Color.red) ;
		}
		g.drawRect(menuItemsSound[2].x1,menuItemsSound[2].y1,menuItemsSound[2].x2-menuItemsSound[2].x1 - 20,menuItemsSound[2].y2-menuItemsSound[2].y1);
		g.setColor(Color.white);
		
		g.drawString(menuItemsSize[0].name, menuItemsSize[0].x1+20, menuItemsSize[0].y1+40);
		g.drawString(menuItemsSize[1].name, menuItemsSize[1].x1+3, menuItemsSize[1].y1+40);
		g.drawString(menuItemsSize[2].name, menuItemsSize[2].x1+20, menuItemsSize[0].y1+40);
		g.drawString(menuItemsSize[3].name, menuItemsSize[3].x1+20, menuItemsSize[0].y1+40);
		if(this.small){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsSize[1].x1, menuItemsSize[1].y1, menuItemsSize[1].x2 - menuItemsSize[1].x1, menuItemsSize[1].y2-menuItemsSize[1].y1);
		g.setColor(Color.white) ;
		if(this.normalSize){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsSize[2].x1, menuItemsSize[2].y1, menuItemsSize[2].x2 - menuItemsSize[2].x1, menuItemsSize[2].y2-menuItemsSize[2].y1);
		g.setColor(Color.white);
		if(this.big){
			g.setColor(Color.red) ;
		}
		g.drawRect(menuItemsSize[3].x1, menuItemsSize[3].y1, menuItemsSize[3].x2 - menuItemsSize[3].x1, menuItemsSize[3].y2-menuItemsSize[3].y1);
		g.setColor(Color.white);
		
		
		g.drawString(menuItemsDifficult[0].name, menuItemsDifficult[0].x1 +20, menuItemsDifficult[0].y1+40);
		g.drawString(menuItemsDifficult[1].name, menuItemsDifficult[1].x1 +3, menuItemsDifficult[1].y1+40);
		g.drawString(menuItemsDifficult[2].name, menuItemsDifficult[2].x1 +20, menuItemsDifficult[2].y1+40);
		g.drawString(menuItemsDifficult[3].name, menuItemsDifficult[3].x1 +20, menuItemsDifficult[3].y1+40);
		if(this.easy){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsDifficult[1].x1, menuItemsDifficult[1].y1, menuItemsDifficult[1].x2 - menuItemsDifficult[1].x1, menuItemsDifficult[1].y2-menuItemsDifficult[1].y1);
		g.setColor(Color.white);
		if(this.normalDifficulty){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsDifficult[2].x1, menuItemsDifficult[2].y1, menuItemsDifficult[2].x2 - menuItemsDifficult[2].x1, menuItemsDifficult[2].y2-menuItemsDifficult[2].y1);
		g.setColor(Color.white);
		if(this.difficult){
			g.setColor(Color.red);
		}
		g.drawRect(menuItemsDifficult[3].x1, menuItemsDifficult[3].y1, menuItemsDifficult[3].x2 - menuItemsDifficult[3].x1, menuItemsDifficult[3].y2-menuItemsDifficult[3].y1);
		
		
	}
	
	public static void mouseEvent(int x, int y) {
		for (int i=0;i< menuItemsPlayer.length;i++){
			if (isincase(x,y,menuItemsPlayer[i])){
				if (menuItemsPlayer[i].name == "1 PLAYER"){
					myGame.setMultiplayer(0);
					InitializeGraphicChoicesMultiPlayer() ;
					onePlayer = true ;
				}
				else if (menuItemsPlayer[i].name == "2 PLAYERS"){
					myGame.setMultiplayer(1);
					myGame.setGamestate(STATE.Menu);
					InitializeGraphicChoicesMultiPlayer() ; 
					twoPlayers = true ;
				}
			}
		}
		for (int i=0; i< menuItemsSound.length;i++){
			if(isincase(x,y,menuItemsSound[i])){
				if (menuItemsSound[i].name == "ON"){
					myGame.setSound(true);
					InitializeGraphicChoicesSound() ;
					soundOn = true ;
				}else if (menuItemsSound[i].name == "OFF"){
					myGame.setSound(false);
					InitializeGraphicChoicesSound() ;
					soundOff = true ;
				}
			}
		}
		for (int i=0; i< menuItemsSize.length;i++){
			if(isincase(x,y,menuItemsSize[i])){
				if (menuItemsSize[i].name == "Small"){
					myGame.setGridSize(20, 20);
					InitializeGraphicChoiceSize() ; // Recolor everything in white in case it's the second time the user chooses
					small = true ;
				}else if (menuItemsSize[i].name == "Normal"){
					myGame.setGridSize(30, 30);
					InitializeGraphicChoiceSize() ; // Recolor everything in white in case it's the second time the user chooses
					normalSize = true ;
				}else if (menuItemsSize[i].name == "Big"){
					myGame.setGridSize(60, 60);
					InitializeGraphicChoiceSize() ; // Recolor everything in white in case it's the second time the user chooses
					big = true ;
				}
			}
			
		}
		for (int i=0; i< menuItemsDifficult.length;i++){
			if(isincase(x,y,menuItemsDifficult[i])){
				if (menuItemsDifficult[i].name == "Easy"){
					myGame.setDifficult(1);
					InitializeGraphicChoiceDifficulty() ;
					easy = true ;
				}else if (menuItemsDifficult[i].name == "Normal"){
					myGame.setDifficult(2);
					InitializeGraphicChoiceDifficulty() ;
					normalDifficulty = true ;
				}else if (menuItemsDifficult[i].name == "Hard"){
					myGame.setDifficult(3);
					InitializeGraphicChoiceDifficulty() ;
					difficult = true ;
					
				}
			}
		}
	}
	
	public static void InitializeGraphicChoicesMultiPlayer(){
		onePlayer = false ;
		twoPlayers = false ;
	}
	
	public static void InitializeGraphicChoicesSound(){
		soundOn = false ;
		soundOff = false ;
	}
	
	public static void InitializeGraphicChoiceDifficulty(){
		easy = false ;
		normalDifficulty = false ;
		difficult = false ;
	}
	
	public static void InitializeGraphicChoiceSize(){
		small = false ;
		normalSize = false ;
		big = false ;
	}
	
	
	
	
	public static boolean isincase(int x, int y, MenuItem menuItem){
		boolean res = false;
		if (x<menuItem.x2 && x>menuItem.x1 && y<menuItem.y2 && y>menuItem.y1){
			res = true;
		}
		return res;
	}
	
	
	/*** Getters ***/
	
	public int getStringSize(String string, Font font){
		FontMetrics metrics = new FontMetrics(font) {};
		Rectangle2D bounds = metrics.getStringBounds(string, null);
		int widthInPixels = (int) bounds.getWidth();
		return widthInPixels;
	}
	
	public int getsizex(){
		return screensize_x;
	}
	
	
	public int getsizey(){
		return screensize_y;
	}
	
	
	
	
	
}
