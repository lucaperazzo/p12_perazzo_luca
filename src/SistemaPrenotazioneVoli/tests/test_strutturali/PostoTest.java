package test_strutturali;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Posto;

public class PostoTest {

	Posto p;
	
	@Before
	public void setUp() throws Exception {
		p = new Posto(121, 'F', 8, 10.00);
	}
	
	@Test
	public void testCostruttore() {
		assertNotNull(p);
		assertEquals(121, p.getId_extra());
		assertEquals(10.00, p.getCosto(), 0.00);
	}
	
	@Test
	public void testInfoPosto() {
		p.printInfoExtra();
	}

}
