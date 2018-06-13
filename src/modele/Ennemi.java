package modele;

import modele.Agissement;

public abstract class Ennemi extends Vivant implements Agissement{
	
	protected int ptAttaque;
	
	public Ennemi(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom, ptVie, posX, posY);
		this.ptAttaque = ptAttaque;
	}
	
	@Override
	public abstract void agir();
	
	public abstract void attaquer(Vivant perso);
		
	public int getPtAttaque() {
		return this.ptAttaque;
	}
	
}
