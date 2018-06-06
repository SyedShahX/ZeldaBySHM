package modele;

import java.awt.Rectangle;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vue.Map1;

public class Collisions {

	public static boolean collisionObstacleMap(int posX,int posY) {
		Rectangle joueur = new Rectangle(posX,posY,20,25);
		int[][] tab = Map1.getTab();
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if (estcollision(tab[i][j], 1) ||
					estcollision(tab[i][j], 2) ||
					estcollision(tab[i][j], 3)) {
					int iPx = i*32;
					int jPx = j*32;
					Rectangle obstacleMap = new Rectangle(jPx,iPx,20,25);
					if (collision(joueur, obstacleMap)) {
						return true;
					}
				}
			}
		}
		
		return false;
		
	}
	public static boolean estcollision(int valTab,int numeroTile) {
		if(valTab == numeroTile)
			return true;
		else {
			return false;
		}
	}
	
	public static boolean collision(Rectangle rect,Rectangle rec2) {
		if(rect.intersects(rec2.getBounds())) {
			return true;
		} else
			return false;
	}
	
	public static void collisionMap(int positionX,int positionY,Monde monde) {
		if (collisionObstacleMap(monde.getLink().getPosX(), monde.getLink().getPosY())) {
			monde.getLink().setPositionFixe(positionX,positionY);
		}
			
	} 
	public static void collisionObjet(Objet obj,int positionX,int positionY,Monde monde) {
		if (monde.getListeObstacles().contains(obj)) {
			if (Collisions.collision(monde.getLink().getBounds(28,28),obj.getBounds(15,15))) {
				monde.getLink().setPositionFixe(positionX,positionY);
			}
			
		}
			
	} 
	
	public static boolean collisionPerso(Personnage perso,int positionX,int positionY,Monde monde) {
		if (monde.getListePersonnages().contains(perso)) {
			if (Collisions.collision(monde.getLink().getBounds(28,28),perso.getBounds(30,30))) {
				monde.getLink().setPositionFixe(positionX,positionY);
				return true;
			}
			
		}
		return false;
		
	} 
	
	public static boolean persoRalenti(int posX,int posY) {
		Rectangle joueur = new Rectangle(posX,posY,20,20);
		int[][] tab = Map1.getTab();
		for(int i=0;i < tab.length;i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if(estcollision(tab[i][j], 14)) {
					int PxX=j*32;
					int PxY=i*32;
					Rectangle buisson = new Rectangle(PxX,PxY,26,15);
					if (collision(joueur, buisson)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
