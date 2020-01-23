package Population;

/*** Handles all the Hero's behaviors ***/
import javax.swing.ImageIcon;

import Objet.ListObjet;
import Objet.ListObjet.OBJET;
import Objet.Objet;

import java.awt.Image;
import java.io.Serializable;

import Population.Population.TYPE;
import Population.Population.MAISON;
import System.Game;
import System.ToolMethods;
import View.Scene1;

public class Hero extends Personnage implements Runnable, Serializable{
	
	/*** Attributes. ***/
	// A lot of boolean values. Their values are changed by the controller
	
	private int mana,manamax;
	private int level;
	private int lifemax;
	private int intellect;
	private int dirx, diry;
	private boolean basicAttack, specialAttack, distanceAttack, health;
	private boolean visibility;
	private boolean FlyingBroom, IsOnFlyingBroom;
	private int experience = 0;
	private int expNeeded = 100;
	private MAISON maison;
	private static int oriH, oriB,oriG, oriD = 0; // Values created to charge the right image according to the mouvement
	private boolean res = true ;
	private int wiznessPoint = 6  ;
	private boolean isWizeEnoughDistanceAttack ;
	private boolean isWizeEnoughSpecialAttack  ;
	private int animcounter = 0;
	private int enemyx;
	private int enemyy;
	private boolean isDrawing; // Useful to draw the flames images
	private ListObjet listobjets ;

	transient  WhichImage changeImage = new WhichImage() ;
	transient  ListObjet listobjet;
	
	/*** Constructor ***/
	
	public Hero(TYPE type,int x, int y, int life, int speed,int strenght, int defence, MAISON maison) {
		super(x, y, life, speed,strenght,defence);
		this.type = type;
		this.speed = speed;
		this.maison = maison;
		this.dirx = 0;
		this.diry = 0;
		this.basicAttack = false;
		this.specialAttack = false;
		this.distanceAttack = false;
		this.health = false;
		this.FlyingBroom = false;
		this.IsOnFlyingBroom = false;
		this.visibility = true;
		this.isDrawing = false;
		this.isWizeEnoughDistanceAttack = false ;
		this.isWizeEnoughSpecialAttack = true ;
		initVariable(life, strenght, defence, maison);
		restoreTransients();
	}
	
	/*** Methods ***/
	
	public void restoreTransients(){
		changeImage = new WhichImage();
		if(maison == MAISON.Gryffondor){
			icon = new ImageIcon("images/Maison/Gryffondor/GryffondorBas/Bas1.png").getImage();
		}else if (maison == MAISON.Serdaigle){
			icon = new ImageIcon("images/Maison/Serdaigle/SerdaigleBas/Bas1.png").getImage();
		}else if(maison == MAISON.Serpentard){
			icon = new ImageIcon("images/Maison/Serpentard/SerpentardBas/Bas1.png").getImage();
		}else if (maison == MAISON.Poufsouffle){
			icon = new ImageIcon("images/Maison/Poufsouffle/PoufsouffleBas/Bas1.png").getImage();
		}
	}
	
	// Initialize the characteristics of the player according to his house
	private void initVariable(int life, int strenght, int defence, MAISON maison){
		this.lifemax = life;
		this.life = lifemax;
		this.level = 1;
		if(maison == MAISON.Gryffondor){
			icon = new ImageIcon("images/Maison/Gryffondor/GryffondorBas/Bas1.png").getImage();
			this.strenght = strenght +15;
			this.defence = defence;
			this.intellect = 3;
			this.mana = this.intellect*25;
		}else if (maison == MAISON.Serdaigle){
			icon = new ImageIcon("images/Maison/Serdaigle/SerdaigleBas/Bas1.png").getImage();
			this.strenght = strenght;
			this.defence = defence;
			this.intellect = 3 + 2;;
			this.mana = this.intellect*25;
		}else if(maison == MAISON.Serpentard){
			icon = new ImageIcon("images/Maison/Serpentard/SerpentardBas/Bas1.png").getImage();
			this.strenght = strenght + 3;
			this.defence = defence;
			this.intellect = 3-2;
			this.mana = this.intellect*25;
		}else if (maison == MAISON.Poufsouffle){
			icon = new ImageIcon("images/Maison/Poufsouffle/PoufsouffleBas/Bas1.png").getImage();
			this.strenght = strenght;
			this.defence = defence;
			this.intellect = 3;
			this.mana = this.intellect*25;
		}
		this.manamax = mana;
	}
	


	// This method is called every 40 millisecond thanks to the Timer
	// Contains all the behaviour's methods of the player
	public void method(Game game){
		int variable = 0;
		animcounter++;
		if (IsOnFlyingBroom){
			variable = 1; // Allows the movement of the player more often because he is on the broom		}
		}if (animcounter ==  this.speed - variable || animcounter > 5){ // The second condition has been added because a problem occured. The computer incremented 2 variables at the same time so the first condition wasn't true anymore and the game nothing happend with the hero
			animcounter = 0;
			move(game);
			verifObjet(game) ;
			fight(game);
		}
		manaRegeneration(+10);
		healthRegeneration(game);
		
	}
	
	// Change the position of the player and checks if there is something particular with his new position
	// For instance if there is an object, an enemy and acts in consequence
	protected void move(Game game){
		int new_x = game.getBoard().getValidePosistion_x (x+getDirX());
		int new_y = game.getBoard().getValidePosistion_y (y+getDirY());
		changeImage.changeIcon(new_x,new_y,x,y, maison, oriD, oriG,oriB,oriH, this);
			
		if((game.getBoard().getelement(new_x,new_y) & Scene1.STONE) == 0){
			setPosition(new_x,new_y);
		}if((game.getBoard().getelement(new_x,new_y) & Scene1.TRAP) != 0){
			setLife(-3);
		}		
	}
	
	private void verifObjet(Game game){
		listobjets = game.getListObjet();
		for(int i = 0 ; i < game.getListObjet().size();i++){
			Objet tempobject = listobjets.get(i) ;
			int posxObjet = tempobject.get_x() ;
			int posyObjet = tempobject.get_y() ;
			if(this.x == posxObjet && this.y == posyObjet){
				if (tempobject.getObjet() == OBJET.Portal){
					listobjets.remove(i);
					game.getBoard().setelement(posxObjet, posyObjet, game.getBoard().getelement(posxObjet, posyObjet)-tempobject.getBinary());
					game.getPopulation().initPopulation(game.NBRE_ENNEMY, game.MAP);	
				}else if(tempobject.getObjet() == OBJET.Balai){
					tempobject.heroInCase(this, posxObjet, posyObjet);
					listobjets.remove(i);
					listobjets.setBalaiAlreadyGiven() ;
					game.getBoard().setelement(posxObjet, posyObjet, game.getBoard().getelement(posxObjet, posyObjet)-tempobject.getBinary());
				}else if(tempobject.getObjet() == OBJET.Cape){
					tempobject.heroInCase(this, posxObjet, posyObjet);
					listobjets.remove(i);
					listobjets.setInvisibilityCloakAlreadyGiven() ;
					game.getBoard().setelement(posxObjet, posyObjet, game.getBoard().getelement(posxObjet, posyObjet)-tempobject.getBinary());
				}else{
					tempobject.heroInCase(this, posxObjet, posyObjet);
					listobjets.remove(i) ;
					game.getBoard().setelement(posxObjet, posyObjet, game.getBoard().getelement(posxObjet, posyObjet)-tempobject.getBinary());
				}
			}
		}
	}
	
	// According to the key input of the user, chooses a different attack
	private void fight(Game game){
		for (int i = 0; i<game.getPopulation().size();i++){
			Personnage ennemy = game.getPopulation().get(i);
			if (ennemy.gettype() != type ){
				this.enemyx = ennemy.get_x();
				this.enemyy= ennemy.get_y();
				if (ToolMethods.isNear(this.x, this.y, enemyx, enemyy, 1) && basicAttack){
					ennemy.setLife(-this.strenght+ennemy.getDefence());
				}if(ToolMethods.isNear(this.x, this.y, enemyx, enemyy, 1) && specialAttack&&this.mana>20 && isWizeEnoughSpecialAttack){
					setMana(-20);
					ennemy.setLife(-(this.intellect*this.strenght)+ennemy.getDefence());
					Thread thread = new Thread (this);
					thread.start();
				}if( (ToolMethods.isSameLine( this.y, enemyy, 3) || ToolMethods.isSameColumn( this.x, enemyx, 3) ) && distanceAttack&&this.mana>50 && isWizeEnoughDistanceAttack){
					Thread thread1 = new Thread(this);
					thread1.start();
					setMana(-50);
					ennemy.setLife(-(this.intellect*this.strenght)+ennemy.getDefence()-20);
				
				}
			}
		}
	}
	
	
	
	
	// Draws flames on the board if the distance attack or the zone attack has been used
	public void drawAttack (Game game){
		if(this.specialAttack){
			for (int j = this.x - 1; j<this.x+2; j++){
				for(int k = this.y - 1; k< this.y +2; k++){
					if((game.getBoard().getelement(j, k)&Scene1.FIRE) == 0){
						game.getBoard().setelement(j, k,game.getBoard().getelement(j, k)+ Scene1.FIRE );
					}	
				}
			}
		}
		else if(this.distanceAttack) {
			if((game.getBoard().getelement(enemyx, enemyy)&Scene1.FIRE)==0){
				game.getBoard().setelement(enemyx,enemyy ,game.getBoard().getelement(enemyx, enemyy)+ Scene1.FIRE ) ;
			}
		}
	}
	
	public void unDrawAttack (Game game){
		for (int j = this.x - 6; j<this.x+7; j++){
			for(int k = this.y - 6; k< this.y +7; k++){
				if( (game.getBoard().getelement(j, k)&Scene1.FIRE) !=0 ){
					game.getBoard().setelement(j, k,game.getBoard().getelement(j, k)- Scene1.FIRE );
				}
			}
		}
	}
	
	// Gives Mana to the player every time the " method " method is called
	private void manaRegeneration(int moreMana){
		animMana++ ;
		if (animMana == 30) {
			animMana=0;
			setMana(moreMana) ;
		}
	}
	
	private void healthRegeneration(Game game){
		if (getHealth() && this.mana>33){
			setMana(-10);
			setLife(3);
		}
	}
	
	// Changes the level of the player and gives him more life, more mana and WiznessPoints
	private void levelUp(int level){
		this.lifemax += 20;
		setLife(20);
		this.manamax +=10;
		setMana(50);
		this.wiznessPoint += 6 ;
	}
	
	// Implicit method of the Thread
	public void run(){
			isDrawing = true;
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isDrawing = false;
	}


	/*** Getters ***/
	
	public int getDirX(){
		return this.dirx;
	}
	
	public int getDirY(){
		return this.diry;
	}
	
	
	
	public boolean getIsDrawing(){
		return this.isDrawing;
	}
	
	public boolean getBalai(){
		return this.FlyingBroom;
	}
	
	public boolean getIsOnFlyingBroom(){
		return this.IsOnFlyingBroom;
	}
	
	public boolean getHealth(){
		return this.health;
	}
	
	public int getLifeMax(){
		return this.lifemax;
	}
	
	public int getManaMax(){
		return this.manamax;
	}
	
	public int getMana(){
		return this.mana ;
	}
	
	public int getExperience(){
		return this.experience ;
	}
	
	public int getExpNeeded(){
		return this.expNeeded ;
	}
	public int getLevel(){
		return this.level ;
	}
	public int getIntellect(){
		return this.intellect;
	}
	public MAISON getMaison(){
		return this.maison;
	}
	public int getOriG(){
		return this.oriG ;
	}
	public int getOriD(){
		return this.oriD ;
	}
	public int getOriH(){
		return this.oriH ;
	}
	public int getOriB(){
		return this.oriB ;
	}
	public boolean getVisibility(){
		return this.visibility ;
	}
	public int getWiznessPoint(){
		return this.wiznessPoint ;
	}
	public boolean getIsWizeEnoughDistanceAttack(){
		return this.isWizeEnoughDistanceAttack ;
	}
	public boolean getIsWizeEnoughSpecialAttack(){
		return this.isWizeEnoughSpecialAttack ;
	}
	
	/*** Setters ***/
	
	public void setDirX(int variable){
		this.dirx = variable;
	}
	
	public void setDirY(int variable){
		this.diry = variable;
	}
	
	public void setBasicAttack(boolean variable){
		this.basicAttack = variable;
	}
	
	public void setSpecialAttack(boolean variable){
		this.specialAttack = variable;
	}
	
	public void setDistanceAttack(boolean variable){
		this.distanceAttack = variable;
	}
	
	public void setVisibility(boolean variable){
		this.visibility = variable;
	}
	
	public void setFlyingBroom(boolean variable){
		this.FlyingBroom = variable;
	}
	
	public void setRun(boolean variable){
		this.IsOnFlyingBroom = variable;
	}
	
	public void setHealth(boolean variable){
		this.health = variable;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setLevel(int addExp){
		this.level ++;
		this.expNeeded += addExp;
		this.experience = 0;
		levelUp(this.level);
	}
	
	public void setMana(int lessMana){
		if(this.mana>0 & this.mana <= this.manamax){
			this.mana += lessMana;
			if (this.mana>this.manamax){
				this.mana = this.manamax;
			}
		}		
	}
	
	public void setExperience(int xp){
		this.experience += xp ;
		if( experience >= this.expNeeded ) {
			setLevel(50) ;
			
		}
	}
	
	public void setLife(int lesslife){
		if( 0< this.life & this.life <= this.lifemax){
			this.life += lesslife ;
			if (this.life > this.lifemax){
				this.life = this.lifemax;
			}
		}
	}
	
	public void setIntellect(int moreIntellect){
		this.intellect += moreIntellect;
	}
	
	public void setOrientationD(int orientation){
		orientation ++ ;
		if ( orientation == 4){
			orientation = 0 ;
		}
		this.oriD= orientation;		
	}
	
	public void setOrientationG(int orientation){
		orientation ++ ;
		if ( orientation == 4){
		orientation = 0 ;
		}
		this.oriG= orientation;		
	}
	
	public void setOrientationH(int orientation){
		orientation ++ ;
		if ( orientation == 4){
		orientation = 0 ;
		}
		this.oriH= orientation;		
	}
	
	public void setOrientationB(int orientation){
		orientation ++ ;
		if ( orientation == 4){
		orientation = 0 ;
		}
		this.oriB= orientation;		
	}
	
	public void setSpeed(int morespeed) {
		this.speed += morespeed;
	}
	
	public void setIcon(Image image){
		this.icon = image ;
	}
	public void setWiznessPoint(int change){
		this.wiznessPoint += change ;
	}
	public void setWizeEnoughDistanceAttack(){
		if(this.wiznessPoint >= 30 &! isWizeEnoughDistanceAttack){
			this.isWizeEnoughDistanceAttack = true ;
			this.wiznessPoint -= 30 ;
		}
	}
	public void setWizeEnoughSpecialAttack(){
		if(this.wiznessPoint >= 6 &! isWizeEnoughSpecialAttack){
			this.isWizeEnoughSpecialAttack = true ;
			this.wiznessPoint -= 6 ;
		}
	}
}
