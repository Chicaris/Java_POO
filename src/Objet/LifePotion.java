package Objet;


import Objet.ListObjet.OBJET;
import Population.Hero;
import View.Scene1;

public class LifePotion extends Objet{
	
	/*** Constructor ***/

	public LifePotion(int x, int y) {
		super(x, y);
		this.objet = OBJET.LifePotion;
	}
	
	/*** Methods ***/

	public void heroInCase(Hero hero, int x, int y) {
		hero.setLife(+20);		
	}
	
	public int getBinary(){
		return Scene1.LIFEPOTION ;
	}

}
