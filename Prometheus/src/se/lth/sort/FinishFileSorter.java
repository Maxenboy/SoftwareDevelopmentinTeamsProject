package se.lth.sort;

import java.io.File;

import se.lth.prometheus.FinishFileReader;
import se.lth.prometheus.RaceFileReader;

public class FinishFileSorter extends FileSorter {
	
	/**
	 * Creates a FinishFileSorter
	 * @param raceFileReader
	 * 							the reader that should be used
	 */
	public FinishFileSorter(RaceFileReader raceFileReader) {
		super(raceFileReader);
	}

	@Override
	protected void read(String filename) throws Exception {
		raceFileReader = new FinishFileReader(new File(filename));
	}

}
