package modele;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Joueur extends Personnage {
	
	private Arme arme;
	public Joueur(String nom, int ptVie, int posX, int posY) {
		super(nom, ptVie, posX, posY);
		this.arme = arme;
	}

	public void seDeplacer(KeyEvent e) {
		int posX = getPosX();
		int posY = getPosY();
		int ajoutDistance = 8;
		
		fixerToucheY(e,KeyCode.UP,posY,-ajoutDistance,"haut");
		fixerToucheY(e,KeyCode.DOWN,posY,ajoutDistance,"bas");
		
		fixerToucheX(e,KeyCode.LEFT,posX,-ajoutDistance,"gauche");
		fixerToucheX(e,KeyCode.RIGHT,posX,ajoutDistance,"droite");
		
		if (Map1.collision(getPosX(), getPosY()) == true) {
			setPosX(posX);
			setPosY(posY);
		}	

	
	}
	
	public void fixerToucheX(KeyEvent e,KeyCode touche,int positionActuelle,
							int nouvellePosition,String nomPerso) {			
		if (e.getCode() == touche) {
			setPosX(positionActuelle + nouvellePosition);
		} 
		
	}
	
	public void fixerToucheY(KeyEvent e,KeyCode touche,int positionActuelle,
							int nouvellePosition,String nomPerso) {			
		if (e.getCode() == touche) {
			setPosY(positionActuelle + nouvellePosition);
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
