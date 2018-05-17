package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyEvent;

public abstract class Personnage {
	
	protected String nom;
	protected int ptVie;
	protected IntegerProperty posX;
	protected IntegerProperty posY;
	
	public Personnage(String nom, int ptVie, int posX, int posY) {
		super();
		this.nom = nom;
		this.ptVie = ptVie;
		this.posX = new SimpleIntegerProperty(posX);
		this.posY = new SimpleIntegerProperty(posY);
		
	}
	
	public abstract void attaquer(Personnage perso);
	
	
	
//	GETTER ET SETTER NOM
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

//	GETTER ET SETTER POINT DE VIE
	public int getPtVie() {
		return ptVie;
	}
	
	public void setPtVie(int ptVie) {
		this.ptVie = ptVie;
	}

//	GETTER ET SETTER POSITION
	public IntegerProperty PosXProperty() {
		return posX;
	}
	
	public int getPosX() {
		return this.posX.getValue();
	}

	public void setPosX(int posX) {
		this.posX.set(posX);
	}

	public IntegerProperty PosYProperty() {
		return posY;
	}

	public int getPosY() {
		return this.posY.getValue();
	}

	public void setPosY(int posY) {
		this.posY.set(posY);;
	}
	
}
