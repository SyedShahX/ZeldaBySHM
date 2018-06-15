package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import modele.Arme;
import modele.Collisions;
import modele.Vivant;
import modele.Objets.Roche;

public class Link extends Vivant {

	private Arme arme;
	private StringProperty orientationEpee;
	private StringProperty orientation;
	private int vitesse;
	private ObservableList<Arme> listeArmes;
	private static int discussion = 0;

	public Link(String nom, int ptVie, int posX, int posY,int vitesse,Arme arme) {
		super(nom, ptVie, posX, posY);
		this.orientation = new SimpleStringProperty();
		this.orientationEpee = new SimpleStringProperty();
		this.arme = arme;
		this.vitesse = vitesse;
		this.listeArmes = FXCollections.observableArrayList();
	}
	
	/**
	 * Diminue la vitesse lorsque Link traverse les buissons.
	 * @return int
	 */
	public int reglerVitesse() {
		if(Collisions.collisionBuisson(getPosX(),getPosY())) {
			setVitesse(3);
		} else {
			setVitesse(10);
		}
		return getVitesse();
	}
	/**
	 * Fixe la position de Link lors d'une collision avec un element
	 * de la map.Link reste à l'endroit où il se situe.
	 * @param positionX
	 * @param positionY
	 */
	public void setPositionFixe(int positionX,int positionY) {
		setPosX(positionX); 
		setPosY(positionY);
	}
	
	/**
	 * Déplacement de Link vers le haut, le bas , la gauche et la droite 
	 * à une certaine vitesse. 
	 * @param up
	 */
	public void seDeplacer(KeyCode up) {
		int posY = getPosY();
		int posX = getPosX();
		int ajoutDistance = reglerVitesse();
		
		switch(up) {
		
		case UP:    changerOrientation("hautEpee","haut");
				    setPosY( posY - ajoutDistance);
			break;
		case DOWN: 	changerOrientation("basEpee", "bas");
				    setPosY( posY + ajoutDistance);
			break;
		case LEFT:  changerOrientation("gaucheEpee", "gauche");
				    setPosX( posX - ajoutDistance);
			break;
		case RIGHT: changerOrientation("droiteEpee", "droite");
					setPosX( posX + ajoutDistance);
			break;	
		default:
			break;
		}
	}

	/**
	 *  Le joueur attaque en appuyant sur la touche ESPACE.
	 *  Il retire des points de vie à son adversaire s'il est armé 
	 *  et s'il l'attaque.
	 *  Si Link n'a pas d'arme, il ne peut attaquer et
	 *  un message lui en informera.
	 *  Si l'adversaire n'a plus de point de vie, il est retiré de la map
	 *  et un message indiquera la mort de ce dernier.
	 *
	 * @param e
	 * @param adversaire
	 */
	public void attaquer(Vivant adversaire) {
			if(getArme() == null) {
				monde.setMessages("Vous ne pouvez attaquer sans armes...");
			} else {
				monde.setMessages("A l'attaque !");
				if(Collisions.collision(getBounds(40,40),adversaire.getBounds(32,30))
						&& monde.getListePersonnages().contains(adversaire)) {
					int adversairePv = adversaire.getPtVie();
					if (adversairePv >= getArme().getPtAttaque()) {
						adversairePv -= getArme().getPtAttaque();
						adversaire.setPtVie(adversairePv);
						System.out.println(adversaire.getNom() + " : "+adversairePv);
					} else {
						if (adversaire == monde.getEnnemiOurs()) {
							monde.supprimerPersoMap(adversaire);
							monde.getFleche().setPosX(monde.getEnnemiOurs().getPosX());
							monde.getFleche().setPosY(monde.getEnnemiOurs().getPosY());
							monde.setMessages(adversaire.getNom() + " est mort.\n"
									+ "Vous avez gagné la flèche.");
							monde.getListeArmes().add(monde.getFleche());
						} else {
							monde.supprimerPersoMap(adversaire);
							monde.setMessages(adversaire.getNom() + " est mort.");
						}
					}
				}
			}	
	}
	
	/**
	 * Link demande au viellard le chemin vers le trésor qui lui répond.
	 * Si Link revient vers lui, seul le viellard lui parlera. 
	 * @param e 
	 */
	public void parler() {
		if (discussion == 0) {
			monde.setMessages(getNom()+" : Bonjour Monsieur. Je cherche\nle coffre fort.\n"
					+ " Sauriez-vous où il peut être ?");
		} 
		discussion++;
		
	}

	public void pousserRoche(KeyCode key,Roche roche) {
		int posX=roche.getPosX();
		int posY=roche.getPosY();
		final int DISTANCE = 2;
		
		if(Collisions.collision(monde.getLink().getBounds(20, 28), monde.getRoche().zoneDetection())) {
			switch(key) {
			case UP: roche.setPosY(posY - DISTANCE);
			break;
			case DOWN: roche.setPosY(posY + DISTANCE);
			break;
			case LEFT: roche.setPosX(posX - DISTANCE);
			break;
			case RIGHT: roche.setPosX(posX + DISTANCE);
			break;
			default:
				break;
			}
		}

}
	
	public void lancer() {
		System.out.println("ok");
	}
	
	/**
	 * Changement d'arme lors de la saisie de la touche Q
	 *  
	 * @param e
	 * @param arme
	 */
	public void changerArmeJoueur() {
		monde.setMessages("Changement d'arme.");
		if (!getListeArmes().isEmpty()) {
			for (Arme armeItem : listeArmes) {
				if (!armeItem.equals(getArme())) {
					setArme(armeItem);
					break;
				}
			}
		} else {
			monde.setMessages("La liste d'armes est vide.");
		}
		
	}
	
	/**
	 * Ajout d'une arme dans la liste d'armes du Link.
	 * 
	 * @param arme
	 */
	public void ajouterArme(Arme arme) {
		this.listeArmes.add(arme);
	}
	
	/**
	 * Suppression d'une arme dans la liste d'armes du Link.
	 * 
	 * @param arme
	 */
	public void supprimerArme(Arme arme) {
		this.listeArmes.remove(arme);
	}
	
	/**
	 * Suppression du tonneau lors de la saisie de la touche A.
	 * 
	 * @param e
	 * @param arme
	 */
	public void casserTonneau(Arme arme) {
		if(Collisions.collision(getBounds(28,28),monde.getTonneau().getBounds(30,30))
				&& monde.getListeObstacles().contains(monde.getTonneau())) {
			// On supprime le tonneau visible sur la map
			monde.supprimerObjetMap(monde.getTonneau());
			// On affiche l'arme sur la map
			monde.ajouterArmeMap(arme);
			monde.setMessages("Appuyez sur B pour prendre "+ arme.getNom());
		}
		
	}
	
	/**
	 * Récupère une arme et l'ajoute dans la liste d'arme de Link.
	 * 
	 * @param e
	 * @param arme
	 */
	public void recupererArme(Arme arme) {
		if (monde.getListeArmes().contains(arme) &&
			Collisions.collision(getBounds(28, 28), arme.getBounds(30, 30))) {
				// On supprime l'arme visible sur la map
				monde.supprimerArmeMap(arme);
				// On ajoute l'arme dans la liste d'armes de Link
				ajouterArme(arme);
				// On remplace l'ancienne arme de Link par la nouvelle
				setArme(arme);
				// On affiche le message de confirmation 
				monde.setMessages(arme.getNom() + " est récupérée !\n"
						+ "Appuyez sur la touche ESPACE pour\nattaquer.");
			}
	}
	
	/**
	 * Changement d'orientation de Link lors d'une prise d'arme.
	 * 
	 * @param orientationEpee
	 * @param orientation
	 */
	public void changerOrientation(String orientationEpee,String orientation) {
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
	public StringProperty orientationEpeeProperty() {
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
	public StringProperty orientationProperty() {
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

}
