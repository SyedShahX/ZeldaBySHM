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
	
//	Images Link Epee
	Image droiteEpee = new Image("assets/images/ImagesLink/droiteEpee.png");
	Image gaucheEpee = new Image("assets/images/ImagesLink/gaucheEpee.png");
	Image basEpee = new Image("assets/images/ImagesLink/basEpee.png");
	Image hautEpee = new Image("assets/images/ImagesLink/hautEpee.png");
	
//	Images Déplacements Ours
	ImageView imgOurs = new ImageView("assets/images/ImageEnnemis/oursGrisGauche.png");
	Image imgOursDroit = new Image("assets/images/ImageEnnemis/oursGrisDroite.png");
	Image imgOursHaut = new Image("assets/images/ImageEnnemis/oursGrisHaut.png");
	Image imgOursBas = new Image("assets/images/ImageEnnemis/oursGrisBas.png");
	Image imgOursGauche = new Image("assets/images/ImageEnnemis/oursGrisGauche.png");
	
//	Images Vieux
	ImageView imgVieux = new ImageView("assets/images/ImagesVieux/vieuxGauche.png");
	Image imgVieuxDroite = new Image("assets/images/ImagesVieux/vieuxDroite.png");
	Image imgVieuxGauche = new Image("assets/images/ImagesVieux/vieuxGauche.png");

//	Association objet - ImageView
	Map<Objet,ImageView> mapObjetImg = new HashMap<>();
	Map<Arme,ImageView> mapArmeImg = new HashMap<>();
	Map<Personnage,ImageView> mapPersoImg = new HashMap<>();
	
	public Controleur() {
		mapObjetImg.put(monde.getTonneau(), imgTonneau);
		mapArmeImg.put(monde.getEpee(), imgEpee);
		mapPersoImg.put(monde.getEnnemiOurs(), imgOurs);
		mapPersoImg.put(monde.getLink(), imgLink);
		mapPersoImg.put(monde.getVieux(), imgVieux);
	}
	
	public void gererTouche(KeyEvent e) {
		int posY = monde.getLink().getPosY();
		int posX = monde.getLink().getPosX();
		
		deplacements(e);
		collisionObstacleMap(posX,posY,monde);
		collisionObjet(monde.getTonneau(), posX, posY,monde);
		collisionPerso(monde.getEnnemiOurs(), posX, posY,monde);
		collisionPerso(monde.getVieux(), posX, posY,monde);
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
	
	public void collisionPerso(Personnage perso,int positionX,int positionY,Monde monde) {
		Collisions.collisionPerso(perso, positionX, positionY, monde);
		
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
		monde.getListePersonnages().addAll(monde.getEnnemiOurs(),monde.getLink(),monde.getVieux());
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
		imgOurs.layoutXProperty().bind(monde.getEnnemiOurs().PosXProperty());
		imgOurs.layoutYProperty().bind(monde.getEnnemiOurs().PosYProperty());
		
		// Bind entre l'image vieux et sa position x et y
		imgVieux.layoutXProperty().bind(monde.getVieux().PosXProperty());
		imgVieux.layoutYProperty().bind(monde.getVieux().PosYProperty());
		
		
		// Animation Ennemi Ours
		gl.initAnimationOurs(monde.getEnnemiOurs(),0.017,170,5,0,"droite","gauche");
		gl.initAnimationVieux(monde.getVieux(), 0.018,100,"droite", "gauche");
		// démarrage de l'animation
		gl.gameLoopOurs.play();
		gl.gameLoopVieux.play();
		
		// Changement position Link
		monde.getLink().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageLink(nouvelleValeur);
				}
		);
		
		// Changement position Ours
		monde.getEnnemiOurs().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageOurs(nouvelleValeur);
				}
		);
		
		// Changement position Link avec épée comme arme
		monde.getLink().OrientationEpeeProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageLinkEpee(nouvelleValeur);
				}
		);
		
//		 Changement image Vieux 
		monde.getVieux().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageVieux(nouvelleValeur);
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
		
		monde.getListeArmes().addListener(new ListChangeListener<Arme>() {

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
		
		monde.getListePersonnages().addListener(new ListChangeListener<Personnage>() {
			
			@Override
			public void onChanged(Change<? extends Personnage> c) {
				while(c.next()) {
					if (c.wasAdded()) {
						for (Personnage obj : c.getAddedSubList()) {
							pane.getChildren().add(mapPersoImg.get(obj));
						}
					} else  if(c.wasRemoved()) {
						for (Personnage obj : c.getRemoved()) {
							pane.getChildren().remove(mapPersoImg.get(obj));
							
						}
					}
				}
			}
			
		});
		
		initializeMap();
		
	}


	public void changerImageOurs(String nouvelleValeur) {
		switch(nouvelleValeur) {
		
		case "haut" :   imgOurs.setImage(imgOursHaut);
			break;
		case "bas" :    imgOurs.setImage(imgOursBas);
			break;
		case "droite" : imgOurs.setImage(imgOursDroit);
			break;
		case "gauche" : imgOurs.setImage(imgOursGauche);
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
	
	public void changerImageLinkEpee(String nouvelleValeur) {
		switch(nouvelleValeur) {
		case "gaucheEpee" : imgLink.setImage(gaucheEpee);
			break;
		case "droiteEpee" : imgLink.setImage(droiteEpee);
			break;
		case "basEpee" : imgLink.setImage(basEpee);
			break;
		case "hautEpee" : imgLink.setImage(hautEpee);
			break;
		}
	}
	public void changerImageVieux(String nouvelleValeur) {
		switch(nouvelleValeur) {
			case "gauche" : imgVieux.setImage(imgVieuxGauche);
				break;
			case "droite" : imgVieux.setImage(imgVieuxDroite);
				break;
		
		}
	}
}