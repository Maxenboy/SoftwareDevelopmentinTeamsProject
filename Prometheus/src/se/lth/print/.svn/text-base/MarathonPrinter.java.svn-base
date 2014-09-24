package se.lth.print;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;


import se.lth.prometheus.Rider;
import se.lth.sort.Time;


public class MarathonPrinter extends Printer {
	private static final String TOP_STRING = "StartNr; Namn; Totaltid; Starttid; Maltid";
	/**
	 * Creates a MarathonPrinter
	 * @param file
	 * 				the file that should be printed to 
	 */
	public MarathonPrinter(File file) {
		super(file);
		this.topString = TOP_STRING;

	}


	/**
	 * prints the different parameters of a Rider to a file
	 * 
	 * @param map
	 *            the map with Id,Rider
	 */
	protected void handle(Map<String, Rider> map) throws IOException {
		Collection<Rider> collection = map.values();
		Iterator<Rider> itr = collection.iterator();

		while (itr.hasNext()) {
			Rider rider = itr.next();
			StringBuilder sb = new StringBuilder();
			sb.append(rider.toString());
			Time t = new Time(rider.getTotalTime());
			if (!(t.getSeconds() == 0 || t.getSeconds() >= 900)) {
				sb.append(CHEAT);
			}
			sb.append("\n");
			bw.write(sb.toString());
		}

	}
}
