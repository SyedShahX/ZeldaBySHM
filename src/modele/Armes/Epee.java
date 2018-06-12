package modele.Armes;

import modele.Arme;

public class Epee extends Arme{
	
	protected int pvArme;
	
	public Epee(String nom, int ptAttaque, int pvArme, int positionX, int positionY) {
		super(nom, ptAttaque, positionX, positionY);
		this.pvArme=pvArme;
	}
	

//	Getter et Setter pvArme
	public int getPvArme() {
		return pvArme;
	}
	public void setPvArme(int pvArme) {
		this.pvArme = pvArme;
	}
	

}
