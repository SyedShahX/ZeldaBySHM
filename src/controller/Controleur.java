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
import modele.Collisions;
import modele.Monde;
import vue.Map1;

public class Controleur implements Initializable {

	@FXML Pane pane;
	@FXML TilePane layout;
	ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");
	Monde monde = new Monde();

	ImageView imgTonneau = new ImageView("assets/images/tonneau.png");

	ImageView imgEpee = new ImageView("assets/images/épée.png");
	Image haut = new Image("assets/images/ImagesLink/haut.png");
	Image gauche = new Image("assets/images/ImagesLink/gauche.png");
	Image basdroit = new Image("assets/images/ImagesLink/basdroit.png");
	Image droite = new Image("assets/images/ImagesLink/droite.png");

	public Controleur() {
		monde.getListeObstacles().add(monde.getTonneau());
		System.out.println(monde.getTonneau());
	}
	
	public void gererTouche(KeyEvent e) {
		int posY = monde.getLink().getPosY();
		int posX = monde.getLink().getPosX();
		
		if (e.getCode() == KeyCode.UP) {
			monde.getLink().seDeplacer(KeyCode.UP);
			
		} else if (e.getCode() == KeyCode.DOWN) {
			monde.getLink().seDeplacer(KeyCode.DOWN);
			
		} else if (e.getCode() == KeyCode.LEFT) {
			monde.getLink().seDeplacer(KeyCode.LEFT);
			
		} else if(e.getCode() == KeyCode.RIGHT){
			monde.getLink().seDeplacer(KeyCode.RIGHT);
		}
		
		collisionObstacleMap(e,posX,posY);
		
		if (monde.getListeObstacles().contains(monde.getTonneau())) {
			collisionObjet(e,posX,posY);
			
		}
	}
	
	public void collisionObstacleMap(KeyEvent e,int positionX,int positionY) {
		if (Collisions.collision(monde.getLink().getPosX(), monde.getLink().getPosY()) == true ) {
			monde.getLink().setPositionFixe(positionX,positionY);
			
		}
			
	} 
	
//	CASSER TONNEAU
	public void casserTonneau(KeyEvent e) {
		if(monde.getLink().collision(monde.getTonneau().getBounds()) == true &&
		   e.getCode() == KeyCode.A) {
				monde.getListeObstacles().remove(monde.getTonneau());
				pane.getChildren().remove(imgTonneau);
				System.out.println(monde.getListeObstacles());
					
		}
	}
	
	public void collisionObjet(KeyEvent e,int positionX,int positionY) {
		if (monde.getLink().collision(monde.getTonneau().getBoundsCollisions()) == true) {
			monde.getLink().setPositionFixe(positionX,positionY);
		}
		
		casserTonneau(e);
			
	} 
		
	

	public void initializeMap() {
		// Affichage de la map
		Map1.map(layout);
		// Affichage de link et du tonneau
		pane.getChildren().addAll(imgTonneau,imgLink);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeMap();
		
		// Bind entre l'image Link et sa position x et y
		imgLink.layoutXProperty().bind(monde.getLink().PosXProperty());
		imgLink.layoutYProperty().bind(monde.getLink().PosYProperty());
		
		// Bind entre l'image Tonneau et sa position x et y
		imgTonneau.layoutXProperty().bind(monde.getTonneau().PosXProperty());
		imgTonneau.layoutYProperty().bind(monde.getTonneau().PosYProperty());
		
		
		// Bind entre l'image Tonneau et sa position x et y
		imgEpee.layoutXProperty().bind(monde.getEpee().PosXProperty());
		imgEpee.layoutYProperty().bind(monde.getEpee().PosYProperty());
		
		// Changement position Link
		monde.getLink().OrientationProperty().addListener(
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




}
