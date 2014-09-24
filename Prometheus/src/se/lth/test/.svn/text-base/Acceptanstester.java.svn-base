package se.lth.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import org.junit.After;
import org.junit.Test;

//import se.lth.prometheus.FinishFileReader;
//import se.lth.prometheus.StartFileReader;
//import se.lth.sort.ResultPrinter;
import se.lth.sort.Sorter;

public class Acceptanstester {

	@Test
	public void testCase() throws IOException {
		String[] s = new String[4];
		s[0] = "testfiler/testresultat.txt";
		s[1] = "testfiler/starttider.txt";
		s[2] = "testfiler/maltider.txt";
		s[3] = "testfiler/namnfil.txt";
		Sorter.main(s);
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		try {
			br2 = new BufferedReader(new FileReader("testfiler/resultat.txt"));
			br1 = new BufferedReader(new FileReader(
					"testfiler/testresultat.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("Filen hittades inte");

		}

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		// String tempString = br1.readLine();

		while (br1.ready()) {
			sb1.append(br1.readLine());

		}
		while (br2.ready()) {
			sb2.append(br2.readLine());

		}
		assertEquals("Files not equal", sb1.toString(), sb2.toString());

	}

	// @After
	// public void tearDown(){
	// File file = new File ("testfiler/testresultat.txt");
	// file.delete();
	// }

}
