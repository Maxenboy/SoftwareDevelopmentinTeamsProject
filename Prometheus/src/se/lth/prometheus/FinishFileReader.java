package se.lth.prometheus;

import java.io.File;
import java.util.StringTokenizer;

import se.lth.sort.Time;

public class FinishFileReader extends RaceFileReader {
	String finishTime;

	/**
	 * Creates a reader that reads a finish file
	 * 
	 * @param file
	 *            The file that will be read
	 * @throws Exception
	 */
	public FinishFileReader(File file) throws Exception {
		super(file);
	}

	@Override
	protected Rider parseStringToRider(String parseString) {
		StringTokenizer to = new StringTokenizer(parseString, "; ");
		String riderID = to.nextToken();
		finishTime = to.nextToken();
		Rider r = new Rider(riderID, null);
		r.addFinishTime(new Time(finishTime));
		return r;
	}

	@Override
	protected void addAttributeToRider(Rider rider) {
		rider.addFinishTime(new Time(finishTime));

	}

}
