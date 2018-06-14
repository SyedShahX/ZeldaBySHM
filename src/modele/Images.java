package modele;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Images {
	

//	ImageView Objets
	public final ImageView imgTonneau = new ImageView("assets/images/tonneau.png");
	public final ImageView imgRoche = new ImageView("assets/images/roche.png");

//	ImageView Armes	
	public final ImageView imgEpee = new ImageView("assets/images/ImagesArmes/epee.png");
	public final ImageView imgFleche = new ImageView("assets/images/ImagesArmes/flecheBas.png");

//  ImageView liste Armes
	public final ImageView listeImgEpee = new ImageView("assets/images/ImagesListeArmes/listeArmesEpee.png");
	public final ImageView listeImgFleche = new ImageView("assets/images/ImagesArmes/flecheBas.png");

//	Images déplacements Link
	public final ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");
	public final Image haut = new Image("assets/images/ImagesLink/haut.png");
	public final Image gauche = new Image("assets/images/ImagesLink/gauche.png");
	public final Image basdroit = new Image("assets/images/ImagesLink/basdroit.png");
	public final Image droite = new Image("assets/images/ImagesLink/droite.png");
	
//	Images Link Epee
	public final Image droiteEpee = new Image("assets/images/ImagesLink/droiteEpee.png");
	public final Image gaucheEpee = new Image("assets/images/ImagesLink/gaucheEpee.png");
	public final Image basEpee = new Image("assets/images/ImagesLink/basEpee.png");
	public final Image hautEpee = new Image("assets/images/ImagesLink/hautEpee.png");
	
//	Images Déplacements Ours
	public final ImageView imgOurs = new ImageView("assets/images/ImageEnnemis/oursGrisGauche.png");
	public final Image imgOursDroit = new Image("assets/images/ImageEnnemis/oursGrisDroite.png");
	public final Image imgOursHaut = new Image("assets/images/ImageEnnemis/oursGrisHaut.png");
	public final Image imgOursBas = new Image("assets/images/ImageEnnemis/oursGrisBas.png");
	public final Image imgOursGauche = new Image("assets/images/ImageEnnemis/oursGrisGauche.png");
	
//	Images Vieux
	public final ImageView imgVieux = new ImageView("assets/images/ImagesVieux/vieuxGauche.png");
	public final Image imgVieuxDroite = new Image("assets/images/ImagesVieux/vieuxDroite.png");
	public final Image imgVieuxGauche = new Image("assets/images/ImagesVieux/vieuxGauche.png");

//	Image ptDeVie
	
	public static final String LIENPOINTDEVIE = "assets/images/ptDeVie.png";
	public final ImageView ptDeVie1 = new ImageView(LIENPOINTDEVIE);
	public final ImageView ptDeVie2 = new ImageView(LIENPOINTDEVIE);
	public final ImageView ptDeVie3 = new ImageView(LIENPOINTDEVIE);
	public final ImageView ptDeVie4 = new ImageView(LIENPOINTDEVIE);
	public final ImageView ptDeVie5 = new ImageView(LIENPOINTDEVIE);

}
