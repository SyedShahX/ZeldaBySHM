package modele;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import modele.Personnages.Ours;
import modele.Personnages.Vieux;

public class GameLoop {
	
	public Timeline gameLoopOurs;
	public Timeline gameLoopVieux;
	public Timeline gameLoopFleche;
	Monde monde = new Monde();
	
	
	public void initAnimationOurs(Ours ours,double duree,int tempsAnimation,
			int ajoutDistanceX, int ajoutDistanceY,String orientationGauche,
			String orientationDroite,Actifs perso) {
		
		gameLoopOurs = new Timeline();
		gameLoopOurs.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(duree), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					monde.getEnnemiOurs().agir(ours,duree,tempsAnimation,
							ajoutDistanceX, ajoutDistanceY, orientationGauche,
							orientationDroite, perso);
				})
		);
		gameLoopOurs.getKeyFrames().add(kf);
	}
	
	public void initAnimationVieux(Vieux vieux,double duree,int tempsAnimation,String orientationDroite,
			String orientationGauche) {
		gameLoopVieux = new Timeline();
		gameLoopVieux.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(duree), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					monde.getVieux().agir(vieux,duree,tempsAnimation,
							orientationDroite,orientationGauche);
					
					
				})
		);
		gameLoopVieux.getKeyFrames().add(kf);
	}
	
	public void initAnimationFleche(double duree) {
		gameLoopVieux = new Timeline();
		gameLoopVieux.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(Duration.seconds(duree), 
				(ev -> {
					monde.getLink().lancer();
				})
				
		);
		gameLoopFleche.getKeyFrames().add(kf);
	}
}
