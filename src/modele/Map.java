package modele;

import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Map {
	
	
	public static ImageView setTile(int tile,TilePane tilePane,int number, String urlImage) {
		ImageView image = null;
		if (tile == number) {
			image = new ImageView(urlImage);
			tilePane.getChildren().add(image);
			System.out.println(image.getX());
		}
		return image;
	}
}
