package Objet;

/*** SuperClass of all the dropped objects. ***/

import java.io.Serializable;

import Objet.ListObjet.OBJET;
import Population.Hero;

public abstract class Objet implements Serializable{
	
	/*** Attributes ***/
	
	protected int x,y;
	protected OBJET objet;
	protected int animcounter;
	
	/*** Constructor ***/
	
	public Objet (int x, int y){
		this.x = x;
		this.y = y;
		this.objet = OBJET.Unknown;
	}
	
	/*** Methods ***/
	
	// Abstract method because defined differently for each object. Interest of the abstract method 
	// because will be called in Hero while looping through the objects
	public abstract void heroInCase(Hero hero,int x, int y);
	
	/*** Getters ***/
	
	public int get_x(){
		return this.x;
	}
	
	public int get_y(){
		return this.y;
	}
		
	public OBJET getObjet(){
		return this.objet;
	}
	
	public abstract int getBinary();
	
	/*** Setters ***/
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
}
