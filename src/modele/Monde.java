package modele;

import java.util.ArrayList;

public class Monde {
	
	private ArrayList<Objet> listeObstacles;
	private ArrayList<Arme> listeArme;
	private Tonneau tonneau;
	private Joueur link;
	
	public Monde() {
		this.listeObstacles=new ArrayList<Objet>(); 
		this.link = new Joueur("Link", 100, 1200, 820,0);
		this.tonneau = new Tonneau(1287,770);
	}
	
//	AJOUTER OBJET
	public void ajouterObjet(Objet obj) {
		listeObstacles.add(obj);
	}
	
//	AJOUTER ARME
	public void ajouterArme(Arme arme) {
		listeArme.add(arme);
	}
	
//	GETTER OBJET
	public Joueur getLink() {
		return this.link;
	}
	public Tonneau getTonneau() {
		return this.tonneau;
	}
	
//	SUPPRIMER OBJET
	public void SupprimerObjet(Object objet) {
		for (Object obj : listeObstacles) {
			if (obj == objet) {
				listeObstacles.remove(obj);
			}
		}
	}
//	SUPPRIMER ARME
	public void SupprimerArme(Arme arme) {
		for (Arme obj : listeArme) {
			if (obj == arme) {
				listeArme.remove(arme);
			}
		}
	}
	
//	GETTER LISTE 
	public ArrayList<Objet> getListeObstacles() {
		return this.listeObstacles;
	}
	
	public ArrayList<Arme> getListeArme() {
		return listeArme;
	}

}
