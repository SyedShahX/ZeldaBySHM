package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Actifs;
import modele.Collisions;
import modele.Ennemi;

public class Ours extends Ennemi {
	
	private StringProperty orientation;
	public int tempsOurs;
	public int tempsOursAttaque;
	
	public Ours(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom,ptVie, posX, posY,ptAttaque);
		this.orientation = new SimpleStringProperty();
	}
	
	
	public void attaquer(Actifs adversaire) {
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
	
	
	public void agir(Ours ours,double duree,int tempsAnimation,
			int ajoutDistanceX, int ajoutDistanceY,String orientationGauche,
			String orientationDroite,Actifs perso) {
			if(!Collisions.collision(ours.getBounds(32, 20),perso.getBounds(32, 18))) {
				if (tempsOurs == tempsAnimation*2) {
					tempsOurs = 0;
				} else if (tempsOurs > tempsAnimation && tempsOurs % 5 == 0) {
							ours.setPosX(ours.getPosX()+ajoutDistanceX);
							ours.setPosY(ours.getPosY()+ajoutDistanceY);
							ours.setOrientation(orientationGauche);
				} else if (tempsOurs < tempsAnimation && tempsOurs % 5 == 0) {
							ours.setOrientation(orientationDroite);
							ours.setPosX(ours.getPosX()-ajoutDistanceX);
							ours.setPosY(ours.getPosY()+ajoutDistanceY);
				}
				tempsOurs++;
			} else  {
					if(tempsOursAttaque %90==0) {
						ours.attaquer(perso);
					}					
					tempsOursAttaque++;
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
