package App;

import java.io.File;
import java.net.URL;

import controller.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	BorderPane borderPane;
	int width = 1600;
	int height = 960;
	
	@Override
	public void start(Stage window) throws Exception {
		
		
		try {
			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/vue/GUIZelda.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());
			window.setTitle("jeu Zelda");
			borderPane = new BorderPane();
			borderPane = loader.load();
			Controleur c = loader.getController();
			Scene scene = new Scene(borderPane,width,height);
			scene.setOnKeyPressed(e -> c.gererTouche(e));
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