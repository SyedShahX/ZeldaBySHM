package modele;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLoop {
	
	public int temps;
	public Timeline gameLoop;
	
	public void initAnimation(Ennemi ennemi,double duree,int tempsAnimation,
			int ajoutDistanceX, int ajoutDistanceY) {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(duree), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(temps==tempsAnimation){
						gameLoop.stop();
					} else if (temps%5==0){
						ennemi.setPosX(ennemi.getPosX()+ajoutDistanceX);
						ennemi.setPosY(ennemi.getPosY()+ajoutDistanceY);
					}
					temps++;
				})
		);
		gameLoop.getKeyFrames().add(kf);
	}
}
