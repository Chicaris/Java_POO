package Population;

/*** SuperClass of all the characters. ***/

import java.awt.Image;
import java.io.Serializable;
import java.lang.reflect.Array;

import Population.Population.TYPE;
import System.Game;

public abstract class Personnage implements Serializable{
	
	/*** Attributes ***/
	
	protected int x,y;
	protected int strenght, defence,life;
	protected int speed;
	protected int animMana;
	protected TYPE type;

	transient protected Image icon;

	/*** Constructor ***/
	
	public Personnage(int x, int y, int life,int speed, int strenght, int defence){
		this.x = x;
		this.y = y;
		this.icon = null;
		this.type = TYPE.Unknown;
		this.life = life;
		this.strenght = strenght;
		this.defence = defence;
		this.speed = speed;
	}	
	
	/*** Getters ***/
	
	public int get_x(){
		return this.x;
	}
	
	public int get_y(){
		return this.y;
	}
	
	public Image getIcon(){
		return this.icon;
	}
	
	public TYPE gettype(){
		return this.type;
	}
	
	public int getStrengh(){
		return this.strenght;
	}
	
	public int getDefence(){
		return this.defence;
	}
	
	public int getLife(){
		return this.life;
	}
	
	/*** Setters ***/
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setStrenght(int variable){
		this.strenght = variable;
	}
	
	public void setDefence(int variable){
		this.defence = variable;
	}
	
	public void setIcon(Array list){
		
	}

	
	public  abstract void setLife(int lesslife);
	
	/*** Methods ***/
	
	// Abstract method because every characters will be stored in a list. 
	// If looping, easier to just write " tempObject.method() "
	public abstract void method(Game game);
	protected abstract void move(Game game) ; 
	public abstract void restoreTransients();
}
