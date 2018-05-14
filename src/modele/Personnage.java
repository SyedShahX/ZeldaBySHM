package modele;

import javafx.scene.image.ImageView;

public class Personnage {
	
	private ImageView img;
	private String nom;
	private int ptVie;
	private int posX;
	private int posY;
//	private Arme arme;
	
	public Personnage(String nom, int ptVie, int posX, int posY) {
		super();
		this.nom = nom;
		this.ptVie = ptVie;
		this.posX = posX;
		this.posY = posY;
		
	}

	public void seDeplacer() {
		
	}
	
	public void lancer() {
		
	}
	
	public void pousser() {
		
	}
	
	public void seBattre() {
		
	}
	
	public void parler() {
		
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public int getPtVie() {
		return ptVie;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}

	public void setPtVie(int ptVie) {
		this.ptVie = ptVie;
	}


	
	
}
