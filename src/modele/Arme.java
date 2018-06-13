package modele;

import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Arme extends ElementsMonde{
	
	protected String nom;
	protected int ptAttaque;
	protected IntegerProperty posX;
	protected IntegerProperty posY;
	
	public Arme(String nom,int ptAttaque,int positionX,int positionY) {
		this.nom=nom;
		this.ptAttaque=ptAttaque;
		this.posX = new SimpleIntegerProperty(positionX);
		this.posY = new SimpleIntegerProperty(positionY);
	}
	
	public Rectangle getBounds(int width, int height) {
		return new Rectangle(getPosX(),getPosY(),width,height);
	}

//	Nom
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

//	PtAttaque
	public int getPtAttaque() {
		return ptAttaque;
	}
	public void setPtAttaque(int ptAttaque) {
		this.ptAttaque = ptAttaque;
	}

	public Object agir() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	positionX
	public IntegerProperty PosXProperty() {
		return this.posX;
	}
	public void setPosX(int posX) {
		this.posX.setValue(posX);
	}
	public int getPosX() {
		return this.posX.getValue();
	}
	
	
//	positionY
	public IntegerProperty PosYProperty() {
		return this.posY;
	}
	public int getPosY() {
		return this.posY.getValue();
	}
	public void setPosY(int posY) {
		this.posY.setValue(posY);
	}

}
