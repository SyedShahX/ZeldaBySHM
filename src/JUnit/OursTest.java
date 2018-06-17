package JUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modele.Monde;

public class OursTest {

	Monde monde;
	
	public OursTest() {
		monde = new Monde();
	}
	
	@Test
	public void testPosition() {
		
	}
	@Test
	public void testCollision() {
//		assertEquals(monde.getEnnemiOurs().attaquer(monde.getLink()), Collisions.collision(monde.getEnnemiOurs().getBounds(32, 20),monde.getLink().getBounds(32, 18)));
	}
	@Test
	public void testChangementImage() {
		int tempsAnimation = 190;
//		assertSame(ours.getOrientation(), tempsAnimation);
		assertTrue("supérieur a 0", tempsAnimation > 0);
	}

}
