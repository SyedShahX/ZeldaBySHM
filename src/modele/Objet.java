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
		Rectangle recTonneau = new Rectangle(this.getPosX(),this.getPosY(),15,15);
		return recTonneau;
		
	}
	
	public Rectangle getBounds() {
		Rectangle recTonneau = new Rectangle(this.getPosX(),this.getPosY(),30,30);
		return recTonneau;
		
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
