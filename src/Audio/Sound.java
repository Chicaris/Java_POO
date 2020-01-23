package Audio;

/****** Handles the beginning song ******/



import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import System.Game;

public class Sound {
	
	/*** Attributes ***/
	
	int whichsound;
	Game game;
	Clip clip;
	AudioInputStream audio = null;
	/*** Constructor ***/	
	
	public Sound(Game game, int wichsound){
		this.game = game;
		try {
			audio= AudioSystem.getAudioInputStream(new File("HarryPotter.wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
		}
		catch(UnsupportedAudioFileException uae) {
	        System.out.println(uae);
	    }
	    catch(IOException ioe) {
	        System.out.println(ioe);
	    }
	    catch(LineUnavailableException lua) {
	        System.out.println(lua);
	    }	
	}
    

	/*** Methods ***/	
	
	
	
	public void play(){
		if (game.getSound() == true){
        	clip.start();
        }if (game.getSound() == false){
        	clip.stop();
        }
	}
}