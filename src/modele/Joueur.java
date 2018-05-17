package modele;

public class Joueur extends Personnage {
	
	private Arme arme;
	
	public Joueur(String nom, int ptVie, int posX, int posY) {
		super(nom, ptVie, posX, posY);
		this.arme = arme;
	}

	@Override
	public void seDeplacer() {
		
		
	}
	
	@Override
	public void attaquer(Personnage perso) {
		// TODO Auto-generated method stub
		
	}
	
	public void lancer() {
			
	}

	public void parler() {
			
	}
	
	public void pousser() {
		
	}

//	GETTER ET SETTER ARME
	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

}
