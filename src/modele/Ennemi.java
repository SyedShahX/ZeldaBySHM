package modele;

import modele.Agissement;

public abstract class Ennemi extends Actifs implements Agissement{
	
	protected int ptAttaque;
	
	public Ennemi(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom, ptVie, posX, posY);
		this.ptAttaque = ptAttaque;
	}
	
	@Override
	public abstract void agir();
	

	public abstract void attaquer(Actifs perso);
	
	// Mettre méthode agir. Problème : le vieux aussi agit...
	
	public int getPtAttaque() {
		return ptAttaque;
	}
	
}
