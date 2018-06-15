package controller;

import java.awt.Rectangle;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import modele.Arme;
import modele.Collisions;
import modele.Images;
import modele.Monde;
import modele.Objet;
import modele.Personnage;
import modele.Vivant;
import modele.Objets.Roche;
import vue.Map1;

public class Controleur implements Initializable {

	@FXML Pane paneVue;
	@FXML Pane paneElements;
	@FXML Pane paneCamera;
	@FXML Pane paneArmes;
	@FXML TilePane map;
	@FXML HBox ptDeVie;
	@FXML HBox listeArmes;
	@FXML Label messages;
    
	Monde monde;
	
	private Map<Objet,ImageView> mapObjetImg;
	private Map<Arme,ImageView> mapArmeImg;
	private Map<Personnage,ImageView> mapPersoImg;
	private Map<Arme,ImageView> mapListArmesLinkImg;
	
	private static final String IMAGEGAUCHE = "gauche";
	private static final String IMAGEDROITE = "droite";
	private static final String IMAGEHAUT = "haut";
	private static final String IMAGEBAS = "bas";
	
	
	public Controleur() {
		
		monde = new Monde();
		System.out.println(monde.getGameLoop());
		mapObjetImg = new HashMap<>();
		mapArmeImg = new HashMap<>();
		mapPersoImg = new HashMap<>();
		mapListArmesLinkImg = new HashMap<>();
		
//	Association des éléments de la map avec leur ImageView correspondant
		mapObjetImg.put(monde.getTonneau(), Images.imgTonneau);
		mapObjetImg.put(monde.getRoche(), Images.imgRoche);
		mapArmeImg.put(monde.getEpee(), Images.imgEpee);
		mapArmeImg.put(monde.getFleche(), Images.imgFleche);
		mapPersoImg.put(monde.getEnnemiOurs(), Images.imgOurs);
		mapPersoImg.put(monde.getLink(), Images.imgLink);
		mapPersoImg.put(monde.getVieux(), Images.imgVieux);
		mapListArmesLinkImg.put(monde.getEpee(), Images.listeImgEpee);
		mapListArmesLinkImg.put(monde.getFleche(), Images.listeImgFleche);
	}
	
	public void gererTouche(KeyEvent e) {
		int posY = monde.getLink().getPosY();
		int posX = monde.getLink().getPosX();
		
		deplacements(e);
		collisionObstacleMap(posX,posY,monde);
		collisionObjet(monde.getTonneau(), posX, posY,monde);
		collisionObjet(monde.getRoche(), posX, posY,monde);
		collisionPerso(monde.getEnnemiOurs(), posX, posY,monde);
		collisionPerso(monde.getVieux(), posX, posY,monde);
		casserTonneau(e,monde.getEpee());
		recupererArme(e,monde.getEpee());
		recupererArme(e,monde.getFleche());
		attaquer(e,monde.getEnnemiOurs());
		parler(e,monde.getLink().getBounds(30, 30), monde
				.getVieux().rectangleDetection(60,20), monde);
		changerArmeJoueur(e);
		lancer(e);
		pousserRoche(e, monde.getRoche());

	}
	
	public void changerArmeJoueur(KeyEvent e) {
		if (e.getCode() == KeyCode.Q) {
			monde.getLink().changerArmeJoueur();
		}
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
	
	public void pousserRoche(KeyEvent e,Roche roche) {
			switch(e.getCode()) {
			case UP:    monde.getLink().pousserRoche(KeyCode.UP,roche);
			break;
			case DOWN: monde.getLink().pousserRoche(KeyCode.DOWN,roche);
			break;
			case LEFT:  monde.getLink().pousserRoche(KeyCode.LEFT,roche);
			break;
			case RIGHT: monde.getLink().pousserRoche(KeyCode.RIGHT,roche);
			break;
			default:
				break;
		}
}
	
	public void attaquer(KeyEvent e,Vivant perso) {
		if (e.getCode() == KeyCode.SPACE)
			monde.getLink().attaquer(perso);	
	}
	
	public void lancer(KeyEvent e) {
		if (e.getCode() == KeyCode.S) {
//			gl.initAnimationFleche(100,100);
//			gl.gameLoopFleche.play();
		}
	}
	
	public void casserTonneau(KeyEvent e,Arme arme) {
		if (e.getCode() == KeyCode.A) 
			monde.getLink().casserTonneau(arme);			
		
	}
	
	public void parler(KeyEvent e,Rectangle rect1,Rectangle rect2,Monde monde) {
		if(Collisions.collision( rect1, rect2)) {
//			gl.gameLoopVieux.stop();
			monde.getLink().parler();
		} if (e.getCode() == KeyCode.U &&
			  Collisions.collision(rect1, rect2)) {
//				gl.gameLoopVieux.stop();
				monde.getVieux().parler();
		} else {
//			gl.gameLoopVieux.play();					
		}
	}
	
	public void recupererArme(KeyEvent e,Arme arme) {
		if(e.getCode() == KeyCode.B ) 
			monde.getLink().recupererArme(arme);
		
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

	
	public void initializeMap() {
		// Affichage de la map
		Map1.map(map);
		
		// Ajout des points de vie sur la map
		ptDeVie.getChildren().add(Images.ptDeVie1);
		ptDeVie.getChildren().add(Images.ptDeVie2);
		ptDeVie.getChildren().add(Images.ptDeVie3);
		ptDeVie.getChildren().add(Images.ptDeVie4);
		ptDeVie.getChildren().add(Images.ptDeVie5);
		
		// Affichage d'un message de bienvenue
		monde.setMessages("Bienvenue !\n"
				+ "Pour attaquer, appuyer sur la touche\nESPACE.\n"
				+ "Pour ouvrir des objets, appuyez sur\nla touche A."
				+ " Bon jeu !");
		
		for (Personnage perso : monde.getListePersonnages()) {
			paneElements.getChildren().add(mapPersoImg.get(perso));
		}
		for (Objet objet : monde.getListeObstacles()) {
			paneElements.getChildren().add(mapObjetImg.get(objet));
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Bind entre l'image de Link et sa position x et y
		Images.imgLink.layoutXProperty().bind(monde.getLink().posXProperty());
		Images.imgLink.layoutYProperty().bind(monde.getLink().posYProperty());
		
		// Bind entre l'image du tonneau et sa position x et y
		Images.imgTonneau.layoutXProperty().bind(monde.getTonneau().posXProperty());
		Images.imgTonneau.layoutYProperty().bind(monde.getTonneau().posYProperty());
		
		// Bind entre l'image de l'épée et sa position x et y
		Images.imgEpee.layoutXProperty().bind(monde.getEpee().posXProperty());
		Images.imgEpee.layoutYProperty().bind(monde.getEpee().posYProperty());
		
		// Bind entre l'image de la flèche et sa position x et y
		Images.imgFleche.layoutXProperty().bind(monde.getFleche().posXProperty());
		Images.imgFleche.layoutYProperty().bind(monde.getFleche().posYProperty());
		
		//Bind entre l'image de la roche et sa position x et y
		Images.imgRoche.layoutXProperty().bind(monde.getRoche().posXProperty());
		Images.imgRoche.layoutYProperty().bind(monde.getRoche().posYProperty());
		
		// Bind entre l'image de ours et sa position x et y
		Images.imgOurs.layoutXProperty().bind(monde.getEnnemiOurs().posXProperty());
		Images.imgOurs.layoutYProperty().bind(monde.getEnnemiOurs().posYProperty());
		
		// Bind entre l'image du vieux et sa position x et y
		Images.imgVieux.layoutXProperty().bind(monde.getVieux().posXProperty());
		Images.imgVieux.layoutYProperty().bind(monde.getVieux().posYProperty());
		
		// Bind entre la camera et la position du joueur
		paneCamera.layoutXProperty().bind(monde.getLink().posXProperty().negate().add(200));
		paneCamera.layoutYProperty().bind(monde.getLink().posYProperty().negate().add(180));
		
		// Bind entre le label et les messages
		messages.textProperty().bind(monde.messagesProperty());

		// Changement de la position de Link
		monde.getLink().orientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> 
					changerImageLink(nouvelleValeur)
		);
		
		// Changement de la position de l'Ours
		monde.getEnnemiOurs().orientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> 
					changerImageOurs(nouvelleValeur)
		);
		
		// Changement de la position de Link avec une épée comme arme
		monde.getLink().orientationEpeeProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> 
					changerImageLinkEpee(nouvelleValeur)
		);
		
//		 Changement de l'image du Vieux 
		monde.getVieux().orientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> 
					changerImageVieux(nouvelleValeur)
		);
		
//		Perte de point de vie
		monde.getLink().ptDeVieProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> 
					perdVie((int) nouvelleValeur)
		);
		
		
		
		monde.getListeObstacles().addListener(new ListChangeListener<Objet>() {
			
			@Override
			public void onChanged(Change<? extends Objet> c) {
				while(c.next()) {
					if (c.wasAdded()) {
						for (Objet obj : c.getAddedSubList()) {
							paneElements.getChildren().add(mapObjetImg.get(obj));
						}
					} else  if(c.wasRemoved()) {
						for (Objet obj : c.getRemoved()) {
							paneElements.getChildren().remove(mapObjetImg.get(obj));
							
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
							paneElements.getChildren().add(mapPersoImg.get(obj));
						}
					} else  if(c.wasRemoved()) {
						for (Personnage obj : c.getRemoved()) {
							paneElements.getChildren().remove(mapPersoImg.get(obj));
							
						}
					}
				}
			}
			
		});
		
		monde.getLink().getListeArmes().addListener(new ListChangeListener<Arme>() {
			
			@Override
			public void onChanged(Change<? extends Arme> c) {
				while(c.next()) {
					if (c.wasAdded()) {
						for (Arme obj : c.getAddedSubList()) {
							monde.getLink().setArme(obj);
							listeArmes.getChildren().add(mapListArmesLinkImg.get(obj));
						}
					} else if(c.wasRemoved()) {
						for (Arme obj : c.getRemoved()) {
							listeArmes.getChildren().remove(mapListArmesLinkImg.get(obj));
							
						}
					}
				}
			}
			
		});
		
		

		// démarrage des différentes animations
		initializeMap();
		monde.getGameLoop().initAnimation();
		monde.getGameLoop().gameLoop.play();

	}


	public void perdVie(int nouvelleValeur) {
		if (nouvelleValeur < 80 && nouvelleValeur > 60) {
			ptDeVie.getChildren().remove(Images.ptDeVie1);
		} else if (nouvelleValeur <= 60 && nouvelleValeur > 40) {
			ptDeVie.getChildren().remove(Images.ptDeVie2);
		} else if (nouvelleValeur <= 40 && nouvelleValeur > 20) {
			ptDeVie.getChildren().remove(Images.ptDeVie3);
		} else if (nouvelleValeur <= 20 && nouvelleValeur > 0) {
			ptDeVie.getChildren().remove(Images.ptDeVie4);
		} else if (nouvelleValeur <= 0) {
			ptDeVie.getChildren().remove(Images.ptDeVie5);
			monde.setMessages("Game Over !");
		}
		
	}

	public void changerImageOurs(String nouvelleValeur) {
		switch(nouvelleValeur) {
		
		case IMAGEHAUT :   Images.imgOurs.setImage(Images.imgOursHaut);
			break;
		case IMAGEBAS :    Images.imgOurs.setImage(Images.imgOursBas);
			break;
		case IMAGEDROITE : Images.imgOurs.setImage(Images.imgOursDroit);
			break;
		case IMAGEGAUCHE : Images.imgOurs.setImage(Images.imgOursGauche);
			break;
		}
		
	}

	public void changerImageLink(String nouvelleValeur) {
		switch(nouvelleValeur) {
		case IMAGEHAUT :   Images.imgLink.setImage(Images.haut);
			break;
		case IMAGEBAS :    Images.imgLink.setImage(Images.basdroit);
			break;
		case IMAGEDROITE : Images.imgLink.setImage(Images.droite);
			break;
		case IMAGEGAUCHE : Images.imgLink.setImage(Images.gauche);
			break;
		}
	}
	
	public void changerImageLinkEpee(String nouvelleValeur) {
		switch(nouvelleValeur) {
		case "gaucheEpee" : Images.imgLink.setImage(Images.gaucheEpee);
			break;
		case "droiteEpee" : Images.imgLink.setImage(Images.droiteEpee);
			break;
		case "basEpee" : Images.imgLink.setImage(Images.basEpee);
			break;
		case "hautEpee" : Images.imgLink.setImage(Images.hautEpee);
			break;
		}
	}
	public void changerImageVieux(String nouvelleValeur) {
		switch(nouvelleValeur) {
			case IMAGEGAUCHE : Images.imgVieux.setImage(Images.imgVieuxGauche);
				break;
			case IMAGEDROITE : Images.imgVieux.setImage(Images.imgVieuxDroite);
				break;
		
		}
	}
}