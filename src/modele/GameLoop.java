package modele;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import modele.Personnages.Vieux;

public class GameLoop {
	
	public int tempsOurs;
	public int tempsVieux;
	public Timeline gameLoopOurs;
	public Timeline gameLoopVieux;
	
	
	public void initAnimationOurs(Ennemi ennemi,double duree,int tempsAnimation,
			int ajoutDistanceX, int ajoutDistanceY,String orientationGauche,
			String orientationDroite) {
		
		gameLoopOurs = new Timeline();
		gameLoopOurs.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(duree), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if (tempsOurs == tempsAnimation*2) {
						tempsOurs = 0;
					} else if (tempsOurs > tempsAnimation && tempsOurs % 5 == 0) {
								ennemi.setPosX(ennemi.getPosX()+ajoutDistanceX);
								ennemi.setPosY(ennemi.getPosY()+ajoutDistanceY);
								ennemi.setOrientation(orientationGauche);
					} else if (tempsOurs < tempsAnimation && tempsOurs % 5 == 0) {
								ennemi.setOrientation(orientationDroite);
								ennemi.setPosX(ennemi.getPosX()-ajoutDistanceX);
								ennemi.setPosY(ennemi.getPosY()+ajoutDistanceY);
					}
					tempsOurs++;
				})
		);
		gameLoopOurs.getKeyFrames().add(kf);
	}
	
	public void initAnimationVieux(Vieux vieux,double duree,
				int tempsAnimation,String orientationDroite,String orientationGauche) {
		gameLoopVieux = new Timeline();
		gameLoopVieux.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(duree), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if (tempsVieux == tempsAnimation*2) {
						tempsVieux = 0;
					} else if (tempsVieux < tempsAnimation && tempsVieux % 5 == 0) {
								vieux.setOrientation(orientationDroite);
					} else if (tempsVieux > tempsAnimation && tempsVieux % 5 == 0) {
								vieux.setOrientation(orientationGauche);
					}
					tempsVieux++;
				})
		);
		gameLoopVieux.getKeyFrames().add(kf);
	}
}
