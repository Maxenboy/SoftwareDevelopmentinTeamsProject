package se.lth.prometheus;

import java.util.ArrayList;
import se.lth.sort.Time;

public class Rider {

	private String id;
	private String raceClass = "";

	private ArrayList<Time> lapTimes;
	private ArrayList<Time> starts = new ArrayList<Time>();
	private ArrayList<Time> finishes = new ArrayList<Time>();

	private String name;

	/**
	 * Creates a Rider with defined values
	 * 
	 * @param id
	 *            the riders id number
	 * @param startTime
	 *            the start time
	 * @param finishTime
	 *            the finish time
	 * @param name
	 *            the riders name
	 * 
	 */

	public Rider(String id, String startTime, String finishTime, String name) {

		lapTimes = new ArrayList<Time>();
		this.name = name;
		this.id = id;
		if (finishTime != null) {
			finishes.add(new Time(finishTime));
		}
		starts.add(new Time(startTime));
	}

	/**
	 * Creates a Rider with given id and name
	 * 
	 * @param id
	 *            the id of the rider
	 * @param name
	 *            the name of the rider
	 */

	public Rider(String id, String name) {
		this.id = id;
		this.name = name;
		lapTimes = new ArrayList<Time>();
	}

	/**
	 * gets the hashcode of the rider
	 */
	@Override
	public int hashCode() {

		return Integer.parseInt(id);
	}

	/**
	 * checks if the riders is equals with object
	 */
	@Override
	public boolean equals(Object obj) {

		return this.hashCode() == obj.hashCode();
	}

	/**
	 * Returns start time of a rider
	 * 
	 * @return start time
	 */
	public String getStartTime() {
		return starts.isEmpty() ? "Start?" : starts.get(0).toString();
	}

	/**
	 * Returns the finish time of a rider
	 * 
	 * @return finish time
	 */

	public String getFinishTime() {
		return finishes.isEmpty() ? "Slut?" : finishes.get(0).toString();
	}

	/**
	 * Return the total time of the race for a rider
	 * 
	 * @return total time
	 */

	public String getTotalTime() {

		return (finishes.isEmpty() || starts.isEmpty()) ? "--.--.--" : starts
				.get(0).calculateDifferance(finishes.get(0)).toString();
	}

	/**
	 * Returns the riders id number
	 * 
	 * @return id number
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the name of the rider
	 * 
	 * @return name of person in rider
	 */
	public String getName() {
		return name;

	}

	/**
	 * Adds a LapTime to the Rider
	 * 
	 * @param time
	 *            of the lap
	 */

	public void addLap(Time time) {
		// Checks if the given time is between the start and finishtime
		if ((time.getSeconds() > starts.get(0).getSeconds())
				&& (time.getSeconds() < finishes.get(0).getSeconds())) {
			lapTimes.add(time);

		}
	}

	/**
	 * Gets the List of laptimes
	 * 
	 * @return the list of laps
	 */

	public ArrayList<Time> getLapTimes() {
		return finishes;
	}

	/**
	 * Adds a finishtime
	 * 
	 * @param time
	 *            the finishtime that is added
	 */
	public void addFinishTime(Time time) {
		finishes.add(time);
	}

	/**
	 * Adds a starttime
	 * 
	 * @param time
	 *            the starttime that is added
	 */
	public void addStartTime(Time time) {
		starts.add(time);
	}

	/**
	 * Prints a printable string of the object
	 * 
	 * @return String with a prinable text of the object
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId()).append("; ").append(getName()).append("; ")
				.append(getTotalTime()).append("; ").append(getStartTime())
				.append("; ").append(getFinishTime()).append(getErrorMessage());
		return sb.toString();
	}

	/**
	 * Gets the errormessage if there is one.
	 * 
	 * @return String with error if no error returns empty string
	 */
	public String getErrorMessage() {
		StringBuilder sb = new StringBuilder();

		if (starts.size() > 1) {
			sb.append("; Flera starttider?");
			for (Time t : starts) {
				if (t != starts.get(0))
					sb.append(" " + t.toString());
			}
		}

		if (finishes.size() > 1) {
			sb.append("; Flera måltider?");
			for (Time t : finishes) {
				if (t != finishes.get(0))
					sb.append(" " + t.toString());
			}
		}

		else {
			sb.append("");
		}
		return sb.toString();
	}

	/**
	 * gets the list of finishTimes
	 * 
	 * @return Arraylist<Time> with the finish times
	 */
	public ArrayList<Time> getFinishTimeList() {
		return finishes;
	}

	/**
	 * gets the list of startTimes
	 * 
	 * @return Arraylist<Time> with the start times
	 */
	public ArrayList<Time> getStartTimeList() {

		return starts;
	}

	/**
	 * sets the race class
	 * 
	 * @param raceClass
	 *            string race class to be set
	 */
	public void setRaceClass(String raceClass) {
		this.raceClass = raceClass;
	}

	/**
	 * Gets the race class
	 * 
	 * @return String The race class
	 */
	public String getRaceClass() {
		return raceClass;
	}

}
