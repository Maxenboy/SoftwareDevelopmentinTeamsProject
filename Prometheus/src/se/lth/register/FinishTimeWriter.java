package se.lth.register;

import java.io.File;
import java.util.Map;

import se.lth.prometheus.CurrentTime;
import se.lth.prometheus.Rider;

public class FinishTimeWriter extends TimeWriter {
	/**
	 * Creates a FinishTimeWriter
	 * 
	 * @param file
	 *            the file that should be read from or written to
	 */
	public FinishTimeWriter(File file) {
		super(file, true);

	}

	@Override
	protected String opText(Rider rider) {
		return rider.getId() + "; " + rider.getFinishTime();
	}

	@Override
	protected Rider opRider(String id) {
		Rider rider = new Rider(id, null);
		rider.addFinishTime(CurrentTime.timeStamp());
		return rider;
	}

	@Override
	protected void mapReg(Map<String, Rider> riders, String id) {
		if (riders.containsKey(id)) {
			riders.get(id).addFinishTime(CurrentTime.timeStamp());

		} else {
			Rider rider = new Rider(id, null);
			rider.addFinishTime(CurrentTime.timeStamp());
			riders.put(id, rider);

		}
	}
}
