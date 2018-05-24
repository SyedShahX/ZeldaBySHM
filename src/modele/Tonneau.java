package modele;

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
	public IntegerProperty PosXProperty() {
		return posX;
	}

	public void setPosX(IntegerProperty posX) {
		this.posX = posX;
	}

	public IntegerProperty PosYProperty() {
		return posY;
	}

	public void setPosY(IntegerProperty posY) {
		this.posY = posY;
	}

}
