package modele;


public abstract class Personnage {
	
	protected String nom;
	protected int ptVie;
	protected int posX;
	protected int posY;
	
	public Personnage(String nom, int ptVie, int posX, int posY) {
		super();
		this.nom = nom;
		this.ptVie = ptVie;
		this.posX = posX;
		this.posY = posY;
		
	}

	public abstract void seDeplacer();
	
	public abstract void attaquer(Personnage perso);
	
	
	
//	GETTER ET SETTER NOM
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

//	GETTER ET SETTER POINT DE VIE
	public int getPtVie() {
		return ptVie;
	}
	
	public void setPtVie(int ptVie) {
		this.ptVie = ptVie;
	}
	
//	GETTER ET SETTER POSITION
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}



	
	
}
