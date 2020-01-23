package View;

/*** Show the inventory of Player 2 ***/

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import System.Game;
import Population.Hero;
import Population.Population.MAISON;

public class Inventory2{
	
	/*** Attributes ***/
	
	static Game myGame;
	private static int screensize_x;
	private int screensize_y;
	private static int decalage;
	private Font font, font1, font2;
	private static Hero hero ;
	
	/*** Constructor ***/
	
	public Inventory2 (Game game){
		this.myGame = game;
		this.decalage = myGame.SCREENSIZE*myGame.BLOCKSIZE+20;
		this.screensize_x = myGame.SCREENSIZE*myGame.BLOCKSIZE;
		this.screensize_y = myGame.SCREENSIZE*myGame.BLOCKSIZE+110;
		this.font = new Font("Arial",Font.BOLD,50);
		this.font1 = new Font("Arial",1,30);
		this.font2 = new Font ("Arial", Font.ITALIC,20);
	}
	
	/*** Methods ***/
	
	public void showMenu(Graphics g){
		g.drawImage(new ImageIcon("images/inventories/inventory.png").getImage(),decalage,0,myGame);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawRect(70+decalage,70,screensize_x - 140, screensize_y - 250);
		g.drawString("Inventory",(screensize_x-getStringSize("Inventory", font))/2+decalage , 130);
		g.drawRect(70+decalage, 70, screensize_x-140, 90);
		g.drawRect(70+decalage, 160, screensize_x/2-70, screensize_y/2 - 70);
		g.drawRect(70+decalage, 160, screensize_x/2-70, 70);
		g.drawRect(70+decalage, 230, 150, 150);
		g.drawRect(70+decalage, 380, screensize_x - 140, 202);
		
		this.hero = myGame.getPopulation().gethero2();
		int life = hero.getLife();
		int lifemax = hero.getLifeMax();
		int experience =  hero.getExperience() ;
		int level = hero.getLevel() ;
		int expNeeded = hero.getExpNeeded() ;
		Font font1 = new Font("Arial",1,20);
		g.setFont(font1); 
		g.drawString(" Life : " + life + " / "  + lifemax, screensize_x/2 + 30 + decalage, 220);
		g.drawString(" Level : " + level, screensize_x/2 + 30 + decalage, 200);
		g.drawString(" Experience : "  + experience + "   /   " + expNeeded, screensize_x/2+30 + decalage, 240);
		g.setFont(font2);
		g.drawString("Number of ennemy : " + (myGame.getPopulation().size()-(myGame.getMultiplayer()+1)),decalage + screensize_x/2 +30,280);
		g.drawString("Strenght : " + hero.getStrengh(),screensize_x/2 + 30 + decalage, 300);
		g.drawString("Intellect : " + hero.getIntellect(),screensize_x/2 + 30 + decalage, 320 );
		g.drawString("Defence : " + hero.getDefence(), screensize_x/2 + 30+ decalage, 340);
		
		if(hero.getIsWizeEnoughDistanceAttack()){
			g.drawString(" Distance Attack : known. Press on C ", screensize_x/2 + 30+decalage, 430);
		}
		else{
			g.drawString(" Distance Attack needs 30 ", screensize_x/2 + 20+decalage, 430);
			g.drawString("Wizeness Points to be learnt ", screensize_x/2 + 30+decalage, 450);
			g.drawString(" Click here to learn if wize enough ", screensize_x/2 + 20+decalage, 470);
		}
		if(hero.getIsWizeEnoughSpecialAttack()){
			g.drawString(" Special Attack : known. Press on X ", screensize_x/2 + 30+decalage,510);
		}
		else{
			g.drawString(" Special Attack needs 6 ", screensize_x/2 + 20+decalage, 510);
			g.drawString("Wizeness Points to be learnt ", screensize_x/2 + 30+decalage, 530);
			g.drawString(" Click here to learn if wize enough ", screensize_x/2 + 20+decalage, 550);
		}
		
		if (myGame.getPopulation().gethero2().getMaison() == MAISON.Gryffondor){
			showGryffondor(g);
		}else if ( myGame.getPopulation().gethero2().getMaison() == MAISON.Serpentard){
			showSerpentard(g);
		}else if (myGame.getPopulation().gethero2().getMaison() == MAISON.Serdaigle){
			showSerdaigle(g);
		}else if (myGame.getPopulation().gethero2().getMaison() == MAISON.Poufsouffle){
			showPoufsouffle(g);
		}
		
	}
	
	public void showGryffondor(Graphics g){
		g.setFont(font1);
		g.drawString("Gryffondor",((screensize_x)-getStringSize("Gryffondor",font1))/4+decalage , 210);
		g.drawImage(new ImageIcon("images/inventories/BlasonDeGryffondor.png").getImage(), 70+decalage, 230 ,myGame);
		g.drawImage(new ImageIcon("images/heroGryffondor.png").getImage(), 300+decalage, 240, myGame);
		g.setFont(font2);
		g.drawString("Si vous allez à Gryffondor !", 110+decalage, 430);
		g.drawString("Vous rejoindrez les courageux,", 110+decalage, 470);
		g.drawString("Les plus hardis et les plus forts", 110+decalage, 510);
		g.drawString("Sont rassemblés en ce haut lieu.", 110+decalage, 550);
		g.drawString("History :", 110+decalage, 620);
		g.drawString("La maison Gryffondor tient son nom de Godric Gryffondor,", 110+decalage, 660);
		g.drawString("l'un des quatre fondateurs de l'école. Son blason est un lion doré.", 110+decalage, 700);
		g.drawString("Le fantôme de la maison Gryffondor est Sir Nicholas,", 110+decalage, 740);
		g.drawString("de Mismy-Porpington (couramment appelé Nick Quasi-Sans-Tête).", 110+decalage, 780);
	}
	
	public void showSerpentard(Graphics g){
		g.drawString("Serpentard",35+((screensize_x-230)/2-getStringSize("Serpentard",font1))/2+decalage , 210);
		g.drawImage(new ImageIcon("images/inventories/BlasonDeSerpentard.png").getImage(), 70+decalage, 230 ,myGame);
		g.drawImage(new ImageIcon("images/heroSerpentard.png").getImage(), 300+decalage, 240, myGame);
		g.setFont(font2);
		g.drawString("Vous finirez à Serpentard !", 110+decalage, 430);
		g.drawString("Si vous êtes plutôt malin,", 110+decalage, 470);
		g.drawString("Car ceux-là sont de vrais roublards,", 110+decalage, 510);
		g.drawString("Qui arrivent toujours à leurs fins.", 110+decalage, 550);
		g.drawString("History :", 110+decalage, 620);
		g.drawString("La maison Serpantard tient son nom de Salazar Serpentard, ", 110+decalage, 660);
		g.drawString("l'un des quatre fondateurs de l'école. Son blason est un serpent.", 110+decalage, 700);
		g.drawString("Le fantôme de la maison Serpentard est le Baron Sanglant.", 110+decalage, 740);
	}	
		
	public void showSerdaigle(Graphics g){
		g.drawString("Serdaigle",35+((screensize_x-230)/2-getStringSize("Serdaigle",font1))/2 +decalage, 210);
		g.drawImage(new ImageIcon("images/inventories/BlasonDeSerdaigle.png").getImage(), 70+decalage, 230 ,myGame);
		g.drawImage(new ImageIcon("images/heroSerdaigle.png").getImage(), 300+decalage, 240, myGame);
		g.setFont(font2);
		g.drawString("Si vous êtes sage et réfléchi !", 110+decalage, 430);
		g.drawString("Serdaigle vous accueillera peut-être,", 110+decalage, 470);
		g.drawString("Là-bas, ce sont des érudits", 110+decalage, 510);
		g.drawString("Qui ont envie de tout connaître.", 110+decalage, 550);
		g.drawString("History :", 110+decalage, 620);
		g.drawString("La maison tient son nom de Rowena Serdaigle,", 110+decalage, 660);
		g.drawString("l'un des quatre fondateurs de l'école. Son blason est un aigle.", 110+decalage, 700);
		g.drawString("Le fantôme de la maison Serdaigle est la Dame Grise,", 110+decalage, 740);
		g.drawString(" la fille de Rowena.", 110+decalage, 780);
	}	

	public void showPoufsouffle(Graphics g){
		g.drawString("Poufsouffle",35+((screensize_x-230)/2-getStringSize("Poufsouffle",font1))/2+decalage , 210);
		g.drawImage(new ImageIcon("images/inventories/BlasonDePoufsouffle.png").getImage(), 70+decalage, 230 ,myGame);
		g.drawImage(new ImageIcon("images/heroPoufsouffle.png").getImage(), 300+decalage, 240, myGame);
		g.setFont(font2);
		g.drawString("Si à Poufsouffle vous allez !", 110+decalage, 430);
		g.drawString("Comme eux vous s'rez juste et loyal,", 110+decalage, 470);
		g.drawString("Ceux de Poufsouffle aiment travailler,", 110+decalage, 510);
		g.drawString("Et leur patience est proverbiale.", 110+decalage, 550);
		g.drawString("History :", 110+decalage, 620);
		g.drawString("La maison tient son nom de Helga Poufsouffle,", 110+decalage, 660);
		g.drawString("l'un des quatre fondateurs de l'école. Son blason est un blaireau.", 110+decalage, 700);
		g.drawString("Le fantôme de la maison Poufsouffle est le Moine Gras.", 110+decalage, 740);
	}	

	public int getStringSize(String string, Font font){
		FontMetrics metrics = new FontMetrics(font) {};
		Rectangle2D bounds = metrics.getStringBounds(string, null);
		int widthInPixels = (int) bounds.getWidth();
		return widthInPixels;
	}
	
	public static void mouseEvent(int x, int y){
		if(isInCase(x,y,screensize_x/2 + 30+decalage,278,120,20) && hero.getWiznessPoint() > 0){
			
			hero.setStrenght(hero.getStrengh()+1);
			hero.setWiznessPoint(-1);
			
		}
		else if(isInCase(x,y,screensize_x/2 + 30+decalage,298,120,20) && hero.getWiznessPoint() > 0){
			
			hero.setIntellect(+1);
			hero.setWiznessPoint(-1);
			
		}
		else if (isInCase(x,y,screensize_x/2 + 30+decalage,318,120,20) && hero.getWiznessPoint() > 0){
			
			hero.setDefence(hero.getDefence()+1) ;
			hero.setWiznessPoint(-1);
			
		}
		else if (isInCase(x,y,screensize_x/2 + 30+decalage,428,120,40) ){
			
				hero.setWizeEnoughDistanceAttack() ;

			
		}
		else if (isInCase(x,y,screensize_x/2 + 30+decalage,508,120,40) ){
			
				hero.setWizeEnoughSpecialAttack() ;
				
			
		}
	}
		private static boolean isInCase(int mx, int my, int x, int y, int width, int height){
			boolean res = false ; 
			if(x < mx & mx < x + width & y < my & my < y + height){
				res = true ;
			}
			
			return res ;
		}
		
	
}
