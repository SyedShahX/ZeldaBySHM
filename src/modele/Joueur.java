package modele;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Joueur extends Personnage {

	private Arme arme;
	public Joueur(String nom, int ptVie, int posX, int posY,int vit) {
		super(nom, ptVie, posX, posY,vit);
		this.arme = arme;
	}
	public int reglerVitesse() {
		if(Map1.persoRalenti(getPosX(),getPosY())==true) {
			setVitesse(3);
		}
		else {
			setVitesse(8);
		}
		return getVitesse();
	}

	public void seDeplacer(KeyEvent e) {
		int posX = getPosX();
		int posY = getPosY();
		int ajoutDistance = reglerVitesse();

		if (Map1.collision(posX, posY) == true) {
			System.out.println("collisions");
		}

		fixerToucheY(e,KeyCode.UP,posY,-ajoutDistance,"haut");
		fixerToucheY(e,KeyCode.DOWN,posY,ajoutDistance,"bas");

		fixerToucheX(e,KeyCode.LEFT,posX,-ajoutDistance,"gauche");
		fixerToucheX(e,KeyCode.RIGHT,posX,ajoutDistance,"droite");

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
