package se.lth.test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.sort.Sorter;

public class ErrorHandlingTest {
	File startFile, finishFile, resultFile, nameFile;
	BufferedWriter bw;
	BufferedReader br;
	
	@Before
	public void setUp() throws Exception {
		startFile = new File("start.txt");
		finishFile = new File("finish.txt");
		resultFile = new File("result.txt");
		nameFile = new File("testfiler/namnfil.txt"); //...
		
		//Temp /Felix
		startFile.delete();
		finishFile.delete();
		resultFile.delete();
	}

	@After
	public void tearDown() throws Exception {
		startFile.delete();
		finishFile.delete();
		resultFile.delete();
	}
	
	@Test
	public void noStartTest() throws IOException {
		bw = new BufferedWriter(new FileWriter(startFile));
		bw.write("");
		
		String[] args = { "result.txt", "start.txt", "testfiler/maltider.txt", "testfiler/namnfil.txt" };
		Sorter.main(args);

		br = new BufferedReader(new FileReader(resultFile));
		
		br.readLine();
		String noStart = br.readLine();
		assertTrue(noStart.contains("Start?"));
	}

	@Test
	public void noFinishTest() throws IOException {
		bw = new BufferedWriter(new FileWriter(finishFile));
		bw.write("");
		
		String[] args = { "result.txt", "testfiler/starttider.txt", "finish.txt", "testfiler/namnfil.txt" };
		Sorter.main(args);
		
		br = new BufferedReader(new FileReader(resultFile));
		
		br.readLine();
		String noFinish = br.readLine();
		
		assertTrue(noFinish.contains("Slut?"));
	}


	@Test
	public void totalTimeLessThanFifteenMinutes() throws IOException {
		bw = new BufferedWriter(new FileWriter(startFile));
		bw.write("1; 12.00.00");
		bw.close();
		
		bw = new BufferedWriter(new FileWriter(finishFile));
		bw.write("1; 12.14.59");
		bw.close();
		
		String[] args = { "result.txt", "start.txt", "finish.txt", "testfiler/namnfil.txt" };
		Sorter.main(args);

		br = new BufferedReader(new FileReader(new File("result.txt")));
		br.readLine();
		String impossibleTimeLine = br.readLine();
		
		assertTrue(impossibleTimeLine.contains("Omöjlig Totaltid?"));
	}

	@Test
	public void multipleStartTest() throws IOException {
		String[] args = { "result.txt", "testfiler/flerastart.txt", "testfiler/maltider.txt", "testfiler/namnfil.txt" };
		Sorter.main(args);

		br = new BufferedReader(new FileReader(resultFile));
		br.readLine();
		String multiFinish = br.readLine();
		
		assertTrue(multiFinish.contains("; Flera starttider?"));
	}
	
	@Test
	public void multipleFinishTest() throws IOException {
		String[] args = { "result.txt", "testfiler/starttider.txt", "testfiler/fleramal.txt", "testfiler/namnfil.txt" };
		Sorter.main(args);

		br = new BufferedReader(new FileReader(resultFile));
		br.readLine();
		String multiFinish = br.readLine();
		
		assertTrue(multiFinish.contains("; Flera måltider?"));
	}

}
