package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Armes.Epee;
import modele.Objets.Tonneau;
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
	private Ennemi ours;
	private Vieux vieux;
	

	public Monde() {
		this.listeObstacles = FXCollections.observableArrayList();
		this.listeArmes = FXCollections.observableArrayList();
		this.listePersonnages = FXCollections.observableArrayList();
		this.link = new Joueur("Link", 100, 130, 828,0,null);
		this.tonneau = new Tonneau(1287,770);
		this.epee = new Epee("épée", 30, 80, 1287, 770);
		this.ours = new Ours("Ours tueur",200,800,538);
		this.vieux = new Vieux("vieux", 0, 870, 220);
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
	public Ennemi getEnnemiOurs() {
		return this.ours;
	}
	public Vieux getVieux() {
		return vieux;
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
