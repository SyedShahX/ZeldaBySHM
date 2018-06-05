package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Actifs;
import modele.Ennemi;

public class Ours extends Ennemi {
	
	private StringProperty orientation;
	
	public Ours(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom,ptVie, posX, posY,ptAttaque);
		this.orientation = new SimpleStringProperty();
	}
	
	@Override
	public void attaquer(Actifs perso) {
			int adversairePv = perso.getPtVie();
			if (adversairePv > getPtAttaque()) {
				adversairePv -= getPtAttaque();
				perso.setPtVie(adversairePv);
				System.out.println(adversairePv);
			} else {
				System.out.println("mort");
			}
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
