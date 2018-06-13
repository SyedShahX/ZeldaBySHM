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
import modele.Vivant;
import modele.Arme;
import modele.Collisions;
import modele.GameLoop;
import modele.Images;
import modele.Monde;
import modele.Objet;
import modele.Personnage;
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
    
	private Monde monde = new Monde();
	private GameLoop gl = new GameLoop();
	private Images img = new Images();
	
//	Association objet - ImageView
	private Map<Objet,ImageView> mapObjetImg = new HashMap<>();
	private Map<Arme,ImageView> mapArmeImg = new HashMap<>();
	private Map<Personnage,ImageView> mapPersoImg = new HashMap<>();
	private Map<Arme,ImageView> mapListArmesLinkImg = new HashMap<>();
	
	
	public Controleur() {
		mapObjetImg.put(monde.getTonneau(), img.imgTonneau);
		mapObjetImg.put(monde.getRoche(), img.imgRoche);
		mapArmeImg.put(monde.getEpee(), img.imgEpee);
		mapArmeImg.put(monde.getFleche(), img.imgFleche);
		mapPersoImg.put(monde.getEnnemiOurs(), img.imgOurs);
		mapPersoImg.put(monde.getLink(), img.imgLink);
		mapPersoImg.put(monde.getVieux(), img.imgVieux);
		mapListArmesLinkImg.put(monde.getEpee(), img.listeImgEpee);
		mapListArmesLinkImg.put(monde.getFleche(), img.listeImgFleche);
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
				.getVieux().RectangleDetection(60,20), monde);
//		changerArmeJoueur(e);
		lancer(e);
		pousserRoche(e, monde.getRoche());

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
	
	// PUUSSER ROCHE
	public void pousserRoche(KeyEvent e,Roche roche) {
		if(Collisions.collision(monde.getLink().getBounds(20, 28), monde.getRoche().zoneDetection())) {
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
		// Ajout des obstacles et ennemis dans les listes
		monde.getListeObstacles().addAll(monde.getTonneau(),monde.getRoche());
		monde.getListePersonnages().addAll(monde.getEnnemiOurs(),monde.getLink(),
										   monde.getVieux());
		
		// Ajout des points de vie sur la map
		ptDeVie.getChildren().add(img.ptDeVie1);
		ptDeVie.getChildren().add(img.ptDeVie2);
		ptDeVie.getChildren().add(img.ptDeVie3);
		ptDeVie.getChildren().add(img.ptDeVie4);
		ptDeVie.getChildren().add(img.ptDeVie5);
		
		// Affichage d'un message de bienvenue
		monde.setMessages("Bienvenue !\n"
				+ "Pour attaquer, appuyer sur la touche\nESPACE.\n"
				+ "Pour ouvrir des objets, appuyez sur\nla touche A."
				+ " Bon jeu !");
		
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Bind entre l'image de Link et sa position x et y
		img.imgLink.layoutXProperty().bind(monde.getLink().PosXProperty());
		img.imgLink.layoutYProperty().bind(monde.getLink().PosYProperty());
		
		// Bind entre l'image du tonneau et sa position x et y
		img.imgTonneau.layoutXProperty().bind(monde.getTonneau().PosXProperty());
		img.imgTonneau.layoutYProperty().bind(monde.getTonneau().PosYProperty());
		
		// Bind entre l'image de l'épée et sa position x et y
		img.imgEpee.layoutXProperty().bind(monde.getEpee().PosXProperty());
		img.imgEpee.layoutYProperty().bind(monde.getEpee().PosYProperty());
		
		// Bind entre l'image de la flèche et sa position x et y
		img.imgFleche.layoutXProperty().bind(monde.getFleche().PosXProperty());
		img.imgFleche.layoutYProperty().bind(monde.getFleche().PosYProperty());
		
		//Bind entre l'image de la roche et sa position x et y
		img.imgRoche.layoutXProperty().bind(monde.getRoche().PosXProperty());
		img.imgRoche.layoutYProperty().bind(monde.getRoche().PosYProperty());
		
		// Bind entre l'image de ours et sa position x et y
		img.imgOurs.layoutXProperty().bind(monde.getEnnemiOurs().PosXProperty());
		img.imgOurs.layoutYProperty().bind(monde.getEnnemiOurs().PosYProperty());
		
		// Bind entre l'image du vieux et sa position x et y
		img.imgVieux.layoutXProperty().bind(monde.getVieux().PosXProperty());
		img.imgVieux.layoutYProperty().bind(monde.getVieux().PosYProperty());
		
		// Bind entre la camera et la position du joueur
		paneCamera.layoutXProperty().bind(monde.getLink().PosXProperty().negate().add(200));
		paneCamera.layoutYProperty().bind(monde.getLink().PosYProperty().negate().add(180));
		
		// Bind entre le label et les messages
		messages.textProperty().bind(monde.messagesProperty());

		
	
		
		// Changement de la position de Link
		monde.getLink().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageLink(nouvelleValeur);
				}
		);
		
		// Changement de la position de l'Ours
		monde.getEnnemiOurs().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageOurs(nouvelleValeur);
				}
		);
		
		// Changement de la position de Link avec une épée comme arme
		monde.getLink().OrientationEpeeProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageLinkEpee(nouvelleValeur);
				}
		);
		
//		 Changement de l'image du Vieux 
		monde.getVieux().OrientationProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					changerImageVieux(nouvelleValeur);
				}
		);
		
//		Perte de point de vie
		monde.getLink().ptDeVieProperty().addListener(
				(obs,ancienneValeur,nouvelleValeur) -> {
					PerdVie((int) nouvelleValeur);
				}
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
					} else  if(c.wasRemoved()) {
						for (Arme obj : c.getRemoved()) {
							listeArmes.getChildren().remove(mapListArmesLinkImg.get(obj));
							
						}
					}
				}
			}
			
		});
		
		

		// démarrage des différentes animations
		initializeMap();
		gl.initAnimation();
		gl.gameLoop.play();
	}


	public void PerdVie(int nouvelleValeur) {
		if (nouvelleValeur < 80 && nouvelleValeur > 60) {
			ptDeVie.getChildren().remove(img.ptDeVie1);
		} else if (nouvelleValeur <= 60 && nouvelleValeur > 40) {
			ptDeVie.getChildren().remove(img.ptDeVie2);
		} else if (nouvelleValeur <= 40 && nouvelleValeur > 20) {
			ptDeVie.getChildren().remove(img.ptDeVie3);
		} else if (nouvelleValeur <= 20 && nouvelleValeur > 0) {
			ptDeVie.getChildren().remove(img.ptDeVie4);
		} else if (nouvelleValeur <= 0) {
			ptDeVie.getChildren().remove(img.ptDeVie5);
			monde.setMessages("Game Over !");
		}
		
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