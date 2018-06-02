package modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Ennemi extends Personnage {
	
	
	protected StringProperty orientation;

	public Ennemi(String nom, int ptVie, int posX, int posY) {
		super(nom, ptVie, posX, posY);
		this.orientation = new SimpleStringProperty();
		
	}

	
	public abstract void attaquer(Personnage perso);
	
//	GETTER ET SETTER ORIENTATION
	public StringProperty OrientationProperty() {
		return this.orientation;
	}

	public StringProperty getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation.set(orientation);
	}
}
