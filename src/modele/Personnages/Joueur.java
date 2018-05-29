package modele.Personnages;

import java.awt.Rectangle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import modele.Arme;
import modele.Collisions;
import modele.Personnage;

public class Joueur extends Personnage {

	private Arme arme;
	private StringProperty orientation;

	public Joueur(String nom, int ptVie, int posX, int posY,int vitesse) {
		super(nom, ptVie, posX, posY,vitesse);
		this.orientation = new SimpleStringProperty();
		this.arme = arme;
	}
	
	public int reglerVitesse() {
		if(Collisions.persoRalenti(getPosX(),getPosY())==true) {
			setVitesse(3);
		} else {
			setVitesse(8);
		}
		return getVitesse();
	}

	public boolean collision(Rectangle rect) {
		if(rect.intersects(this.getBounds())) {
		return true;
	}else
		return false;
	}
	
	public void setPositionFixe(int positionX,int positionY) {
		setPosX(positionX); 
		setPosY(positionY);
	}
	
	public void seDeplacer(KeyCode key) {
		int posY = getPosY();
		int posX = getPosX();
		int ajoutDistance=reglerVitesse();

		if (key.equals(KeyCode.UP)) {
			setOrientation("haut");
			setPosY( posY - ajoutDistance);
		} else if(key.equals(KeyCode.DOWN)) {
			setOrientation("bas");
			setPosY( posY + ajoutDistance);
		} else if(key.equals(KeyCode.LEFT)) {
			setOrientation("gauche");
			setPosX( posX - ajoutDistance);
		} else if (key.equals(KeyCode.RIGHT)){
			setOrientation("droite");
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
//	GETTER PROPERTY ET SETTER DE ORIENTATION
	public StringProperty OrientationProperty() {
		return this.orientation;
	}
	
	public void setOrientation(String orientation) {
		this.orientation.setValue(orientation);
	}
	
	public String getOrientation() {
		return this.orientation.getValue();
	}


}
