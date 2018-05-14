package App;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {
	
	TilePane layout;
	
	@Override
	public void start(Stage window) throws Exception {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/vue/GUIZelda.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());
			window.setTitle("jeu Zelda");
			layout = new TilePane();
			layout = loader.load();
			Scene scene = new Scene(layout,1600,960);
			window.setScene(scene);
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

