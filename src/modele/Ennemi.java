package modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Ennemi extends Personnage {
	
	protected StringProperty orientation;
	GameLoop gl = new GameLoop();

	public Ennemi(String nom, int ptVie, int posX, int posY,int vit) {
		super(nom, ptVie, posX, posY,vit);
		this.orientation = new SimpleStringProperty();
	}

	@Override
	public void attaquer() {
		// TODO Auto-generated method stub
		
	}

	public void seDeplacer(Ennemi ennemi,double d,int tempsAnimation,int ajoutDistanceX,int ajoutDistanceY) {
		gl.initAnimation(ennemi, d, tempsAnimation, ajoutDistanceX, ajoutDistanceY);
	}
	
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
