package modele;

import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Objet {
	protected IntegerProperty posX;
	protected IntegerProperty posY;
	protected Monde monde;
	
	public Objet(int positionX, int positionY) {
		super();
		this.posX = new SimpleIntegerProperty(positionX);
		this.posY = new SimpleIntegerProperty(positionY);
	}
	
	public void setMonde(Monde monde) {
		this.monde = monde;
	}
	
	public Rectangle getBounds(int width, int height) {
		return new Rectangle(this.getPosX(),this.getPosY(),width,height);
	}
	// GETTER AND SETTER
	public IntegerProperty PosXProperty() {
		return posX;
	}

	public void setPosX(IntegerProperty posX) {
		this.posX = posX;
	}

	public IntegerProperty PosYProperty() {
		return posY;
	}
	public int getPosX() {
		return this.posX.getValue();
	}
	public int getPosY() {
		return this.posY.getValue();
	}
	public void setPosY(IntegerProperty posY) {
		this.posY = posY;
	}

}
