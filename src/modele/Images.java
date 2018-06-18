package modele;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Images {
	

//	ImageView Objets
	public static ImageView imgTonneau = new ImageView("assets/images/ImagesMap/tonneau.png");
	public static ImageView imgRoche = new ImageView("assets/images/ImagesMap/rocherPoussable.png");

//	ImageView Armes	

//  ImageView liste Armes
	public static ImageView listeImgEpee = new ImageView("assets/images/ImagesListeArmes/listeArmesEpee.png");
	public static ImageView listeImgFleche = new ImageView("assets/images/ImagesListeArmes/listeArmesFleche.png");

//	Images déplacements Link
	public static ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");
	public static Image haut = new Image("assets/images/ImagesLink/haut.png");
	public static Image gauche = new Image("assets/images/ImagesLink/gauche.png");
	public static Image basdroit = new Image("assets/images/ImagesLink/basdroit.png");
	public static Image droite = new Image("assets/images/ImagesLink/droite.png");
	
//	Images Link Epee
	public static ImageView imgEpee = new ImageView("assets/images/ImagesArmes/epee.png");
	public static Image droiteEpee = new Image("assets/images/ImagesLink/droiteEpee.png");
	public static Image gaucheEpee = new Image("assets/images/ImagesLink/gaucheEpee.png");
	public static Image basEpee = new Image("assets/images/ImagesLink/basEpee.png");
	public static Image hautEpee = new Image("assets/images/ImagesLink/hautEpee.png");
	
//	Images Link Flèche
	public static ImageView imgFleche = new ImageView("assets/images/ImagesArmes/flecheBas.png");
	public static Image imgFlecheBas = new Image("assets/images/ImagesArmes/flecheBas.png");
	public static Image imgFlecheHaut = new Image("assets/images/ImagesArmes/flecheHaut.png");
	public static Image imgFlecheDroite = new Image("assets/images/ImagesArmes/flecheDroite.png");
	public static Image imgFlecheGauche = new Image("assets/images/ImagesArmes/flecheGauche.png");
//	Images Déplacements Ours
	public static ImageView imgOurs = new ImageView("assets/images/ImageEnnemis/oursGrisGauche.png");
	public static Image imgOursDroit = new Image("assets/images/ImageEnnemis/oursGrisDroite.png");
	public static Image imgOursHaut = new Image("assets/images/ImageEnnemis/oursGrisHaut.png");
	public static Image imgOursBas = new Image("assets/images/ImageEnnemis/oursGrisBas.png");
	public static Image imgOursGauche = new Image("assets/images/ImageEnnemis/oursGrisGauche.png");
	
//	Images Vieux
	public static ImageView imgVieux = new ImageView("assets/images/ImagesVieux/vieuxGauche.png");
	public static Image imgVieuxDroite = new Image("assets/images/ImagesVieux/vieuxDroite.png");
	public static Image imgVieuxGauche = new Image("assets/images/ImagesVieux/vieuxGauche.png");

//	Image ptDeVie
	
	public static final String LIENPOINTDEVIE = "assets/images/ImagesMap/ptDeVie.png";
	public static ImageView ptDeVie1 = new ImageView(LIENPOINTDEVIE);
	public static ImageView ptDeVie2 = new ImageView(LIENPOINTDEVIE);
	public static ImageView ptDeVie3 = new ImageView(LIENPOINTDEVIE);
	public static ImageView ptDeVie4 = new ImageView(LIENPOINTDEVIE);
	public static ImageView ptDeVie5 = new ImageView(LIENPOINTDEVIE);

}
