package se.lth.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.lth.sort.Time;

public class TimeTest {

	Time t;

	@Before
	public void setUp() throws Exception {
		t = new Time(60);
	}

	@Test
	public void testZero() {
		t = new Time(0);
		assertEquals("00.00.00", t.toString());
	}

	@Test
	public void testLessThanOneMinute() {
		t = new Time(40);
		assertEquals("00.00.40", t.toString());
	}

	@Test
	public void testOneMinute() {
		assertEquals("00.01.00", t.toString());
	}

	@Test
	public void testMoreThanOneMinute() {
		t = new Time(80);
		assertEquals("00.01.20", t.toString());
	}

	@Test
	public void testOneHour() {
		t = new Time(3600);
		assertEquals("01.00.00", t.toString());
	}

	@Test
	public void testMoreThanOneHour() {
		t = new Time(3730);
		assertEquals("01.02.10", t.toString());
	}

	@Test
	public void testConversionStringToTime() {
		t = new Time("01.12.12");
		assertEquals("01.12.12", t.toString());
	}

	@Test
	public void testCalculation() {
		Time t1, t2, t3;

		t1 = new Time("23.30.00");
		t2 = new Time("01.30.00");
		t3 = t1.calculateDifferance(t2);
		assertEquals("02.00.00", t3.toString());
	}

	@Test
	public void testCalculationOverMidnight() {
		Time t1, t2, t3;

		t1 = new Time("23.30.00");
		t2 = new Time("01.30.00");
		t3 = t1.calculateDifferance(t2);
		assertEquals("02.00.00", t3.toString());
	}

	@Test
	public void testLapTimeList() {
		ArrayList<Time> list = new ArrayList<Time>();
		assertTrue(t.calculateLapTimes(list) instanceof ArrayList<?>);
	}

	@Test
	public void testLapTimeCalculation() {
		ArrayList<Time> list = new ArrayList<Time>();
		Time time = new Time("08.00.00");
		list.add(new Time("09.00.00"));
		list.add(new Time("11.00.00"));
		list.add(new Time("14.00.00"));
		ArrayList<Time> knownList = new ArrayList<Time>();
		knownList.add(new Time("01.00.00"));
		knownList.add(new Time("02.00.00"));
		knownList.add(new Time("03.00.00"));
		ArrayList<Time> lapList = time.calculateLapTimes(list);
		for (int i = 0; i < 3; i++) {
			assertEquals(knownList.get(i).toString(), lapList.get(i).toString());
		}

	}

}
