package se.lth.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.print.RegisterFinishPrinter;
import se.lth.print.RegisterStartPrinter;
import se.lth.prometheus.Rider;
import se.lth.sort.Sorter;

public class SorterTest {
	File startFile, finishFile, resultFile, nameFile;
	BufferedReader br;
	RegisterStartPrinter rsp;
	RegisterFinishPrinter rfp;

	@Before
	public void setUp() throws Exception {
		startFile = new File("start.txt");
		finishFile = new File("finish.txt");
		resultFile = new File("result.txt");
		
		Rider r = new Rider("1", "10.00.00", "11.00.00", "Alfons");
		
		rsp = new RegisterStartPrinter(startFile);
		TreeMap<String, Rider> sMap = new TreeMap<String, Rider>();
		sMap.put(r.getId(), r);
		
		rfp = new RegisterFinishPrinter(finishFile);
		TreeMap<String, Rider> fMap = new TreeMap<String, Rider>();
		fMap.put(r.getId(), r);
		
		rsp.print(sMap);
		rfp.print(fMap);

		String[] args = new String[4];
		args[0] = "result.txt";
		args[1] = "start.txt";
		args[2] = "finish.txt";
		// Kolla så namnfil finns!
		args[3] = "testfiler/namnfil.txt";

		Sorter.main(args);
		
		br = new BufferedReader(new FileReader(resultFile));
	}

	@After
	public void tearDown() {
		startFile.delete();
		finishFile.delete();
		resultFile.delete();
	}

	@Test
	public void testFileIsCreated() {
		assertTrue("The result file was not created", resultFile.exists());
	}

	@Test
	public void testFirstLine() throws IOException {
		String firstLine = br.readLine();
		assertEquals("The header line is incorrect",
				"StartNr; Namn; Totaltid; Starttid; Maltid", firstLine);
	}

}
