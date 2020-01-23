package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Population.Hero;
import Population.Personnage;
import Population.Population.TYPE;
import System.Game;
import System.ToolMethods;

public class Scene2 extends JPanel {
	public final static int STONE = 1;
	public final static int ICE = 2;
	public final static int HERB = 4;
	public final static int GROUND = 8;
	public final static int BAGUETTE = 16;
	public final static int FIRE = 32;
	public final static int BALAI = 64;
	public final static int CAPE =128;
	public final static int LIFEPOTION = 256 ;
	public final static int MANAPOTION = 512 ;
	public final static int PORTAL = 1024 ;
	public final static int TRAP = 2048;
	private int decalage ;
	
	Game myGame; 
	
    private Image herbImage,stoneImage,iceImage,baguetteImage, balaiImage,capeImage,lifePotionImage, manaPotionImage, groundImage, fireImage, portal, trap;
    
    
	public Scene2(Game game){
		myGame = game;
		decalage = myGame.BLOCKSIZE* myGame.SCREENSIZE + 20;
		loadImages();		
	}
	
	private void loadImages(){
		herbImage = new ImageIcon("images/Pelouse.png").getImage();
		stoneImage = new ImageIcon("images/Stone.png").getImage();
		iceImage = new ImageIcon("images/ice.png").getImage();
		groundImage = new ImageIcon("images/Pierre.png").getImage();
		baguetteImage = new ImageIcon("images/Objets/baguette.png").getImage();
		balaiImage = new ImageIcon("images/Objets/balai.png").getImage();
		capeImage = new ImageIcon("images/Objets/cape.png").getImage();
		lifePotionImage = new ImageIcon("images/Objets/PotionLife.png").getImage() ;
		manaPotionImage = new ImageIcon("images/Objets/PotionMana.png").getImage() ;
		fireImage = new ImageIcon("images/fire.png").getImage();
		portal = new ImageIcon("images/Objets/Portal.png").getImage();
		trap = new ImageIcon("images/trap.png").getImage();
	}

	
	
	public void show(Graphics g){
		int sceneObject ;
		int x,y;
		Image currentIcon  = herbImage;
		Personnage hero = myGame.getPopulation().gethero2();
		int herox = hero.get_x();
		int heroy = hero.get_y();

		for (x = getrange(herox); x<getrange(herox) + Game.SCREENSIZE;x++){
			for (y = getrange(heroy); y<getrange(heroy) + Game.SCREENSIZE;y++){
				if (!(x<0 || y<0 || y>Game.GRIDSIZE_X-1 || x > Game.GRIDSIZE_Y-1)){
					sceneObject = myGame.getBoard().getelement(x,y);
					if ( (sceneObject & ICE)!=0){
						currentIcon = iceImage;
						g.drawImage(currentIcon,decalage + (x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if((sceneObject & STONE)!= 0){
						currentIcon = stoneImage;
						g.drawImage(currentIcon, decalage + (x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & GROUND) !=0){
						currentIcon = groundImage;
						g.drawImage(currentIcon,decalage + (x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & HERB) != 0){
						currentIcon = herbImage;
						g.drawImage(currentIcon, decalage + (x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & BAGUETTE) !=0){
						currentIcon = baguetteImage;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & BALAI) !=0){
						currentIcon = balaiImage;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & CAPE) !=0){
						currentIcon = capeImage;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & FIRE) != 0){
						currentIcon = fireImage;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & LIFEPOTION) != 0){
						currentIcon = lifePotionImage;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & MANAPOTION) != 0){
						currentIcon = manaPotionImage;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & PORTAL) != 0){
						currentIcon = portal;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}if ((sceneObject & TRAP) != 0){
						currentIcon = trap;
						g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
					}
					showPopulation(g,x,y,herox,heroy);
				}
				showme(g);
			}
		}
		}

	public void showPopulation(Graphics g, int x, int y, int herox, int heroy){
		for (int i=0; i<myGame.getPopulation().size();i++){
			Image currentIcon = myGame.getPopulation().get(i).getIcon();
			Image heroIcon = myGame.getPopulation().gethero2().getIcon();
			int ennemy_x = myGame.getPopulation().get(i).get_x();
			int ennemy_y = myGame.getPopulation().get(i).get_y();
			if (myGame.getPopulation().get(i).gettype() != TYPE.Hero2 && (x == ennemy_x && y==ennemy_y)){
				g.drawImage(currentIcon, decalage +(x - herox+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, (y - heroy+(Game.SCREENSIZE-1)/2) * Game.BLOCKSIZE, myGame);
			}
			g.drawImage(heroIcon,decalage +((Game.SCREENSIZE-1)/2)*Game.BLOCKSIZE,((Game.SCREENSIZE-1)/2)*Game.BLOCKSIZE,myGame);
		}
	}
	
	public void showme(Graphics g){
		Hero hero = (Hero) myGame.getPopulation().gethero2();
		int herox = hero.get_x();
		int heroy = hero.get_y();
		int life = hero.getLife();
		int lifemax = hero.getLifeMax();
		int mana = hero.getMana() ;
		int manamax = hero.getManaMax();
		int experience =  hero.getExperience() ;
		int level = hero.getLevel() ;
		int expNeeded = hero.getExpNeeded() ;
		Font font = new Font("Arial",1,20);
		Font font2 = new Font("Arial",1, 15);
		g.setFont(font);
		g.setColor(Color.gray);
		g.fillRect(decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 40, lifemax*2, 16);
		g.setColor(Color.green);
		g.fillRect(decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 40,life*2, 16);
		g.setColor(Color.white);
		g.drawRect(decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 40, lifemax*2, 16); 
		g.drawString(" Life : " + life, decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 30);
		g.drawString(" Level : " + level + ", " + " Experience : "  + experience + "   /   " + expNeeded,decalage + myGame.SCREENSIZE*myGame.BLOCKSIZE - 325, myGame.SCREENSIZE*myGame.BLOCKSIZE + 40);
		g.drawString("Maison : " + hero.getMaison(), decalage + 250 , myGame.SCREENSIZE*myGame.BLOCKSIZE +64);
		g.setFont(font2);
		g.drawString("Number of ennemy : " + (myGame.getPopulation().size()-(myGame.getMultiplayer()+1)), decalage + 500, myGame.SCREENSIZE*myGame.BLOCKSIZE+104);
		g.drawString("Strenght : " + hero.getStrengh(),decalage + 500,myGame.SCREENSIZE*myGame.BLOCKSIZE+90);
		g.drawString("Intellect : " + hero.getIntellect(),decalage + 500, myGame.SCREENSIZE*myGame.BLOCKSIZE+75);
		g.drawString("Defence : " + hero.getDefence(), decalage + 500, myGame.SCREENSIZE*myGame.BLOCKSIZE+60);
	
		if(hero.getBalai()){
			g.drawString("Flying Broom : " + " Yes. Press on A to get on it. " , decalage + 175, myGame.SCREENSIZE*myGame.BLOCKSIZE+90);
		}
		else{
			g.drawString("Flying Broom : " + "No. Kill monsters to get it. " , decalage +175, myGame.SCREENSIZE*myGame.BLOCKSIZE+90);
		}
		
		g.setColor(Color.gray);
		g.fillRect(decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 84, manamax*2, 16);
		g.setColor(Color.blue);
		g.fillRect(decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 84,mana*2, 16);
		g.setColor(Color.white);
		g.drawRect(decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 84, manamax*2, 16);
		g.drawString(" Mana : " + mana, decalage + 10, myGame.SCREENSIZE*myGame.BLOCKSIZE + 74);
		//984
		for(int i = 0 ; i < myGame.getPopulation().size(); i++){
			int enemyLife = myGame.getPopulation().get(i).getLife() ;
			int enemy_x = myGame.getPopulation().get(i).get_x() ;
			int enemy_y = myGame.getPopulation().get(i).get_y() ;
			if(ToolMethods.isNear(herox, heroy, enemy_x, enemy_y,3)){
				if(myGame.getPopulation().get(i).gettype() == TYPE.BasicEnnemy ){
						g.setColor(Color.gray);
						g.fillRect(decalage + 350, 15, 200, 32);
						g.setColor(Color.red);
						g.fillRect(decalage + 350, 15,enemyLife *2, 32);
						g.setColor(Color.white);
						g.drawRect(decalage + 350, 15, 200, 32); 
						g.drawString(" Enemy "+ i +" Life : " + enemyLife, decalage + 350, 15);
						
				}else if(myGame.getPopulation().get(i).gettype() == TYPE.Boss ){
					g.setColor(Color.gray);
					g.fillRect(decalage + 150, 15, 200, 32);
					g.setColor(Color.red);
					g.fillRect(decalage + 150, 15,enemyLife *2, 32);
					g.setColor(Color.white);
					g.drawRect(decalage + 150, 15, 200, 32); 
					g.drawString(" Boss " +" Life : " + enemyLife, decalage + 150, 15);
				
				}
			}
		}
	}
	
	public int getrange(int position){
		return position -(Game.SCREENSIZE-1)/2;
	}
}
