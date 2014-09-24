package se.lth.prometheus;

import java.util.Date;

import se.lth.sort.Time;

public class CurrentTime {
	private static String time;

	/**
	 * Returns the current time 
	 * 
	 * @return Time
	 * 				Current time
	 */
	public static Time timeStamp() {
		Date date = new Date(System.currentTimeMillis());
		String[] format = date.toString().split(" ");
		time = format[3];
		time = time.replace(':', '.');
		return new Time(time);
	}

}
