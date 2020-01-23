package Objet;


import Objet.ListObjet.OBJET;
import Population.Hero;
import View.Scene1;


public class Baguette extends Objet {
	
	/*** Constructor ***/
	
	public Baguette(int x, int y) {
		super(x, y);
		this.objet = OBJET.Baguette;
	}
	
	/*** Methods ***/
	
	public void heroInCase(Hero hero,int x, int y){
		hero.setStrenght(hero.getStrengh()+5);	
	}
	
	public int getBinary(){
		return Scene1.BAGUETTE ;
	}
}
