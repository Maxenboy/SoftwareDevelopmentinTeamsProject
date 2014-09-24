package se.lth.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import se.lth.print.RegisterFinishPrinter;
import se.lth.prometheus.Rider;

public class RegisterFinishPrinterTest {
	File finishFile = new File("finish.txt");
	RegisterFinishPrinter rp;
	BufferedReader br;
	Rider r;

	@Before
	public void setUp() throws Exception {
		rp = new RegisterFinishPrinter(finishFile);
		TreeMap<String, Rider> map = new TreeMap<String, Rider>();
		r = new Rider("1", "10.00.00", "11.00.00", null);
		map.put(r.getId(), r);

		rp.print(map);
		br = new BufferedReader(new FileReader("finish.txt"));
	}

	@After
	public void tearDown() {
		finishFile.delete();
	}

	@Test
	public void testResultLength() throws IOException {
		int i = 0;
		while (br.readLine() != null)
			i++;

		assertEquals("there are two lines", 1, i);
	}

	@Test
	public void testResult() throws IOException {
		String line = br.readLine();
		assertEquals(r.getId() + "; " + r.getFinishTime(), line);
	}

}
