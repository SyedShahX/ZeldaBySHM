package modele;

import java.awt.Rectangle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;

public class Joueur extends Personnage {

	private Arme arme;
	private StringProperty orientation;

	public Joueur(String nom, int ptVie, int posX, int posY,int vit) {
		super(nom, ptVie, posX, posY,vit);
		this.orientation = new SimpleStringProperty();
		this.arme = arme;
	}
	
	public int reglerVitesse() {
		if(Collisions.persoRalenti(getPosX(),getPosY())==true) {
			setVitesse(3);
		}
		else {
			setVitesse(8);
		}
		return getVitesse();
	}

	public boolean collision(Rectangle rect) {
		if(rect.intersects(this.getBounds())) {
			//System.out.println("tonneau");
		return true;
	}else
		return false;
	}

	public void seDeplacer(KeyCode key) {
		int posY = getPosY();
		int posX = getPosX();
		int ajoutDistance=reglerVitesse();

		if (key.equals(KeyCode.UP)) {
			setOrientation("haut");
			System.out.println("haut");
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
