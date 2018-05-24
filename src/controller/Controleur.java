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
import modele.Tonneau;

public class Controleur implements Initializable {
	
	@FXML Pane pane;
	@FXML TilePane layout;
	Joueur link = new Joueur("Link", 100, 120, 820);
	ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");

	ImageView imgTonneau = new ImageView("assets/images/tonneau.png");
	Tonneau tonneau = new Tonneau(1287,770);
	
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
		
		if (e.getCode() == KeyCode.UP) {
			imgLink.setImage(haut); // ne pas dupliquer (créer un listener)
			link.seDeplacer(KeyCode.UP);
			// appeler seDéplacer(KeyCode) de la classe Link 
			
		} else if (e.getCode() == KeyCode.DOWN) {
			imgLink.setImage(basdroit);
			link.seDeplacer(KeyCode.DOWN);
			
		} else if (e.getCode() == KeyCode.LEFT) {
			imgLink.setImage(gauche);
			link.seDeplacer(KeyCode.LEFT);
			
		} else {
			imgLink.setImage(droite);
			link.seDeplacer(KeyCode.RIGHT);
			
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
		imgTonneau.layoutXProperty().bind(tonneau.PosXProperty());
		imgTonneau.layoutYProperty().bind(tonneau.PosYProperty());
	}
	

	public void initializeMap() {
		// Affichage de la map
		Map1.map(layout);
		// Affichage de link et du tonneau
		pane.getChildren().addAll(imgTonneau,imgLink);
	}
	
	
	
}
