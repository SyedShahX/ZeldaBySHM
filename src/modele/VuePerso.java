package modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VuePerso {
	
//	ImageView imgDefaut = new ImageView("assets/images/ImagesLink/joueur.png");
//	ImageView haut = new ImageView("assets/images/ImagesLink/haut.png");
//	ImageView bas = new ImageView("assets/images/ImagesLink/bas.png");
//	ImageView droite = new ImageView("assets/images/ImagesLink/droite.png");
//	ImageView gauche = new ImageView("assets/images/ImagesLink/gauche.png");
	
	ImageView imageView;
	
	public VuePerso(ImageView image) {
		this.imageView = image;
	}
	
	public void setImage(Image img) {
		imageView.setImage(img);
	}

	public ImageView getImageView() {
		return imageView;
	}
}
