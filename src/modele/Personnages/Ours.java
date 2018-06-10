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
	public void attaquer(Actifs adversaire) {
		int adversairePv = adversaire.getPtVie();
		if (adversairePv > 0) {
			adversairePv -= getPtAttaque();
			adversaire.setPtVie(adversairePv);
			System.out.println(adversairePv);
		} else {
			monde.getListePersonnages().remove(adversaire);
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
