package GameCore.gfx;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

final public class SoundLoader {
	
	public static AudioInputStream LoadSound(String path){
	try{	
	return AudioSystem.getAudioInputStream(SoundLoader.class.getResourceAsStream("/res/audio/" + path));
	}catch(Exception e){
	e.printStackTrace();
	System.exit(1);
	}
	return null;
	}
}
