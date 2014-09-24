package se.lth.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import se.lth.prometheus.RaceFileReader;
import se.lth.prometheus.Rider;
import se.lth.prometheus.StartFileReader;
import se.lth.sort.Time;

public class RaceFileReaderTest {

	RaceFileReader rfr;

	@Before
	public void setUp() throws Exception {
		rfr = new StartFileReader(new File("testfiler/starttider.txt"));
	}

	@Test
	public void testEditMap() throws IOException {
		TreeMap<String, Rider> actualMap = new TreeMap<String, Rider>();
		TreeMap<String, Rider> expectedMap = new TreeMap<String, Rider>();
		Rider[] rider = { new Rider("1", null), new Rider("2", null),
				new Rider("3", null), new Rider("4", null),
				new Rider("5", null) };
		rider[0].addFinishTime(new Time("13.23.34"));
		rider[1].addFinishTime(new Time("13.15.16"));
		rider[2].addFinishTime(new Time("13.05.06"));
		rider[3].addFinishTime(new Time("13.12.07"));
		rider[4].addFinishTime(new Time("13.16.07"));
		expectedMap.put("1", rider[0]);
		expectedMap.put("2", rider[1]);
		expectedMap.put("3", rider[2]);
		expectedMap.put("4", rider[3]);
		expectedMap.put("5", rider[4]);

		rfr.editMap(actualMap);
		assertEquals("Objekten skiljer sig", expectedMap, actualMap);

	}

}
