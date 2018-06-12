package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Armes.Epee;
import modele.Objets.Tonneau;
import modele.Objets.roche;
import modele.Personnages.Joueur;
import modele.Personnages.Ours;
import modele.Personnages.Vieux;

public class Monde {
	
	private ObservableList<Objet> listeObstacles;
	private ObservableList<Arme> listeArmes;
	private ObservableList<Personnage> listePersonnages;
	private Tonneau tonneau;
	private Arme epee;
	private Joueur link;
	private Ours ours;
	private Vieux vieux;
	private roche roche;
	

	public Monde() {
		this.listeObstacles = FXCollections.observableArrayList();
		this.listeArmes = FXCollections.observableArrayList();
		this.listePersonnages = FXCollections.observableArrayList();
		this.link = new Joueur("Link", 200, 320, 1020,0,null);
		this.tonneau = new Tonneau(1475,964);
		this.epee = new Epee("épée", 30, 100, 1475, 964);
		this.ours = new Ours("Ours tueur",200,1221,415,10);
		this.vieux = new Vieux("vieux", 755, 703);
		this.roche = new roche(724,370); 
		this.getLink().setMonde(this);
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
		getListeArmes().remove(arme);
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
	public Ours getEnnemiOurs() {
		return this.ours;
	}
	public Vieux getVieux() {
		return vieux;
	}
	public roche getRoche() {
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

}
