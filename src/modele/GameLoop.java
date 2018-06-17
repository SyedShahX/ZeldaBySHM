package modele;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLoop {
	
	Monde monde;
	public Timeline gameLoop;
	public Timeline gameLoopFleche;
	
	public GameLoop() {
		 this.monde = null;
	}

	
	public void setMonde(Monde monde) {
		this.monde = monde;
		
	}
	
	public void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		
		
		KeyFrame animation = new KeyFrame(Duration.seconds(0.017), 
				(e ->
					{
						 monde.getEnnemiOurs().agir();
						 monde.getVieux().agir();
					 }
				)
		);
		
		
		gameLoop.getKeyFrames().add(animation);
	}
	
	public void initAnimationFleche(String orientation,Vivant adversaire) {
		gameLoopFleche = new Timeline();
		gameLoopFleche.setCycleCount(Timeline.INDEFINITE);
		KeyFrame animationFleche = new KeyFrame(Duration.seconds(0.010), 
				(e ->
					monde.getFleche().agir(orientation,adversaire)
				)
		);
		gameLoopFleche.getKeyFrames().add(animationFleche);
	}

}
