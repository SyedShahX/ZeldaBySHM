package modele.Personnages;

import modele.Personnage;

public abstract class Ennemi extends Personnage {
	
	

	public Ennemi(String nom, int ptVie, int posX, int posY,int vit) {
		super(nom, ptVie, posX, posY,vit);
		// TODO Auto-generated constructor stub
	}

	public void seDeplacer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attaquer(Personnage perso) {
		// TODO Auto-generated method stub
		
	}
	
	

}
