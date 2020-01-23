package Controller;

/*** Controller part1. Only changes boolean values in the accurate class. ***/

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import System.Game;
import Population.Hero;
import System.Game.STATE;


public class KeyInput extends KeyAdapter{
	
	/*** Attributes ***/
	Game myGame;
	
	/*** Constructor ***/
	public KeyInput(Game game){
		myGame = game;
	}
	
	/*** Methods ***/
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_1){
        	myGame.saveGame("HarryPotter1.save");
        }if (key == KeyEvent.VK_2){
        	myGame.saveGame("HarryPotter2.save");
        }if (key == KeyEvent.VK_3){
        	myGame.saveGame("HarryPotter3.save");
        }if (key == KeyEvent.VK_4){
        	myGame.saveGame("HarryPotter4.save");
        }
		if (key == KeyEvent.VK_ESCAPE){
	    	myGame.goMenu();
	    }if (key == KeyEvent.VK_P){
	    	myGame.pause();
	    }if (key == KeyEvent.VK_I){
	    	if (myGame.getGameState() == STATE.Game){
	    		myGame.stateInventory();
	    	}else if (myGame.getGameState() == STATE.Inventory){
	    		myGame.setGamestate(STATE.Game);
	    	}
	    }
	    if (myGame.getGameState() == STATE.Game){
	        Hero hero1 = myGame.getPopulation().gethero1();
	        keyPressHero1(key, hero1);
	        if (myGame.getPopulation().getMultiplayer() == 1){
		        Hero hero2 = myGame.getPopulation().gethero2();
		        keyPressHero2(key, hero2);
	        }
        }
        
    }
	
    // All the commands for player 1
	public void keyPressHero1 (int key, Hero hero){
		if (key == KeyEvent.VK_LEFT) { 
        	hero.setDirX(-1);
        	hero.setDirY(0);
        	hero.setOrientationG(hero.getOriG ());
        }if (key == KeyEvent.VK_RIGHT){ 
        	hero.setDirX(1);
        	hero.setDirY(0) ;
        	hero.setOrientationD(hero.getOriD ());
        }if (key == KeyEvent.VK_UP){
        	hero.setDirX(0);
        	hero.setDirY(-1) ;
        	hero.setOrientationH(hero.getOriH ());
        }if (key == KeyEvent.VK_DOWN){ 
        	hero.setDirX(0);
        	hero.setDirY(1) ;
        	hero.setOrientationB(hero.getOriB ());
        }if (key == KeyEvent.VK_W){
        	hero.setBasicAttack(true);
        }if ( key == KeyEvent.VK_X){
        	hero.setSpecialAttack(true);
        }if (key == KeyEvent.VK_C){
        	hero.setDistanceAttack(true);
        }if (key == KeyEvent.VK_V){
        	hero.setHealth(true);
        }if (key == KeyEvent.VK_A){
        	if(hero.getBalai() &! hero.getIsOnFlyingBroom()){
        	hero.setRun(true);
        	}
        	else if(hero.getBalai() && hero.getIsOnFlyingBroom()){
            	hero.setRun(false);
           	}
        }
	}
	
	// All the commands fort Player 2
    public void keyPressHero2 (int key, Hero hero){
    	if (key == KeyEvent.VK_Q) {
        	hero.setDirX(-1);
        	hero.setDirY(0);
        }if (key == KeyEvent.VK_D){
        	hero.setDirX(1);
        	hero.setDirY(0);
        }if (key == KeyEvent.VK_Z){
        	hero.setDirX(0);
        	hero.setDirY(-1);
        }if (key == KeyEvent.VK_S){
        	hero.setDirX(0);
        	hero.setDirY(1);
        }if (key == KeyEvent.VK_K){
        	hero.setBasicAttack(true);
        }if ( key == KeyEvent.VK_L){
        	hero.setSpecialAttack(true);
        }if (key == KeyEvent.VK_M){
        	hero.setDistanceAttack(true);
        }if (key == KeyEvent.VK_J){
        	hero.setHealth(true);
        }if (key == KeyEvent.VK_SHIFT){
        	if(hero.getBalai() &! hero.getIsOnFlyingBroom()){
            	hero.setRun(true);
            }
            else if(hero.getBalai() && hero.getIsOnFlyingBroom()){
                hero.setRun(false);
            }
        }
    }
        

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (myGame.getGameState() == STATE.Game){
        	 Hero hero1 = myGame.getPopulation().gethero1();
             keyReleasedHero1(key, hero1);
             if (myGame.getPopulation().getMultiplayer() == 1){
             	Hero hero2 = myGame.getPopulation().gethero2();
             	keyReleasedHero2(key, hero2);
             } 
        }
    }
    
    public void keyReleasedHero2(int key, Hero hero){
    	if (key == KeyEvent.VK_Q || key == KeyEvent.VK_D || key == KeyEvent.VK_Z || key == KeyEvent.VK_S){
        	hero.setDirX(0);
        	hero.setDirY(0);    
	    }if (key == KeyEvent.VK_K){
	    	hero.setBasicAttack(false);
	    }if ( key == KeyEvent.VK_L){
	    	hero.setSpecialAttack(false);
	
	    }if (key == KeyEvent.VK_M){
	    	hero.setDistanceAttack(false);
	
	    }if (key == KeyEvent.VK_J){
	    	hero.setHealth(false);
	
	    }
    }
    
    public void keyReleasedHero1(int key,Hero hero){
	    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
	    	hero.setDirX(0);
	    	hero.setDirY(0);
	    }if (key == KeyEvent.VK_W){
	    	hero.setBasicAttack(false);
	    }if ( key == KeyEvent.VK_X){
	    	hero.setSpecialAttack(false) ;
	    }if (key == KeyEvent.VK_C){
	    	hero.setDistanceAttack(false);
	    }if (key == KeyEvent.VK_V){
	    	hero.setHealth(false);
	    }
    }
}


