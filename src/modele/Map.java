package modele;

import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Map {
	
	
	public static void setTile(int tile,TilePane tilePane,int number, String urlImage) {
		if (tile == number) {
			ImageView image = new ImageView(urlImage);
			tilePane.getChildren().add(image);
		}
	}
}
