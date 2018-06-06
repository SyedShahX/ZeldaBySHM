package modele;

public class Actifs extends Personnage {

	protected int ptVie;
	
	public Actifs(String nom,int ptVie, int posX, int posY) {
		super(nom, posX, posY);
		this.ptVie = ptVie;
	}
	
	public int getPtVie() {
		return ptVie;
	}

	public void setPtVie(int ptVie) {
		this.ptVie = ptVie;
	}
}
