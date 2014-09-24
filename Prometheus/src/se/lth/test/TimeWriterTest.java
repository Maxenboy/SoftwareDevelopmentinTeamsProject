package se.lth.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.register.FinishTimeWriter;
import se.lth.register.StartTimeWriter;
import se.lth.register.TimeWriter;

public class TimeWriterTest {
	TimeWriter stw, ftw;
	File startFile, finishFile;
	BufferedReader sbr,fbr;

	@Before
	public void setUp() throws Exception {
		startFile = new File("start.txt");
		finishFile = new File("finish.txt");
		startFile.delete(); //st�dar ev. gammalt skr�p fr�n andra tester
		finishFile.delete();
		startFile = new File("start.txt");
		finishFile = new File("finish.txt");
		startFile.createNewFile();
		finishFile.createNewFile();
		stw = new StartTimeWriter(startFile);
		ftw = new FinishTimeWriter(finishFile);
		sbr= new BufferedReader(new FileReader(startFile));
		fbr= new BufferedReader(new FileReader(finishFile));
	}

	@After
	public void tearDown() throws Exception {
		startFile.delete(); // Fungerar inte... n�gon str�m �r fortfarande �ppen f�r filen?
		finishFile.delete();
	}

	@Test
	public void startTest() throws Exception {
		String testString = stw.register("1");
		String s=sbr.readLine();
		assertEquals(testString, s);
	}

	@Test
	public void finishTest() throws Exception {
		String testString = ftw.register("1");
		String s=fbr.readLine();
		assertEquals(testString, s);
	}

	
	@Test
	public void manyStartTest() throws Exception {

		String[] testStrings = new String[4];
		testStrings[0] = stw.register("1");
		testStrings[1] = stw.register("2");
		testStrings[2] = stw.register("3");
		testStrings[3] = stw.register("4");

		String s = "";
		for (int i = 0; i < 4; i++) {
			s = sbr.readLine();
			assertEquals("Row number " + i
					+ " in start.txt was not as expected", testStrings[i], s);
		}

	}

}
