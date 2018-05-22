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
import modele.Position;

public class Controleur implements Initializable {
	
	@FXML Pane pane;
	@FXML TilePane layout;
	Position positionLink=new Position(120,820);
	Joueur link = new Joueur("Link", 100, positionLink,0);
	ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");
	
	
	public void seDeplacer(KeyEvent e) {
		link.seDeplacer(e);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeMap();
		imgLink.layoutXProperty().bind(link.getPosition().getPosXProperty());
		imgLink.layoutYProperty().bind(link.getPosition().getPosYProperty());
		
		
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
