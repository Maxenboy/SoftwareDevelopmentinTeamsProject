package se.lth.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.lth.prometheus.ConfigFileReader;

public class ConfigFileReaderTest {

	ConfigFileReader configFileReader;
	
	@Before
	public void setUp() {
		try {
			configFileReader = new ConfigFileReader(new File("testfiler/config.txt"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Test
	public void testSingleValueVariable(){
		assertEquals("finish.txt", configFileReader.get("finishFile"));
		assertEquals("name.txt", configFileReader.get("nameFile"));
		assertEquals("4", configFileReader.get("maxLaps"));
	}
	
//	@Test
//	public void testMultipleValueVariable() {
//		ArrayList<String> expectedList = new ArrayList<String>();
//		expectedList.add("start.txt");
//		expectedList.add("start2.txt");
//		expectedList.add("start3.txt");
//		assertEquals(expectedList, configFileReader.getMultiple("startFile"));
//	}

}
