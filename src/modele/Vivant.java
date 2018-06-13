package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Vivant extends Personnage {

	protected IntegerProperty ptVie;
	
	public Vivant(String nom,int ptVie, int posX, int posY) {
		super(nom, posX, posY);
		this.ptVie = new SimpleIntegerProperty(ptVie);
	}
	
	public int getPtVie() {
		return this.ptVie.getValue();
	}

	public void setPtVie(int ptVie) {
		this.ptVie.set(ptVie);
	}
	
	public IntegerProperty ptDeVieProperty() {
		return this.ptVie;
	}
}
