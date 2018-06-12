package modele;

public abstract class Ennemi extends Actifs{
	
	protected int ptAttaque;
	
	public Ennemi(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom, ptVie, posX, posY);
		this.ptAttaque = ptAttaque;
	}
	

	public abstract void attaquer(Actifs perso);
	
	public void seDeplacer() {
		
	}
	
	public int getPtAttaque() {
		return ptAttaque;
	}
	
}
