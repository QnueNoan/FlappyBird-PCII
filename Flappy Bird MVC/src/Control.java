import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener, KeyListener{

	private Affichage affichage;
	private Etat etat;
	private Parcours parcours;


	public Control(Affichage a, Etat e, Parcours p) {
		this.affichage = a;
		this.etat = e;
		this.parcours = p;
	}


	public synchronized void lancementJeu() {
		(new Thread() {
			@Override
			public void run() {
				while(true) {
					if(etat.getDebutJeu()) {
						parcours.avancer();
						etat.moveDown();
						affichage.lancerTimer();
						affichage.repaint();
						try {
							Thread.sleep(500);
						} catch(Exception e) {}
					}
				}
				
			};
		}).start();
	}

	/*
	 * Suite à l'implémentation de MouseListener, cela permet à l'utlisateur d'avoir une interaction à la souris, 
	 * Ici, on a une boucle toute simple
	 * Lorsque l'on clic, le jeu se lance, et si le jeu est deja lancer, cela fait sauter l'ovale et actualise l'affichage de la fenentre
	 */
		@Override
		public void mouseClicked(MouseEvent e) {
			if (!etat.getDebutJeu()) {
				etat.setDebutJeu(true);
				lancementJeu();
			}
			else{
				etat.jump();
				affichage.repaint();
			}

		}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Suite à l'implémentation de KeyListener, cela permet à l'utlisateur d'avoir une interaction au clavier, 
	 * Ici, on a une boucle toute simple
	 * Lorsque l'on appuie sur la touche espace, le jeu se lance, et si le jeu est deja lancer, cela fait sauter l'ovale et actualise l'affichage de la fenentre
	 */	@Override
	public void keyPressed(KeyEvent e) {	
		if (!etat.getDebutJeu()) {
			etat.setDebutJeu(true);
			lancementJeu();
		}

		else{
			switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				etat.jump();
				affichage.repaint();
				break;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}