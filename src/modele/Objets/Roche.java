package modele.Objets;

import java.awt.Rectangle;

import modele.Objet;

public class Roche extends Objet {
	
	public Roche(String nom,int positionX, int positionY) {
		super(nom,positionX,positionY);
	}
	public Rectangle zoneDetection() {
		return new Rectangle(getPosX()-40,getPosY()-10,65,40);
	}
}   