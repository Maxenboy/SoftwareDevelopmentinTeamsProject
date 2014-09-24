package se.lth.sort;

import java.io.File;

import se.lth.prometheus.RaceFileReader;
import se.lth.prometheus.StartFileReader;

public class StartFileSorter extends FileSorter {

	public StartFileSorter(RaceFileReader rfr) {
		super(rfr);
	}

	@Override
	protected void read(String filename) throws Exception {
		raceFileReader = new StartFileReader(new File(filename));
	}

}
