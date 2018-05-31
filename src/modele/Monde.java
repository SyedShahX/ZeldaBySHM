package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Armes.Epee;
import modele.Objets.Tonneau;
import modele.Personnages.Joueur;
import modele.Personnages.Ours;

public class Monde {
	
	private ObservableList<Objet> listeObstacles;
	private ObservableList<Arme> listeArmes;
	private ObservableList<Ennemi> listeEnnemis;
	private Tonneau tonneau;
	private Joueur link;
	private Arme epee;
	private Ennemi ours;
	
	public Monde() {
		this.listeObstacles = FXCollections.observableArrayList();
		this.listeArmes = FXCollections.observableArrayList();
		this.listeEnnemis = FXCollections.observableArrayList();
		this.link = new Joueur("Link", 100, 600, 520,0,null);
		this.tonneau = new Tonneau(1287,770);
		this.epee = new Epee("épée", 30, 80, 1287, 770);
		this.ours = new Ours("Ours tueur",200,800,538,0);
	}
	
//	AJOUTER OBJET
	public void ajouterObjet(Objet obj) {
		this.listeObstacles.add(obj);
	}
	
//	AJOUTER ARME
	public void ajouterArme(Arme arme) {
		this.listeArmes.add(arme);
	}
	
	
//	SUPPRIMER OBJET
	public void supprimerObjet(Objet objet) {
		getListeObstacles().remove(objet);
	}
//	SUPPRIMER ARME
	public void supprimerArme(Arme arme) {
		getListeArme().remove(arme);
	}


//	GETTER ELEMENTS
	public Joueur getLink() {
		return this.link;
	}
	public Tonneau getTonneau() {
		return this.tonneau;
	}
	public Arme getEpee() {
		return this.epee;
	}
	public Ennemi getEnnemiOurs() {
		return this.ours;
	}
	
//	GETTER LISTES OBSERVABLES
	public ObservableList<Objet> getListeObstacles() {
		return this.listeObstacles;
	}
	
	public ObservableList<Arme> getListeArme() {
		return this.listeArmes;
	}

	public ObservableList<Ennemi> getListeEnnemis() {
		return this.listeEnnemis;
	}

}
