package System;

/*** Based on a SwingTimer, handles the different states of the Game et reacts according to it ***/

import java.awt.Color;
import Audio.Sound;
import Controller.KeyInput;
import Controller.MouseInput;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Objet.ListObjet;
import Population.Population;
import Population.Population.MAISON;
import View.ButtonMenu;
import View.Choices;
import View.Gameover;
import View.Inventory1;
import View.Inventory2;
import View.Load;
import View.ParametreMenu;
import View.PrincipalMenu;
import View.Scene1;
import View.Scene2;


public class Game extends JPanel implements ActionListener{
	
	/*** Attributes ***/
	
	private int	 multiplayer;
	private MAISON maison1,maison2;
	private int  speed;
	private boolean sound;
	
	public static final int BLOCKSIZE = 96;
	public static int GRIDSIZE_X = 30;
	public static int GRIDSIZE_Y = 30;
	public static int SCREENSIZE = 6; // Depends on the computer used.
	public static int NBRE_ENNEMY = 20;
	public static int NBRE_TRAP = 10;
	public static int MAP = 1;
	
    private Timer timer;
    private STATE gamestate;
    private PrincipalMenu principalmenu;
    private ParametreMenu parametremenu;
    private Board board;
    private Scene1 scene1;
    private Scene2 scene2;
    private Population population;
    private Gameover gameover;
    private Inventory1 inventory1;
    private Inventory2 inventory2;
    private Choices choices;
    private ButtonMenu buttonMenu ;
    private ListObjet listobjet;
    private Load load;
    private Sound music;
   
    
	public enum STATE {
		Menu,
		Load,
		Choices,
		ShowButtons,
		Game,
		Parametre,
		Inventory,
		Gameover
	};
    
	/*** Constructor ***/
	
    public Game() {
    	initVariables();
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(new KeyInput(this));
        addMouseListener(new MouseInput(this));

        timer = new Timer(40, this); // Because it is a Swing Timer, it calls " actionPerformed " every 
        timer.start(); // 40 Milli seconds which call the method " paintCompoenent(). But the Model and the
        			   // view are well separated because this method Just calls the view's methods without defining them.
    }
    
    /*** Methods ***/
    
    // Initialize the attributes of the Game
    private void initVariables(){
    	gamestate = STATE.Menu;
    	principalmenu = new PrincipalMenu(this);
    	parametremenu = new ParametreMenu(this);
    	board = new Board(this, GRIDSIZE_X, GRIDSIZE_Y, NBRE_TRAP);
    	scene1 = new Scene1(this);
    	scene2 = new Scene2(this);
    	gameover = new Gameover(this);
    	inventory1 = new Inventory1(this);
    	inventory2 = new Inventory2(this);
    	choices = new Choices(this);
    	buttonMenu = new ButtonMenu(this) ;
    	listobjet = new ListObjet(this);
    	load = new Load(this);
    	music = new Sound(this, 1);
    	speed = 1;
    	maison1 = MAISON.Unknown;
    	maison2 = MAISON.Unknown;
    	multiplayer = 0;
    	sound = false;
    }
    
    public void saveGame(String filename){
  		try {
	    	ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(this.listobjet);
			oos.writeObject(this.board);
			oos.writeObject(this.population);// Writes the content of the object to the file
			oos.flush(); // Flushes the buffer
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
    }
    
    public void loadGame(String filename){		
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(filename));
			this.listobjet = (ListObjet) ois.readObject();
			listobjet.restoreTransients(this);
			this.board = (Board) ois.readObject();
			board.restoreTransients(this);
			this.population = (Population) ois.readObject();
			population.restoreTransients(this);
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void actionPerformed(ActionEvent e) {
        repaint(); // repaint is a swing's method which calls paintComponent()
    }    
    
    // According to the current State, shows the right window  
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        if (gamestate == STATE.Menu){
        	setscreensize(640,500);
        	principalmenu.showMenu(g);
        }else if (gamestate == STATE.Load){
        	setscreensize(640,500);
        	load.showMenu(g);
        }else if (gamestate == STATE.Choices){
        	setscreensize(1280,1000);
        	choices.showMenu(g);
        }else if(gamestate == STATE.ShowButtons){
        	setscreensize(1280,1000);
        	buttonMenu.showButton(g, population.getMultiplayer()) ;
        }else if (gamestate == STATE.Game){
        	setscreensize(BLOCKSIZE*SCREENSIZE+ population.getMultiplayer()*(BLOCKSIZE*SCREENSIZE+ 20),BLOCKSIZE*SCREENSIZE+120);
        	animation(); // calls the method of each object of the list " population " 
        	scene1.show(g);
        	if (population.getMultiplayer() == 1){
        		scene2.show(g);
        	}
        }else if (gamestate == STATE.Parametre){
        	setscreensize(640,500);
        	parametremenu.showMenu(g);
        }else if (gamestate == STATE.Inventory){
        	setscreensize(BLOCKSIZE*SCREENSIZE+ population.getMultiplayer()*(BLOCKSIZE*SCREENSIZE+ 20),BLOCKSIZE*SCREENSIZE+120);
        	inventory1.showMenu(g);
        	if (population.getMultiplayer() == 1){
        		inventory2.showMenu(g);
        	}
        }else if (gamestate == STATE.Gameover){
        	setscreensize(640,500);
        	gameover.showMenu(g);
        }
        g.dispose();
    }	
    
    
    private void animation() {
		for (int i = 0; i<population.size();i++){
			population.get(i).method(this);
		}
    	if (getPopulation().gethero1().getIsDrawing()){
    		getPopulation().gethero1().drawAttack(this);
    	}if (getPopulation().gethero1().getIsDrawing() == false){
    		getPopulation().gethero1().unDrawAttack(this);
    	}if (population.getMultiplayer() == 1){
    		if (getPopulation().gethero2().getIsDrawing()){
    			getPopulation().gethero2().drawAttack(this);
    		}if (getPopulation().gethero2().getIsDrawing() == false){
        		getPopulation().gethero2().unDrawAttack(this);
    		}
    	}
		population.death();
	}
    
    
    
    private void setscreensize(int screensizex, int screensizey){
    	setPreferredSize(new Dimension(screensizex, screensizey));
    	((JFrame) SwingUtilities.getRoot(this)).pack();
    	setBackground(Color.black);
    	invalidate();
    }
    
	public void goMenu(){
		initVariables();
	}
	
	public void StartChoices(){
		gamestate = STATE.Choices;
	}
	public void StartLoad(){
		gamestate = STATE.Load;
	}
    public void StartGame(){
    	gamestate = STATE.Game;
    }
    public void showButton(){
		gamestate = STATE.ShowButtons;
	}
    
	public void parametre(){
    	gamestate = STATE.Parametre;
    }
    
    public void quit(){
    	System.exit(1);
    }
    
    public void stateInventory(){
    	gamestate = STATE.Inventory;
    }
    
    public void pause(){
    	if (timer.isRunning()){
    		timer.stop();
    	}else{
    		timer.start();
    	}
    }
    
    public void gameover(){
    	gamestate = STATE.Gameover;
    }
    
    public void inventory(){
    	gamestate = STATE.Inventory;
    }


    /*** Getters ***/
    
    public MAISON getMaison1(){
    	return this.maison1;
    }

    public MAISON getMaison2(){
    	return this.maison2;
    }
    
    public STATE getGameState(){
    	return this.gamestate ;
    }
    
    public Board getBoard(){
    	return this.board ;
    }
    
    public Scene1 getscene1(){
    	return this.scene1;
    }
    
    public Scene2 getscene2(){
    	return this.scene2;
    }
    
    public Population getPopulation(){
    	return this.population ; 
    }
    
    public ListObjet getListObjet(){
    	return this.listobjet;
    }
    
    public int getspeed(){
    	return this.speed;
    }

    public int getMultiplayer(){
    	return this.multiplayer;
    }
    
    public static int getGridSizeX (){
    	return GRIDSIZE_X;
    }
    
    public static int getGridSizeY (){
    	return GRIDSIZE_Y;
    }
    
	public int getMap(){
		return MAP;
	}
	
	public boolean getSound(){
		return this.sound;
	}
	
	public Sound getMusic() {
		return music;
	}
    /*** Setters ***/
    
    public void setMaison(MAISON variable){
    	if(this.maison1 == MAISON.Unknown){
    		this.maison1 = variable;
    	}else{
    		this.maison2 = variable;
    	}
    	this.population = new Population(NBRE_ENNEMY, this);
    }
    
    public void setGamestate(STATE variable){
    	this.gamestate = variable;
    }
    
    public void setspeed(int variable){
    	this.speed = variable;
    }
    
    public void setNewBoard(){
    	 this.board = new Board(this,GRIDSIZE_X, GRIDSIZE_Y, NBRE_TRAP);
    }
    
    public void setMultiplayer(int variable){
    	this.multiplayer = variable;
    }
    
    public void setSound(boolean variable){
    	this.sound = variable;
        getMusic().play();
    }
    
    public void setGridSize(int gridx, int gridy){
    	GRIDSIZE_X = gridx;
    	GRIDSIZE_Y = gridy;
    }
    
	
	public void setMap(int variable){
		MAP = variable;
	}
    
    public void setDifficult(int difficult){
    	if (difficult == 1){
    		NBRE_ENNEMY = 10;
    		setMap(1);
    	}else if (difficult == 2){
    		NBRE_ENNEMY = 20;
    		setMap(3);
    	}else if (difficult == 3){
    		NBRE_ENNEMY = 40;
    		setMap(5);
    	}
    	
    }
}
