import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Timer;

import java.awt.geom.Point2D.Double;
import java.util.TimerTask;
import java.awt.Point;


@SuppressWarnings("serial")
public class Affichage extends JPanel{
	// Constantes
	public static final int LARG = 400;
	public static final int HAUT = 600;
	public static int x_oval = 40;
	public static final int width_oval = 50;
	public static final int height_oval = 100;

	/*
	 * Image Fond
	 */
	private ImageIcon iconeBandeFond;	
	private Image imgBandeFond;
	/*
	 * Attributs
	 */
	private Etat etat;
	private Parcours parcours;
	private Bird bird;
	
	private Timer timer;
	private int countdown = 60;
	private boolean timerLance = false;

	// Constructeur
	public Affichage(Etat e, Parcours p, Bird b) {
		super();
		setPreferredSize(new Dimension(LARG, HAUT));
		this.etat = e;   
		this.parcours = p;
		this.bird = b;


		// img
		this.iconeBandeFond = new ImageIcon(getClass().getResource("/img/background.png"));
		this.imgBandeFond = this.iconeBandeFond.getImage();
		
		this.timer = new Timer();
	}
	/*
	 * Cette fonction nous permet de dessiné tous les éléments que l'on lui demande
	 * A savoir ici : l'image de fond, la couleur de l'ovale, l'ovale, la ligne brisée, sa couleur ainsi que l'épaisseurs de ceux-ci
	 * Enfin permet egalement de désionné l'oiseau (gif) a partir de ces coordonnées.
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g); // Nettoie la zone d'affichage
		g.drawImage(this.imgBandeFond,0, 0, null);
		g.setColor(Color.white); 
		g.drawOval(etat.getOvalY(), etat.getOvalX(), width_oval, height_oval); 
		g.setColor(Color.white);
		
		Double[] mesPoints = parcours.getParcours();
		Point precedent = modele2vue(mesPoints[0]);

		for(int i=0; i<mesPoints.length;i++) {
			Point nouveau = modele2vue(mesPoints[i]);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(2));
			g.drawLine(precedent.x, precedent.y, nouveau.x, nouveau.y);
			precedent = nouveau;	     	        
		}
		g.drawImage(bird.getBird(), bird.getBird_X(), 
				bird.getBird_Y(), null);  
		g.setColor(Color.WHITE);
		g.drawString("Temps restant: " + countdown + " s", 150, 20);
	}

	/*
	 *  Converti l'abscisse & l'ordonnée de la courbe, pour qu'il soit adapté à la fenetre du jeu.
	 */
	private Point modele2vue(Double d) {
		int x = (int)(d.x*LARG);
		int y = (int)(d.y*HAUT);
		return new Point(x,y);
	}
	
	
	public void lancerTimer() {
		if(this.timerLance == false) {
			this.timer.schedule(new TimerFlappy(), 0, 1000);
			this.timerLance = true;
		}
	}
	
	class TimerFlappy extends TimerTask {
	    public void run() {
	        if(countdown == 0) {
	        	etat.resetEtat();
	        	parcours.resetParcours();
	        	timerLance = false;
	        	timer.cancel();
	        	timer = new Timer();
	        	countdown = 60;
	        	repaint();
	        }
	        else 
	        	countdown = countdown - 1;
	    }

	}
	
	
	

	
	

		

		
	

}