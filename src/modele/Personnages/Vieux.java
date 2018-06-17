package modele.Personnages;

import java.awt.Rectangle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Agir;
import modele.Collisions;
import modele.Personnage;

public class Vieux extends Personnage implements Agir{

	private StringProperty orientation;
	private int tempsVieux;
	
	public Vieux(String nom, int posX, int posY) {
		super(nom, posX, posY);
		this.orientation = new SimpleStringProperty();
	}
	
	public Rectangle rectangleDetection(int width, int height) {
		return new Rectangle(getPosX()-30, getPosY()-10,width,height);
	}
	
	public void parler() {
		if(monde.getLink().getArme() == null) {
			monde.setMessages(getNom() + " : Ne continue pas ce\nchemin si tu n'es pas armé !"
					+ " Tu y\ntrouveras un méchant ours tueur ! Il\nte faut une arme."
					+ "Si tu souhaite\ncontinuer sur ce chemin,\nà tes risques et périls !");
		} else {
			monde.setMessages(getNom() + " : Tu as "+monde.getLink().getArme().getNom()+ " !\nTu peux aller\ncombattre le grand méchant\nours tueur !"
					+ " À l'attaque !");
		}
		
	}
	
	@Override
	public void agir() {
		
		int tempsAnimation = 100;
		if(!Collisions.collision(this.getBounds(32, 20),monde.getLink().getBounds(32, 18))){
			if (tempsVieux == tempsAnimation*2) {
				tempsVieux = 0;
			} else if (tempsVieux < tempsAnimation && tempsVieux % 5 == 0) {
				setOrientation("droite");
			} else if (tempsVieux > tempsAnimation && tempsVieux % 5 == 0) {
				setOrientation("gauche");
			}
			tempsVieux++;
		} else {
			monde.getGameLoop().gameLoop.stop();
		}
	}
	
	
//	GETTER ET SETTER ORIENTATION
	public StringProperty orientationProperty() {
		return this.orientation;
	}

	public StringProperty getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation.set(orientation);
	}


}
