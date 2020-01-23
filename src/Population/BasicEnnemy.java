package Population;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import Population.Population.TYPE;
import System.Game;
import View.Scene1;

public class BasicEnnemy extends Personnage implements Serializable{
	
	/*** Attributes ***/
	
	private int lifemax; // Speed represents the velocity of the enemy in his action.
	private int animcounter = 0;
	private transient WhichImage changeimage;
	
	/*** Constructor ***/
	
	public BasicEnnemy(int x, int y,int maxlife, int speed, int strenght, int defence) {
		super(x, y, maxlife,speed, strenght,defence);
		type = TYPE.BasicEnnemy;
		this.life = maxlife;
		this.lifemax = maxlife;
		this.strenght = strenght;
		this.defence = defence;
		this.speed = speed;
		restoreTransients();
	}
	
	
	public void restoreTransients() {
		changeimage = new WhichImage();
		icon = new ImageIcon("images/Monstres/Detraqueur/DetraqueurBas.png").getImage();
	}
	
	/*** Methods ***/
	
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
	
	protected void move(Game game){
		int new_x = x;
		int new_y = y;
		int random = (int) (Math.random()*4);
		switch (random){
			case 0: // up
				new_y-=1;
			break;
			case 1: // down
				new_y +=1;
			break;
			case 2: // to the right
				new_x+=1;
			break; 
			case 3: // to the left
				new_x-=1;
			break;	
		}
		new_x = game.getBoard().getValidePosistion_x (new_x);
		new_y = game.getBoard().getValidePosistion_y (new_y);
		changeimage.changeEnnemiesIcon(random, this);
		if((game.getBoard().getelement(new_x, new_y) & Scene1.STONE) == 0){ // Checks with a binary method if there is a block on the case
			setPosition(new_x,new_y);
		}
	}
	
	private void fight(Game game,Hero hero){
		int herox = hero.get_x();
		int heroy = hero.get_y();
		if (x == herox && y == heroy){
			hero.setLife(hero.getDefence()-this.strenght);
		}
	}
	
	/*** Getter ***/
	
	
	/*** Setter ***/
	
	
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