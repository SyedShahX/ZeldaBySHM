package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import modele.Map1;

public class ControllerZelda implements Initializable {
	
	@FXML TilePane layout;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeMap();
		
	}

	public void initializeMap() {
		Map1.map(layout);
		
	}
	
	
}
