package se.lth.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.lth.prometheus.CurrentTime;
import se.lth.sort.Time;

public class CurrentTimeTest {

	@Test
	public void testFormat() {
		Time t1 = MockCurrentTime.timeStamp();
		Time t2 = MockCurrentTime.timeStamp();
		assertEquals("Wrong ", t1.toString(), t2.toString());
	}

	private static class MockCurrentTime extends CurrentTime {

		public static Time timeStamp() {
			return new Time("14.08.50");
		}
	}

}