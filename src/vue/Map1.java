package vue;


import javafx.scene.layout.TilePane;



public class Map1 extends Map {
	
	static int[][] tab = {{2,2,2,2,2,2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2},
			  {2,2,2,2,2,2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2},
			  {2,2,2,2,2,2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2},
			  {2,2,2,2,2,2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2},
			  {2,2,2,2,2,2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2},
			  {2,2,2,2,2,2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2},
			  {2,2,2,2,2,2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 14, 14, 14, 2, 2, 14, 14, 14, 14, 14, 2, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 14, 14, 14, 2, 2, 14, 14, 14, 14, 14, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 4, 12, 12, 12, 12, 4, 12, 12, 4, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 14, 14, 14, 14, 14, 14, 14, 2, 2, 14, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 1, 1, 1, 1, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 14, 14, 14, 14, 14, 14, 14, 2, 2, 14, 2, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 11,13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 1, 1, 1, 1, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 3, 4, 12, 12, 4, 12, 4, 12, 12, 12, 12, 1, 1, 1, 1, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 2, 12, 2, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 3, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 3, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 11, 11, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 2, 2, 2, 2, 12, 12, 12, 12, 2, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 3, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 2, 2, 2, 2, 12, 12, 12, 12, 2, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 3, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 2, 2, 2, 2, 12, 12, 12, 12, 2, 11, 11, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 12, 12, 12, 12, 12, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 2, 2, 2, 2, 12, 12, 12, 12, 2, 11, 11, 2, 12, 12, 12, 12, 14, 14, 14, 14, 12, 12, 12, 12, 12, 12, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 2, 3, 12, 12, 12, 14, 3, 3, 14, 12, 12, 12, 12, 12, 12, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 2, 12, 12, 12, 12, 14, 3, 3, 14, 12, 12, 12, 12, 12, 12, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 2, 12, 12, 12, 12, 14, 14, 14, 14, 12, 12, 12, 12, 12, 12, 11, 11, 12, 12, 12, 12, 12, 3, 3, 3, 3, 3, 3, 3, 3, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 2, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 11, 11, 12, 12, 12, 12, 12, 3, 3, 1, 2, 1, 2, 1, 2, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 2, 11, 11, 2, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 11, 11, 12, 12, 12, 12, 12, 3, 12, 12, 12, 12, 12, 12, 12, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 4, 4, 4, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 3, 3, 2, 1, 2, 1, 2, 1, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 4, 12, 4, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 3, 3, 3, 3, 3, 3, 3, 3, 12, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 12, 4, 4, 4, 12, 3, 12, 12, 12, 12, 12, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 1,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,2,2},
		      {2,2,2,2,2,2,2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2,2,2,2,2,2}
			};
	public static int[][] getTab(){
		return tab;
	}
	
	
	public static void map(TilePane tilePane) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				int tile = tab[i][j];
				setTile(tile,tilePane,12, "assets/images/herbe.png");
				setTile(tile,tilePane,14, "assets/images/buisson.png");
				setTile(tile,tilePane,11, "assets/images/terre.png");
				setTile(tile,tilePane,13, "assets/images/patte.png");
				setTile(tile,tilePane,1, "assets/images/arbreFruit.png");
				setTile(tile,tilePane,2, "assets/images/arbre.png");
				setTile(tile,tilePane,4, "assets/images/fleur.png");
				setTile(tile,tilePane,3, "assets/images/roche.png");
			}
		}
	}
} 
