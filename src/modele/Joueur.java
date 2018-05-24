package modele;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public class Joueur extends Personnage {
	
	private Arme arme;
	public Joueur(String nom, int ptVie, int posX, int posY) {
		super(nom, ptVie, posX, posY);
		this.arme = arme;
	}
	
	public void collision(Rectangle rect) {
		
	}

	public void seDeplacer(KeyCode key) {
		int posY = getPosY();
		int posX = getPosX();
		int ajoutDistance = 8;
		
		if (key.equals(KeyCode.UP)) {
			setPosY( posY - ajoutDistance);
		} else if(key.equals(KeyCode.DOWN)) {
			setPosY( posY + ajoutDistance);
		} else if(key.equals(KeyCode.LEFT)) {
			setPosX( posX - ajoutDistance);
		} else {
			setPosX( posX + ajoutDistance);
		}
	}
	
	@Override
	public void attaquer(Personnage perso) {
		// TODO Auto-generated method stub
		
	}
	
	public void lancer() {
			
	}

	public void parler() {
			
	}
	
	public void pousser() {
		
	}

//	GETTER ET SETTER ARME
	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}


}
