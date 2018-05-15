package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Joueur;
import modele.Map1;

public class Controleur implements Initializable {
	
	@FXML Pane pane;
	@FXML TilePane layout;
	Joueur link = new Joueur("Link", 100, 120, 820);
	ImageView imgLink = new ImageView("assets/images/joueur.png");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeMap();
		imgLink.accessibleTextProperty().bind(link.PosXProperty().asString());
		imgLink.accessibleTextProperty().bind(link.PosYProperty().asString());
		
	}

	public void initializeMap() {
		// Affichage de la map
		Map1.map(layout);
		// Affichage de link
		imgLink.setLayoutX(120);
		imgLink.setLayoutY(820);
		pane.getChildren().add(imgLink);
		
	}
	
	
	
}
