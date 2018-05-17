package modele;



import java.awt.Rectangle;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Joueur extends Personnage {

	private Arme arme;

	public Joueur(String nom, int ptVie, int posX, int posY) {
		super(nom, ptVie, posX, posY);
		this.arme = arme;
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
	public void seDeplacer(KeyEvent e) {
		int posX = getPosX();
		int posY = getPosY();

		//      if (e.getCode() == KeyCode.UP) {
		//              setPosY(posY - 5);
		//      } else if(e.getCode() == KeyCode.DOWN) {
		//              setPosY(posY + 5);
		//      } else if (e.getCode() == KeyCode.LEFT) {
		//              setPosX(posX - 5);
		//      } else if (e.getCode() == KeyCode.RIGHT) {
		//              setPosX(posX + 5);
		//             
		//      }
		Map1.collisions(posX, posY);
		fixerToucheY(e,KeyCode.UP,posY,-8);
		fixerToucheY(e,KeyCode.DOWN,posY,8);

		fixerToucheX(e,KeyCode.LEFT,posX,-8);
		fixerToucheX(e,KeyCode.RIGHT,posX,8);
	}

	public void fixerToucheX(KeyEvent e,KeyCode touche,int positionActuelle,int nouvellePosition) {                 
		if (e.getCode() == touche) {
			setPosX(positionActuelle + nouvellePosition);
		}

	}

	public void fixerToucheY(KeyEvent e,KeyCode touche,int positionActuelle,int nouvellePosition) {                 
		if (e.getCode() == touche) {
			setPosY(positionActuelle + nouvellePosition);
		}
	}

}


