package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Armes.Epee;
import modele.Objets.Tonneau;
import modele.Personnages.Joueur;

public class Monde {
	
	private ObservableList<Objet> listeObstacles;
	private ObservableList<Arme> listeArme;
	private Tonneau tonneau;
	private Joueur link;
	private Arme epee;
	
	public Monde() {
		this.listeObstacles = FXCollections.observableArrayList();
		this.listeArme = FXCollections.observableArrayList();
		this.link = new Joueur("Link", 100, 1200, 820,0);
		this.tonneau = new Tonneau(1287,770);
		this.epee = new Epee("épée", 20, 80, 1287, 770);
	}
	
//	AJOUTER OBJET
	public void ajouterObjet(Objet obj) {
		this.listeObstacles.add(obj);
	}
	
//	AJOUTER ARME
	public void ajouterArme(Arme arme) {
		this.listeArme.add(arme);
	}
	
	
//	SUPPRIMER OBJET
	public void supprimerObjet(Objet objet) {
		for (Object obj : listeObstacles) {
			if (obj == objet) {
				this.listeObstacles.remove(obj);
			}
		}
	}
//	SUPPRIMER ARME
	public void supprimerArme(Arme arme) {
		for (Arme obj : listeArme) {
			if (obj == arme) {
				this.listeArme.remove(arme);
			}
		}
	}
	
//	GETTER OBJET
	public Joueur getLink() {
		return this.link;
	}
	public Tonneau getTonneau() {
		return this.tonneau;
	}
	public Arme getEpee() {
		return this.epee;
	}
	
//	GETTER LISTE 
	public ObservableList<Objet> getListeObstacles() {
		return this.listeObstacles;
	}
	
	public ObservableList<Arme> getListeArme() {
		return this.listeArme;
	}


}
