import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {

	/**Cha�ne de caract�res contenant les chemins des fichiers audio*/
	private String persistantPath  = "./assets/son/persistantmk.wav";
	private String jumpPath ="./assets/son/jump_flappy.wav";


	
	/**Objets clip repr�sentant des instances de l'interface clip ainsi que les diff�rentes pistes audio */
	private Clip jumpAudio, persistantAudio ;
	
	/**
	 * Constructeur de la classe Audio, ce constructeur peut �tre appel� en dehors de la classe Audio afin 
	 * de cr�er une nouvelle instance de cette classe pour jouer les diff�rents sons du jeu.
	 * 
	 * Ce constructeur v�rifie �galement � l'aide d'un try/catch si les chemins les fichiers sont bien des fichiers sons
	 * et si le chemin des fichiers est bien correct, si ce n'est pas le cas une exception sera lev�e.
	 * 
	 */
	public Audio () {
		
		try {
			jumpAudio = AudioSystem.getClip();
			persistantAudio = AudioSystem.getClip();

			jumpAudio.open(AudioSystem.getAudioInputStream(new File(jumpPath).getAbsoluteFile()));
			persistantAudio.open(AudioSystem.getAudioInputStream(new File(persistantPath).getAbsoluteFile() ) );

			
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
			 
	}
	/**
	 *  Cette m�thode permet de lire la bande son � chaque fois que l'ovale saute
	 */
	public void playJumpAudio () {
		jumpAudio.setFramePosition(0);
		jumpAudio.start();
	}
	
	/*
	 * Cette m�thode permet de lire la musique de fond en boucle
	 */
	public void loopPersistantAudio() {
	
		persistantAudio.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
		
}
