package modele;

public class Arme {
	protected String nom;
	protected int ptAttaque;
	protected int pvArme;
	
	public Arme(String nom,int ptAttaque,int pvArme) {
		this.nom=nom;
		this.ptAttaque=ptAttaque;
		this.pvArme=pvArme;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPtAttaque() {
		return ptAttaque;
	}

	public void setPtAttaque(int ptAttaque) {
		this.ptAttaque = ptAttaque;
	}

	public int getPvArme() {
		return pvArme;
	}

	public void setPvArme(int pvArme) {
		this.pvArme = pvArme;
	}
	
}
