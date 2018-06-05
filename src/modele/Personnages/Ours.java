package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Ennemi;

public class Ours extends Ennemi {
	
	private StringProperty orientation;
	
	public Ours(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom,ptVie, posX, posY,ptAttaque);
		this.orientation = new SimpleStringProperty();
	}
	
	@Override
	public void attaquer() {
//			int adversairePv = monde.getLink().getPtVie();
//			if (adversairePv > getPtAttaque()) {
//				adversairePv -= getPtAttaque();
//				monde.getLink().setPtVie(adversairePv);
//				System.out.println(adversairePv);
//			} else {
//				System.out.println("mort");
//			}
		System.out.println("touché par méchant");
		
	}
	
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
