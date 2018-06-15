package modele;

public abstract class Ennemi extends Vivant implements Agir{
	
	protected int ptAttaque;
	
	public Ennemi(String nom, int ptVie, int posX, int posY,int ptAttaque) {
		super(nom, ptVie, posX, posY);
		this.ptAttaque = ptAttaque;
	}
	
	public abstract void attaquer(Vivant perso);
		
	public int getPtAttaque() {
		return this.ptAttaque;
	}
	
}
