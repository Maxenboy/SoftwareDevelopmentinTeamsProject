package se.lth.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import se.lth.prometheus.Rider;
import se.lth.sort.Time;

public class RiderTest {
	Rider r0, r1, r2, r3;
	ArrayList<Time> lapTimes;

	@Before
	public void setUp() throws Exception {
		r0 = new Rider("1", "10.00.00", "11.00.00", "Alfons");
		r1 = new Rider("2", "12.00.00", "14.00.00", "Bertil");
	}

	@Test
	public void testGetStartTime() {
		assertEquals("10.00.00", r0.getStartTime());
		assertEquals("12.00.00", r1.getStartTime());
	}

	@Test
	public void testGetFinishTime() {
		assertEquals("11.00.00", r0.getFinishTime());
		assertEquals("14.00.00", r1.getFinishTime());
	}

	@Test
	// TODO detta test kollar inte så att id är samma.
	public void testGetTotalTime() {

		assertEquals("01.00.00", r0.getTotalTime());
		assertEquals("02.00.00", r1.getTotalTime());
	}

	@Test
	public void testGetId() {
		assertEquals("1", r0.getId());
		assertEquals("2", r1.getId());
	}

//	@Test
//	public void testAddLap() {
//		Time t = new Time("12.30.00");
//		r1.addLap(new Time("12.30.00"));
//		lapTimes = r1.getLapTimes();
//		assertEquals(t.getSeconds(), lapTimes.get(0).getSeconds());
//	}

//	@Test
//	public void testGetLapTime() {
//		Time t = new Time("13.00.00");
//		Time t2 = new Time("13.10.00");
//		r1.addLap(new Time("13.00.00"));
//		r1.addLap(new Time("13.10.00"));
//		lapTimes = r1.getLapTimes();
//		assertEquals("Expected t.seconds, got wrong value", t.getSeconds(),
//				lapTimes.get(0).getSeconds());
//		assertEquals("Expected t2.seconds, got wrong value", t2.getSeconds(),
//				lapTimes.get(1).getSeconds());
//	}

//	@Test
//	public void testFailureLapForOne() {
//		Time t = new Time("11.00.00");
//		r1.addLap(t);
//		lapTimes = r1.getLapTimes();
//
//		assertNotSame(1, lapTimes.size());
//	}

	@Test
	public void testErrorMessageFinishTimes() {
		r0.addFinishTime(new Time("12.00.00"));
		assertEquals(
				"Expected '; Flera måltider? 12.00.00' got "
						+ r0.getErrorMessage(), "; Flera måltider? 12.00.00",
				r0.getErrorMessage());
	}
	
	@Test
	public void testErrorMessageStartTimes() {
		r0.addStartTime(new Time("10.30.00"));
		assertEquals(
				"Expected '; Flera starttider? 10.30.00' got "
						+ r0.getErrorMessage(), "; Flera starttider? 10.30.00",
				r0.getErrorMessage());
	}
	
	@Test
	public void testGetRaceClass() {
		r0.setRaceClass("Senior");
		assertEquals("Senior", r0.getRaceClass());
	}
	
	@Test
	public void testGetEmptyRaceclass() {
		assertEquals("", r0.getRaceClass());
	}


}
