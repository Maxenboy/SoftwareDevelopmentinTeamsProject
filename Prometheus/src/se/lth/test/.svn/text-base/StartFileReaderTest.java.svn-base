package se.lth.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import se.lth.prometheus.RaceFileReader;
import se.lth.prometheus.Rider;
import se.lth.prometheus.StartFileReader;

public class StartFileReaderTest {
	RaceFileReader rfr;
	String riderString;
	TreeMap<String, Rider> ridermap;

	@Before
	public void setUp() throws Exception {
		rfr = new StartFileReader(new File("testfiler/starttider.txt"));
		ridermap = new TreeMap<String, Rider>();
	}

	@Test
	public void testParseStringToRider() throws IOException {
		rfr.editMap(ridermap);
		Rider r = ridermap.get("1");
		assertEquals("Objekten är inte likadana", "12.00.00", r.getStartTime());
	}
}