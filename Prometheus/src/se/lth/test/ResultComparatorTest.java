package se.lth.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lth.prometheus.Rider;
import se.lth.sort.ResultComparator;
import se.lth.sort.Time;

public class ResultComparatorTest {
	ResultComparator comparator;
	Rider r1, r2;

	@Before
	public void setUp() {
		r1 = new Rider("1", "12.00.00", "13.00.00", "kurt");
		r2 = new Rider("2", "12.00.00", "12.55.00", "albin");
		r1.addFinishTime(new Time("13.34.00"));
		r1.addFinishTime(new Time("13.54.00"));
		r2.addFinishTime(new Time("13.20.00"));
		r2.addFinishTime(new Time("13.44.00"));
		comparator = new ResultComparator();
	}

//	@Test
//	public void testComparingTotalTimes() {
//		assertTrue(comparator.compare(r1, r2) > 0);
//		fail("Not yet implemented");
//	}

	@After
	public void tearDown() {

	}
}
