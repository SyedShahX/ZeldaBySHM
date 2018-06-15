package modele.Armes;

import javafx.scene.input.KeyEvent;
import modele.Arme;
import modele.Collisions;

public class Fleche extends Arme {
	
	private int tempsFleche;
	
	public Fleche(String nom, int ptAttaque,int positionX, int positionY) {
		super(nom, ptAttaque,positionX, positionY);
	}
	
	public void agir(KeyEvent e) {

		int tempsAnimation = 170;
		final int DISTANCE = 10;
		
		if (monde.getListeArmes().contains(monde.getFleche())) {
			setPosX(monde.getLink().getPosX());
			setPosY(monde.getLink().getPosY());
			if(!Collisions.collision(this.getBounds(32, 20),
					monde.getLink().getBounds(32, 18))) {
				if (tempsFleche == tempsAnimation) {
					tempsFleche = 0;
					monde.supprimerArmeMap(monde.getFleche());
				} else if(tempsFleche < tempsAnimation && tempsFleche % 5 == 0) {
					switch(e.getCode()) {
					case UP:    setPosY(getPosY() - DISTANCE);
						break;
					case DOWN:  setPosY(getPosY() + DISTANCE);
						break;
					case LEFT:  setPosX(getPosX() - DISTANCE);
						break;
					case RIGHT: setPosX	(getPosX() + DISTANCE);
						break;
					default:
						break;
					}
					tempsFleche++;
				} else {
					
				}
			}
		}
	}
}
