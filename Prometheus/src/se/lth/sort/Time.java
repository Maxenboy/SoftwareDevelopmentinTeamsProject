package se.lth.sort;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Time {
	private int seconds = 0;

	/**
	 * Creates a time object with the length specified in seconds
	 * 
	 * @param seconds
	 */
	public Time(int seconds) {
		this.seconds = seconds;
	}

	/**
	 * Creates a time object which converts the time format "09.10.08" to
	 * seconds
	 * 
	 * @param timeString
	 */
	public Time(String timeString) {
		if (!timeString.equals("--.--.--"))
			seconds = convertTimeStringToInt(timeString);
	}

	/**
	 * Calculates the total time from start to finish
	 * 
	 * @param finishTime
	 * @return totalTime
	 */
	public Time calculateDifferance(Time finishTime) {

		Time tempTime = finishTime;

		if ((finishTime.getSeconds() - this.seconds) < 0) {
			tempTime = new Time(finishTime.getSeconds() + 3600 * 24);
		}

		return new Time(tempTime.getSeconds() - this.seconds);
	}

	/**
	 * Returns the time in seconds
	 */
	public int getSeconds() {
		return this.seconds;
	}

	private int convertTimeStringToInt(String timeString) {
		int seconds;
		StringTokenizer tokenizer = new StringTokenizer(timeString, ".");
		seconds = Integer.parseInt(tokenizer.nextToken()) * 3600;
		seconds += Integer.parseInt(tokenizer.nextToken()) * 60;
		seconds += Integer.parseInt(tokenizer.nextToken());
		return seconds;
	}

	/**
	 * Returns the time in the format "hh.mm.ss"
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int hours;
		int minutes;
		int seconds;

		hours = this.seconds / 3600;
		minutes = (this.seconds % 3600) / 60;
		seconds = this.seconds % 60;

		if (hours <= 9)
			sb.append("0");
		sb.append(hours + ".");
		if (minutes <= 9)
			sb.append("0");
		sb.append(minutes + ".");
		if (seconds <= 9)
			sb.append("0");
		sb.append(seconds);

		return sb.toString();
	}

	/**
	 * Calculates the time for each lap
	 * 
	 * @param list
	 *            List of time-laps
	 * @return the calculated lap-times
	 */
	public ArrayList<Time> calculateLapTimes(ArrayList<Time> list) {
		Time temptime = this;
		ArrayList<Time> laptimes = new ArrayList<Time>();
		for (int i = 0; i < list.size(); i++) {
			laptimes.add(temptime.calculateDifferance(list.get(i)));
			temptime = list.get(i);
		}
		return laptimes;

	}
}
