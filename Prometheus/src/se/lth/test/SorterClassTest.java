package se.lth.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.sort.Sorter;

public class SorterClassTest {
	
	@Before
	public void setup(){
		File f = new File("result.txt");
		f.delete();
	}
	
	@After
	public void tearDown(){
		File f = new File("result.txt");
		f.delete();
	}
	@Test
	public void testClassPrint() throws IOException {
		String[] s = new String[4];
		s[0] = "result.txt";
		s[1] = "testfiler_iteration2_13/starttider.txt";
		s[2] = "testfiler_iteration2_13/maltider1.txt";
		s[3] = "testfiler_iteration2_13/namnfil.txt";
		Sorter.main(s);
		BufferedReader br = new BufferedReader(new FileReader("result.txt"));
		BufferedReader expectedFile = new BufferedReader(new FileReader(
				"testfiler_iteration2_13/resultat2.txt"));
		StringBuilder real = new StringBuilder();
		StringBuilder expected = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			real.append(br.readLine());
			expected.append(expectedFile.readLine());
		}

		assertEquals(expected.toString(), real.toString());

	}

}
