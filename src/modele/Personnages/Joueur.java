package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.Actifs;
import modele.Arme;
import modele.Collisions;
import modele.Personnage;

public class Joueur extends Actifs {

	private Arme arme;
	private StringProperty orientationEpee;
	protected StringProperty orientation;
	private int vitesse;
	// TODO liste Arme pour le joueur
	

	public Joueur(String nom, int ptVie, int posX, int posY,int vitesse,Arme arme) {
		super(nom, ptVie, posX, posY);
		this.orientation = new SimpleStringProperty();
		this.orientationEpee = new SimpleStringProperty();
		this.arme = arme;
		this.vitesse = vitesse;
		
	}
	
	public int reglerVitesse() {
		if(Collisions.persoRalenti(getPosX(),getPosY())) {
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
		
		case UP:    if(getArme() != null) {
						setOrientationEpee("hautEpee");
					} else {						
						setOrientation("haut");
					}
				    setPosY( posY - ajoutDistance);
			break;
		case DOWN:  if(getArme() != null) {
						setOrientationEpee("basEpee");
					} else {						
						setOrientation("bas");
					}
				    setPosY( posY + ajoutDistance);
			break;
		case LEFT:  if(getArme() != null) {
						setOrientationEpee("gaucheEpee");
					} else {						
						setOrientation("gauche");
					}
				    setPosX( posX - ajoutDistance);
			break;
		case RIGHT: if(getArme() != null) {
						setOrientationEpee("droiteEpee");
					} else {
						setOrientation("droite");
					}
					setPosX( posX + ajoutDistance);
			break;
		default:
			break;
		}
	}

	
	public void attaquer(Personnage adversaire) {
		if(Collisions.collision(monde.getLink().getBounds(40,40),adversaire.getBounds(28,28))) {
				int adversairePv = adversaire.getPtVie();
				if (adversairePv > getArme().getPtAttaque()) {
					adversairePv -= getArme().getPtAttaque();
					adversaire.setPtVie(adversairePv);
					System.out.println(adversairePv);
				} else {
					monde.getListePersonnages().remove(adversaire);
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
			}
		}
	}
	// Récupérer Arme
	public void recupererArme() {
		if (monde.getListeArmes().contains(monde.getEpee())) {
			if (Collisions.collision(monde.getLink().getBounds(28,28), monde.getEpee().getBounds(12,12))) {
				monde.supprimerArme(monde.getEpee());
				monde.getLink().changerArmeJoueur(monde.getEpee());
				setOrientation("gaucheEpee");
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
	
//	GETTER PROPERTY ET SETTER DE ORIENTATIONEPEE
	public StringProperty OrientationEpeeProperty() {
		return this.orientationEpee;
	}
	
	public void setOrientationEpee(String orientation) {
		this.orientationEpee.setValue(orientation);
	}
	
	public String getOrientationEpee() {
		return this.orientationEpee.getValue();
	}
	
//  GETTER ET SETTER VITESSE
	public int getVitesse() {
		return this.vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse=vitesse;
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
