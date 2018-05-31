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
import modele.Personnage;
import vue.Map1;

public class Controleur implements Initializable {

	@FXML Pane pane;
	@FXML Pane paneArmes;
	@FXML TilePane layout;
	Monde monde = new Monde();
	GameLoop gl = new GameLoop();
	

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

//	Association objet - ImageView
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
		collisionObstacleMap(posX,posY,monde);
		collisionObjet(monde.getTonneau(), posX, posY,monde);
		collisionEnnemi(monde.getEnnemiOurs(), posX, posX,monde);
		casserTonneau(e);
		recupererArme();
		attaquer(e,monde.getEnnemiOurs());
	}
	
//	Déplacements du joueur
	public void deplacements(KeyEvent e) {
		switch(e.getCode()) {
		case UP:    monde.getLink().seDeplacer(KeyCode.UP);
			break;
		case DOWN:  monde.getLink().seDeplacer(KeyCode.DOWN);
			break;
		case LEFT:  monde.getLink().seDeplacer(KeyCode.LEFT);
			break;
		case RIGHT: monde.getLink().seDeplacer(KeyCode.RIGHT);
			break;
		default:
			break;
		}
	}
	
	public void attaquer(KeyEvent e,Personnage perso) {
		if (e.getCode() == KeyCode.SPACE) {
			if(monde.getLink().getArme() != null) {
				monde.getLink().attaquer(perso);
			} else {
				System.out.println("Vous n'avez aucune armes.");
			}
		}
	}

	public void recupererArme() {
			monde.getLink().recupererArme();
	}
	
	public void collisionObstacleMap(int positionX,int positionY,Monde monde) {
		Collisions.collisionMap(positionX, positionY, monde);
			
	} 
	
	
	public void collisionObjet(Objet obj,int positionX,int positionY,Monde monde) {
		Collisions.collisionObjet(obj,positionX,positionY,monde);
			
	} 
	
	public void collisionEnnemi(Personnage perso,int positionX,int positionY,Monde monde) {
		Collisions.collisionEnnemi(perso, positionX, positionY, monde);
		
	} 
	
//	CASSER TONNEAU
	public void casserTonneau(KeyEvent e) {
		monde.getLink().casserTonneau(e);
	}
	

	public void initializeMap() {
		// Affichage de la map
		Map1.map(layout);
		// Ajout des obstacles et ennemis dans les listes
		monde.getListeObstacles().add(monde.getTonneau());
		monde.getListeEnnemis().add(monde.getEnnemiOurs());
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
		
		// démarrage de l'animation
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
		switch(nouvelleValeur) {
		case "haut" :   imgOursGauche.setImage(imgOursHaut);
			break;
		case "bas" :    imgOursGauche.setImage(imgOursBas);
			break;
		case "droite" : imgOursGauche.setImage(imgOursDroit);
			break;
		}
		
	}

	public void changerImageLink(String nouvelleValeur) {
		switch(nouvelleValeur) {
		case "haut" :   imgLink.setImage(haut);
			break;
		case "bas" :    imgLink.setImage(basdroit);
			break;
		case "droite" : imgLink.setImage(droite);
			break;
		case "gauche" : imgLink.setImage(gauche);
			break;
		}
	}
}