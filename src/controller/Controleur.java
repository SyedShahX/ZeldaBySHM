package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Arme;
import modele.Collisions;
import modele.Monde;
import modele.Objet;
import vue.Map1;

public class Controleur implements Initializable {

	@FXML Pane pane;
	@FXML Pane paneArmes;
	@FXML TilePane layout;
	ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");
	Monde monde = new Monde();

	ImageView imgTonneau = new ImageView("assets/images/tonneau.png");

	ImageView imgEpee = new ImageView("assets/images/épée.png");
	Image haut = new Image("assets/images/ImagesLink/haut.png");
	Image gauche = new Image("assets/images/ImagesLink/gauche.png");
	Image basdroit = new Image("assets/images/ImagesLink/basdroit.png");
	Image droite = new Image("assets/images/ImagesLink/droite.png");
	
	Map<Objet,ImageView> mapObjetImg = new HashMap<>();
	Map<Arme,ImageView> mapArmeImg = new HashMap<>();
	
	public Controleur() {
		mapObjetImg.put(monde.getTonneau(), imgTonneau);
		mapArmeImg.put(monde.getEpee(), imgEpee);
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
		
		recupererArme();
	}
	
	public void recupererArme() {
		if (monde.getListeArme().contains(monde.getEpee())) {
			if (monde.getLink().getBounds().intersects(monde.getEpee().getBounds())) {
				monde.getListeArme().remove(monde.getEpee());
				monde.getLink().setArme(monde.getEpee());
				System.out.println(monde.getLink());
			}
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
				monde.getListeArme().add(monde.getEpee());
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
		monde.getListeObstacles().add(monde.getTonneau());
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
		
		// ObservableList listeObstacles écoute ListChangeListener
		monde.getListeObstacles().addListener(new ListChangeListener<Objet>() {
			
			@Override
			public void onChanged(Change<? extends Objet> c) {
				while(c.next()) {
					if (c.wasAdded()) {
						for (Objet obj : c.getAddedSubList()) {
							pane.getChildren().add(mapObjetImg.get(obj));
						}
					} else  if(c.wasRemoved()) {
						for (Objet obj : c.getRemoved()) {
							pane.getChildren().remove(mapObjetImg.get(obj));
							
						}
					}
				}
			}
			
		});
		
		monde.getListeArme().addListener(new ListChangeListener<Arme>() {

			@Override
			public void onChanged(Change<? extends Arme> c) {
				while(c.next()) {
					if (c.wasAdded()) {
						for (Arme arme : c.getAddedSubList()) {
							paneArmes.getChildren().add(mapArmeImg.get(arme));
						}
					} else  if(c.wasRemoved()) {
						for (Arme arme : c.getRemoved()) {
							paneArmes.getChildren().remove(mapArmeImg.get(arme));
							
						}
					}
				}
			}
			
		});
		
		
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
