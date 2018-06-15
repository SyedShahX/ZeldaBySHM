package modele.Personnages;

import java.awt.Rectangle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Agir;
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
		if(monde.getLink().getArme() == monde.getEpee()) {
				monde.setMessages(getNom() + " : Tu as "+monde.getEpee().getNom()+ " !\nTu peux aller\ncombattre le grand méchant\nours tueur !"
					+ " À l'attaque !");
				
		} else {
			monde.setMessages(getNom() + " : Ne continue pas ce\nchemin si tu n'es pas armé !"
					+ " Tu y\ntrouveras un méchant ours tueur ! Il\nte faut une "+monde.getEpee().getNom()+ "."
					+ "Si tu souhaite\ncontinuer sur ce chemin,\nà tes risques et périls !");
		}
		
	}
	
	@Override
	public void agir() {
		
		int tempsAnimation = 100;
		
		if (tempsVieux == tempsAnimation*2) {
			tempsVieux = 0;
		} else if (tempsVieux < tempsAnimation && tempsVieux % 5 == 0) {
			setOrientation("droite");
//			System.out.println("droite");
		} else if (tempsVieux > tempsAnimation && tempsVieux % 5 == 0) {
			setOrientation("gauche");
//			System.out.println("gauche");
		}
		tempsVieux++;
//		System.out.println("temps : "+tempsVieux);
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
