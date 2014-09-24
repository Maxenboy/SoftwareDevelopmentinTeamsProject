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


import se.lth.print.Printer;
import se.lth.print.RegisterFinishPrinter;
import se.lth.print.RegisterStartPrinter;
import se.lth.prometheus.Rider;
import se.lth.sort.Sorter;

public class MarathonPrinterTest {
	File startFile, finishFile, resultFile;
	RegisterStartPrinter rsp;
	RegisterFinishPrinter rfp;
	Printer rp;
	BufferedReader br;
	Rider r;

	@Before
	public void setUp() throws Exception {
		startFile = new File("start.txt");
		finishFile = new File("finish.txt");
		resultFile = new File("result.txt");
		
		r = new Rider("1", "10.00.00", "11.00.00", "Anders Asson");
		
		rsp = new RegisterStartPrinter(startFile);
		rfp = new RegisterFinishPrinter(finishFile);
		
		TreeMap<String, Rider> riderMap = new TreeMap<String, Rider>();
		
		riderMap.put(r.getId(), r);
		
		rsp.print(riderMap);
		rfp.print(riderMap);

		String[] s = new String[4];
		s[0] = "result.txt";
		s[1] = "start.txt";
		s[2] = "finish.txt";
		// Kolla så namnfil finns!
		s[3] = "testfiler/namnfil.txt";

		Sorter.main(s);
		br = new BufferedReader(new FileReader("result.txt"));
	}

	@After
	public void tearDown() {
		startFile.delete();
		finishFile.delete();
		resultFile.delete();
	}

	@Test
	public void testResultLength() throws IOException {
		int i = 0;
		while (br.readLine() != null)
			i++;
		assertEquals("The number of lines is wrong", 6, i);
	}

	@Test
	public void testResult() throws IOException {
		br.readLine();
		String line = br.readLine();
		assertEquals(r.getId() + "; " + r.getName() + "; " + r.getTotalTime()
				+ "; " + r.getStartTime() + "; " + r.getFinishTime(), line);
	}

}
