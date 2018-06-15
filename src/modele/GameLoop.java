package modele;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLoop {
	
	Monde monde;
	public Timeline gameLoop;
	
	public GameLoop() {
		 this.monde = null;
	}

	
	public void setMonde(Monde monde) {
		this.monde = monde;
		
	}
	
	public void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(Duration.seconds(0.017), 
				(e ->
					{for (Personnage perso : monde.getListePersonnages()) {
						perso.agir();
					}}
					/*System.out.println(monde.getEnnemiOurs().getPosX());
					System.out.println(monde.getEnnemiOurs().getPosY());
					*/
//					monde.getVieux().agir();}
				)
		);
		
//		KeyFrame animationVieux = new KeyFrame(Duration.seconds(0.05), 
//				(e ->
//				)
//		);
		
//		KeyFrame animationFleche = new KeyFrame(Duration.seconds(0.05), 
//				(e ->
//					monde.getFleche().agir()
//				)
//		);
		
		gameLoop.getKeyFrames().add(kf);
	}


	public Monde getMonde() {
		// TODO Auto-generated method stub
		return this.monde;
	}

}
