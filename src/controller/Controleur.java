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
import modele.Ennemi;
import modele.GameLoop;
import modele.Monde;
import modele.Objet;
import vue.Map1;

public class Controleur implements Initializable {

	@FXML Pane pane;
	@FXML Pane paneArmes;
	@FXML TilePane layout;
	GameLoop gl = new GameLoop();
	
	Monde monde = new Monde();

//	ImageView Objets
	ImageView imgTonneau = new ImageView("assets/images/tonneau.png");

//	ImageView Armes
	ImageView imgEpee = new ImageView("assets/images/ImagesArmes/épée.png");
	
//	Images déplacements Link
	ImageView imgLink = new ImageView("assets/images/ImagesLink/joueur.png");
	Image haut = new Image("assets/images/ImagesLink/haut.png");
	Image gauche = new Image("assets/images/ImagesLink/gauche.png");
	Image basdroit = new Image("assets/images/ImagesLink/basdroit.png");
	Image droite = new Image("assets/images/ImagesLink/droite.png");
	
//	Images Déplacements Ours
	ImageView imgOursGauche = new ImageView("assets/images/ImageEnnemis/oursGrisGauche.png");
	Image imgOursHaut = new Image("assets/images/ImagesLink/haut.png");
	Image imgOursBas = new Image("assets/images/ImagesLink/gauche.png");
	Image imgOursDroit = new Image("assets/images/ImageEnnemis/oursGrisGauche.png");

	Map<Objet,ImageView> mapObjetImg = new HashMap<>();
	Map<Ennemi,ImageView> mapEnnemisImg = new HashMap<>();
	Map<Arme,ImageView> mapArmeImg = new HashMap<>();
	
	public Controleur() {
		mapObjetImg.put(monde.getTonneau(), imgTonneau);
		mapArmeImg.put(monde.getEpee(), imgEpee);
		mapEnnemisImg.put(monde.getEnnemiOurs(), imgOursGauche);
	}
	
	public void gererTouche(KeyEvent e) {
		int posY = monde.getLink().getPosY();
		int posX = monde.getLink().getPosX();
		
		deplacements(e);
		collisionObstacleMap(e,posX,posY);
		collisionObjet(e,monde.getTonneau(), posX, posY);
		casserTonneau(e);
		recupererArme();
		attaquer(e);
	}
	
//	Déplacements du joueur
	public void deplacements(KeyEvent e) {
		
		if (e.getCode() == KeyCode.UP) {
			monde.getLink().seDeplacer(KeyCode.UP);
			
		} else if (e.getCode() == KeyCode.DOWN) {
			monde.getLink().seDeplacer(KeyCode.DOWN);
			
		} else if (e.getCode() == KeyCode.LEFT) {
			monde.getLink().seDeplacer(KeyCode.LEFT);
			
		} else if(e.getCode() == KeyCode.RIGHT){
			monde.getLink().seDeplacer(KeyCode.RIGHT);
		} 
	}
	
	public void attaquer(KeyEvent e) {
		if (e.getCode() == KeyCode.SPACE) {
			if (monde.getLink().getArme() != null) {
				monde.getLink().attaquer();				
			} else {
				System.out.println("Le joueur n'a aucune armes pour attaquer");
			}
		}
	}

	public void recupererArme() {
			if (monde.getListeArme().contains(monde.getEpee())) {
				if (monde.getLink().getBounds().intersects(monde.getEpee().getBounds())) {
					monde.supprimerArme(monde.getEpee());
					monde.getLink().changerArmeJoueur(monde.getEpee());
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
				monde.supprimerObjet(monde.getTonneau());
				monde.ajouterArme(monde.getEpee());
					
		}
	}
	
	public void collisionObjet(KeyEvent e,Objet obj,int positionX,int positionY) {
		if (monde.getListeObstacles().contains(obj)) {
			if (monde.getLink().collision(obj.getBoundsCollisions()) == true) {
				monde.getLink().setPositionFixe(positionX,positionY);
			}
			
		}
			
	} 
	

	public void initializeMap() {
		Map1.map(layout);
		monde.getListeObstacles().add(monde.getTonneau());
		monde.getListeEnnemis().add(monde.getEnnemiOurs());
		// Affichage de la map
		// Affichage de link et du tonneau
		pane.getChildren().addAll(imgLink);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		// Bind entre l'image Link et sa position x et y
		imgLink.layoutXProperty().bind(monde.getLink().PosXProperty());
		imgLink.layoutYProperty().bind(monde.getLink().PosYProperty());
		
		// Bind entre l'image Tonneau et sa position x et y
		imgTonneau.layoutXProperty().bind(monde.getTonneau().PosXProperty());
		imgTonneau.layoutYProperty().bind(monde.getTonneau().PosYProperty());
		
		// Bind entre l'image Tonneau et sa position x et y
		imgEpee.layoutXProperty().bind(monde.getEpee().PosXProperty());
		imgEpee.layoutYProperty().bind(monde.getEpee().PosYProperty());
		
		// Bind entre l'image Ours et sa position x et y
		imgOursGauche.layoutXProperty().bind(monde.getEnnemiOurs().PosXProperty());
		imgOursGauche.layoutYProperty().bind(monde.getEnnemiOurs().PosYProperty());
		
		// Changement position Link
		monde.getLink().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageLink(nouvelleValeur);
				}
		);
		
		// Animation Ennemi Ours
		gl.initAnimation(monde.getEnnemiOurs(),0.017,265,-5,0);
		
		// demarre l'animation
		gl.gameLoop.play();
		
		// Changement position Ours
		monde.getEnnemiOurs().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageOurs(nouvelleValeur);
				}
		);
		
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
		
		monde.getListeEnnemis().addListener(new ListChangeListener<Ennemi>() {
			
			@Override
			public void onChanged(Change<? extends Ennemi> c) {
				while(c.next()) {
					if (c.wasAdded()) {
						for (Ennemi obj : c.getAddedSubList()) {
							pane.getChildren().add(mapEnnemisImg.get(obj));
						}
					} else  if(c.wasRemoved()) {
						for (Ennemi obj : c.getRemoved()) {
							pane.getChildren().remove(mapEnnemisImg.get(obj));
							
						}
					}
				}
			}
			
		});
		
		initializeMap();
		
	}

	public void changerImageOurs(String nouvelleValeur) {
		if (nouvelleValeur == "haut") {
			imgOursGauche.setImage(imgOursHaut);
		} else if (nouvelleValeur == "bas") {
			imgOursGauche.setImage(imgOursBas);
		} else if (nouvelleValeur == "droite") {
			imgOursGauche.setImage(imgOursDroit);
		}
		
	}

	public void changerImageLink(String nouvelleValeur) {
		if (nouvelleValeur == "haut") {
			imgLink.setImage(haut);
		} else if (nouvelleValeur == "bas") {
			imgLink.setImage(basdroit);
		} else if (nouvelleValeur == "gauche") {
			imgLink.setImage(gauche);
		} else if (nouvelleValeur == "droite") {
			imgLink.setImage(droite);
		}
	}




}
