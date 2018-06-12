 package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Personnage;

public class Vieux extends Personnage{

	private StringProperty orientation;
	private int tempsVieux;
	
	public Vieux(String nom, int posX, int posY) {
		super(nom, posX, posY);
		this.orientation = new SimpleStringProperty();
	}
	
	public void parler() {
		if(monde.getLink().getArme() == monde.getEpee()) {
				monde.setMessages(getNom() + " : Tu es armé ! Super ! Tu peux aller\ncombattre le grand méchant\nours tueur !"
					+ " À l'attaque !");
		} else {
			monde.setMessages(getNom() + " : Ne continue pas ce chemin si\ntu n'es pas armé !"
					+ " Tu y trouveras un\nméchant ours tueur ! Il te faut une\narme. "
					+ "Si tu souhaite continuer sur ce\nchemin, à tes risques et périls !");
		}
		
	}
	
	public void agir(Vieux vieux,double duree,int tempsAnimation,String orientationDroite,
			String orientationGauche) {
		
		if (tempsVieux == tempsAnimation*2) {
			tempsVieux = 0;
		} else if (tempsVieux < tempsAnimation && tempsVieux % 5 == 0) {
					vieux.setOrientation(orientationDroite);
		} else if (tempsVieux > tempsAnimation && tempsVieux % 5 == 0) {
					vieux.setOrientation(orientationGauche);
		}
		tempsVieux++;
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
