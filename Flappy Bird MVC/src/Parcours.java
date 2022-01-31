import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Point2D.Double;


public class Parcours {
	/*
	 * Tirage Al�atoire
	 */
	public static final Random rand= new Random();
	
	/*
	 * Cr�ation d'une liste de points � d�ssiner
	 */
	private ArrayList<Double> mesPoints = new ArrayList<Double>();
	
/*
 *  Le constructeur fabrique les points
 *  On place le point de d�part de la lign� bris�e (centr� � l'int�rieur de l'ovale)
 *  Par la suite, on randomise les points g�n�r�, mais en les empechants de d�pass� une certaine somme
 *  Cela permet que la ligne bris�e ne soit pas trop pointu, voir impossible pour le joueur
 *  Puis on instancie les nouveaux points
 */
	public Parcours() { 
		double x_precedent = 0.04;
		mesPoints.add(new Double(0.04,0.53)); 
		
		for (int i = 0; i<9; ++i){
			double randomValueX = 0.3 + (0.5 - 0.3) * rand.nextDouble(); 
			double randomValueY = 0.3 + (0.5 - 0.3) * rand.nextDouble(); 
			double x = x_precedent + randomValueX;
			double y = randomValueY;	
			//ajoute un point  
			mesPoints.add(new Double(x,y));
			x_precedent = x;
		}
		
		mesPoints.add(new Double(x_precedent + rand.nextDouble(),rand.nextDouble()));
		
	}
		
	
	
	/*
	 * Permet de faire en sortes que les points "se d�placent" 
	 * On fait diminuer l'abscices des points pour que la courbe recule
	 */
	public void avancer() {
		for(int i = 0 ; i<mesPoints.size(); ++i ) {
			Double d = mesPoints.get(i);
			double x = d.getX();
			double y = d.getY();
			mesPoints.set(i,new Double(x-0.1,y));
		}
		double randomValueX = 0.3 + (0.5 - 0.3) * rand.nextDouble();
		double randomValueY = 0.3 + (0.5 - 0.3) * rand.nextDouble();
		double x = mesPoints.get(mesPoints.size()-1).getX() + randomValueX;
		double y = randomValueY;	
		//ajoute un point  
		mesPoints.add(new Double(x,y));
	}

	//Un getteur sur les points
	public Double[] getParcours() {
		return mesPoints.toArray(new Double[mesPoints.size()]);	
	}
	
	
	public void resetParcours() {
		this.mesPoints = new ArrayList<Double>();
		
		double x_precedent = 0.04;
		mesPoints.add(new Double(0.04,0.53)); 
		
		for (int i = 0; i<9; ++i){
			double randomValueX = 0.3 + (0.5 - 0.3) * rand.nextDouble(); 
			double randomValueY = 0.3 + (0.5 - 0.3) * rand.nextDouble(); 
			double x = x_precedent + randomValueX;
			double y = randomValueY;	
			//ajoute un point  
			mesPoints.add(new Double(x,y));
			x_precedent = x;
		}
		
		mesPoints.add(new Double(x_precedent + rand.nextDouble(),rand.nextDouble()));
	}
	

}
