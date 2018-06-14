package modele;

import modele.Armes.Epee;
import modele.Armes.Fleche;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Objets.Roche;
import modele.Objets.Tonneau;
import modele.Personnages.Joueur;
import modele.Personnages.Ours;
import modele.Personnages.Vieux;

public class Monde {
	
	private ObservableList<Objet> listeObstacles;
	private ObservableList<Arme> listeArmes;
	private ObservableList<Personnage> listePersonnages;
	Joueur link = new Joueur("Link", 100, 320, 1020,20,null);
	Tonneau tonneau = new Tonneau("tonneau",1475,964);
	Arme epee = new Epee("l'épée", 30, 70, 1475, 964);
	Arme fleche = new Fleche("la flèche", 50,0,0);
	Ours ours = new Ours("l'Ours tueur",200,1221,415,10);
	Vieux vieux = new Vieux("Le viellard", 755, 703);
	Roche roche = new Roche("roche",724,370);
	private StringProperty messages;

	public Monde() {
		System.out.println("monde");
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
		getListePersonnages().addAll(ours,vieux,link);
		getListeObstacles().addAll(tonneau,roche);
		getListeArmes().addAll(epee,fleche);
	}
	
//	AJOUTER OBJET
	public void ajouterObjetMap(Objet obj) {
		this.listeObstacles.add(obj);
	}
	
//	AJOUTER ARME
	public void ajouterArmeMap(Arme arme) {
		this.listeArmes.add(arme);
	}
	
	
//	SUPPRIMER OBJET
	public void supprimerObjetMap(Objet objet) {
		getListeObstacles().remove(objet);
	}
//	SUPPRIMER ARME
	public void supprimerArmeMap(Arme arme) {
		getListeArmes().remove(arme);
	}


//	GETTER ELEMENTS
	public Joueur getLink() {
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
