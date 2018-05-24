package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
		int posY = link.getPosY();
		int posX = link.getPosX();
		
		if (e.getCode() == KeyCode.UP) {
			link.seDeplacer(KeyCode.UP);
			
		} else if (e.getCode() == KeyCode.DOWN) {
			link.seDeplacer(KeyCode.DOWN);
			
		} else if (e.getCode() == KeyCode.LEFT) {
			link.seDeplacer(KeyCode.LEFT);
			
		} else if(e.getCode() == KeyCode.RIGHT){
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
		
		// Bind entre l'image Link et sa position x et y
		imgLink.layoutXProperty().bind(link.PosXProperty());
		imgLink.layoutYProperty().bind(link.PosYProperty());
		
		// Bind entre l'image Tonneau et sa position x et y
		imgTonneau.layoutXProperty().bind(tonneau.PosXProperty());
		imgTonneau.layoutYProperty().bind(tonneau.PosYProperty());
		
		link.OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageLink(nouvelleValeur);
				}
		);
		
		
	}
	

	private void changerImageLink(String nouveau) {
		if (nouveau == "haut") {
			imgLink.setImage(haut);
		} else if (nouveau == "bas") {
			imgLink.setImage(basdroit);
		} else if (nouveau == "gauche") {
			imgLink.setImage(gauche);
		} else if (nouveau == "droite") {
			imgLink.setImage(droite);
		}
	}


	public void initializeMap() {
		// Affichage de la map
		Map1.map(layout);
		// Affichage de link et du tonneau
		pane.getChildren().addAll(imgTonneau,imgLink);
	}
	
	
	
}
