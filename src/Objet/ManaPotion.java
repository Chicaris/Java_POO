package Objet;


import Objet.ListObjet.OBJET;
import Population.Hero;
import View.Scene1;

public class ManaPotion extends Objet{
	
	/*** Constructor ***/

	public ManaPotion(int x, int y) {
		super(x, y);
		this.objet = OBJET.ManaPotion;
	}
	
	/*** Methods ***/

	public void heroInCase(Hero hero, int x, int y) {
		hero.setMana(+20);		
	}
	
	public int getBinary(){
		return Scene1.MANAPOTION ;
	}

}
