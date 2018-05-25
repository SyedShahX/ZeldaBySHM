package modele;

import java.util.ArrayList;

public class Monde {
	
	private ArrayList<Objet> ListeObstacles;
	private ArrayList<Arme> ListeArme;
	private Tonneau tonneau;
	private Joueur Link;
	
	public Monde() {
		this.ListeObstacles=new ArrayList<Objet>(); 
		this.Link=new Joueur("Link", 100, 1200, 820,0);
		this.tonneau=new Tonneau(1287,770);
	}
	public void ajouterObjet() {
		
	}
	public ArrayList<Objet> getListeObstacles() {
		return ListeObstacles;
	}
	public Joueur getLink() {
		return this.Link;
	}
	public Tonneau getTonneau() {
		// TODO Auto-generated method stub
		return this.tonneau;
	}
	

}
