package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.Actifs;
import modele.Arme;
import modele.Collisions;

public class Joueur extends Actifs {

	private Arme arme;
	private StringProperty orientationEpee;
	private StringProperty orientation;
	private StringProperty paroles;
	private int vitesse;
	private ObservableList<Arme> listeArmes;

	public Joueur(String nom, int ptVie, int posX, int posY,int vitesse,Arme arme) {
		super(nom, ptVie, posX, posY);
		this.orientation = new SimpleStringProperty();
		this.orientationEpee = new SimpleStringProperty();
		this.arme = arme;
		this.vitesse = vitesse;
		this.listeArmes = FXCollections.observableArrayList();
		this.paroles = new SimpleStringProperty();
	}
	
	public int reglerVitesse() {
		if(Collisions.collisionBuisson(getPosX(),getPosY())) {
			setVitesse(3);
		} else {
			setVitesse(15);
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
		
		case UP:    ChangerOrientation("hautEpee","haut");
				    setPosY( posY - ajoutDistance);
			break;
		case DOWN: 	ChangerOrientation("basEpee", "bas");
				    setPosY( posY + ajoutDistance);
			break;
		case LEFT:  ChangerOrientation("gaucheEpee", "gauche");
				    setPosX( posX - ajoutDistance);
			break;
		case RIGHT: ChangerOrientation("droiteEpee", "droite");
					setPosX( posX + ajoutDistance);
			break;
		default:
			break;
		}
	}

	
	public void attaquer(Actifs adversaire) {
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
	
	public void parler(KeyEvent e) {
		setParoles("Link : Bonjour Monsieur. Je cherche\nle coffre fort.\n"
				+ " Sauriez-vous où il peut être ?");
		if (e.getCode() == KeyCode.Z) {
			monde.getVieux().parler(e);			
		}
	}

	public void pousser() {

	}
	
//	CHANGER ARME
	public void changerArmeJoueur(Arme arme) {
		setArme(arme);
		
	}
	public void ajouterArme(Arme arme) {
		this.listeArmes.add(arme);
	}
	
	public void supprimerArme(Arme arme) {
		this.listeArmes.remove(arme);
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
	public void recupererArme(Arme arme) {
		if (monde.getListeArmes().contains(arme)) {
			if (Collisions.collision(monde.getLink().getBounds(28,28), arme.getBounds(12,12))) {
				monde.supprimerArme(arme);
				ajouterArme(arme);
				monde.getLink().changerArmeJoueur(arme);
			}
		}
	}
	
//  Changement d'orientation lors d'une prise d'arme
	public void ChangerOrientation(String orientationEpee,String orientation) {
		if(getArme() == monde.getEpee()) {
			setOrientationEpee(orientationEpee);
		} else {						
			setOrientation(orientation);
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
	
	public ObservableList<Arme> getListeArmes() {
		return listeArmes;
	}
	
//	Getter et Setter StringProperty paroles
	public StringProperty parolesProperty() {
		return this.paroles;
	}

	public void setParoles(String paroles) {
		this.paroles.set(paroles);
	}
	
	public String getParoles() {
		return this.paroles.get();
	}



}
