package se.lth.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.prometheus.PersonFileReader;
import se.lth.prometheus.Rider;

public class PersonFileReaderTest {

	PersonFileReader pfr;

	@Before
	public void setUp() throws Exception {
		pfr = new PersonFileReader(new File(
				"testfiler_iteration2_13/namnfil.txt"));
	}

	@After
	public void tearDown() {
		pfr = null;
	}

	@Test
	public void testColumnRow() {
		assertEquals("StartNr; Namn", pfr.getHeaderLine());
	}

	@Test
	public void testReadAllLines() throws IOException {
		TreeMap<String, Rider> expectedMap = new TreeMap<String, Rider>();
		expectedMap.put("1", new Rider("1", "Anders Asson"));
		expectedMap.put("2", new Rider("2", "Bength Bsson"));
		expectedMap.put("101", new Rider("101", "Chris Csson"));
		expectedMap.put("102", new Rider("102", "David Dsson"));
		expectedMap.put("103", new Rider("103", "Erik Esson"));

		TreeMap<String, Rider> actualMap = new TreeMap<String, Rider>();
		pfr.editMap(actualMap);
		assertEquals("Objekten skiljer sig", expectedMap, actualMap);

	}

	@Test
	public void testRiderHasClass() throws Exception {
		pfr = new PersonFileReader(new File(
				"testfiler_iteration2_13/namnfil.txt"));
		TreeMap<String, Rider> actualMap = new TreeMap<String, Rider>();
		pfr.editMap(actualMap);
		assertEquals("Hade inte rätt klass", "SENIOR", actualMap.get("1")
				.getRaceClass());
	}

	@Test
	public void testRiderHasCorrectClass() throws IOException {
		TreeMap<String, Rider> actualMap = new TreeMap<String, Rider>();
		pfr.editMap(actualMap);

		if (actualMap.size() == 5) {
			Collection<Rider> coll = actualMap.values();
			Iterator<Rider> itr = coll.iterator();
			while (itr.hasNext()) {
				Rider r = itr.next();
				switch (Integer.parseInt(r.getId())) {
				case 1:
					assertEquals("SENIOR", r.getRaceClass());
					break;
				case 2:
					assertEquals("SENIOR", r.getRaceClass());
					break;
				case 101:
					assertEquals("JUNIOR", r.getRaceClass());
					break;
				case 102:
					assertEquals("JUNIOR", r.getRaceClass());
					break;
				case 103:
					assertEquals("JUNIOR", r.getRaceClass());
					break;
				}
			}
		} else {
			fail("The number of Riders didn't match the file");
		}
	}
	
	@Test
	public void testRiderClassMapsMap() throws IOException{
		TreeMap<String, Rider> map = new TreeMap<String, Rider>();
		pfr.editMap(map);
		TreeMap<String, Rider> seniorMap = pfr.getClassMapsMap().get("SENIOR");
		assertTrue("seniorMap innehöll inte alla seniorer", seniorMap.containsValue(map.get("1")));
		for(Rider r:seniorMap.values())
			assertEquals("SENIOR", r.getRaceClass());
	}
}
