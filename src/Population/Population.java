package Population;

/*** Creates a list with all the characters of the game. ***/

import java.io.Serializable;
import java.util.ArrayList;

import System.Game;
import View.Scene1;

public class Population implements Serializable{
	
	/*** Attributes ***/

	private static final long serialVersionUID = 1L;

	public ArrayList<Personnage> population = new ArrayList<Personnage>();
	
	public enum TYPE{
		Unknown,
		Hero1,
		Hero2,
		BasicEnnemy,
		Boss
	};
	
	public enum MAISON{
		Unknown,
		Gryffondor,
		Serpentard,
		Serdaigle,
		Poufsouffle
	};
	
	private int map;
	private int multiplayer;
	
	transient Game myGame;
	
	/*** Constructor ***/
	
	public Population(int nbre_ennemy, Game game){
		this.multiplayer = game.getMultiplayer();
		restoreTransients(game);
		population.add(new Hero(TYPE.Hero1,8,9,100,3,6,3,myGame.getMaison1()));
		if (myGame.getMultiplayer() == 1){
			population.add(new Hero(TYPE.Hero2,25,25,100,3,6,3,myGame.getMaison2()));
		}
		initPopulation(nbre_ennemy, map);
	}
	
	/*** Methods ***/
	
	public void restoreTransients(Game game) {
		myGame = game;
		this.map = game.getMap();
		for (int i =0; i<population.size();i++){
			population.get(i).restoreTransients();
		}
	}
	
	// Initialize the list with all the characters.
	public void initPopulation(int nbre_ennemy, int map) {
		myGame.setNewBoard();
		((Hero) gethero1()).setPosition(1,2);
		if (myGame.getMultiplayer() == 1){
			((Hero) gethero2()).setPosition(myGame.getGridSizeX()-2,myGame.getGridSizeY()-5);
		}
		for (int i = 0;i<nbre_ennemy;i++){
			addBasicEnnemy(5*map,3*map);
		}
		for (int i = 0; i<map;i++){
			addBoss(10*map,3*map);
		}
		myGame.getListObjet().initListObjet();
		this.map+= 2; // Increments the number of maps already given. 
					// Allows easily to raise the power of the enemies each round 
	}

	private void addBoss(int strenght, int defence){
		boolean res = true;
		while (res){
			int x = (int) (Math.random()*Game.getGridSizeX());
			int y = (int) (Math.random()*Game.getGridSizeY());
			if (myGame.getBoard().getelement(x, y) != Scene1.STONE){
				population.add(new Boss(x,y,100,25,strenght,defence));
				res = false;
			}
		}
	}
	
	private void addBasicEnnemy(int strenght, int defence){
		boolean res = true;
		while (res){
			int x = (int) (Math.random()*Game.getGridSizeX());
			int y = (int) (Math.random()*Game.getGridSizeY());
			if (myGame.getBoard().getelement(x, y) != Scene1.STONE){
				population.add(new BasicEnnemy(x,y,100,25,strenght,defence));
				res = false;
			}
		}
	}
	
	
	// Handles the death of the characters according to their type.
	// Shows the GameOver window if the player died
	// Drops the object if an enemy died
	// Add a portal if no enemies left on the map
	public void death(){
		for (int i = 0; i<population.size();i++){
			if (population.get(i).getLife() <= 0){
				if (population.get(i).gettype() == TYPE.Hero1 || population.get(i).gettype() == TYPE.Hero2){
					myGame.gameover(); 
				}else{
					myGame.getListObjet().addObjet(population.get(i).get_x(), population.get(i).get_y());
					population.remove(i);
					gethero1().setExperience(+50);					
				}
			}
		}
		if (population.size()<=1+myGame.getMultiplayer()){ // Generates a new map if there are ONLY players on the map
			myGame.getListObjet().addPortal(8,9);
		}
	}
	
	/*** Getters ***/
	
	public int size() {
		return population.size();
	}
	
	public Personnage get(int index) {
		return population.get(index);
	}
	
	public Hero gethero1() {
		for (int i =0; i<population.size();i++){
			if(population.get(i).gettype() == TYPE.Hero1){
				return (Hero) population.get(i);
			}
		}
		return null;
	}
	
	public Hero gethero2() {
		for (int i =0; i<population.size();i++){
			if(population.get(i).gettype() == TYPE.Hero2){
				return (Hero) population.get(i);
			}
		}
		return null;
	}
	
	public int getMultiplayer(){
		return this.multiplayer;
	}
	

	
	/*** Setters ***/
	public void setMultiplayer(int variable){
		this.multiplayer = variable;
	}

}
