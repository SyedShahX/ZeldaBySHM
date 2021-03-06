package modele;

import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ElementsMonde {
	
	protected Monde monde;
	protected String nom;
	protected IntegerProperty posX;
	protected IntegerProperty posY;

	public ElementsMonde(String nom, int posX, int posY) {
		super();
		this.nom = nom;
		this.posX = new SimpleIntegerProperty(posX);
		this.posY = new SimpleIntegerProperty(posY);
		this.monde = null;
		
	}
	
	public Rectangle getBounds(int width,int height) {
		return new Rectangle(getPosX()-7,getPosY(),width,height);
	}
	
	public void setPositionFixe(int positionX,int positionY) {
		setPosX(positionX); 
		setPosY(positionY);
	}
	
	public void setMonde(Monde monde) {
		this.monde = monde;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public IntegerProperty posXProperty() {
		return posX;
	}
	
	public int getPosX() {
		return this.posX.getValue();
	}

	public void setPosX(int posX) {
		this.posX.setValue(posX);
	}

	public IntegerProperty posYProperty() {
		return posY;
	}

	public int getPosY() {
		return this.posY.getValue();
	}

	public void setPosY(int posY) {
		this.posY.setValue(posY);
	}
}
