package App;

import java.io.File;
import java.net.URL;

import controller.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	Pane paneVue;
	@Override
	public void start(Stage window) throws Exception {
		
		int width = 500;
		int height = 360;
		
		try {
			FXMLLoader loader = new FXMLLoader();	
			URL url = new File("ZeldaBySHM-master/src/vue/GUIZelda.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());
			window.setTitle("jeu Zelda");
			paneVue = new Pane();
			paneVue = loader.load();
			Controleur c = loader.getController();
			Scene scene = new Scene(paneVue,width,height);
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