package modele;

import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Objet {
	protected IntegerProperty posX;
	protected IntegerProperty posY;
	
	public Objet(int positionX, int positionY) {
		super();
		this.posX = new SimpleIntegerProperty(positionX);
		this.posY = new SimpleIntegerProperty(positionY);
	}

	public Rectangle getBoundsCollisions() {
		return new Rectangle(this.getPosX(),this.getPosY(),30,30);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.getPosX(),this.getPosY(),15,15);
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
