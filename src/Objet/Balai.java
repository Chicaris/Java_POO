package Objet;

import Objet.ListObjet.OBJET;
import Population.Hero;
import View.Scene1;

public class Balai extends Objet {
	
	/*** Constructor ***/
	
	public Balai(int x, int y) {
		super(x, y);
		this.objet = OBJET.Balai;
	}
	
	/*** Methods ***/
	
	public void heroInCase(Hero hero,int x, int y){
		hero.setFlyingBroom(true);
	}
	
	public int getBinary(){
		return Scene1.BALAI ;
	}
}
