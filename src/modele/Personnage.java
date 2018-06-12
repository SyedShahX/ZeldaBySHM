package modele;

import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
	
	protected String nom;
	protected IntegerProperty posX;
	protected IntegerProperty posY;
	protected Monde monde;

	public Personnage(String nom, int posX, int posY) {
		super();
		this.nom = nom;
		this.posX = new SimpleIntegerProperty(posX);
		this.posY = new SimpleIntegerProperty(posY);
		this.monde = null;
		
	}
	
	public void setMonde(Monde monde) {
		this.monde = monde;
	}
	
	public Rectangle getBounds(int width,int height) {
		return new Rectangle(getPosX()-7,getPosY(),width,height);
	}
	
//	GETTER ET SETTER NOM
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
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
		this.posY.set(posY);
	}
}