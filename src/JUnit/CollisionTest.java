package JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modele.Collisions;
import modele.Monde;

public class CollisionTest {

	Monde monde;
	
	public CollisionTest() {
		monde = new Monde();
	}
	@Test
	public void testCollision() {
		/**
		 *  On fixe à Link une position X et Y similaires à celle d'un obstacle de la map
		 *  afin de vérifier s'il est bien en collision avec cet obstacle.
		 */
		monde.getLink().setPosX(20);
		monde.getLink().setPosY(20);
		int posX = monde.getLink().getPosX();
		int posY = monde.getLink().getPosY();
		assertTrue(Collisions.collisionObstacleMap(monde.getLink().getPosX(),monde.getLink().getPosY()));
		/**
		 * On vérifie maintenant s'il n'est pas en collision en un buisson.
		 */
		assertFalse(Collisions.collisionBuisson(posX,posY));
	}
}
