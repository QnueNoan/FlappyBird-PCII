
public class Etat {

	// Constantes
	public int oval_x;
	public int oval_y;
	
	
	public static int jump = 20;
	public static final int Chute = 20;
	private boolean debutjeu;
	private Audio audio;
	
  /*
   * 
   * Donne les coordonnées initiales de l'ovale dans l'affichage
   */
	public Etat(Audio audio) {
		this.audio = audio; 
		oval_x = 260;
		oval_y = 10;
		
	}	
	/*
	 * Permet à l'ovale de monter vers le haut (ordonnée)
	 * De plus un "son" est joué à chaque saut
	 */
	public void jump() {
		if(this.oval_x > 1)
		//if (hauteur-jump>0) {
			this.oval_x -= jump;
		//this.oval_y += jump;
		audio.playJumpAudio();
		
		//}
	}

	/*
	 *  Permet à l'ovale de chuter (tombe vers le bas en ordonnée)
	 *  De plus l'ovale ne peut pas sortir de la fenetre d'affichage
	 */
	public void moveDown() {
		if(this.oval_x + 100 < 600)
			oval_x += Chute;

	}
	
	/*
	 * Setter & Getter
	 */
	public boolean getDebutJeu() {
		return this.debutjeu;
	}
	
	public  void setDebutJeu(boolean b) {
		this.debutjeu = b;
	}

	public int getOvalX() {
		return this.oval_x;
	}
	
	public int getOvalY() {
		return this.oval_y;
	}
	
	public void resetEtat() {
		this.debutjeu = false;
		oval_x = 260;
		oval_y = 10;
	}
}

