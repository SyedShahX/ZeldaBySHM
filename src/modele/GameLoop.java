package modele;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import modele.Personnages.Ours;
import modele.Personnages.Vieux;

public class GameLoop {
	
	public int tempsOurs;
	public int tempsVieux;
	public int tempsOursAttaque;
	public Timeline gameLoopOurs;
	public Timeline gameLoopVieux;
	
	
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
					if(!Collisions.collision(ours.getBounds(32, 20),perso.getBounds(32, 18))) {
					if (tempsOurs == tempsAnimation*2) {
						tempsOurs = 0;
					} else if (tempsOurs > tempsAnimation && tempsOurs % 5 == 0) {
								ours.setPosX(ours.getPosX()+ajoutDistanceX);
								ours.setPosY(ours.getPosY()+ajoutDistanceY);
								ours.setOrientation(orientationGauche);
					} else if (tempsOurs < tempsAnimation && tempsOurs % 5 == 0) {
								ours.setOrientation(orientationDroite);
								ours.setPosX(ours.getPosX()-ajoutDistanceX);
								ours.setPosY(ours.getPosY()+ajoutDistanceY);
					}
					tempsOurs++;
					}
					else { 
						if(tempsOursAttaque %90==0) {
							ours.attaquer(perso);
							
						}
						tempsOursAttaque++;
				}
					
					
					
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
