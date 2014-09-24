package se.lth.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.print.Printer;
import se.lth.print.RegisterFinishPrinter;
import se.lth.print.RegisterStartPrinter;
import se.lth.prometheus.Rider;
import se.lth.sort.Sorter;

public class LapRacePrinterTest {
	File startFile, finishFile, resultFile;
	RegisterStartPrinter rsp;
	RegisterFinishPrinter rfp;
	Printer rp;
	BufferedReader br, expectedFile;
	Rider r;
	int varv;

	@Before
	public void setUp() throws Exception {
		expectedFile = new BufferedReader(new FileReader(
				"testfiler_iteration2/resultat.txt"));
		String[] s = new String[6];
		s[0] = "result.txt";
		s[1] = "testfiler_iteration2/starttider.txt";
		s[2] = "testfiler_iteration2/maltider.txt";
		s[3] = "testfiler_iteration2/namnfil.txt";
		s[4] = "3";
		varv = Integer.parseInt(s[4]);
		Sorter.main(s);
		br = new BufferedReader(new FileReader("result.txt"));
	}

	@After
	public void tearDown() {
		File resultFile = new File("result.txt");
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
		StringBuilder real = new StringBuilder();
		StringBuilder expected = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			real.append(br.readLine());
			expected.append(expectedFile.readLine());
		}

		assertEquals(expected.toString(), real.toString());
	}

}
