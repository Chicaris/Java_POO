package Objet;

import Objet.ListObjet.OBJET;
import Population.Hero;
import View.Scene1;

public class Cape extends Objet {
	
	/*** Constructor ***/

	public Cape(int x, int y) {
		super(x, y);
		this.objet = OBJET.Cape;
	}
	
	/*** Methods ***/
	
	public void heroInCase(Hero hero,int x, int y){
		hero.setVisibility(false);
	}
	
	public int getBinary(){
		return Scene1.CAPE ;
	}
}
