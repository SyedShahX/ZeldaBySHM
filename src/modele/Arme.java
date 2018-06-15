package modele;

public class Arme extends ElementsMonde{
	
	protected int ptAttaque;

	public Arme(String nom,int ptAttaque,int positionX,int positionY) {
		super(nom,positionX,positionY);
		this.ptAttaque = ptAttaque;
	}
	
	public int getPtAttaque() {
		return ptAttaque;
	}

}
