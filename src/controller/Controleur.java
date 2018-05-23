package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Joueur;
import modele.Map1;
import modele.VuePerso;

public class Controleur implements Initializable {
	
	@FXML Pane pane;
	@FXML TilePane layout;
	Joueur link = new Joueur("Link", 100, 120, 820);
	ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");
	VuePerso img = new VuePerso(imgLink);

	ImageView imgTonneau = new ImageView("assets/images/tonneau.png");
	// TODO CLASSE TONNEAU Tonneau tonneau = new Tonneau();
	
	ImageView epee = new ImageView("assets/images/épée.png");
	Image haut = new Image("assets/images/ImagesLink/haut.png");
	Image gauche = new Image("assets/images/ImagesLink/gauche.png");
	Image basdroit = new Image("assets/images/ImagesLink/basdroit.png");
	Image droite = new Image("assets/images/ImagesLink/droite.png");
	
	public void gererTouche(KeyEvent e) {
//		Ici on doit gerer les touches puis appeler la classe joueur qui va
//		s'occuper de faire le déplacement et de changer l'image.
		
		int posY = link.getPosY();
		int posX = link.getPosX();
		int ajoutDistance = 8;
		
		if (e.getCode() == KeyCode.UP) {
			imgLink.setImage(haut);
			link.setPosY( posY - ajoutDistance);
			
		} else if (e.getCode() == KeyCode.DOWN) {
			img.setImage(basdroit);
			link.setPosY( posY + ajoutDistance);
			
		} else if (e.getCode() == KeyCode.LEFT) {
			img.setImage(gauche);
			link.setPosX( posX - ajoutDistance);
			
		} else {
			img.setImage(droite);
			link.setPosX( posX + ajoutDistance);
			
		}
		
		if (Map1.collision(link.getPosX(), link.getPosY())) {
			link.setPosX(posX);
			link.setPosY(posY);
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeMap();
		imgLink.layoutXProperty().bind(link.PosXProperty());
		imgLink.layoutYProperty().bind(link.PosYProperty());
		
		// TODO bind tonneau
//		imgLink.layoutXProperty().bind(tonneau.PosXProperty());
//		imgLink.layoutYProperty().bind(tonneau.PosYProperty());
	}
	

	public void initializeMap() {
		// Affichage de la map
		Map1.map(layout);
		// Affichage de link
		imgLink.setLayoutX(120);
		imgLink.setLayoutY(100);
		imgTonneau.setLayoutX(1287);
		imgTonneau.setLayoutY(770);
		pane.getChildren().addAll(imgTonneau,imgLink);
	}
	
	
	
}
