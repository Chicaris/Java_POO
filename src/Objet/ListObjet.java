package Objet;

/*** Handles the objects. Creates an ArrayList with them ***/
import java.io.Serializable;
import java.util.ArrayList;

import System.Game;
import View.Scene1;

public class ListObjet implements Serializable{
	
	/*** Attributes ***/
	
	transient Game myGame;
	public ArrayList<Objet> listObjet = new ArrayList<Objet>();
	private boolean BalaiAlreadyGiven = false ;
	private boolean InvisibilityCloakAlreadyGiven = false ;
	
	public enum OBJET {
		Unknown,
		Cape,
		Baguette,
		Balai,
		LifePotion,
		ManaPotion,
		Portal
	}
	
	/*** Constructor. ***/
	
	public ListObjet (Game game){
		restoreTransients(game);
	}
	
	/*** Methods ***/
	
	public void restoreTransients(Game game) {
		this.myGame = game;
	}
	public void initListObjet(){
		this.listObjet = new ArrayList<Objet>();
	}
	
	public int size(){
		return listObjet.size();
	}
	
	
	// Method called when an enemy dies. Drops randomly an abject. If the broom or the cloak
	// are already given, they won't anymore
	
	public void addObjet(int x, int y){
		int random = (int) (Math.random()*4) ;
		switch(random){
			case (0):
				listObjet.add(new Baguette(x,y));
				myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.BAGUETTE);
			break;
			case(1):
				if(this.BalaiAlreadyGiven){
					listObjet.add(new ManaPotion(x,y)) ;
					myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.MANAPOTION);
				}
				else{
					listObjet.add(new Balai(x,y));
					myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.BALAI);
				}
			break;
			case(2):
				if(InvisibilityCloakAlreadyGiven){
					listObjet.add(new LifePotion(x,y)) ;
					myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.LIFEPOTION);
				}
				else{
				listObjet.add(new Cape(x,y));
				myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.CAPE);
				}
			break;
			case(3):
				listObjet.add(new LifePotion(x,y)) ;
				myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.LIFEPOTION);
			break ;
			case(4):
				listObjet.add(new ManaPotion(x,y)) ;
				myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.MANAPOTION);
			break ;
			
			}
	}
	
	// Method called when no more enemies on the map
	public void addPortal(int x, int y){
		listObjet.add(new Portal(x,y)) ;
		myGame.getBoard().setelement(x, y,myGame.getBoard().getelement(x, y)+ Scene1.PORTAL);
	}
	
	public void remove(int i) {
		listObjet.remove(i) ;		
	}
	
	
	
	/*** Getters ***/
	
	public Objet get(int index){
		return listObjet.get(index);
	}	
	public Objet getObjet(int x, int y, OBJET objet){
		for (int i = 0 ; i<listObjet.size();i++){
			if (x == listObjet.get(i).get_x() && y == listObjet.get(i).get_y() && objet == listObjet.get(i).getObjet()){
				return listObjet.get(i);
			}
		}
		return null;
	}

	
	
	
	/*** Setters ***/
	
	public void setBalaiAlreadyGiven(){
		this.BalaiAlreadyGiven = true ;
	}
	public void setInvisibilityCloakAlreadyGiven(){
		this.InvisibilityCloakAlreadyGiven =true ;
	}
}
