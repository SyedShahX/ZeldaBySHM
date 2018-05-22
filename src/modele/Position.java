package modele;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Position {
	private IntegerProperty posX;
	private IntegerProperty posY;
	
	public Position(int posX,int posY) {
		this.posX = new SimpleIntegerProperty(posX);
		this.posY = new SimpleIntegerProperty(posY);
	}

	public IntegerProperty getPosXProperty() {
		return this.posX;
	}
	public int getPosX() {
		return this.posX.getValue();
	}

	public void setPosX(int posX) {
		this.posX.set(posX);
	}

	public IntegerProperty getPosYProperty() {
		return posY;
	}
	public int getPosY() {
		return posY.getValue();
	}

	public void setPosY(int posY) {
		this.posY.set(posY);
	}
	
}
