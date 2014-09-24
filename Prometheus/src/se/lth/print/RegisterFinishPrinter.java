package se.lth.print;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;


import se.lth.prometheus.Rider;
import se.lth.sort.Time;

public class RegisterFinishPrinter extends Printer {
	/**
	 * Creates a RegisterFinishPrinter
	 * 
	 * @param file
	 *            the file that should be printed to
	 */
	public RegisterFinishPrinter(File file) {
		super(file);
		this.topString = "";
	}

	@Override
	protected void handle(Map<String, Rider> map) throws IOException {
		String s;
		Collection<Rider> collection = map.values();
		Iterator<Rider> itr = collection.iterator();

		while (itr.hasNext()) {
			Rider rider = itr.next();
			for (Time time : rider.getFinishTimeList()) {
				s = rider.getId() + "; " + time + "\n";
				bw.write(s);
			}
		}

	}

}
