package modele;



import java.awt.Rectangle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Tonneau extends Objet {
	
	private IntegerProperty posX;
	private IntegerProperty posY;
	
	public Tonneau(int positionX, int positionY) {
		super(positionX,positionY);
	}

	// GETTER AND SETTER
	public Rectangle getBoundsCollisions() {
		Rectangle recTonneau = new Rectangle(this.getPosX(),this.getPosY(),15,15);
		return recTonneau;
		
	}
	public Rectangle getBounds() {
		Rectangle recTonneau = new Rectangle(this.getPosX(),this.getPosY(),30,30);
		return recTonneau;
		
	}

}
