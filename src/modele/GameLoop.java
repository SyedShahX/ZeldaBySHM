package modele;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLoop {
	
	Monde monde = new Monde();
	public Timeline gameLoop;
	
	/**
	 *  faire une seule gameloop pour tous -> donc une méthode initAnimation
	 *  avec toutes les méthodes agir()
	 */
	
	public void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame animationOurs = new KeyFrame(Duration.seconds(0.017), 
				(e ->
					monde.getEnnemiOurs().agir()
				)
		);
		
		KeyFrame animationVieux = new KeyFrame(Duration.seconds(0.05), 
				(e ->
					monde.getVieux().agir()
				)
		);
		
//		KeyFrame animationFleche = new KeyFrame(Duration.seconds(0.05), 
//				(e ->
//					monde.getFleche().agir()
//				)
//		);
		
		gameLoop.getKeyFrames().addAll(animationOurs,animationVieux);
	}
}
