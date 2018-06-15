package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import modele.Personnages.Ours;

public class OursTest {

	Ours ours;
	
	public OursTest() {
		ours = new Ours("l'Ours tueur",200,1221,415,10);
	}
	
	@Test
	public void testPosition() {
//		assertEquals()
		
	}
	@Test
	public void testCollision() {
		
	}
	@Test
	public void testChangementImage() {
		int tempsAnimation = 190;
		assertSame(ours.getOrientation(), tempsAnimation);
		assertEquals(ours.getPosX(), tempsAnimation);
	}

}
