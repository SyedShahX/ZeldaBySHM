package App;

import java.io.File;
import java.net.URL;

import controller.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.Monde;

public class Main extends Application {
	
	BorderPane borderPane;
	@Override
	public void start(Stage window) throws Exception {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			URL url = new File("ZeldaBySHM-master/src/vue/GUIZelda.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());
			window.setTitle("jeu Zelda");
			borderPane = new BorderPane();
			borderPane = loader.load();
			Controleur c = loader.getController();
			Scene scene = new Scene(borderPane,1600,960);
//			Camera ca=new PerspectiveCamera();
//			ca.setLayoutX(0);
//			ca.setLayoutY(600);
//			
			scene.setOnKeyPressed(e -> c.gererTouche(e));
//			scene.setCamera(ca);
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