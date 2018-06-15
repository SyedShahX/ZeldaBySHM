package modele;

import modele.Armes.Epee;
import modele.Armes.Fleche;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Objets.Roche;
import modele.Objets.Tonneau;
import modele.Personnages.Link;
import modele.Personnages.Ours;
import modele.Personnages.Vieux;

public class Monde {
	
	private ObservableList<Objet> listeObstacles;
	private ObservableList<Arme> listeArmes;
	private ObservableList<Personnage> listePersonnages;
	Link link = new Link("Link", 100, 320, 1020,20,null);
	Tonneau tonneau = new Tonneau("tonneau",1475,964);
	Arme epee = new Epee("l'épée", 30, 70, 1475, 964);
	Arme fleche = new Fleche("la flèche", 50,0,0);
	Ours ours = new Ours("l'Ours tueur",200,1221,415,10);
	Vieux vieux = new Vieux("Le viellard", 755, 703);
	Roche roche = new Roche("roche",724,370);
	private StringProperty messages;

	public Monde() {
		this.listeObstacles = FXCollections.observableArrayList();
		this.listeArmes = FXCollections.observableArrayList();
		this.listePersonnages = FXCollections.observableArrayList();
		this.messages = new SimpleStringProperty();
		this.getVieux().setMonde(this);
		this.getLink().setMonde(this);
		this.getEnnemiOurs().setMonde(this);
		this.getTonneau().setMonde(this);
		this.getFleche().setMonde(this);
		this.getEpee().setMonde(this);
		this.getRoche().setMonde(this);
		ajouterPersoMap(link,ours,vieux);
		ajouterObjetMap(tonneau,roche);
	}
	
	public void ajouterPersoMap(Personnage... perso) {
		getListePersonnages().addAll(perso);
	}
	public void supprimerPersoMap(Personnage perso) {
		getListePersonnages().remove(perso);
	}
	
	public void ajouterArmeMap(Arme... arme) {
		getListeArmes().addAll(arme);
	}
	public void supprimerArmeMap(Arme arme) {
		getListeArmes().remove(arme);
	}
	
	public void ajouterObjetMap(Objet... obj) {
		getListeObstacles().addAll(obj);
	}	
	public void supprimerObjetMap(Objet obj) {
		getListeObstacles().remove(obj);
	}


//	GETTER ELEMENTS
	public Link getLink() {
		return link;
	}
	public Tonneau getTonneau() {
		return this.tonneau;
	}
	public Arme getEpee() {
		return this.epee;
	}
	public Arme getFleche() {
		return this.fleche;
	}
	public Ours getEnnemiOurs() {
		return this.ours;
	}
	public Vieux getVieux() {
		return this.vieux;
	}
	public Roche getRoche() {
		return this.roche;
	}
	
	public Personnage getP(Personnage p ) {
		Personnage personnage = null;
		for (Personnage perso : getListePersonnages()) {
			if (perso == p) {
				personnage = perso;
			}
		}
		return personnage;
	}
	
//	GETTER LISTES OBSERVABLES
	public ObservableList<Objet> getListeObstacles() {
		return this.listeObstacles;
	}
	
	public ObservableList<Arme> getListeArmes() {
		return this.listeArmes;
	}

	public ObservableList<Personnage> getListePersonnages() {
		return this.listePersonnages;
	}

	public StringProperty messagesProperty() {
		return messages;
	}
	
	public void setMessages(String message) {
		this.messages.set(message);
	}
	
	public String getMessages() {
		return this.messages.get();
	}
}
