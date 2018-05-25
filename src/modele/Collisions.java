package modele;

import java.awt.Rectangle;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vue.Map1;

public class Collisions {

	public static boolean collision(int posX,int posY) {
		Rectangle joueur = new Rectangle(posX,posY,20,25);
		int[][] tab=Map1.getTab();
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if (estcollision(tab[i][j]) == true) {
					int iPx = i*32;
					int jPx = j*32;
					Rectangle arbre = new Rectangle(jPx,iPx,20,26);
					if (joueur.intersects(arbre)) {
						return true;
					}
				}
			}
		}
		
		return false;
		
	}
	public static boolean estcollision(int valtab) {
		if(valtab==2||valtab==3||valtab==1)
			return true;
		else {
		return false;
		}
	}

	public static boolean persoRalenti(int PosX,int PosY) {
		Rectangle joueur = new Rectangle(PosX,PosY,20,20);
		int[][] tab=Map1.getTab();
		for(int i=0;i<tab.length;i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if(tab[i][j]==14) {
					int PxX=j*32;
					int PxY=i*32;
					Rectangle buisson = new Rectangle(PxX,PxY,26,15);
					if (joueur.intersects(buisson)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
