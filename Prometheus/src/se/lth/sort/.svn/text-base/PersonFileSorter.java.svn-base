package se.lth.sort;

import java.io.File;

import se.lth.prometheus.RaceFileReader;
import se.lth.prometheus.PersonFileReader;

public class PersonFileSorter extends FileSorter {
	public PersonFileSorter(RaceFileReader rfr) {
		super(rfr);
	}

	@Override
	protected void read(String filename) throws Exception {
		raceFileReader = new PersonFileReader(new File(filename));
	}

}
