package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.Arme;
import modele.Collisions;
import modele.Monde;
import modele.Personnage;

public class Joueur extends Personnage {

	private Arme arme;
	private StringProperty orientation;
	

	public Joueur(String nom, int ptVie, int posX, int posY,int vitesse,Arme arme) {
		super(nom, ptVie, posX, posY,vitesse);
		this.orientation = new SimpleStringProperty();
		this.arme = arme;
		
	}
	
	public int reglerVitesse() {
		if(Collisions.persoRalenti(getPosX(),getPosY()) == true) {
			setVitesse(3);
		} else {
			setVitesse(8);
		}
		return getVitesse();
	}
	
	public void setPositionFixe(int positionX,int positionY) {
		setPosX(positionX); 
		setPosY(positionY);
	}
	
	public void seDeplacer(KeyCode key) {
		int posY = getPosY();
		int posX = getPosX();
		int ajoutDistance = reglerVitesse();
		
		switch(key) {
		
		case UP:    setOrientation("haut");
				    setPosY( posY - ajoutDistance);
			break;
		case DOWN:  setOrientation("bas");
				    setPosY( posY + ajoutDistance);
			break;
		case LEFT:  setOrientation("gauche");
				    setPosX( posX - ajoutDistance);
			break;
		case RIGHT: setOrientation("droite");
					setPosX( posX + ajoutDistance);
			break;
		default:
			break;
		}
	}

	@Override
	public void attaquer(Personnage adversaire) {
		if(Collisions.collision(monde.getLink().getBounds(28,28),adversaire.getBounds(28,28))) {
				int adversairePv = adversaire.getPtVie();
				if (adversairePv > getArme().getPtAttaque()) {
					adversairePv -= getArme().getPtAttaque();
					adversaire.setPtVie(adversairePv);
					System.out.println(adversairePv);			
				} else {
					System.out.println("mort");
				}
		}
		
	}
	
	public void parler() {

	}

	public void pousser() {

	}
	
//	CHANGER ARME
	public void changerArmeJoueur(Arme arme) {
		setArme(arme);
		
	}
	
	public void casserTonneau(KeyEvent e) {
		if(Collisions.collision(monde.getLink().getBounds(28,28),monde.getTonneau().getBounds(30,30))) {
			if(e.getCode() == KeyCode.A) {
				monde.supprimerObjet(monde.getTonneau());
				monde.ajouterArme(monde.getEpee());
				System.out.println(monde.getListeObstacles());
			}
		}
	}
	// Récupérer Arme
	public void recupererArme() {
		if (monde.getListeArme().contains(monde.getEpee())) {
			if (Collisions.collision(monde.getLink().getBounds(28,28), monde.getEpee().getBounds(12,12))) {
				monde.supprimerArme(monde.getEpee());
				monde.getLink().changerArmeJoueur(monde.getEpee());
			}
		}
	}

	//	GETTER ET SETTER ARME
	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}
//	GETTER PROPERTY ET SETTER DE ORIENTATION
	public StringProperty OrientationProperty() {
		return this.orientation;
	}
	
	public void setOrientation(String orientation) {
		this.orientation.setValue(orientation);
	}
	
	public String getOrientation() {
		return this.orientation.getValue();
	}


}
