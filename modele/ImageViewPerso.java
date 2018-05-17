package modele;

import javafx.scene.image.ImageView;

public class ImageViewPerso {
	
	ImageView imgDefaut = new ImageView("assets/images/ImagesLink/joueur.png");
	ImageView haut = new ImageView("assets/images/ImagesLink/haut.png");
	ImageView bas = new ImageView("assets/images/ImagesLink/bas.png");
	ImageView droite = new ImageView("assets/images/ImagesLink/droite.png");
	ImageView gauche = new ImageView("assets/images/ImagesLink/gauche.png");
	
	public ImageViewPerso(ImageView img) {
		this.imgDefaut = img;
	}
	
	public void setImage(ImageView img) {
		imgDefaut.setImage(img);
	}
}
