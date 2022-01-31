import java.awt.Image;

import javax.swing.ImageIcon;

public class Bird extends Thread {
	private int img_bird = 1;
	private int bird_X;
	private int bird_Y;
	
	private Image bird;
	
	public Parcours parcours;
	
	public Bird () {
				
		(new Thread () {
			@Override
			public void run() {
				while (true) {
					ImageIcon stream = new ImageIcon(getClass().getResource("/img/"+ img_bird +".png"));
					bird = stream.getImage();
					img_bird++;
					if(img_bird == 9) {
						img_bird = 1;
					}}
			}
		}).start();
	}
	
	/*
	 * Getters & setters
	 */


	public int getBird_X() {
		return bird_X;
	}
	
	public int getBird_Y() {
		return bird_Y;
	}
	
	public Image getBird() {
		return bird;
	}
		
}
