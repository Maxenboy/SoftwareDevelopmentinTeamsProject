package se.lth.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import se.lth.prometheus.FinishFileReader;
import se.lth.prometheus.RaceFileReader;
import se.lth.prometheus.Rider;

public class FinishFileReaderTest {
	RaceFileReader rfr;
	String riderString;
	TreeMap<String, Rider> ridermap;

	@Before
	public void setUp() throws Exception {
		rfr = new FinishFileReader(new File("testfiler/maltider.txt"));
		ridermap = new TreeMap<String, Rider>();
	}

	@Test
	public void testParseStringToRider() throws IOException {
		rfr.editMap(ridermap);
		Rider r = ridermap.get("1");
		assertEquals("Objekten är inte likadana", "13.23.34", r.getFinishTime());
	}
}
