package modele;

import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Arme {
	
	protected String nom;
	protected int ptAttaque;
	protected int pvArme;

	private IntegerProperty posX;
	private IntegerProperty posY;
	
	public Arme(String nom,int ptAttaque,int pvArme,int positionX,int positionY) {
		this.nom=nom;
		this.ptAttaque=ptAttaque;
		this.pvArme=pvArme;
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

//	PvArme
	public int getPvArme() {
		return pvArme;
	}
	public void setPvArme(int pvArme) {
		this.pvArme = pvArme;
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
