package System;

/*** Creates the board. ***/

import java.io.Serializable;

import View.Scene1;

public class Board implements Serializable{
	
	/*** Attributes ***/
	
	transient Game myGame;
	public int[][] matrice;
	
	
	/*** Constructor ***/
	
	public Board(Game game, int width, int height, int nbre_trap){
		restoreTransients(game);
		matrice = new int[width][height];
		creatematrice();
		addTrap(nbre_trap);
	}
	
	/*** Methods ***/
	
	public void restoreTransients(Game game) {
		myGame = game;
	}
	
	public void creatematrice(){
		for (int x = 0; x<Game.getGridSizeX();x++){
			for (int y = 0; y<Game.getGridSizeY();y++){
				int random = (int) (Math.random()*4);					
				if (createwall(x,y) || (random < 1 && !createway(x,y))){
					matrice[x][y] = Scene1.STONE;
				}else{
					if (random<1 || createway(x,y)){
						matrice[x][y] = Scene1.GROUND;
					}else{
						matrice[x][y] = Scene1.HERB;
					}
				}	
			}
		}
	}
	
	public void addTrap(int nbre_trap){
		for (int i = 0; i<nbre_trap;i++){
			int randomx = ToolMethods.random(1, Game.getGridSizeX());
			int randomy = ToolMethods.random(1, Game.getGridSizeY());
			if (getelement(randomx,randomy)!=Scene1.STONE){
				setelement(randomx, randomy,getelement(randomx, randomy) + Scene1.TRAP);
			}
		}
	}
	
	private boolean createway(int x, int y){
		boolean rv = false;
		if (y == 2 && x<9){
			rv = true;
		}else if (x == 8 && y>1 && y<Game.GRIDSIZE_Y-(myGame.SCREENSIZE-1)/2){
			rv = true;
		}else if (y==Game.GRIDSIZE_Y-(myGame.SCREENSIZE-1)/2-1 && x>8){
			rv = true;
		}
		return rv;	
	}
	
	private boolean createwall(int x,int y){
		boolean rv = false;
		if (x==0 || y==0|| x==Game.getGridSizeX()-1 || y==Game.getGridSizeY()-1){
			rv = true;
		}
		return rv;
		
	}

	
	/*** Getters ***/	
	
	public int getelement(int x, int y){
		if (!(x<0 || y<0 || y>Game.getGridSizeX()-1 || x > Game.getGridSizeY()-1)){
			return matrice[x][y];
		}else{
			return 0;
		}
	}
	
	public int getValidePosistion_x (int x){
		int rv = x;
		if(x<0){rv=0;}
		else if(x>=Game.getGridSizeX()){rv=Game.getGridSizeX()-1;}
		return rv;
	}
	
	public int getValidePosistion_y (int y){
		int rv = y;
		if(y<0){rv=0;}
		else if(y>=Game.getGridSizeY()){rv=Game.getGridSizeY()-1;}
		return rv;
	}
	
	/*** Setters ***/
	

	public void setelement(int x, int y, int element){
		matrice[x][y] = element;
	}
}
