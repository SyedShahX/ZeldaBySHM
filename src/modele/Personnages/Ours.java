package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Vivant;
import modele.Collisions;
import modele.Ennemi;

public class Ours extends Ennemi {
	
	private StringProperty orientation;
	private int tempsOurs;
	private int tempsOursAttaque;
	
	public Ours(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom,ptVie, posX, posY,ptAttaque);
		this.orientation = new SimpleStringProperty();
	}
	
	
	public void attaquer(Vivant adversaire) {
		if (monde.getListePersonnages().contains(monde.getEnnemiOurs())) {
			int adversairePv = adversaire.getPtVie();
			if (adversairePv > 0) {
				adversairePv -= getPtAttaque();
				adversaire.setPtVie(adversairePv);
				System.out.println(adversaire.getNom() + " : "+adversairePv);
			} else {
				monde.getListePersonnages().remove(adversaire);
			}
		}
		
	}
	
	@Override
	public void agir() {
		int tempsAnimation = 170;
			if(!Collisions.collision(this.getBounds(32, 20),monde.getLink().getBounds(32, 18))) {
				if (tempsOurs == tempsAnimation*2) {
					tempsOurs = 0;
				} else if (tempsOurs > tempsAnimation && tempsOurs % 5 == 0) {
							setOrientation("gauche");
							setPosX(getPosX() + 4);
				} else if (tempsOurs < tempsAnimation && tempsOurs % 5 == 0) {
							setOrientation("droite");
							setPosX(getPosX() - 4);
				}
				tempsOurs++;
			} else  {
					if(tempsOursAttaque % 90 == 0) {
						this.attaquer(monde.getLink());
					}					
					tempsOursAttaque++;
			}
	}
	
//	GETTER ET SETTER ORIENTATION
	public StringProperty orientationProperty() {
		return this.orientation;
	}

	public StringProperty getOrientation() {
		return this.orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation.set(orientation);
	}



}
