package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Arme;
import modele.Collisions;
import modele.Ennemi;
import modele.GameLoop;
import modele.Images;
import modele.Monde;
import modele.Objet;
import modele.Personnage;
import vue.Map1;

public class Controleur implements Initializable {

	@FXML Pane pane;
	@FXML Pane paneArmes;
	@FXML TilePane layout;
	Monde monde = new Monde();
	GameLoop gameLoop = new GameLoop();
	Images img = new Images();
	
//	Association objet - ImageView
	Map<Objet,ImageView> mapObjetImg = new HashMap<>();
	Map<Arme,ImageView> mapArmeImg = new HashMap<>();
	Map<Personnage,ImageView> mapPersoImg = new HashMap<>();
	
	public Controleur() {
		mapObjetImg.put(monde.getTonneau(), img.imgTonneau);
		mapArmeImg.put(monde.getEpee(), img.imgEpee);
		mapPersoImg.put(monde.getEnnemiOurs(), img.imgOurs);
		mapPersoImg.put(monde.getLink(), img.imgLink);
		mapPersoImg.put(monde.getVieux(), img.imgVieux);
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
//		attaquerJoueur(monde.getEnnemiOurs(), posX, posY,monde);
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
	
	public void attaquerJoueur(Ennemi ennemi,int positionX,int positionY,Monde monde) {
		if (Collisions.collisionPerso(ennemi, positionX, positionY, monde)) {
			ennemi.attaquer();
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
	
	public boolean collisionPerso(Personnage perso,int positionX,int positionY,Monde monde) {
		
		if(Collisions.collisionPerso(perso, positionX, positionY, monde)) {
			return true;
		}
		
		return false;
		
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
		monde.getListePersonnages().addAll(monde.getEnnemiOurs(),monde.getLink(),
										   monde.getVieux());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		// Bind entre l'image Link et sa position x et y
		img.imgLink.layoutXProperty().bind(monde.getLink().PosXProperty());
		img.imgLink.layoutYProperty().bind(monde.getLink().PosYProperty());
		
		// Bind entre l'image Tonneau et sa position x et y
		img.imgTonneau.layoutXProperty().bind(monde.getTonneau().PosXProperty());
		img.imgTonneau.layoutYProperty().bind(monde.getTonneau().PosYProperty());
		
		// Bind entre l'image Tonneau et sa position x et y
		img.imgEpee.layoutXProperty().bind(monde.getEpee().PosXProperty());
		img.imgEpee.layoutYProperty().bind(monde.getEpee().PosYProperty());
		
		// Bind entre l'image Ours et sa position x et y
		img.imgOurs.layoutXProperty().bind(monde.getEnnemiOurs().PosXProperty());
		img.imgOurs.layoutYProperty().bind(monde.getEnnemiOurs().PosYProperty());
		
		// Bind entre l'image vieux et sa position x et y
		img.imgVieux.layoutXProperty().bind(monde.getVieux().PosXProperty());
		img.imgVieux.layoutYProperty().bind(monde.getVieux().PosYProperty());
		
		
		// Animation Ennemi Ours
		gameLoop.initAnimationOurs(monde.getEnnemiOurs(),0.017,170,5,0,"droite","gauche");
		gameLoop.initAnimationVieux(monde.getVieux(), 0.05,100,"droite", "gauche");
		// démarrage de l'animation
		gameLoop.gameLoopOurs.play();
		gameLoop.gameLoopVieux.play();
		
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
		
		case "haut" :   img.imgOurs.setImage(img.imgOursHaut);
			break;
		case "bas" :    img.imgOurs.setImage(img.imgOursBas);
			break;
		case "droite" : img.imgOurs.setImage(img.imgOursDroit);
			break;
		case "gauche" : img.imgOurs.setImage(img.imgOursGauche);
			break;
		}
		
	}

	public void changerImageLink(String nouvelleValeur) {
		switch(nouvelleValeur) {
		case "haut" :   img.imgLink.setImage(img.haut);
			break;
		case "bas" :    img.imgLink.setImage(img.basdroit);
			break;
		case "droite" : img.imgLink.setImage(img.droite);
			break;
		case "gauche" : img.imgLink.setImage(img.gauche);
			break;
		}
	}
	
	public void changerImageLinkEpee(String nouvelleValeur) {
		switch(nouvelleValeur) {
		case "gaucheEpee" : img.imgLink.setImage(img.gaucheEpee);
			break;
		case "droiteEpee" : img.imgLink.setImage(img.droiteEpee);
			break;
		case "basEpee" : img.imgLink.setImage(img.basEpee);
			break;
		case "hautEpee" : img.imgLink.setImage(img.hautEpee);
			break;
		}
	}
	public void changerImageVieux(String nouvelleValeur) {
		switch(nouvelleValeur) {
			case "gauche" : img.imgVieux.setImage(img.imgVieuxGauche);
				break;
			case "droite" : img.imgVieux.setImage(img.imgVieuxDroite);
				break;
		
		}
	}
}