package modele.Objets;



import java.awt.Rectangle;

import modele.Objet;

public class Roche extends Objet {
	
	
	public Roche(int positionX, int positionY) {
		super(positionX,positionY);
	}
	public Rectangle zoneDetection() {
		return new Rectangle(getPosX()-20,getPosY()-10,60,40);
	}
}