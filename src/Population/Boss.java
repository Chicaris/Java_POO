package Population;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import Population.Population.TYPE;
import System.Game;
import System.ToolMethods;
import View.Scene1;

public class Boss extends Personnage implements Serializable{
	
	/*** Attributes ***/
	
	private int lifemax;
	private int new_x,new_y;
	private int animcounter = 0;
	private transient WhichImage changeimage;
	
	/*** Constructor ***/
	
	public Boss(int x, int y,int life, int speed, int strenght, int defence) {
		super(x, y,life, speed,strenght,defence);
		type = TYPE.Boss;
		this.speed = speed; 
		this.life = life;
		this.lifemax = life;
		this.strenght = strenght;
		this.defence = defence;
		this.new_x = x;
		this.new_y = y;
		restoreTransients();
	}
	
	public void restoreTransients() {
		changeimage = new WhichImage();
		icon = new ImageIcon("images/Monstres//Troll/TrollBas.png").getImage();
	}
	
	/*** Method ***/
	
	public void method(Game game){
		Hero hero2;
		animcounter++;
		if (animcounter == this.speed){
			animcounter = 0;
			Hero hero1 = (Hero) game.getPopulation().gethero1();
			fight(game, hero1);
			if (game.getMultiplayer() == 1){
				hero2 = (Hero) game.getPopulation().gethero2();
				fight(game, hero2);
			}
			move(game);
		}
	}
	
	// Two possibility of movements. Random or chasing the player if close enough.
	protected void move(Game game){
		int herox,heroy, dir = 0;
		Hero hero1 = game.getPopulation().gethero1();
		Hero hero2 = game.getPopulation().gethero2();
		// Chasing the player
		if (ToolMethods.isNear(new_x, new_y, hero1.get_x(), hero1.get_y(),4) && hero1.getVisibility()){
			herox = hero1.get_x();
			heroy = hero1.get_y();
			moveToHero(new_x, new_y, hero1.get_x(), hero1.get_y());
		}else if (game.getMultiplayer() == 1 && ToolMethods.isNear(new_x, new_y, hero2.get_x(), hero2.get_y(),4) && hero2.getVisibility()){
			herox = hero2.get_x();
			heroy = hero2.get_y();
			moveToHero(new_x, new_y, hero2.get_x(), hero2.get_y());
		}
		// Random movements
		else{
			int random = (int) (Math.random()*4);
			switch (random){
				case 0:
					new_x-=1;
					break;
				case 1:
					new_x+=1;
					break;
				case 2:
					new_y-=1;
					break;
				case 3:
					new_y +=1;
					break;
			}
		}
		new_x = game.getBoard().getValidePosistion_x (new_x);
		new_y = game.getBoard().getValidePosistion_y (new_y);
		if (y-new_y<0){
			dir = 1;
		}
		if (x-new_x<0){
			dir = 2;
		}
		if (y-new_y > 0){
			dir = 0;
		}
		if (x-new_x > 0){
			dir = 3;
		}
		changeimage.changeBossIcon(dir, this);
		if((game.getBoard().getelement(new_x, new_y) & Scene1.STONE) == 0){
			setPosition(new_x,new_y);
		}
	}
	
	// AI to reach the player
	private void moveToHero(int x,int y,int herox,int heroy){
		if (x == heroy && y == heroy){
			this.new_x = herox;
			this.new_y = heroy;
		}else if( ToolMethods.isSameLine(y, heroy,5) ){ // the number is the allowed distance.
			if(ToolMethods.isBigger(x, herox)){ 
				this.new_x -- ;			
			}
			else{
				this.new_x ++ ;
			}
		}else if (ToolMethods.isSameColumn(x, herox,5)  ){
			if(ToolMethods.isBigger(y, heroy)){ 
				this.new_y -- ;
			}
			else{
				this.new_y ++ ;
			}
		}else if (ToolMethods.isDiagonalUp(x, y, herox, heroy)){ 
			this.new_y -- ;			
		}else if(ToolMethods.isDiagonalDown(x, y, herox, heroy)){
			this.new_y ++ ;
		}
	}
	
	private void fight(Game game,Hero hero){
		int herox = hero.get_x();
		int heroy = hero.get_y();
		if (x == herox && y == heroy){
			hero.setLife(-this.strenght+hero.getDefence());
			}
	}
	
	
	
	/*** Setters ***/
	
	public void setLife(int lesslife){
		if( 0< this.life & this.life <= this.lifemax){
			this.life += lesslife ;
			if (this.life > this.lifemax){
				this.life = this.lifemax;
			}
		}
	}

	
	public void setIcon(Image newIcon){
		this.icon = newIcon ;
	}
}
