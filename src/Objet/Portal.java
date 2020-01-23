package Objet;

import Objet.ListObjet.OBJET;
import Population.Hero;

import View.Scene1;

public class Portal extends Objet{
	
	/*** Constructor ***/
	
	public Portal(int x, int y) {
		super(x, y);
		this.objet = OBJET.Portal ;	
	}

	/*** Methods ***/
	
	public void heroInCase(Hero hero, int x, int y) {
	}
	
	/*** Getters ***/

	public int getBinary() {
		return Scene1.PORTAL;
	}

}
