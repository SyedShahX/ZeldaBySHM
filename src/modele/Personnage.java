package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyEvent;

public abstract class Personnage {
	
	protected String nom;
	protected int ptVie;
	//protected IntegerProperty posX;
	//protected IntegerProperty posY;
	protected int vitesse;
	protected Position position;
	
	public Personnage(String nom, int ptVie,Position position,int vit) {
		super();
		this.nom = nom;
		this.ptVie = ptVie;
		this.position=position;
		this.vitesse=vit;
		
	}
	
	public abstract void attaquer(Personnage perso);
	
	
	
//	GETTER ET SETTER NOM
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getVitesse() {
		return this.vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse=vitesse;
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
	/*public IntegerProperty PosXProperty() {
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
	}*/
	public Position getPosition() {
		return this.position;
	}
	public void setPosition(int posX,int posY) {
		this.position.setPosX(posX);
		this.position.setPosY(posY);
	}
	
}
