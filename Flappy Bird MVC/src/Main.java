import javax.swing.JFrame;


public class Main {

	public static void main(String [] args) {
		JFrame test = new JFrame("Flappy Ouistiti");
		Audio audio = new Audio();
		Etat etat = new Etat(audio);
		Parcours parcours = new Parcours();
		Bird bird = new Bird();
		Affichage affichage = new Affichage(etat,parcours,bird);
		Control control = new Control(affichage,etat,parcours);
		audio.loopPersistantAudio();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.add(affichage);
		test.addMouseListener(control);
		test.addKeyListener(control);	
		test.pack();
		test.setVisible(true);
		
	
		
	      
		
		
		
		
		
		
		
		
		
	
		
	}

}
