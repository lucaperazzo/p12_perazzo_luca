package test_strutturali;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myclasses.Extra;

public class ExtraTest {
	
	Extra e1;
	
	@Before
	public void setUp() throws Exception {
		e1 = new Extra(15);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(e1);
		assertEquals(15, e1.getId_extra());
	}
	
	@Test
	public void testInfoExtra() {
		e1.printInfoExtra();
	}

}
