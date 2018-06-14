package modele;



import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Tonneau {
	
	private IntegerProperty posX;
	private IntegerProperty posY;
	
	public Tonneau(int positionX, int positionY) {
		this.posX = new SimpleIntegerProperty(positionX);
		this.posY = new SimpleIntegerProperty(positionY);
	}

	// GETTER AND SETTER
	public IntegerProperty posXProperty() {
		return posX;
	}
	public Rectangle getBoundsCollisions() {
		return new Rectangle(this.getPosX(),this.getPosY(),15,15);
		
	}
	public Rectangle getBounds() {
		return new Rectangle(this.getPosX(),this.getPosY(),30,30);
		
	}

	public void setPosX(IntegerProperty posX) {
		this.posX = posX;
	}

	public IntegerProperty posYProperty() {
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
