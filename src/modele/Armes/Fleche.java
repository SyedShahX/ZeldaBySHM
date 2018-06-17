package modele.Armes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Arme;
import modele.Collisions;
import modele.Vivant;

public class Fleche extends Arme{
	
	private int tempsFleche;
	private StringProperty orientation;
	
	public Fleche(String nom, int ptAttaque,int positionX, int positionY) {
		super(nom, ptAttaque,positionX, positionY);
		this.orientation = new SimpleStringProperty();
	}

	public void agir(String orientationLink,Vivant adversaire) {

		int tempsAnimation = 60;
		final int DISTANCE = 10;
		
		if (monde.getLink().getListeArmes().contains(monde.getFleche()) &&
				!Collisions.collision(getBounds(40,40),adversaire.getBounds(32,30))) {
				if (tempsFleche == tempsAnimation) {
					tempsFleche = 0;
					monde.getGameLoop().gameLoopFleche.stop();
					monde.supprimerArmeMap(this);
				} else if(tempsFleche < tempsAnimation && tempsFleche % 5 == 0) {
					switch(orientationLink) {
					case "haut":    setPosY(getPosY() - DISTANCE);
						break;
					case "bas":  	setPosY(getPosY() + DISTANCE);
						break;
					case "gauche":  setPosX(getPosX() - DISTANCE);
						break;
					case "droite": 	setPosX	(getPosX() + DISTANCE);
						break;
					}
				}
				tempsFleche++;
		} else {

			monde.getGameLoop().gameLoopFleche.stop();
			monde.supprimerArmeMap(this);
			monde.getLink().enleverPointDeVie(adversaire);
		}
	}
	
	public String getOrientation() {
		return this.orientation.get();
	}
	
	public void setOrientation(String orientation) {
		this.orientation.set(orientation);
	}
	
	public StringProperty orientationProperty() {
		return this.orientation;
	}
}

