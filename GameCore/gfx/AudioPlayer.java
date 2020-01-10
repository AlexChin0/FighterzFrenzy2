package GameCore.gfx;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class AudioPlayer{
	
	private Clip clip;
	private AudioInputStream inputStream;
	
	public AudioPlayer(String path){
		   inputStream = SoundLoader.LoadSound(path);
			  try {
				  clip = AudioSystem.getClip();
				  clip.open(inputStream);
			} catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
	}
	
	 public void playSound(){	
		 if(!clip.isActive()){
			  clip.setMicrosecondPosition(0);
			  clip.start(); 
		 }
		 }
	 
	 public void loopSound(){
		 if(isClosed()){
			 clip.setFramePosition(0);
			 clip.start();
		 }
		 clip.loop(Clip.LOOP_CONTINUOUSLY);
	 }
	 
	 public boolean isActive(){
		 if(clip.isActive()){
		return true;
		 }else{
		return false;
		 }	 
	 }
	 
	 public boolean isClosed(){
		 if(!clip.isOpen()){
		return true;
		 }else{
		return false;
		 }	 
	 }
	 
	 public void stopSound(){
	   clip.stop();
	 }
	 
	 }
	 
