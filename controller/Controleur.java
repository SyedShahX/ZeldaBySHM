package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.ImageViewPerso;
import modele.Joueur;
import modele.Map1;

public class Controleur implements Initializable {
	
	@FXML Pane pane;
	@FXML TilePane layout;
	Joueur link = new Joueur("Link", 100, 120, 820);
	ImageViewPerso imgLink = new ImageViewPerso("assets/images/ImagesLink/joueur.png");
	
	
	public void seDeplacer(KeyEvent e) {
		link.seDeplacer(e);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeMap();
		imgLink.layoutXProperty().bind(link.PosXProperty());
		imgLink.layoutYProperty().bind(link.PosYProperty());
		
		
	}
	

	public void initializeMap() {
		// Affichage de la map
		Map1.map(layout);
		// Affichage de link
		imgLink.setLayoutX(120);
		imgLink.setLayoutY(100);
		pane.getChildren().add(imgLink);
	}
	
	
	
}
