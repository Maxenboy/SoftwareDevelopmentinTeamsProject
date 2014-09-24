package se.lth.print;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import se.lth.prometheus.Rider;
import se.lth.sort.Time;

public class LapRacePrinter extends Printer {
	private int maxLaps;

	/**
	 * Creates a LapRacePrinter
	 * 
	 * @param file
	 *            the file that should be printed to
	 * @param maxLaps
	 *            max number of laps
	 */

	public LapRacePrinter(File file, int maxLaps) {
		super(file);

		this.maxLaps = maxLaps;
		this.topString = generateTopString();

	}

	private String generateTopString() {
		StringBuilder sb = new StringBuilder();
		sb.append("StartNr; Namn; #Varv; TotalTid; ");
		for (int i = 1; i <= maxLaps; i++) {
			sb.append("Varv" + i + "; ");
		}
		sb.append("Start; ");
		for (int i = 1; i < maxLaps; i++) {
			sb.append("Varvning" + i + "; ");
		}
		sb.append("Mål");
		return sb.toString();
	}

	/**
	 * prints the different parameters of a Rider to a file
	 * 
	 * @param map
	 *            map of riders to be printed
	 */

	protected void handle(Map<String, Rider> map) throws IOException {
		Collection<Rider> collection = map.values();
		Iterator<Rider> itr = collection.iterator();
		while (itr.hasNext()) {
			Rider rider = itr.next();
			ArrayList<Time> turntimes = rider.getLapTimes();
			Time startTime = new Time(rider.getStartTime());
			ArrayList<Time> laptimes = startTime.calculateLapTimes(turntimes);

			StringBuilder sb = new StringBuilder();
			sb.append(rider.getId() + "; ");
			sb.append(rider.getName() + "; ");
			sb.append(turntimes.size() + "; ");
			String totaltime = startTime.calculateDifferance(
					turntimes.get(turntimes.size() - 1)).toString();
			sb.append(totaltime + "; ");
			for (int i = 0; i < maxLaps; i++) {
				try {
					sb.append(laptimes.get(i) + "; ");
				} catch (IndexOutOfBoundsException e) {
					sb.append("; ");
				}
			}

			sb.append(rider.getStartTime() + "; ");
			for (int i = 0; i < maxLaps - 1; i++) {
				try {
					sb.append(turntimes.get(i) + "; ");
				} catch (IndexOutOfBoundsException e) {
					sb.append("; ");
				}
			}
			if (turntimes.size() >= maxLaps) {
				sb.append(turntimes.get(turntimes.size() - 1));
			}

			sb.append("\n");
			bw.write(sb.toString());
		}

	}
}
