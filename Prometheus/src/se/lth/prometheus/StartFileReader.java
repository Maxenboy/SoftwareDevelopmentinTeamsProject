package se.lth.prometheus;

import java.io.File;
import java.util.StringTokenizer;

import se.lth.sort.Time;

public class StartFileReader extends RaceFileReader {
	String startTime;

	/**
	 * Creates a reader that reads a start file
	 * 
	 * @param (File) The file that will be read
	 * @throws Exception
	 */
	public StartFileReader(File file) throws Exception {
		super(file);
	}

	@Override
	protected Rider parseStringToRider(String parseString) {
		StringTokenizer tokenizer = new StringTokenizer(parseString, "; ");
		String riderID = tokenizer.nextToken();
		startTime = tokenizer.nextToken();
		Rider r = new Rider(riderID, null);
		r.addStartTime(new Time(startTime));
		return r;
	}

	@Override
	protected void addAttributeToRider(Rider rider) {
		rider.addStartTime(new Time(startTime));
	}

}
