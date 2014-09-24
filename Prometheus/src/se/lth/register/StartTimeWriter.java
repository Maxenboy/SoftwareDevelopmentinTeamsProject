package se.lth.register;

import java.io.File;
import java.util.Map;

import se.lth.prometheus.CurrentTime;
import se.lth.prometheus.Rider;

public class StartTimeWriter extends TimeWriter {

	/**
	 * Creates a StartTimeWriter
	 * 
	 * @param file
	 *            the file that should be read from or written to
	 */
	public StartTimeWriter(File file) {
		super(file, false);

	}

	@Override
	protected String opText(Rider rider) {
		return rider.getId() + "; " + rider.getStartTime();
	}


	@Override
	protected Rider opRider(String id) {
		Rider rider = new Rider(id, null);
		rider.addStartTime(CurrentTime.timeStamp());
		return rider;
	}

	@Override
	protected void mapReg(Map<String, Rider> riders, String id) {
		if (riders.containsKey(id)) {
			riders.get(id).addStartTime(CurrentTime.timeStamp());

		} else {
			Rider rider = new Rider(id, null);
			rider.addStartTime(CurrentTime.timeStamp());
			riders.put(id, rider);

		}
	}

}